
// Java Program to compare two images 
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File; 
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import Math.math;
import ic.util.FileManage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;


class Record2 extends TimerTask
{
    public void run()
    {
        try {
            Robot robot = new Robot();
            if((RecordMain.rec_on)){
                robot.keyPress(KeyEvent.VK_PAGE_DOWN);
                robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
                robot.delay(6000);
                robot.keyPress(KeyEvent.VK_PAGE_DOWN);                
                robot.keyPress(KeyEvent.VK_PAGE_DOWN);
                RecordMain.rec_on = false;
            }             

        } catch (AWTException ex) {
            Logger.getLogger(Record.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}


class Helper2 extends TimerTask 
{
    static int k = 1;
    static double sum = 0;
    static int count = 1;
    math mt = new math();
        
    public void run()
    {    
        File fileA = null;
        File fileB = null;
        FileManage fm = new FileManage();

        try{   
            Robot robot = new Robot(); 

            robot.keyPress(KeyEvent.VK_END);
            robot.keyRelease(KeyEvent.VK_END);

            String path = "K:\\DOCS\\BOOKS\\ECollect\\JRS\\CAM\\sharex";
            File dir_current = fm.getLastModifiedDir(path);

            // Populates the array with names of files and directories
            String[] captured = (new File(dir_current.toString())).list();
            fileB = fm.getLastModifiedFile(dir_current.toString());
            for(String cap:captured)
            {                    
                String comp = dir_current.toString()+"\\"+cap;
                if ((fileA != null)&&(comp.equals(fileB.toString())))
                    break;
                
                if(!cap.contains("mp4"))
                {
                    fileA = new File(dir_current.toString()+"\\"+cap); 
                }
            }
            
            double percent = mt.calcP(fileA,fileB);
            sum = sum + percent;
            
            double avg =  mt.calculateAverage(percent);//sum/(double)k;
            //System.out.println(list.calculateSTD());
            double cutoff = avg + 1.15*mt.calculateSTD();
            System.out.println(String.format("cut:  %.2f  calc:  %.2f",cutoff, percent));
            System.out.println(percent);
            if(fileB !=null && percent < cutoff){
                fileB.delete();
                System.out.println("Removing picture");
            }
            else
            {
                RecordMain.rec_on = true;
               System.out.println("Saved picture");
            }
            
            } catch(AWTException e){
        e.printStackTrace();
        }
    }
}

public class RecordMain
{ 
    public static boolean rec_on = true;
    public static boolean rec_dwn = false;
    protected static RecordMain obj;
    public static BufferedReader reader;    
    
    public static void main(String[] args) throws InterruptedException, FileNotFoundException 
    { 
        obj = new RecordMain();
        Date date = new Date();
        Timer timer = new Timer();        
        
      
       // reader = new BufferedReader(new FileReader(filename));

        
       // timer.scheduleAtFixedRate(new Helper(frame),date,1000);
        timer.scheduleAtFixedRate(new Helper2(),date,7000);
        timer.scheduleAtFixedRate(new Record2(),date,5000);
        
        System.out.println("Timer running");  

        synchronized(obj)
        {
            obj.wait();
            timer.cancel();
            
            System.out.println(timer.purge());
                    
        }  
        
        

    
    } 
} 


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
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;
import javax.imageio.ImageIO;

class Record extends TimerTask
{
    public void run()
    {
        try {
            Robot robot = new Robot();
            if((Main.rec_on)){

                for(long i=0; i<150000; i++)
                    System.out.println(i);
                
                robot.keyPress(KeyEvent.VK_PAGE_DOWN);
              //  robot.keyRelease(KeyEvent.VK_PAGE_DOWN);

                for(long i=0; i<50000; i++)
                    System.out.println(i);
                robot.keyPress(KeyEvent.VK_PAGE_DOWN); 
                Main.rec_on = false;
            }             

        } catch (AWTException ex) {
            Logger.getLogger(Record.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}


class Helper extends TimerTask 
{
    static int k = 1;
    static double sum = 0;
    static int count = 1;
    math mt = new math();
    String path = "K:\\DOCS\\BOOKS\\ECollect\\JRS\\CAM\\sharex\\";//D:\\Documents\\COURSES\\Software\\ImageComparison";
    
    public void capture(Robot r) throws IOException{
        Random rand = new Random();
        String filename = String.valueOf(rand.nextInt(640000000))+".jpg";
        Rectangle capture = new Rectangle(400,100,800,600);
        BufferedImage Image = r.createScreenCapture(capture);
        ImageIO.write(Image, "jpg", new File(path+"\\Screenshots\\"+filename));
    }
        
    public void run()
    {    
        File fileA = null;
        File fileB = null;
        FileManage fm = new FileManage();

        try{   
            Robot robot = new Robot(); 

            robot.keyPress(KeyEvent.VK_END);
            robot.keyRelease(KeyEvent.VK_END);
            
          //  capture(robot);

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
            double std = mt.calculateSTD();
            //System.out.println(list.calculateSTD());
            double cutoff = avg + 2*std;
            System.out.println(String.format("cut:  %.2f  calc:  %.2f",cutoff, percent));
            System.out.println(String.format("avg:  %.2f  std:  %.2f",avg, std));
            if(fileB !=null && percent < cutoff){
                fileB.delete();
                System.out.println("Removing picture");
            }
            else
            {
               Main.rec_on = true;
               System.out.println("Saved picture");
              // for(int i = 0; i<3; i++)
               //{
                  // robot.keyPress(KeyEvent.VK_0); 
                 //  robot.keyRelease(KeyEvent.VK_0);
                  // Thread.sleep(175);

              // }
              }
            
            } catch(AWTException e){
        e.printStackTrace();
        } 
    }
}

public class Main 
{ 
    public static boolean rec_on = true;
    public static boolean rec_dwn = false;
    protected static Main obj;
    public static void main(String[] args) throws InterruptedException 
    { 
        obj = new Main();
        Date date = new Date();
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new Helper(),date, 4030);
        timer.scheduleAtFixedRate(new Record(),date,5000);
        
        System.out.println("Timer running");  
        
        synchronized(obj)
        {
            obj.wait();
            timer.cancel();
            
            System.out.println(timer.purge());
                    
        }  
    } 
} 

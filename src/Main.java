
// Java Program to compare two images 
import ic.util.Cleric;
import ic.util.Constants;
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
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.util.Random;
import javax.imageio.ImageIO;


class Record extends TimerTask
{
    NewJFrame frame;
    FileManage fm = new FileManage();
    
    Record(NewJFrame frame)
    {
        this.frame = frame;
    }
    
    public void run()
    {
        
        try {
            if(!frame.isON)
                return;
            fm.scanFile();

        } catch (IOException ex) {
            Logger.getLogger(Record.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(Record.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AWTException ex) {
            Logger.getLogger(Record.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}


class Helper extends TimerTask 
{
    NewJFrame frame;
    FileManage fm = new FileManage();

    Helper(NewJFrame frame)
    {
        this.frame = frame;
    }
    
    static int k = 1;
    static double sum = 0;
    static int count = 1;
    math mt = new math();
    String path = "D:\\Documents\\COURSES\\Software\\ImageComparison";

    public void capture(Robot r) throws IOException{
        Random rand = new Random();
        String filename = String.valueOf(rand.nextInt(640000000))+".jpg";
        //Rectangle capture = new Rectangle(77,93,110,12);
        //Rectangle capture = new Rectangle(500,200,680,480);
        BufferedImage Image = r.createScreenCapture(Constants.capture);
        ImageIO.write(Image, "jpg", new File(path+"\\Screenshots\\"+filename));
    }
    
    public void killMob(Robot r) throws InterruptedException {
        Thread.sleep(2000);

        r.keyPress(KeyEvent.VK_M);
        r.keyRelease(KeyEvent.VK_M);
        Thread.sleep(1000);
        r.keyPress(KeyEvent.VK_G);
        r.keyRelease(KeyEvent.VK_G);
        Thread.sleep(7000);
        r.keyPress(KeyEvent.VK_F);
        r.keyRelease(KeyEvent.VK_F);
        Thread.sleep(7000);
        r.keyPress(KeyEvent.VK_V);
        r.keyRelease(KeyEvent.VK_V);
        Thread.sleep(7000);
       // r.keyRelease(KeyEvent.VK_X);
    }
    
    public void lodiTrigger(Robot r) throws InterruptedException
    {
        for(int i = 0; i<3; i++) {
            r.keyPress(KeyEvent.VK_0); 
            r.keyRelease(KeyEvent.VK_0);
            Thread.sleep(200);
        }
    }
    
    public void run()
    {    
        File fileA = null;
        File fileB = null;
        Cleric CLR = Constants.clr; 

        try{   

            if(!frame.isON)
                return;
            
            Robot robot = new Robot(); 
            
            capture(robot);
            
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
            
           // double avg =  mt.calculateAverage(percent);
            //double std = mt.calculateSTD();
            //System.out.println(list.calculateSTD());
           // double cutoff = avg;
            double upper = Math.min(Constants.sliderval+15,85);   
            double lower = Math.max(Constants.sliderval-15,25);

            
            frame.inTextStream(String.format("%.2f", percent));
            //System.out.println(String.format("cut:  %.2f  calc:  %.2f",cutoff, percent));
            //System.out.println(String.format("avg:  %.2f  std:  %.2f",avg, std));
            //System.out.println("CHAIN IS " + CLR.CHchain(percent));
            
            if(CLR.CHchain(percent)){/*CH CHAIN*/} 
            else if ((percent > upper)&&(percent<90)){
                CLR.Lheal('y');
            } else if (percent <= Constants.sliderval){ //&& (percent > lower)) {
               CLR.CHheal();
            }
           // } else {
           // } 
            
            fm.purgeLogFiles(dir_current);

        } catch(AWTException e){
        e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(Helper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}


public class Main 
{ 
    protected static Main obj;
    public static BufferedReader reader;
    public static NewJFrame frame;
    
    
    public static void main(String[] args) throws InterruptedException, FileNotFoundException 
    { 
        obj = new Main();
        Date date = new Date();
        Timer timer = new Timer();
        frame = new NewJFrame();
        
        
      
       // reader = new BufferedReader(new FileReader(filename));

        
       // timer.scheduleAtFixedRate(new Helper(frame),date,1000);
        timer.scheduleAtFixedRate(new Helper(frame),date,1000);
        timer.scheduleAtFixedRate(new Record(frame),date,2000);
        
        System.out.println("Timer running");  
                /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frame.setVisible(true);
            }
        });
        synchronized(obj)
        {
            obj.wait();
            timer.cancel();
            
            System.out.println(timer.purge());
                    
        }  
        
        

    
    } 
} 

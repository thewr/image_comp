
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
import javax.swing.JFrame;


class JLogger extends TimerTask
{
    ClickThrough frame;
    FileManage fileManager = new FileManage();
    
    JLogger(ClickThrough frame)
    {
        this.frame = frame;
    }
    
    
    public void run()
    {
        if(!frame.isButtonSelected()) return;
        try {
            fileManager.scanFile();
        } catch (IOException ex) {
            Logger.getLogger(JLogger.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParseException ex) {
            Logger.getLogger(JLogger.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AWTException ex) {
            Logger.getLogger(JLogger.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}



class Helper extends TimerTask 
{
    ClickThrough frame;
    FileManage fm = new FileManage();

    Helper(ClickThrough frame)
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

        Cleric CLR = Constants.clr; 

        try{   
            
            if(!frame.getSlider().isEnabled())
            {
               return;
            }
            Robot robot = new Robot();
                        
            capture(robot);
            
            File[] fileAB = fm.getFiles(path);
            
            
            double percent = mt.calcP(fileAB[0], fileAB[1], "fit");     
            double upper = Math.min(Constants.sliderval+15,70);   
            double lower = Math.max(Constants.sliderval-30,40);

            
            frame.inTextStream(String.format("%.0f", percent));
            
            //if(Constants.clr.isSelected()){
                if(CLR.CHchain(percent)) {
                    /*CHCHAIN*/
                }
                
                if(CLR.LHEALS(percent)) {
                    /*LHEALS*/
                }
                
                if (CLR.isCH())
                {
                    if((percent > upper)&&(percent < 80)||(percent<lower)){
                        CLR.Lheal('v');
                    } else if (percent <= Constants.sliderval) {
                        CLR.CHheal();
                    }
                }
                
            //}
            
           // } else {
           // } 
            
            fm.purgeLogFiles(path);

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
    public static ClickThrough frame;
    
    
    public static void main(String[] args) throws InterruptedException, FileNotFoundException 
    { 
        obj = new Main();
        Date date = new Date();
        Timer timer = new Timer();
        JFrame.setDefaultLookAndFeelDecorated(true);

        frame = new ClickThrough();//NewJFrame();
        // Set the window to 55% opaque (45% translucent).

      
       // reader = new BufferedReader(new FileReader(filename));

        
       // timer.scheduleAtFixedRate(new Helper(frame),date,1000);
        timer.scheduleAtFixedRate(new Helper(frame),date,700);
        timer.scheduleAtFixedRate(new JLogger(frame),date,1000);
        
        System.out.println("Timer running");  
        /* Create and display the form */
        

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                // Set the window to 55% opaque (45% translucent).
                frame.setOpacity(0.60f);

                // Display the window.
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Math;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author Thewbacca
 */
public class math {
    ArrayList <Double> marks;
    double avg = 0.0;
    int x0 = 5;
    int N = 7;
    double r = 0.20;
    double p = 2;
    
    public math(){
            marks  = new ArrayList();
    }
    
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = BigDecimal.valueOf(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
    return bd.doubleValue();
}
    /**
    
    @param x value
    * @param x0 mid
    * @param r rate
    * @param pwr power
    
    
    **/
    
    double logfun(int x)
    {
        return round(1/(double)(1+Math.pow(Math.exp(r*(x-x0)),p)),4);
    }

    public double calculateAverage(double data){
        marks.add(data);
        if(marks.size()>N) //remove first if 
        {
            marks.remove(0);
        }
        Double sum = 0.0;
        Double sumw = 0.0;
        int k = marks.size();
        for(Double mark:marks)
        {
            double w =  logfun(k--);

            
            System.out.println("k: "+k+
                    " w: " + w +
                    " x: " + mark);
            
            sumw = sumw+w;
            
            sum += w*mark;
        }
        avg = sum.doubleValue()/sumw; //marks.size();  
        return avg;
    }
    
    public double calculateSTD(){
        Double sum = 0.0;
        Double sumw = 0.0;
        int k = marks.size();
        for(Double mark:marks)
        {
            double w = logfun(k--);            
            sum += w*Math.pow(mark-avg,2);
            sumw += w;
        }
        return Math.sqrt(sum.doubleValue()/sumw); //marks.size();          
    }
    

    public double calcP(File A, File B, String fit)
    {
        BufferedImage imgA = null; 
        BufferedImage imgB = null; 
        double p = 0;
        
        try
        {       
            // Populates the array with names of files and directories
            if(fit.equals("fit")) {
                imgA = ImageIO.read(new File("D:\\Documents\\COURSES\\Software\\ImageComparison\\fullhp.jpg"));
            } else {
                 imgA = ImageIO.read(A);
            }
            imgB = ImageIO.read(B);
        } 
        catch (IOException e) 
        { 
            System.out.println(e); 
        } 
        
        int width1 = imgA.getWidth(); 
        int width2 = imgB.getWidth(); 
        int height1 = imgA.getHeight(); 
        int height2 = imgB.getHeight(); 
  
        if ((width1 != width2) || (height1 != height2)) 
            System.out.println("Error: Images dimensions"+ 
                                             " mismatch"); 
        else
        { 
            long difference = 0; 
            for (int y = 0; y < height1; y++) 
            { 
                for (int x = 0; x < width1; x++) 
                { 
                    int rgbA = imgA.getRGB(x, y); 
                    int rgbB = imgB.getRGB(x, y); 
                    int redA = (rgbA >> 16) & 0xff; 
                    int greenA = (rgbA >> 8) & 0xff; 
                    int blueA = (rgbA) & 0xff; 
                    int redB = (rgbB >> 16) & 0xff; 
                    int greenB = (rgbB >> 8) & 0xff; 
                    int blueB = (rgbB) & 0xff; 
                    difference += Math.abs(redA - redB); 
                    difference += Math.abs(greenA - greenB); 
                    difference += Math.abs(blueA - blueB); 
                } 
            } 
  
            // Total number of pixels
            double total_pixels = width1 * height1 * 3; 
  
            // Normalizing the value of different pixels 
            double avg_different_pixels = difference/ total_pixels; 
  
            // There are 255 values of pixels in total 
            p = (avg_different_pixels / 255) * 100; 
            double[] args = {0.1385,-2.73,4.4473,101.15};
            if(fit.equals("fit"))
            {
                p = fun(p, args);
            }
        }
        return round(p,4);            
    }
    
    public double fun(double x, double[] args)
    {
        double y = 0.0;
        int n = args.length;
        for(int i=n; i>0; i--)
        {
            y += args[n-i]*Math.pow(x, i-1);
        }
        return y;
    }
    
}

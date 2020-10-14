/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Math;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

/**
 *
 * @author Thewbacca
 */
public class math {
    ArrayList <Double> marks;
    Double avg = 0.0;
    public math(){
            marks  = new ArrayList();
    }

    public double calculateAverage(double data){
        marks.add(data);
        if(marks.size()>7) //remove first if 
        {
            marks.remove(0);
        }
        Double sum = 0.0;
        Double sumw = 0.0;
        int k = marks.size();
        for(Double mark:marks)
        {
            double w = 1/(double)(1+Math.exp(0.5*(k-5)));    

            System.out.println("k: "+k+
                    " w: " + w +
                    " x: " + mark);

            k=k-1;
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
            double w = 1/(double)(1+Math.exp(0.5*(k-5)));            
            sum += w*Math.pow(mark-avg,2);
            sumw += w;
            k=k-1;
        }
        return Math.sqrt(sum.doubleValue()/sumw); //marks.size();          
    }
    
    public double calcP(File A, File B)
    {
        BufferedImage imgA = null; 
        BufferedImage imgB = null; 
        double percentage = 0;
        
        try
        {       
            // Populates the array with names of files and directories
            imgA = ImageIO.read(A);
            //    Image imA = imgA.getScaledInstance(20, 20, Image.SCALE_DEFAULT);
            imgB = ImageIO.read(B);
            //    imgB = (BufferedImage) imgB.getScaledInstance(20, 20, Image.SCALE_DEFAULT);
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
            double avg_different_pixels = difference / total_pixels; 
  
            // There are 255 values of pixels in total 
            percentage = (avg_different_pixels / 255) * 100; 
        }
        return percentage;            
    }
    
}

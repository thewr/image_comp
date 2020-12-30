/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ic.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.text.ParseException;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Thewbacca
 */
public final class Seek {
    private static LinkedList<String[]> que = new LinkedList<>();

    private static Seek instance;
    Robot robot;
    private Seek() {
        try {
            robot = new Robot();
        } catch (AWTException ex) {
            Logger.getLogger(Keys.class.getName()).log(Level.SEVERE, null, ex);
        }
    System.out.println("Robot Constructor Called");}
    public static Seek getInstance(){
        if(instance==null)
            instance = new Seek();
        return instance;
    }
    
    public static void direction(String line, String timestamp) throws AWTException, ParseException {
        
        Robot robot = new Robot();

        if(line.contains("Your Location is ")){
                String[] coords = (line.split("Your Location is ")[1])
                        .split(", ");
                //System.out.println(coords[0] + "  " + coords[1] + "  " + coords[2]);
                coords[2] = timestamp;
                que.add(coords);

                if(que.size()>2){
                        que.remove();
                        que.forEach((n)->{System.out.println(n);});
                        String[] c0 =que.get(0); //previous
                        String[] c1 = que.get(1);  //recent
                        
                        double a = getAngle(c0,c1);
                        if (a < 0) a += 360;
                        
                        System.out.println();
                        System.out.println(a);
                        
                        //String[] desired_location ={"2324","-990"};
                        double c = getAngle(Constants.location,c1);
                        if (c < 0) c += 360;
                        
                        double desiredAngle = c - a;
                        // Compute its acute counterpart
                        if (desiredAngle > 180)
                            desiredAngle -= 360;
                        else if (desiredAngle < -180)
                            desiredAngle += 360;
                        
                        // Advance the monster towards player by a predefined value
                        a += Math.min(3, Math.abs(desiredAngle)) * Math.signum(desiredAngle);
                        
                        // Convert this angle back in the -180 to 180 degree range
                        if (a > 180) a -= 360;
                        else if (a < -180) a += 360;
                        //monster.setAngle(a);
                        
                        
                        //
                        //double distance = getDistance(c0,c1);
                       
                            
                        //long delta_t = Time.getInstance().getDiff(c0[2], c1[2]);
                       // double rate = distance/(double)(delta_t/1000);
                        
                        
                       // System.out.println("Distance: " + distance);
                        //
                        double distance1 = getDistance(Constants.location,c1);
                        double distance2 = getDistance(Constants.location, c0);
                        double diff = distance1-distance2;
                        
                        int x = 7* (int) Math.round(Math.abs(desiredAngle/4));
       
                        
                        if(distance1<50){
                            robot.keyPress(Character.toUpperCase('S'));
                            robot.keyRelease(Character.toUpperCase('S'));
                        }
                            
   
                        
                        System.out.println("Distance: " + distance1);
                        //if(distance==0.0)
                        //    x=300;
                        System.out.println(x);
                        
                       // System.out.println("Delay: " + x);
                            // Convert this angle back in the -180 to 180 degree range
                            robot.keyPress(Character.toUpperCase('1'));
                            if(desiredAngle<0){
                                robot.keyPress(Character.toUpperCase('d'));
                                robot.delay(x);
                                robot.keyRelease(Character.toUpperCase('d'));
                            } else if (desiredAngle>0) {
                                robot.keyPress(Character.toUpperCase('a'));
                                robot.delay(x);
                                robot.keyRelease(Character.toUpperCase('a'));
                            }
                  
                            //System.out.println(a + "  " + c + "  " + desiredAngle);  
                }
        }           
    }
        public static double getAngle(String[] c0, String[] c1)
        {
            double[] prev = {Double.parseDouble(c0[0]),
                            Double.parseDouble(c0[1])};
            double[] curr = {Double.parseDouble(c1[0]),
                            Double.parseDouble(c1[1])};
            double[] diff = {curr[0]-prev[0], curr[1]-prev[1]};
            //System.out.println("Vector: " + "< " + diff[1] + ", " + diff[0] + " >");
            double ang = (180/Math.PI)*Math.atan2(diff[0],diff[1]);    
            //(x > 0 ? x : (2*PI + x)) * 360 / (2*PI)
           // ang = (ang + 360) % 360;  // +360 for implementations where mod returns negative numbers
            return ang;
      
        }
        
        public static double getDistance(String[] c0, String[] c1)
        {
            double[] prev = {Double.parseDouble(c0[0]),
                            Double.parseDouble(c0[1])};
            double[] curr = {Double.parseDouble(c1[0]),
                            Double.parseDouble(c1[1])};
            double distance = Math.sqrt(Math.pow(curr[0]-prev[0],2.0)+Math.pow(curr[1]-prev[1],2.0));
            return distance;

        }

}

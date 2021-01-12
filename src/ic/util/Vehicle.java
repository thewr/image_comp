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

/**
 *
 * @author Thewbacca
 */
public class Vehicle {
    PVector location;
    PVector velocity;
    PVector acceleration;
    LinkedList<String[]> que = new LinkedList<>();
    
    float maxspeed;
    
    public Boolean isValidInstance;
    private Vehicle(){}
    private static class LazyLoader {
        static final Vehicle INSTANCE = new Vehicle();
    }
    public static Vehicle getInstance(){
        return LazyLoader.INSTANCE;
    }

  void seek(PVector target) {
    PVector desired = PVector.sub(target,location);
    desired.normalize();
    desired.mult(maxspeed); //Calculating the desired velocity to target at max speed
    PVector steer = PVector.sub(desired,velocity); //Reynolds’s formula for steering force
    //applyForce(steer); //Using our physics model and applying the force to the object’s acceleration
  }


    
}



class PVector {
 
  float x;
  float y;
 
  PVector(float x_, float y_) {
    x = x_;
    y = y_;
  }
  
   void add(PVector v) {
    y = y + v.y;
    x = x + v.x;
  }
   
   

  void sub(PVector v) {
    x = x - v.x;
    y = y - v.y;
  }
  
  static PVector sub(PVector v1, PVector v2){
      return (new PVector(v1.x-v2.x,v1.y-v2.y));
  }

    void mult(float n) {
    //With multiplication, the components of the vector are multiplied by a number.
       x = x * n;
       y = y * n;
     }

    void div(float n) {
      x = x / n;
      y = y / n;
    }
 

    float mag() {
      return (float)Math.sqrt((double)(x*x + y*y));
    }

    



    void normalize() {
     float m = mag();
     if (m != 0) {
       div(m);
     }
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
                        
                        String[] c0 =que.get(0); //previous
                        String[] c1 = que.get(1);  //recent
                        
                        double a = getAngle(c0,c1);
                        if (a < 0) a += 360;
                        
                        
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
                        double distance1 = getDistance(Constants.location,c1);
                        double distance2 = getDistance(Constants.location, c0);
                        double diff = distance1-distance2;
                        
                        int x = 7* (int) Math.round(Math.abs(desiredAngle/6));
       
                        
                        if(distance1<50){
                            robot.keyPress(Character.toUpperCase('S'));
                            robot.keyRelease(Character.toUpperCase('S'));
                        }
                            
   
                        
                        System.out.println("\n"+"Distance: " + distance1);
                        System.out.println("Change Angle: " + x/7);
                        System.out.println("Desired Angle: " + desiredAngle);
                        System.out.println(String.format("Distance: %f \n, "
                                + "Changle Angle: %f", c1, x/7));
                        
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





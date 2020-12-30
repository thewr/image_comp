/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ic.util;

/**
 *
 * @author Thewbacca
 */
public class Vehicle {
    PVector location;
    PVector velocity;
    PVector acceleration;
    
    float maxspeed;
    
    

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





}



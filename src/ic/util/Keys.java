package ic.util;


import java.awt.AWTException;
import java.awt.Robot;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thewbacca
 */
public class Keys {
    private static Keys instance;
    Robot robot;
    private Keys() {
        try {
            robot = new Robot();
        } catch (AWTException ex) {
            Logger.getLogger(Keys.class.getName()).log(Level.SEVERE, null, ex);
        }
    System.out.println("Robot Constructor Called");}
    public static Keys getInstance(){
        if(instance==null)
            instance = new Keys();
        return instance;
    }
    
   
    
    public void pressANDdelay(char c, int t)
    {
        if (c==' '){
            robot.delay(t);
        } else {
            robot.keyPress(Character.toUpperCase(c));
            robot.delay(10);
            robot.keyRelease(Character.toUpperCase(c));
            robot.delay(t);
        }
    }
   
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ic.util;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

/**
 *
 * @author Thewbacca
 */
public class Bard {
    private static Bard instance;
    Keys key = Keys.getInstance();
    private Bard() {/*Empty Constructor*/}
    public static Bard getInstance(){
        if(instance==null)
            instance = new Bard();
        return instance;
    }
    public static void kite(Boolean flag) throws AWTException{
        Robot robot = new Robot();
        //if (flag)
        //{
                robot.keyPress(KeyEvent.VK_D);
                robot.delay(200);
                robot.keyRelease(KeyEvent.VK_D);
        //} else {
            
       // }
    }
}

package ic.util;

import java.awt.AWTException;
import java.util.HashMap;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Thewbacca
 */
public class Cleric {
    private static Cleric instance;
    private Cleric() {
        for(String s:clrStrings)
        {
            map.put(s, false);
        }
    }
    
    public static Cleric getInstance(){
        if(instance==null)
            instance = new Cleric();
        return instance;
    }
    
    Keys key = Keys.getInstance();
    private boolean bSelected = false;
    private boolean bSit = true;
    private boolean bChain = false;
    private boolean bLheals = false;
    public boolean bSlowed = false;
    public boolean bStart = false;
    private boolean[] bLheal = {false, false, false}; //remedy
    
    private static HashMap<String, Boolean> map = new HashMap<>(); 
    String[] clrStrings = { "CH", "CHAIN", "LHEALS", "NONE"};


    public enum Tax {
    NONE(0), SALES(10), IMPORT(5);

    private final int value;
    private Tax(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
    
    public static enum spellName {
        REM(0,'y'), CE(1,'v'), DL(2,'b');
        private final int value;
        private final char c;
        private spellName(int value, char c) {
            this.value = value;
            this.c = c;
        }
        public int getValue() {
            return value;
        }
        public char getChar() {
            return c;
        }
        
        public static spellName getName(char c)
        {
            spellName name = null;
            switch(c){
                case('y'):
                    name = spellName.REM;
                    break;
                case('v'):
                    name = spellName.CE;
                    break;
                case('b'):
                    name = spellName.DL;
                    break;
            }
            return name;
        }
    }
    
    public void setSpell(spellName name, boolean flag)
    {
        bLheal[name.getValue()] = flag;
    }
    
    public void sitSelected(boolean flags)
    {
        bSit = flags;
    }
    
    public boolean isCHAIN()
    {
        return map.get("CHAIN");
    }
    
    public void lhealsSelected(boolean flag)
    {
        bLheals = flag;
    }
    
    public void setSelected(String selected)
    {
        String[] clrStrings = { "CH", "CHAIN", "LHEALS", "NONE"};
        
        for(String s:clrStrings)
        {
            map.replace(s, false);
            if(selected.equals(s))
            {
                map.replace(s, true);
            }
        }

        
    }
    
    public void CHheal() {
        
        if(!bSlowed){
            key.pressANDdelay('M', 500);
        } else {
            key.pressANDdelay('M', 5000);
        }

        //key.pressANDdelay('P', 80);
        key.pressANDdelay('F', 14000);
        sit();
    }
    
    public boolean CHchain(double percent) {
        
        
        //no ch chain
        if(!isCHAIN()){
            return false;
        }
        //start chain
        boolean case0 = isCHAIN()&&bStart;
        //not slowed
        boolean case1 = !bSlowed;
        //slowed
       // System.out.println(isCHAIN() + " | " + bStart + " | " + bSlowed);
        //boolean case2 = bSlowed&&((int)Math.round(percent)<=Constants.sliderval);
        
        
        if(case0)//&&(case1))//||case2))
        {
                CHheal();          
                bStart = false;
        } 
        
        return true;
    }
    
    public boolean LHEALS(double percent) throws AWTException {
        
        if(!isLHEALS()){
            return false;
        }
        if(((int)Math.round(percent)<=Constants.sliderval))
        {
            /*
            Robot robot = new Robot();
            robot.keyPress(Character.toUpperCase('d'));
            robot.delay(100);
            robot.keyRelease(Character.toUpperCase('d'));
            */
            Lheal('v');
        }
        return true;
    }
    
    
    public void Lheal(char c) {  
        //int val = spellName.getName(c).getValue();
        //if(bLheal[val]){
        //    //standx
            key.pressANDdelay('M', 200);
           //heal type
            key.pressANDdelay(c, 550);
            key.robot.delay(1000);
            sit();
       // }
    }
    
    private void sit(){
        if(bSit){
            //sit
            key.pressANDdelay('X', 80);
        }       
    }
    
    public void setStartChain(boolean flag){
        bStart = flag;
    }
    
    
    public void setSlowed(boolean flag1){
        bSlowed = flag1;
    }
    
    public void isSlowed(boolean flag1)
    {
        bSlowed = flag1;
    }
    
    public boolean isLHEALS()
    {
        return map.get("LHEALS");
    }
    
    public boolean isCH()
    {
        return map.get("CH");
    }
    
    /*
    public void setSelected(boolean flag)
    {
        bSelected = flag;
    }
    */
    
    public boolean isSelected()
    {
        return bSelected;
    }
    
    
}
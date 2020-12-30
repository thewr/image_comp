package ic.util;



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
    Keys key = Keys.getInstance();
    private boolean bSit = true;
    private boolean bChain = false;
    private boolean bSlowed = false;
    private boolean bStart = false;
    private boolean[] bLheal = {false, false, false}; //remedy
    
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

    private Cleric() {/*Empty Constructor*/}
    public static Cleric getInstance(){
        if(instance==null)
            instance = new Cleric();
        return instance;
    }
    
    public void sitSelected(boolean flags)
    {
        bSit = flags;
    }
    
    public void chainSelected(boolean flags)
    {
        bChain = flags;
    }
    
    public void CHheal() {
        key.pressANDdelay('M', 200);
        key.pressANDdelay('P', 80);
        key.pressANDdelay('F', 14000);
        sit();
    }
    
    public boolean CHchain(double percent) {
        //no ch chain
        if(!bChain){
            return false;
        }
        //start chain
        boolean case0 = bChain&&bStart;
        //not slowed
        boolean case1 = !bSlowed;
        //slowed
        System.out.println(bChain + " | " + bStart + " | " + bSlowed);
        boolean case2 = bSlowed&&((int)Math.round(percent)<=Constants.sliderval);
        

        
        if(case0&&(case1||case2))
        {
                CHheal();          
                bStart = false;
        } 
        
        return true;
    }
    
    public void Lheal(char c) {  
        int val = spellName.getName(c).getValue();
        if(bLheal[val]){
            //stand
            key.pressANDdelay('M', 200);
           //heal type
            key.pressANDdelay(c, 550);
            sit();
        }
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
    
    
}


import java.util.Random ;
/**
 * Write a description of class FunctionSin here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FunctionSin extends Function
{ 
    Function testFunction ;
    Function testFunction2;
    Option random = new Option();
    String name;
    // instance variables - replace the example below with your own
    public FunctionSin(int level){
        
        function(level);
        
    }

    public void function(int level){
        int ran = random.random(3);
        if(ran == 0 && level >= 1){
            testFunction = new FunctionCos(level-1);
         
        }
        else if(ran ==1 && level >=1 ){
            testFunction = new FunctionSin(level-1);
           
        }
         else if(ran == 2 && level >= 1){
            testFunction = new  Average(level-1);
            
        }
        
        if(level == 0){
            
            if(ran == 0){
            testFunction = new X();
            }
            else{
                testFunction = new Y();
            }
            }
        
        
    }
     public String getFunction(){
        return "Sin( " + testFunction.getFunction()+ ")";
        
    }
    /**
     * Constructor for objects of class Sin
     */
    public double getValue(double num,double num2){
        
        
        return Math.sin( Math.PI *testFunction.getValue(num,num2));
    
     
}

}

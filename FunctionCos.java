
import java.util.Random ;
/**
 * Write a description of class FunctionCos here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FunctionCos extends Function{
    // instance variables - replace the example below with your own
     Function testFunction ;
     Function testFunction2;
     Option random = new Option();
     
    public FunctionCos(int level){
        function(level);
        
    }
     
    
    public String getFunction(){
        return "Cos( " + testFunction.getFunction()+ ")";
        
    }
    public void function(int level){
       int ran = random.random(3);
        if(ran == 0 && level >= 1){
            testFunction = new FunctionCos(level -1);
            
        }
        else if(ran ==1 && level >= 1){
            testFunction= new FunctionSin(level -1);
           
        }
        
        else if(ran == 2 && level >= 1){
            testFunction = new  Average(level-1);
            
        }
        if(  level == 0){
             if(ran == 0){
              testFunction = new X();
            }
            else{
                testFunction = new Y();
            }
       
        }
        
       
    }
   
    /**
     * Constructor for objects of class FunctionCos
     */
    public double getValue(double num,double num2){
        
       return Math.cos( Math.PI *testFunction.getValue(num,num2));
  
    }
}

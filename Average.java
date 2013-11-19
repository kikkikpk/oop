
import java.util.Random ;
/**
 * Write a description of class Average here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Average extends Function
{  Function  testFunction;
    Function testFunction2;
    // instance variables - replace the example below with your own
    private int x;
    Option random = new Option();
    public Average(int level){
        function(level);
        
    }
    
    
    
    public void function(int level){
       int ran = random.random(3);
        if(ran == 0 && level >= 1){
            testFunction = new FunctionCos(level -1);
             testFunction2 = new FunctionCos(level-1);
        }
        else if(ran ==1 && level >= 1){
            testFunction= new FunctionSin(level -1);
            testFunction2 = new FunctionSin(level-1);
        }
        else if(ran ==2 && level >= 1){
            testFunction = new Average(level-1);
             testFunction2 = new Average(level-1);
        }
        
        if(  level == 0){
             if(ran == 0){
              testFunction = new X();
              testFunction2 = new X();
            }
            else{
                testFunction = new Y();
                testFunction2 = new Y();
            }
       
        }
        
       
    }
     public String getFunction(){
        return "Average( " + testFunction.getFunction()+ ")";
        
    }
    /**
     * Constructor for objects of class Average
     */
    public double  getValue(double num, double num2){
        return (testFunction.getValue(num,num2) +testFunction2.getValue(num,num2))/2;
        
    }
    
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
   
}

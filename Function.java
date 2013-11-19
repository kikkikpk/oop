 


/**
 * Write a description of class Fuction here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public  abstract class  Function
{
    // instance variables - replace the example below with your own
    private int x;
    Option random = new Option();
    Function testFunction;
    /**
     * Constructor for objects of class Fuction
     */
    public Function()
    {
        
        
    }

    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    
    public abstract double getValue(double num , double num2);
    
    
    public  void function(int level){
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
    public abstract String getFunction();
}

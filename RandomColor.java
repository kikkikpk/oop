

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

import java.util.Stack;

class RandomColor extends JPanel{

    private boolean print;
   
    private Option random ;
    private   Function red ;
    private   Function green ;
    private   Function blue ;
    private String name;
    private static final int MIN = 6;
    private static final int MAX = 8;
    // create 256 gray scale colors to avoid lots
    // of garbage color objects
    public RandomColor(){
        random = new Option();
        print = false;
        setPreferredSize(new Dimension(400,400));
    }
    
    public int getDeep(int min,int max){
        int deep = random.random((max-min)+1)+min;
        return  deep;
    }
 

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D)g;
        double xInc = 2 / getWidth();
        double yInc = 2 / getHeight();
        double xVal = -1;
        double yVal = -1;  
        red = new FunctionCos(getDeep(MIN,MAX));
        blue = new Average(getDeep(MIN,MAX));
        green = new FunctionSin(getDeep(MIN,MAX));
        
        for(int x = 0; x < getWidth(); x++){
            yVal = -1;
            for(int y = 0; y < getHeight(); y++){
                    double i= ((((double) x) / getWidth()) * 2.0) - 1.0;
                    double j = ((((double) y) / getHeight()) * 2.0) - 1.0;
                    int r = (int)    ((red.getValue(i,j) +1.0) / 2.0 * 255);
                    int gr = ( int ) ((green.getValue(i,j) +1.0) / 2.0 * 255);
                    int b =  (int ) ((blue.getValue(i,j) +1.0) / 2.0 * 255);
                    Color color = new Color(r,gr,b);
                    g2.setColor(color);
                Rectangle2D pixel = new Rectangle2D.Double(x, y, 1, 1);
                g2.fill(pixel);
                yVal += yInc;
                /*if( !print){
                    System.out.println("Red " + red.toString());
                    System.out.println("Green " + green.toString());
                    System.out.println("Blue " + blue.toString());
                    print = true;
                }*/
            }
            xVal += xInc;
        }
        //print = false;
    }   
    public void printFunction(){
        System.out.println("Red " + red.getFunction());
        System.out.println("Green " + green.getFunction());
        System.out.println("Blue " + blue.getFunction());
    }
  

}
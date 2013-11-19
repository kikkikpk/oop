  

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
/**
 * Write a description of class Main here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Main
{

 
    private  static final int deep = 7;
      private JFrame frame;
      private RandomColor thePanel;
  public static void main (String args[]){
   Main index = new Main();
   //index.indexMap();
   index.mainMap();
   
  }
    
   
    public void mainMap(){
        
      
        frame = new JFrame();
        
        frame.setSize(500,600);
        thePanel = new RandomColor();
        frame.add(thePanel);

        // create panel with buttons
        JPanel buttonPanel = new JPanel();
        JButton gen = new JButton("RANDOM");
        JButton func = new JButton("OPTION");
        gen.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                thePanel.repaint();
            }
        });
        func.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                thePanel.printFunction();
            }
        });
        
        buttonPanel.add(gen);
        buttonPanel.add(func);
        //buttonPanel.add(getButton("RANDOM", true));
        //buttonPanel.add(getButton("OPTION", true));

        // add components to frame
        frame.add(thePanel, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);
        frame.setVisible(true);
        
     
    }
    /* public JButton getButton(String label, final boolean makeColor){
        JButton result = new JButton(label);
        result.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                
                thePanel.repaint();
            }
        }
        );
        return result;
    }*/
    
  
    
   
    
}



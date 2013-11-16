
/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.awt.*;
import javax.swing.*;

public class Button
{
    public static void main (String [] args)
    {
        JDialog d = new JDialog();
        d.setTitle("RANDOM ART");
        d.setSize(400,500);
        d.setLocation(400,600);
        JPanel p = new JPanel();
        JLabel label1 = new JLabel();
        JLabel label2 = new JLabel();
        //p.add(getButton("New COLOR"));
         //p.add(getButton("New DAKE"));
        JButton button1 = new JButton("New COLOR");
        JButton button2 = new JButton ("NEW DAKE");
        p.setLayout(new BorderLayout());
        p.add(label1);
       // p.add(button1);
        p.add(label2);
       // p.add(button2);
        d.getContentPane().add(p);
        d.setVisible(true);
        
        p.add(button1, BorderLayout.NORTH);
      p.add(button2, BorderLayout.SOUTH);

    }
}

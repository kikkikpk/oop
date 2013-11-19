
/**
 * Write a description of class RunCalculator here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

import javax.swing.*;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.awt.event.*;
public class GUI extends JFrame{
    
     private JFrame frame = new JFrame ();
    private ImageIcon image = new ImageIcon("welcome_kik.png");
    private JButton button = new JButton(image);
     
    public static void main(String[]args){
        JFrame frame = new JFrame ();
        frame.setTitle("RANDOM ART PROJECT");
        frame.setSize(500,500);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);
        GUI gui = new GUI();
        ImageIcon image = new ImageIcon("welcome_kik.png");
        JButton button = new JButton(image);

        frame.add(button); // abb button image
        Image icon = Toolkit.getDefaultToolkit().getImage("images.jpeg");
        frame.setIconImage(icon); // set the Default Icon of program

        JMenuBar jmb = new JMenuBar(); // create the new MenuBar
        JMenu menu = new JMenu("Option"); // Option Menu
        menu.setMnemonic(KeyEvent.VK_O); // User can click O button to open the sub menu
        jmb.add(menu); 

        JMenu info = new JMenu(" Info ");
        info.setMnemonic(KeyEvent.VK_I);
        jmb.add(info);
        frame.setJMenuBar(jmb); // add Menubar to frame

        JMenuItem jDev = new JMenuItem(" Developers ");
        jDev.setMnemonic(KeyEvent.VK_D);
        info.add(jDev);
        jDev.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){
                    JOptionPane.showMessageDialog(null, " MEMBERS  \n Miss.Pilaiwan 54270334 \n Miss Reen" , " Developers " , 
                        JOptionPane.INFORMATION_MESSAGE,  new ImageIcon("cat12.png")); // pop up
                }
            });

        JMenuItem jHelp = new JMenuItem(" Help"); // Help Bar Menu
        jHelp.setMnemonic(KeyEvent.VK_H); // User can click H Button to pop up help menu
        menu.add(jHelp); // add Help Function to MenuBar  
        jHelp.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){
                    JOptionPane.showMessageDialog(null, " \n BUTTON   \n \n Random       Click chang color \n Option         Click show option    "  , "Help", 
                       JOptionPane.INFORMATION_MESSAGE, new ImageIcon());
                }
            });

        JMenuItem jExit = new JMenuItem(" Exit "); // Exit Bar Menu
        jExit.setMnemonic(KeyEvent.VK_E);  // User can click E button to exit the program
        menu.add(jExit); // add Exit Function to MenuBar
        jExit.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){
                    JOptionPane.showMessageDialog(null," \n Thank you For Attention ! " ,"EXIT", 
                        JOptionPane.INFORMATION_MESSAGE ,  new ImageIcon());
                    System.exit(0);
                }
            });

        button.addActionListener(new ActionListener()
            {
                public void actionPerformed(ActionEvent e){
                    //RandomArt pic =new RandomArt();
                    //pic.start();
                    // ArtPanel pic = new ArtPanel();
                    Main main = new Main();
                    main.mainMap() ;
                    
                }
            });

    }
    public void setMain(){
        
    }
    
}

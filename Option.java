
import java.util.Random ;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;
class Option extends JFrame{
   FlowLayout layoutFlow;
   JButton button;
   JLabel label,image ;
    private JFrame frame;
   Container contain;
   private RandomColor thePanel;
   public Option(){
       
    }
  public Option(String nameOfTopic){
   
    super(nameOfTopic);
    frame = new JFrame();
    
    
    frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
    
  }
  
  public void createButton(String nameOfButton,int x ,int y ,int width,int height){
     button = new JButton(nameOfButton);
     setBound(button,null,x,y,width,height);
     container(button,null);
     
  }
  
  
  
  public void container(JButton button,JLabel label){
     contain = getContentPane();
    if(button == null){
     contain.add(label); 
    }
    else{
     contain.add(button); 
    }
  }
  
  
  public void createWord(String word,int sizeFont,int x ,int y ,int width,int height){
    label = new JLabel();
    setBound(null,label,x,y,width,height);
    label.setText(word);
    
    label.setFont(new Font("TimesRoman",Font.BOLD,sizeFont));
    container(null,label);
  }
  
  
  public void createImage(String name){
    JLabel image = new JLabel(new ImageIcon(getClass().getResource(name+".gif"))); 
    getContentPane().add(image);
    image.setBounds(750,470,500,600);
  }
  
  
  
  
  public void setBound(JButton button,JLabel label,int x,int y,int width,int height){
    if(button == null){
     label.setBounds(x,y,width,height); 
    }
    else if(label == null){
     button.setBounds(x,y,width,height); 
    }
    else{
      
    }
  }
   public int random(int num){
        Random random = new Random();
        return random.nextInt(num);
    }
  
}
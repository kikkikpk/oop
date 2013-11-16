import java.awt.*;
import java.applet.*;
public class ll extends Applet    
{    
   Image im;
   public void init()

   {
      im = getImage(getCodeBase(), "pic.gif");   
   }
   public void paint(Graphics g)
   {
      g.drawImage(im, 10, 15, this); //แสดงภาพที่ x=10, y=15
   }
}



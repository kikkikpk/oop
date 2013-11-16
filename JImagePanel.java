import java.io.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import javax.swing.JPanel;
import javax.imageio.ImageIO;

class JImagePanel extends JPanel {
    protected BufferedImage bi;

    protected void readFile(File f) {
        try { bi = ImageIO.read(f); }
        catch (IOException e) { }
    }

    protected void setBufferedImage(BufferedImage b) {
        bi = b;
    }

    protected void paintComponent(Graphics g) {
        JImagePanel panel = new JImagePanel();
        super.paintComponent(g);
        panel.readFile(new File("images.gif"));
        g.drawImage(bi, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}

/*
อันนี้ที่อ.ชลเมธสอนน
JImagePanel panel = new JImagePanel();
// อย่าประกาศเป็น JPanel เพราะจะเรียกใช้ readFile ไม่ได้

panel.setPreferredSize(new Dimension(160, 120));
// เซ็ตขนาดกว้างยาว

panel.setBackground(Color.LIGHT_GRAY);
// ใช้สีเทาแสดงแทนเมื่อไม่มีรูป

panel.readFile(new File("sample.jpg"));
// อ่านข้อมูลรูปภาพจากไฟล์

panel.repaint();
// อันนี้เพื่อ refresh รูปภาพหลังจากอ่านไฟล์
*/
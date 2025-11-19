import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;

class Disegno extends JComponent{
    @Override
    public void paintComponent(Graphics g){
        
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        g2.drawRect(100,100,100,100);

    }
}
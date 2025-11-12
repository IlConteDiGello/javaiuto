import javax.swing.JFrame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;

public class Finestra extends JFrame {

    public Finestra(String title){
        super(title);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setUndecorated(true);

        this.pack();
        this.setVisible(true);

        setFullscreen();

        System.out.println("creata finestra guh");
    }

    private void setFullscreen() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        GraphicsDevice device = ge.getDefaultScreenDevice();
        
        if (device.isFullScreenSupported()) {
            device.setFullScreenWindow(this);
        } else {
            System.err.println("Modalità Full Screen esclusiva non supportata su questo dispositivo. La finestra sarà massimizzata.");
            this.setExtendedState(JFrame.MAXIMIZED_BOTH);
        }
    }
    
}

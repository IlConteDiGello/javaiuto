import javax.swing.JFrame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;


public class Finestra extends JFrame {

    private Pannello pannello;
    public Finestra(String title){
        super(title); //chiama il costruttre JFrame

        pannello = new Pannello();

        this.add(pannello);

        this.pack();//adatta la finestra ai contenuti all'interno
        this.setVisible(true);  //rende la finestra visibile sullo schermo

        setFullscreen();  //mette lo schermo intero

        System.out.println("creata finestra guh");
    }

    private void setFullscreen() {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment(); //queste due robe che non so che cazzo siano identificano lo schermo
        GraphicsDevice device = ge.getDefaultScreenDevice(); //sul quale sta runnando l'applicazione
        
        if (device.isFullScreenSupported()) {
            device.setFullScreenWindow(this); //chiave, affida la gestione della finestra a JFrame, e quindi viene attuato il fullscreen eccetera
        } else {
            System.err.println("Modalità Full Screen esclusiva non supportata su questo dispositivo. La finestra sarà massimizzata.");
            this.setExtendedState(JFrame.MAXIMIZED_BOTH); //se non è supportata, si massimizza la finestra
        }
    }
    
}

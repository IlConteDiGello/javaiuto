import javax.swing.JFrame;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.event.KeyListener;

public class Finestra extends JFrame implements Runnable, KeyListener{

    private Player player;
    private Thread thread;

    private int cameraOffsetX=0;
    private int cameraOffsetY=0;

    public pannelloDiGioco(){
        player = new Player(getWidth() / 2, 500);

        this.addKeyListener(this);
        this.setFocusable(true);

        thread = new Thread(this);
        thread.start();
    }
    

    private Piattaforma piattaforma;

    public Finestra(String title){
        super(title); //chiama il costruttre JFrame

        piattaforma = new Piattaforma();

        this.add(piattaforma);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //dice che quando l'utente preme per esempio la X l'applicazione deve terminare

        this.setUndecorated(true); //rimuove decorazioni, bordi e barra del titolo

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

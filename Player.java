import java.awt.event.KeyEvent;

public class Player {
    public Vector2D playerpos; // posizione attuale
    public float velocitax = 0;
    public float velocitay = 0;
    public float gravita = 1;

    //booleane di input per vedere dove stai annando
    public boolean sinistra = false;
    public boolean destra = false;
    public boolean shiftpremuto = false;
    public boolean spaziopremuto = false;
    
    // stato del player
    public boolean involo = false;
    public boolean dashattivato = false;
    public boolean dashpronto = true;
    public boolean dashando = false;
    public boolean atterra = false;
    public boolean planando = false;
    
    // costanti
    private final float potenzaVolo = -5f; // Esempio
    private final float maxGravita = 10f; // Esempio
    private final int bordoXDestra = Variabili.bordoXdestra;
    private final int bordoXSinistra = Variabili.bordoXsinistra;
    private final int yPiattaforma = Variabili.ypiattaforma;
    
    // Variabili di Tempo (usano System.currentTimeMillis())
    private long UltimoAumentoSpeed = 0;
    private long ultimodash = 0;
    private long ultimaAccelerazioneVolo = 0;

    public Player(float Xinit, float Yinit){
        playerpos = new Vector2D(Xinit, Yinit);
    }
}

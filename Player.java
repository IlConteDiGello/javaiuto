import java.awt.event.KeyEvent; //serve a controllare i tasti premuti

public class Player {
    public Vector2D playerpos; // posizione attuale
    public float velocitax = 0;
    public float velocitay = 0; //velocità di caduta
    public final float gravita = 1; //costante della gravità

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

    public void Update(){

        movimento();
        playerpos.x += velocitax;
        playerpos.y += velocitay;
    }

    public void movimento(){
        long clock=System.currentTimeMillis();
        int VMax = 17, VMin = -17;
        int delay = 50; //in millisecondi
        if(sinistra && clock - UltimoAumentoSpeed >= delay && velocitax <=VMax){
            if(velocitax >= 0) velocitax -=3;
            else velocitax--;
            UltimoAumentoSpeed = clock;
        }else if(destra && clock - UltimoAumentoSpeed >= delay && velocitax <= VMax) {
            if(velocitax <= 0) velocitax+=3;
            else velocitax++;
            UltimoAumentoSpeed = clock;
        }else if(!sinistra && !destra && clock - UltimoAumentoSpeed >= delay && velocitax!=0){
            if(velocitax < 0) velocitax++;
            else if(velocitax > 0) velocitax--;
            UltimoAumentoSpeed = clock;
        }
    }

    public void inputs(int keyCode, boolean premuto){
        switch(keyCode){
            case KeyEvent.VK_4:
                sinistra = premuto;
                break;
            case KeyEvent.VK_D:
                destra=premuto;
                break;
        }
    }

}

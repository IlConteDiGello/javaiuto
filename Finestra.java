import javax.swing.JFrame;
import java.awt.GraphicsEnvironment;
import java.awt.GraphicsDevice;
public class Finestra extends JFrame{   //per creare la finestra

    public static JFrame CreaFinestra(){
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment(); //ottengo ambiente grafico
        GraphicsDevice gd = ge.getDefaultScreenDevice(); //ottiene lo schermo su cui visualizzare la finestra

        Finestra finestra = new Finestra();
        finestra.setUndecorated(true); //rimuove bordi, pulsanti eccetera
        finestra.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        if(gd.isFullScreenSupported()){ //se il dispositivo supporta la funzione di fullscreen
            gd.setFullScreenWindow(finestra); //setta fullscreen
        }else{ //altrimenti
            finestra.setSize(ge.getMaximumWindowBounds().getSize()); //massimizza la finestra
        }
        
        finestra.setTitle("Maremma maiala");
        System.out.println("Creata finestra guh");

        return finestra;
    }
}
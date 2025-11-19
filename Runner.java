import javax.swing.JFrame;
import javax.swing.SwingUtilities;

//EDT: Event Dispatch Thread, dove avvengono tutti i processi grafici e interfacce utenti

public class Runner {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() { //fa avviare il codice dentro l'EDT, non nel main thread
        //thread apposta per fare roba grafica e interazioni
        //runnable crea una classe anonima che dica cosa eseguire all'EDT
            @Override //serve per leggibilità e sicurezza, inoltre serve al compilatore
            public void run() {
                JFrame finestra = Finestra.CreaFinestra();
                Disegno disegno = new Disegno();
                finestra.add(disegno);
                finestra.setVisible(true);
            }
        });
    }
}
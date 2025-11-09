import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;

public class linea extends JPanel {

    // Altezza fissa dal basso per la piattaforma
    private static final int PLATFORM_HEIGHT_FROM_BOTTOM = 50; 

    @Override
    protected void paintComponent(Graphics g) {
        // Chiama il metodo della superclasse per pulire lo sfondo
        super.paintComponent(g); 
        
        // --- 1. Impostare il Colore ---
        // I disegni successivi useranno questo colore
        g.setColor(Color.WHITE); 
        
        // --- 2. Calcolare le Coordinate ---
        int larghezzaFinestra = getWidth();
        int altezzaFinestra = getHeight();
        
        // Calcola la coordinata Y per la linea (Y=0 è in alto)
        int yPiattaforma = altezzaFinestra - PLATFORM_HEIGHT_FROM_BOTTOM;
        
        // --- 3. Generare la Retta ---
        // Disegna una retta che va da sinistra (x=0) a destra (x=larghezzaFinestra)
        // mantenendo la stessa coordinata Y
        
        // g.drawLine(x1, y1, x2, y2);
        g.drawLine(0, yPiattaforma, larghezzaFinestra, yPiattaforma); 
        
        // Esempio di retta verticale a metà schermo
        g.setColor(Color.RED);
        g.drawLine(larghezzaFinestra / 2, 0, larghezzaFinestra / 2, altezzaFinestra);
    }
    
    // ... resto dei metodi del gioco (costruttore, startLoop, ecc.)
}
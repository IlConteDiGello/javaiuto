import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Dimension;

public class Piattaforma extends JPanel {
    
    // Costruttore
    public Piattaforma() {
        // Imposta una dimensione iniziale, che poi il fullscreen ignorerà
        this.setPreferredSize(new Dimension(800, 600)); 
        this.setBackground(Color.WHITE); // Imposta lo sfondo nero
    }

    // Questo metodo viene chiamato per disegnare
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Pulisce lo sfondo
        
        // --- LOGICA DI DISEGNO DELLA PIATTAFORMA ---
        
        int larghezzaFinestra = getWidth();
        int altezzaFinestra = getHeight();
        
        // Definiamo un'altezza Y fissa per la piattaforma (es. 50px dal fondo)
        int yPiattaforma = altezzaFinestra - 50; 
        
        // Imposta il colore per la piattaforma
        g.setColor(Color.BLACK); 
        
        // Disegna una retta orizzontale (la tua piattaforma)
        // g.drawLine(x1, y1, x2, y2);
        g.drawLine(0, yPiattaforma, larghezzaFinestra, yPiattaforma); 
        
        // (In un gioco reale, chiameresti qui il tuo WorldGenerator.drawWorld(g);)
    }
    
}
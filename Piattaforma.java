

import java.awt.Graphics2D;
import java.awt.Color;
// Importa la classe Variabili se usi i suoi limiti (es. Variabili.ypiattaforma)

public class Piattaforma {
    
    // Questo è il metodo che verrà chiamato da GamePanel
    public static void draw(Graphics2D g2d) {
        
        int yPiattaforma = 900;
        
        g2d.setColor(Color.WHITE);

        g2d.drawLine(-15000, yPiattaforma, 15000, yPiattaforma);
    }
}
import javax.swing.JPanel; // Necessario per getWidth(), addKeyListener(), setFocusable()
import java.awt.Graphics;
import java.awt.event.KeyListener; // Necessario per l'interfaccia KeyListener
import java.awt.event.KeyEvent;    // Necessario per l'oggetto KeyEvent
import java.awt.Dimension;

public class Pannello extends JPanel implements Runnable, KeyListener {
    private Player player;
    private Thread thread;

    private int cameraOffsetX=0;
    private int cameraOffsetY=0;

    public void pannelloDiGioco(){
        player = new Player(getWidth() / 2, 500);

        this.addKeyListener(this);
        this.setFocusable(true);

        thread = new Thread(this);
        thread.start();
    }

    @Override

    public void run(){
        final double FPS = 60.0;
        final double tempoPerUpdate = 1000000000 / FPS;
        long ultimoTempo = System.nanoTime();
        double delta = 0;

        while(true){
            long ora = System.nanoTime();
            delta += (ora - ultimoTempo) / tempoPerUpdate;
            ultimoTempo = ora;

            if(delta >= 1){
                player.Update();

                delta--;
            }
        }
    }
    private void updateCamera(){
    cameraOffsetX = (int) (player.playerpos.x - getWidth()/2);
    cameraOffsetY = (int) (player.playerpos.y. - getHeight()/2);
}

@Override

protected void paint(Graphics g){
    super.paintComponent(g);

    Graphics2D g2d = (Graphics2D) g;

    g2d.translate(-cameraOffsetX, -cameraOffsetY);

    WorldGenerator.drawWorld(g2d);

    g2d.setColor(color.RED);

    g2d.fillOval((int)player.playerpos.x - 15, (int)player.playerpos.y - 30,30, 30);

    g2d.translate(cameraOffsetX, cameraOffsetY);
}

@Override public void keyPressed(KeyEvent e) { player.setInputState(e.getKeyCode(), true);}
@Override public void keyReleased(KeyEvent e) { player.setInputState(e.getKeyCode(), false);}
@Override public void keyTyped(KeyEvent e) {}
}


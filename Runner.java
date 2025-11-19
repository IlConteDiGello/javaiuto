import javax.swing.SwingUtilities;

public class Runner{
    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run(){
                Finestra finestra = new Finestra("Maremma maiala...");
            }
        });
    }
}
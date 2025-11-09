public class Vector2D {
    public float x;
    public float y;

    public Vector2D(float x, float y) {
        this.x = x;
        this.y = y;
    }

    // Aggiungi metodi utili come PVector
    public void add(Vector2D other) {
        this.x += other.x;
        this.y += other.y;
    }
    
    // Puoi aggiungere qui il calcolo del modulo, la normalizzazione, ecc.

}

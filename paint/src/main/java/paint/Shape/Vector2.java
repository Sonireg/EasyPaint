package paint.Shape;

public class Vector2 {
    public int x;
    public int y;

    public Vector2(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void add(Vector2 other) {
        this.x += other.x;
        this.y += other.y;
    }

    public Vector2 negate() {
        return new Vector2(-this.x, -this.y);
    }
}

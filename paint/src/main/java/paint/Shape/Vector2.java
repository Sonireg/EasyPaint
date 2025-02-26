package paint.Shape;

public class Vector2 {
    public Integer x;
    public Integer y;

    public Vector2(Integer x, Integer y) {
        this.x = x;
        this.y = y;
    }

    public void add(Vector2 other) {
        this.x += other.x;
        this.y += other.y;
    }

    public Vector2 sumWith(Vector2 other) {
        return new Vector2(x + other.x, y + other.y);
    }

    public Vector2 negate() {
        return new Vector2(-this.x, -this.y);
    }

    public String toString() {
        return x.toString() + " " + y.toString() + " ";
    }

    public Integer SquareDistance(Vector2 v) {
        return (x - v.x) * (x - v.x) + (y - v.y) * (y - v.y);
    }
}

package paint.Shape;
import paint.ControlElements.Canvas;

public abstract class AbstractShape {
    public abstract void draw(Canvas canvas);
    public abstract String toString();
    public void setVisible(boolean newVisibylityState) {
        isVisible = newVisibylityState;
    }
    public void setColor(Character newColor) {
        color = newColor;
    }
    public void move(Vector2 moveVector) {
        position.add(moveVector);
    }
    protected Vector2 position;
    protected Character color;
    protected Integer id;
    protected boolean isVisible = true;
}

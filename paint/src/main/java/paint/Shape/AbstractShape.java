package paint.Shape;
import paint.ControlElements.Canvas;

public abstract class AbstractShape {
    public abstract void draw(Canvas canvas);
    public void setVisible(boolean newVisibylityState) {
        isVisible = newVisibylityState;
    }
    protected Vector2 position;
    protected char color;
    protected int id;
    protected boolean isVisible = true;
}

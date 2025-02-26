package paint.Shape;
import paint.ControlElements.Canvas;

public class Triangle extends AbstractShape {
    public Triangle(Vector2 initPos, char initColor, int initID, int initHeight) {
        this.position = initPos;
        this.color = initColor;
        this.id = initID;
        this.height = initHeight;
    }

    @Override
    public void draw(Canvas canvas) {
    }

    @Override
    public String toString() {
        return "triangle " + height.toString() + " ";
    }

    private Integer height;
}

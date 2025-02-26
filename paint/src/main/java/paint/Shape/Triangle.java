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
        if (!isVisible) {
            return;
        }
        for (int i = 0; i < height; i++) {
            for (int j = -i; j <= i; ++j) {
                canvas.setElement(position.sumWith(new Vector2(j, i)), color);
            }
        }
    }

    @Override
    public String toString() {
        return "triangle " + position.toString() + color + " " + height.toString() + " ";
    }

    private Integer height;
}

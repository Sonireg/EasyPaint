package paint.Shape;

import paint.ControlElements.Canvas;

public class Circle extends AbstractShape {

    public Circle(Vector2 initPos, char initColor, int initID, int initRadius) {
        this.position = initPos;
        this.color = initColor;
        this.id = initID;
        this.radius = initRadius;
    }

    @Override
    public void draw(Canvas canvas) {
    }
    private int radius;
}

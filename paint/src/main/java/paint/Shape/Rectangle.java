package paint.Shape;

import paint.ControlElements.Canvas;

public class Rectangle extends AbstractShape {
    public Rectangle(Vector2 initPos, char initColor, int initID, int initLength, int initWidth) {
        this.position = initPos;
        this.color = initColor;
        this.id = initID;
        this.length = initLength;
        this.width = initWidth;
    }
    
    
    @Override
    public void draw(Canvas canvas) {
    }

    @Override
    public String toString() {
        return "rectangle " + length.toString() + " " + width.toString() + " ";
    }

    private Integer length;
    private Integer width;
}

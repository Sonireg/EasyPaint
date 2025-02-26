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
        if (!isVisible) {
            return;
        }
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < length; j++) {
                canvas.setElement(position.sumWith(new Vector2(i, j)), color);
            }
        }
    }

    @Override
    public String toString() {
        return "rectangle " + position.toString() + color + " " + length.toString() + " " + width.toString() + " ";
    }

    private Integer length;
    private Integer width;
}

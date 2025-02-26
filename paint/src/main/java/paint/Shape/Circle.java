package paint.Shape;

import paint.ControlElements.Canvas;

public class Circle extends AbstractShape {

    public Circle(Vector2 initPos, char initColor, int initID, int initRadius) {
        this.position = initPos;
        this.color = initColor;
        this.id = initID;
        this.radiusSquare = initRadius;
    }

    @Override
    public void draw(Canvas canvas) {
        if (!isVisible) {
            return;
        }
        int radius = (int) Math.sqrt(radiusSquare) + 1;
        for (int i = -radius; i < radius; i++) {
            for (int j = -radius; j < radius; j++) {
                Vector2 currPos = position.sumWith(new Vector2(i, j));
                if (currPos.SquareDistance(position) <= radiusSquare) {
                    canvas.setElement(currPos, color);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "circle " + position.toString() + color + " " + radiusSquare.toString() + " ";
    }

    private Integer radiusSquare;
}

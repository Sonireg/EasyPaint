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
        dfsDraw(canvas, position);
    }

    @Override
    public String toString() {
        return "circle " + position.toString() + color + " " + radiusSquare.toString() + " ";
    }

    private Integer radiusSquare;

    private void dfsDraw(Canvas canvas, Vector2 drawPos) {
        canvas.setElement(drawPos, color);
        Vector2[] neighbors = {
            new Vector2(drawPos.x - 1, drawPos.y), 
            new Vector2(drawPos.x + 1, drawPos.y), 
            new Vector2(drawPos.x, drawPos.y - 1), 
            new Vector2(drawPos.x, drawPos.y + 1)
        };
        for (var neighbor : neighbors) {
            if (neighbor.SquareDistance(position) <= radiusSquare) {
                canvas.setElement(neighbor, color);
                dfsDraw(canvas, neighbor);
            }
        }
    }

}

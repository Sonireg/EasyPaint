package paint.ShapeCommand;

import paint.ControlElements.Canvas;
import paint.Shape.AbstractShape;

public class AddComand extends AbstractShapeCommand {
    @Override
    public void doCommand() {
        canvas.getFigures().add(shape);
    }
    @Override
    public void undoCommand() {
        canvas.getFigures().get(figureID).setVisible(false);
    }
    AbstractShape shape;
}

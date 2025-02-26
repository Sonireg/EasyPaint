package paint.ShapeCommand;

import paint.ControlElements.Canvas;
import paint.Shape.AbstractShape;

public class AddComand extends AbstractShapeCommand {
    
    public AddComand(Integer initFigureID, Canvas initCanvas, AbstractShape initShape) {
        canvas = initCanvas;
        figureID = initFigureID;
        shape = initShape;
    }

    @Override
    public void doCommand() {
        canvas.getFigures().add(shape);
    }

    @Override
    public void undoCommand() {
        canvas.getFigures().get(figureID).setVisible(false);
    }

    @Override
    public String toString() {
        return "AddComand " + shape.toString() + " " + figureID.toString() + " ";
    }

    AbstractShape shape;
}

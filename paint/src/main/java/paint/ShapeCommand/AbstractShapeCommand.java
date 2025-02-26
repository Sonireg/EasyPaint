package paint.ShapeCommand;
import paint.ControlElements.Canvas;

public abstract class AbstractShapeCommand {
    public abstract void doCommand();
    public abstract void undoCommand();
    public abstract String toString();
    protected Canvas canvas;
    protected Integer figureID;
}

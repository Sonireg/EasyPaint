package paint.ShapeCommand;
import paint.ControlElements.Canvas;

public abstract class AbstractShapeCommand {
    public abstract void doCommand();
    public abstract void undoCommand();
    protected Canvas canvas;
    protected int figureID;
}

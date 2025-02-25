package paint.ShapeCommand;

public class FillCommand extends AbstractShapeCommand {
    @Override
    public void doCommand() {
        canvas.getFigures().get(figureID).setColor(newColor);
    }
    @Override
    public void undoCommand() {
        canvas.getFigures().get(figureID).setColor(oldColor);
    }
    private Character newColor;
    private Character oldColor;
}

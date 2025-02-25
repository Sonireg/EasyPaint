package paint.ShapeCommand;

public class EraseCommand extends AbstractShapeCommand {
    @Override
    public void doCommand() {
        canvas.getFigures().get(figureID).setVisible(false);
    }
    @Override
    public void undoCommand() {
        canvas.getFigures().get(figureID).setVisible(true);
    }
}

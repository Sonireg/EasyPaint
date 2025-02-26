package paint.ShapeCommand;

import paint.ControlElements.Canvas;

public class EraseCommand extends AbstractShapeCommand {
    
    public EraseCommand(Integer initFigureID, Canvas initCanvas) {
        canvas = initCanvas;
        figureID = initFigureID;
    }

    @Override
    public void doCommand() {
        canvas.getFigures().get(figureID).setVisible(false);
    }
    @Override
    public void undoCommand() {
        canvas.getFigures().get(figureID).setVisible(true);
    }

    @Override
    public String toString() {
        return "EraseCommand " + figureID.toString() + " ";
    }
}

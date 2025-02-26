package paint.ShapeCommand;

import paint.ControlElements.Canvas;

public class FillCommand extends AbstractShapeCommand {

    public FillCommand(Integer initFigureID, Canvas initCanvas, Character initNewColor, Character initOldColor) {
        canvas = initCanvas;
        figureID = initFigureID;
        newColor = initNewColor;
        oldColor = initOldColor;
    }

    @Override
    public void doCommand() {
        canvas.getFigures().get(figureID).setColor(newColor);
    }

    @Override
    public void undoCommand() {
        canvas.getFigures().get(figureID).setColor(oldColor);
    }

    @Override
    public String toString() {
        return "FillCommand " + figureID.toString() + " " + newColor + " " + oldColor + " ";
    }

    private Character newColor;
    private Character oldColor;
}

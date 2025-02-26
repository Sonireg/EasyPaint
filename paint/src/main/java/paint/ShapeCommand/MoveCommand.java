package paint.ShapeCommand;

import paint.ControlElements.Canvas;
import paint.Shape.Vector2;

public class MoveCommand extends AbstractShapeCommand {
    
    public MoveCommand(Integer initFigureID, Canvas initCanvas, Vector2 initMoveDirection) {
        canvas = initCanvas;
        figureID = initFigureID;
        moveDirection = initMoveDirection;
    }

    @Override
    public void doCommand() {
        canvas.getFigures().get(figureID).move(moveDirection);
    }
    @Override
    public void undoCommand() {
        canvas.getFigures().get(figureID).move(moveDirection.negate());
    }

    @Override
    public String toString() {
        return "MoveCommand " + figureID.toString() + " " + moveDirection.x.toString() + " " + moveDirection.y.toString() + " ";
    }

    private Vector2 moveDirection;
}

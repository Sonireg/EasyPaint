package paint.ShapeCommand;

import paint.Shape.Vector2;

public class MoveCommand extends AbstractShapeCommand {
    @Override
    public void doCommand() {
        canvas.getFigures().get(figureID).move(moveDirection);
    }
    @Override
    public void undoCommand() {
        canvas.getFigures().get(figureID).move(moveDirection.negate());
    }
    private Vector2 moveDirection;
}

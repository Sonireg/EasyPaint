package paint.ControlElements;
import java.util.Stack;
import paint.ShapeCommand.AbstractShapeCommand;

public class CommandManager {
    public void completeCommand(AbstractShapeCommand command) {

    }

    public void canceleLastCommand() {

    }

    public void SetDoneCommands(Stack<AbstractShapeCommand> new_commands_stack) {
        
    }


    private Stack<AbstractShapeCommand> doneCommands;
    private Stack<AbstractShapeCommand> undoneCommands;
}

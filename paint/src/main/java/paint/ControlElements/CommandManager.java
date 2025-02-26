package paint.ControlElements;
import java.util.Stack;
import paint.ShapeCommand.AbstractShapeCommand;

public class CommandManager {
    
    public void completeCommand(AbstractShapeCommand command) {
        command.doCommand();
        doneCommands.push(command);
        undoneCommands.clear();
    }

    public void canceleLastCommand() {
        AbstractShapeCommand last_done_command = doneCommands.pop();
        last_done_command.undoCommand();
        undoneCommands.push(last_done_command);
    }

    public void canceleLastCanceledCommand() {
        AbstractShapeCommand last_cancled_command = undoneCommands.pop();
        last_cancled_command.undoUndoCommand();
        doneCommands.push(last_cancled_command);
    }

    public void setDoneCommands(Stack<AbstractShapeCommand> new_commands_stack) {
        undoneCommands.clear();
        doneCommands = new_commands_stack;
    }

    public Stack<AbstractShapeCommand> getDoneCommands() {
        return doneCommands;
    }

    private Stack<AbstractShapeCommand> doneCommands = new Stack<AbstractShapeCommand>();
    private Stack<AbstractShapeCommand> undoneCommands = new Stack<AbstractShapeCommand>();
}

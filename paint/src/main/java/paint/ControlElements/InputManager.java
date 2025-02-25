package paint.ControlElements;
import paint.ControlElements.CommandManager;
import paint.ControlElements.FileManager;

public class InputManager {

    public InputHandlingStates HandleInput(String input) {
        return InputHandlingStates.GOOD;
    }


    private CommandManager commandManager = new CommandManager();
}

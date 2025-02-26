package paint.ControlElements;
import paint.ControlElements.CommandManager;
import paint.ControlElements.FileManager;
import paint.App;

public class InputManager {

    public InputHandlingStates HandleInput(String input, App currAppState) {
        return InputHandlingStates.GOOD;
    }


    private CommandManager commandManager = new CommandManager();
}

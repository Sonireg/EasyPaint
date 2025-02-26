package paint.ControlElements;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import paint.App;
public class FileManager {

    public static InputHandlingStates SaveAppState(String filePath, Canvas canvas, CommandManager commandManager) {
        PrintWriter out;
        try {
            out = new PrintWriter(filePath);
        }
        catch(FileNotFoundException e) {
            return InputHandlingStates.NO_FILE;
        }
        out.println("Figures");
        for (var shape : canvas.getFigures()) {
            out.print(shape.toString());
        }
        out.println("");
        out.println("Commands");
        for (var command : commandManager.getDoneCommands()) {
            out.print(command.toString());
        }
        out.close();
        return InputHandlingStates.GOOD;
    }
    
    public static InputHandlingStates LoadAppStateFromFile(String filePath, App savedApp) {
        return InputHandlingStates.GOOD;
    }
}

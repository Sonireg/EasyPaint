package paint;

import paint.ControlElements.Canvas;
import paint.ControlElements.CommandManager;
import paint.ControlElements.InputManager;
import paint.ControlElements.InputHandlingStates;

import java.util.Scanner;

public class App {

    private Canvas mainCanvas;
    private CommandManager commandManager;
    private InputManager inputManager;

    public App() {
        mainCanvas = new Canvas(25, 80, '.');
        commandManager = new CommandManager();
        inputManager = new InputManager(mainCanvas, commandManager);
    }

    public void MainCycle() {
        Scanner scanner = new Scanner(System.in);
        mainCanvas.redraw();
        while (true) {
            System.out.print("Input your command: ");
            String input = scanner.nextLine();
            InputHandlingStates result = inputManager.handleInput(input);
            switch (result) {
                case QUIT:
                    System.out.println("Exiting the application...");
                    scanner.close();
                    return;
                case NO_FILE:
                    System.out.println("File not found. Please check the file path.");
                    break;
                case NOT_EXISTING_COMMAND:
                    System.out.println("Unknown command! Try again.");
                    break;
                case EMPTY_COMMAND:
                    System.out.println("Empty command not allowed!");
                    break;
                case TO_FEW_ARGUMENTS_FOR_ADD:
                    System.out.println("To few arguments for add command");
                    break;
                case NON_EXISTING_FIGURE:
                    System.out.println("Unknown figure!");
                    break;
                case TO_FEW_ARGUMENTS_FOR_DELETE:
                    System.out.println("To few arguments for delete command");
                    break;
                case TO_FEW_ARGUMENTS_FOR_FILL:
                    System.out.println("To few arguments for fill command");
                    break;
                case TO_FEW_ARGUMENTS_FOR_MOVE:
                    System.out.println("To few arguments for move command");
                    break;
                case TO_FEW_ARGUMENTS_FOR_SAVE:
                    System.out.println("To few arguments for save command");
                    break;
                case TO_FEW_ARGUMENTS_FOR_LOAD:
                    System.out.println("To few arguments for load command");
                    break;
                case INVALID_COLOR:
                    System.out.println("Invalid color");
                    break;
                case INVALID_NUMBER:
                    System.out.println("Invalid number");
                    break;
                case INVALID_INDEX:
                    System.out.println("Invalid index");
                    break;
                default:
                    System.out.println("UNKNOWN ERROR");
                    break;
            }
            mainCanvas.redraw();
        }
    }

    
}
package paint.ControlElements;

import paint.Shape.AbstractShape;
import paint.Shape.Circle;
import paint.Shape.Rectangle;
import paint.Shape.Triangle;
import paint.Shape.Vector2;
import paint.ShapeCommand.AbstractShapeCommand;
import paint.ShapeCommand.AddComand;
import paint.ShapeCommand.EraseCommand;
import paint.ShapeCommand.FillCommand;
import paint.ShapeCommand.MoveCommand;

public class InputManager {

    private Canvas canvas;
    private CommandManager commandManager;

    public InputManager(Canvas canvas, CommandManager commandManager) {
        this.canvas = canvas;
        this.commandManager = commandManager;
    }

    public InputHandlingStates handleInput(String input) {
        String[] tokens = input.split(" ");
        if (tokens.length == 0) {
            return InputHandlingStates.EMPTY_COMMAND;
        }

        String command = tokens[0].toLowerCase();

        switch (command) {
            case "add":
                return handleAddCommand(tokens);
            case "delete":
                return handleDeleteCommand(tokens);
            case "fill":
                return handleFillCommand(tokens);
            case "move":
                return handleMoveCommand(tokens);
            case "undo":
                commandManager.canceleLastCommand();
                return InputHandlingStates.GOOD;
            case "redo":
                commandManager.canceleLastCanceledCommand();
                return InputHandlingStates.GOOD;
            case "save":
                return handleSaveCommand(tokens);
            case "load":
                return handleLoadCommand(tokens);
            case "ls":
                return handleListCommand();
            case "quit":
                return InputHandlingStates.QUIT;
            default:
                return InputHandlingStates.NOT_EXISTING_COMMAND;
        }
    }

    private InputHandlingStates handleAddCommand(String[] tokens) {
        if (tokens.length < 5) {
            return InputHandlingStates.TO_FEW_ARGUMENTS_FOR_ADD;
        }

        if (tokens[4].length() != 1 || !isValidColor(tokens[4].charAt(0))) {
            return InputHandlingStates.INVALID_COLOR;
        }

        try {
            int x = Integer.parseInt(tokens[2]);
            int y = Integer.parseInt(tokens[3]);
            int id = canvas.getFigures().size();

            String shapeType = tokens[1];
            char color = tokens[4].charAt(0);

            AbstractShape shape;
            switch (shapeType) {
                case "circle":
                    int radius = Integer.parseInt(tokens[5]);
                    if (radius <= 0) {
                        return InputHandlingStates.BAD_FIGURE_PARAMETRS;
                    }
                    shape = new Circle(new Vector2(x, y), color, id, radius);
                    break;
                case "rectangle":
                    if (tokens.length < 6) {
                        return InputHandlingStates.TO_FEW_ARGUMENTS_FOR_ADD;
                    }
                    int width = Integer.parseInt(tokens[5]);
                    int height = Integer.parseInt(tokens[6]);
                    if (width <= 0 || height <= 0) {
                        return InputHandlingStates.BAD_FIGURE_PARAMETRS;
                    }
                    shape = new Rectangle(new Vector2(x, y), color, id, width, height);
                    break;
                case "triangle":
                    if (tokens.length < 7) {
                        return InputHandlingStates.TO_FEW_ARGUMENTS_FOR_ADD;
                    }
                    int a = Integer.parseInt(tokens[5]);
                    int b = Integer.parseInt(tokens[6]);
                    int c = Integer.parseInt(tokens[7]);
                    if (a + b < c || b + c < a || c + a < b || a <= 0 || b <= 0 || c <= 0) {
                        return InputHandlingStates.BAD_FIGURE_PARAMETRS;
                    }
                    double p3x = 1. * (b * b - c * c + a * a) / (2 * a);
                    int p3y = (int)Math.sqrt(b * b - p3x * p3x);
                    shape = new Triangle(new Vector2(x, y), color, id, 
                                         new Vector2(a + 1, 0), new Vector2((int)p3x, -p3y));
                    break;
                default:
                    return InputHandlingStates.NON_EXISTING_FIGURE;
            }

            AbstractShapeCommand addCommand = new AddComand(id, canvas, shape);
            commandManager.completeCommand(addCommand);
            return InputHandlingStates.GOOD;
        } catch (NumberFormatException e) {
            return InputHandlingStates.INVALID_NUMBER;
        }
    }

    private InputHandlingStates handleDeleteCommand(String[] tokens) {
        if (tokens.length < 2) {
            return InputHandlingStates.TO_FEW_ARGUMENTS_FOR_DELETE;
        }

        try {
            int id = Integer.parseInt(tokens[1]);
            if (id < 0 || id >= canvas.getFigures().size()) {
                return InputHandlingStates.INVALID_INDEX;
            }

            AbstractShapeCommand eraseCommand = new EraseCommand(id, canvas);
            commandManager.completeCommand(eraseCommand);
            return InputHandlingStates.GOOD;
        } catch (NumberFormatException e) {
            return InputHandlingStates.INVALID_NUMBER;
        }
    }

    private InputHandlingStates handleFillCommand(String[] tokens) {
        if (tokens.length < 3) {
            return InputHandlingStates.TO_FEW_ARGUMENTS_FOR_FILL;
        }

        if (tokens[2].length() != 1 || !isValidColor(tokens[2].charAt(0))) {
            return InputHandlingStates.INVALID_COLOR;
        }

        try {
            int id = Integer.parseInt(tokens[1]);
            if (id < 0 || id >= canvas.getFigures().size()) {
                return InputHandlingStates.INVALID_INDEX;
            }

            char newColor = tokens[2].charAt(0);
            char oldColor = canvas.getFigures().get(id).getColor();
            AbstractShapeCommand fillCommand = new FillCommand(id, canvas, newColor, oldColor);
            commandManager.completeCommand(fillCommand);
            return InputHandlingStates.GOOD;
        } catch (NumberFormatException e) {
            return InputHandlingStates.INVALID_NUMBER;
        }
    }

    private InputHandlingStates handleMoveCommand(String[] tokens) {
        if (tokens.length < 4) {
            return InputHandlingStates.TO_FEW_ARGUMENTS_FOR_MOVE;
        }

        try {
            int id = Integer.parseInt(tokens[1]);
            if (id < 0 || id >= canvas.getFigures().size()) {
                return InputHandlingStates.INVALID_INDEX;
            }

            int deltaX = Integer.parseInt(tokens[2]);
            int deltaY = Integer.parseInt(tokens[3]);
            AbstractShapeCommand moveCommand = new MoveCommand(id, canvas, new Vector2(deltaX, deltaY));
            commandManager.completeCommand(moveCommand);
            return InputHandlingStates.GOOD;
        } catch (NumberFormatException e) {
            return InputHandlingStates.INVALID_NUMBER;
        }
    }

    private InputHandlingStates handleSaveCommand(String[] tokens) {
        if (tokens.length < 2) {
            return InputHandlingStates.TO_FEW_ARGUMENTS_FOR_SAVE;
        }

        String filePath = tokens[1];
        return FileManager.SaveAppState(filePath, canvas, commandManager);
    }

    private InputHandlingStates handleLoadCommand(String[] tokens) {
        if (tokens.length < 2) {
            return InputHandlingStates.TO_FEW_ARGUMENTS_FOR_LOAD;
        }

        String filePath = tokens[1];
        return FileManager.LoadAppStateFromFile(filePath, canvas, commandManager);
    }

    private InputHandlingStates handleListCommand() {
        System.out.println("Figures on canvas:");
        for (int i = 0; i < canvas.getFigures().size(); i++) {
            AbstractShape shape = canvas.getFigures().get(i);
            if (shape.isVisible()) {
                System.out.println(i + ": " + shape.toString());
            }
        }
        return InputHandlingStates.GOOD;
    }

    private boolean isValidColor(char color) {
        return !Character.isWhitespace(color) && !Character.isISOControl(color);
    }
}
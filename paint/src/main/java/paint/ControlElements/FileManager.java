package paint.ControlElements;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;
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

public class FileManager {

    public static InputHandlingStates SaveAppState(String filePath, Canvas canvas, CommandManager commandManager) {
        PrintWriter out;
        try {
            out = new PrintWriter(filePath);
        }
        catch(FileNotFoundException e) {
            return InputHandlingStates.NO_FILE;
        }
        for (var shape : canvas.getFigures()) {
            out.print(shape.toString());
        }
        out.println("END");
        for (var command : commandManager.getDoneCommands()) {
            out.print(command.toString());
        }
        out.close();
        return InputHandlingStates.GOOD;
    }
    

    public static InputHandlingStates LoadAppStateFromFile(String filePath, Canvas canvas, CommandManager commandManager) {
        Scanner inSaved;
        try {
            inSaved = new Scanner(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            return InputHandlingStates.NO_FILE;
        }

        canvas.setFigures(savedShapes(inSaved));
        commandManager.setDoneCommands(savedCommands(inSaved, canvas, canvas.getFigures()));
        inSaved.close();
        return InputHandlingStates.GOOD;
    }


    private static ArrayList<AbstractShape> savedShapes(Scanner inSaved) {
        ArrayList<AbstractShape> shapes = new ArrayList<>();
        while (inSaved.hasNext()) {
            String type = inSaved.next();
            if (type.equals("END")) {
                break;
            }
            
            Vector2 position = new Vector2(inSaved.nextInt(), inSaved.nextInt());
            char color = inSaved.next().charAt(0);
            int id = inSaved.nextInt();

            switch (type) {
                case "circle":
                    int radius = inSaved.nextInt();
                    shapes.add(new Circle(position, color, id, radius));
                    break;
                case "rectangle":
                    int length = inSaved.nextInt();
                    int width = inSaved.nextInt();
                    shapes.add(new Rectangle(position, color, id, length, width));
                    break;
                case "triangle":
                    int height = inSaved.nextInt();
                    shapes.add(new Triangle(position, color, id, height));
                    break;
            }
        }
        return shapes;
    }


    private static Stack<AbstractShapeCommand> savedCommands(Scanner inSaved, Canvas canvas, ArrayList<AbstractShape> shapes) {
        Stack<AbstractShapeCommand> doneCommands = new Stack<>();
        while (inSaved.hasNext()) {
            String commandType = inSaved.next();
            if (!inSaved.hasNextInt()) break;
            int figureID = inSaved.nextInt();
            
            switch (commandType) {
                case "AddComand":
                    doneCommands.push(new AddComand(figureID, canvas, shapes.get(figureID)));
                    break;
                case "EraseCommand":
                    doneCommands.push(new EraseCommand(figureID, canvas));
                    break;
                case "FillCommand":
                    char newColor = inSaved.next().charAt(0);
                    char oldColor = inSaved.next().charAt(0);
                    doneCommands.push(new FillCommand(figureID, canvas, newColor, oldColor));
                    break;
                case "MoveCommand":
                    Vector2 moveVector = new Vector2(inSaved.nextInt(), inSaved.nextInt());
                    doneCommands.push(new MoveCommand(figureID, canvas, moveVector));
                    break;
            }
        }
        return doneCommands;
    }

}

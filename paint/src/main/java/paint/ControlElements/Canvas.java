package paint.ControlElements;
import paint.Shape.AbstractShape;
import java.util.ArrayList;

public class Canvas {
    
    public void SetElement(int x, int y, Character color){
        field.get(x).set(y, color);
    }

    public void FillBackground() {
        for (ArrayList<Character> line : field) {
            for (Character element : line) {
                element = background;
            }
        }
    }

    public int GetWidth() {
        return width;
    }

    public int GetHeight() {
        return height;
    }

    public void Redraw() {
        FillBackground();
        for (AbstractShape shape : figures) {
            shape.draw(this);
        }
    }


    private ArrayList<AbstractShape> figures;
    private ArrayList<ArrayList<Character>> field;
    private int height = 25;
    private int width = 80;
    private Character background;
}

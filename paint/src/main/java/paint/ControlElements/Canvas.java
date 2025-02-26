package paint.ControlElements;
import paint.Shape.AbstractShape;
import java.util.ArrayList;

public class Canvas {
    
    public void setElement(int x, int y, Character color){
        field.get(x).set(y, color);
    }

    public void fillBackground() {
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                field.get(x).set(y, background);
            }
        }
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public void redraw() {
        fillBackground();
        for (AbstractShape shape : figures) {
            shape.draw(this);
        }
    }

    public ArrayList<AbstractShape> getFigures() {
        return figures;
    }


    private ArrayList<AbstractShape> figures;
    private ArrayList<ArrayList<Character>> field;
    private Integer height = 25;
    private Integer width = 80;
    private Character background;
}

package paint.ControlElements;
import paint.Shape.AbstractShape;
import java.util.ArrayList;

import paint.Shape.Vector2;

public class Canvas {
    
    public Canvas(Integer initHeight, Integer initWidth, Character initBackCharacter) {
        height = initHeight;
        width = initWidth;
        background = initBackCharacter;
        field = new ArrayList<ArrayList<Character>>();
        for (int i = 0; i < width; i++) {
            ArrayList<Character> row = new ArrayList<>();
            for (int j = 0; j < height; j++) {
                row.add(background);
            }
            field.add(row);
        }
    }

    public void setElement(Vector2 pos, Character color){
        if (pos.x < 0 || pos.x >= width || pos.y < 0 || pos.y >= height) {
            return;
        }

        field.get(pos.x).set(pos.y, color);
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
        System.out.print("\033[H\033[2J");  
        System.out.flush(); 
        for (AbstractShape shape : figures) {
            shape.draw(this);
        }
        
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(field.get(x).get(y));
                System.out.print(' ');
            }
            System.out.println();
        }
    }

    public ArrayList<AbstractShape> getFigures() {
        return figures;
    }

    public void setFigures(ArrayList<AbstractShape> newFigures) {
        figures = newFigures;
    }


    private ArrayList<AbstractShape> figures = new ArrayList<AbstractShape>();
    private ArrayList<ArrayList<Character>> field;
    private Integer height = 25;
    private Integer width = 80;
    private Character background = '.';
}

package paint.ControlElements;
import paint.Shape.AbstractShape;
import java.util.Vector;

public class Canvas {
    
    public void SetElement(int x, int y, char color){

    }

    public void FillBackground(){

    }

    public int GetWidth() {
        return width;
    }

    public int GetHeight() {
        return height;
    }

    public void Redraw() {
        
    }




    private Vector<AbstractShape> figures;
    private char[][] field;
    private int height;
    private int width;
    private char background;
}

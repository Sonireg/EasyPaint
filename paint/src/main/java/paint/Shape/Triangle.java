package paint.Shape;
import paint.ControlElements.Canvas;

public class Triangle extends AbstractShape {
    public Triangle(Vector2 initPos, char initColor, int initID, Vector2 p1, Vector2 p2) {
        this.position = initPos;
        this.color = initColor;
        this.id = initID;
        this.vectToSecondVert = p1;
        this.vectToThirdVert = p2;
    }

    @Override
    public void draw(Canvas canvas) {
        if (!isVisible) {
            return;
        }
        
        int minX = Math.min(Math.min(position.x, position.sumWith(vectToSecondVert).x), position.sumWith(vectToThirdVert).x);
        int minY = Math.min(Math.min(position.y, position.sumWith(vectToSecondVert).y), position.sumWith(vectToThirdVert).y);
        int maxX = Math.max(Math.max(position.x, position.sumWith(vectToSecondVert).x), position.sumWith(vectToThirdVert).x);
        int maxY = Math.max(Math.max(position.y, position.sumWith(vectToSecondVert).y), position.sumWith(vectToThirdVert).y);

        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                Vector2 point = new Vector2(x, y);
                if (isPointInsideTriangle(point)) {
                    canvas.setElement(point, color);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "triangle " + position.toString() + color + " " + isVisible + " " 
        + vectToSecondVert.toString() + vectToThirdVert.toString();
    }



    private boolean isPointInsideTriangle(Vector2 point) {
        // Вершины треугольника
        Vector2 A = position;
        Vector2 B = position.sumWith(vectToSecondVert);
        Vector2 C = position.sumWith(vectToThirdVert);
        
        // Вычисление площади треугольников
        int areaOriginal = (B.x - A.x) * (C.y - A.y) - (B.y - A.y) * (C.x - A.x);
        int area1 = (A.x - point.x) * (B.y - point.y) - (A.y - point.y) * (B.x - point.x);
        int area2 = (B.x - point.x) * (C.y - point.y) - (B.y - point.y) * (C.x - point.x);
        int area3 = (C.x - point.x) * (A.y - point.y) - (C.y - point.y) * (A.x - point.x);
    
        // Проверка, что все площади имеют одинаковый знак (или равны нулю)
        boolean hasSameSign = (areaOriginal > 0 && area1 > 0 && area2 > 0 && area3 > 0)
                            || (areaOriginal < 0 && area1 < 0 && area2 < 0 && area3 < 0)
                            || (areaOriginal == 0 && (area1 == 0 || area2 == 0 || area3 == 0));
    
        return hasSameSign;
    }

    private Vector2 vectToSecondVert;
    private Vector2 vectToThirdVert;
}

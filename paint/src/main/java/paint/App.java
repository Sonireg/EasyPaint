package paint;
import paint.ControlElements.Canvas;
import paint.ControlElements.InputManager;

public class App {
    private Canvas mainCanvas;
    private InputManager inputManager;
    public Canvas GetCanvas() {
        return mainCanvas;
    }
    public void SetCanvas(Canvas canvas) {
        mainCanvas = canvas;
    }
    public void MainCycle() {
    }
}

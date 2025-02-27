import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.PrintStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

import paint.App;


public class AppTest {
    
    @Test
    void testFromFile() {
        try {
            Scanner scanner = new Scanner(new File("TestCases/testAmount"));
            int testAmount = scanner.nextInt();
            scanner.close();
            for (int i = 1; i <= testAmount; ++i) {
                String simulatedUserInput = new String(Files.readAllBytes(Path.of("TestCases/" + i)));
                System.setIn(new ByteArrayInputStream(simulatedUserInput.getBytes()));
        
                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
                System.setOut(new PrintStream(outputStream));
        
                App app = new App();
                app.MainCycle();
        
                String consoleOutput = outputStream.toString().trim();
                
                String exp = new String(Files.readAllBytes(Path.of("TestCases/" + i + "ans")));;
        
                assertEquals(exp.replaceAll("\\s+", ""), 
                             consoleOutput.replaceAll("\\s+", ""), 
                             "Неверный результат в тесте " + i);
            
            }
        }
        catch (Exception e) {
            assertTrue(false, "Нет файла с тестом или ответом на него!");
        }
    }
}

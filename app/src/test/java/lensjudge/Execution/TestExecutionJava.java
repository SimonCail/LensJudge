package lensjudge.Execution;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestExecutionJava {

    @Test
    @DisplayName("Test execute Java")
    public void testExecute() {
        ExecutionJava executionJava = new ExecutionJava();
        String sourceFilePath="/export/etu/simon.caillieret/Documents/QDEV/SAE/groupe-b2-s3.a.01/app/src/test/java/lensjudge/Execution/TestExecutionJava.java";
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        executionJava.execute(sourceFilePath);

        String expectedOutput = "Expected output from the Java program";
        assertTrue(outContent.toString().contains(expectedOutput));

        System.setOut(System.out);

    }

}

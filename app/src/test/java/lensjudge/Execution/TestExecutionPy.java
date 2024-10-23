package lensjudge.Execution;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestExecutionPy {

    @Test
    @DisplayName("Test execute Python")
    public void testExecute() {
        ExecutionPy executionPy = new ExecutionPy();
        String binaryFileName = "/export/etu/simon.caillieret/Documents/QDEV/SAE/groupe-b2-s3.a.01/ProgTestSae/timethroughtheglass.py";
        executionPy.execute(binaryFileName);
    }
}

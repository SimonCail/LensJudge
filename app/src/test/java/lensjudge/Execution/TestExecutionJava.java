package lensjudge.Execution;

import lensjudge.compilation.CompilerC;
import lensjudge.compilation.CompilerJava;
import lensjudge.process.ProcessAdapter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestExecutionJava {
    @Test
    @DisplayName("Test ExecutionJava")
    public void testExecute() {
        ExecutionJava executionJava = new ExecutionJava();
        String sourceFilePath = "/export/etu/simon.caillieret/Documents/QDEV/SAE/groupe-b2-s3.a.01/ProgTestSae/TimeThroughTheGlass.java";
        File sourceFile=new File(sourceFilePath);
        CompilerJava compilerJava=new CompilerJava();
        String className = compilerJava.getBinaryFileName(sourceFilePath);
        compilerJava.executeCompilerCommand(sourceFile,className);
        ProcessAdapter process=executionJava.execute(sourceFilePath, className);
        process.startProcess();
        assertEquals("Hello\n", process.getStandardOutput());
    }
}

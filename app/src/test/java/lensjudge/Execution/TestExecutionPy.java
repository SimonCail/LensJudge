package lensjudge.Execution;

import lensjudge.compilation.CompilerPython;
import lensjudge.process.ProcessAdapter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestExecutionPy {
    @Test
    @DisplayName("Test ExecutionPy")
    public void testExecute() {
        ExecutionPy executionPy = new ExecutionPy();
        String sourceFilePath2 = "/SAEA3.01/groupe-b2-s3.a.01/app/src/test/resources/ProgTestSae/timethroughtheglass.py";
        File sourceFile2=new File(sourceFilePath2);
        CompilerPython compilerPython = new CompilerPython();
        compilerPython.executeCompilerCommand(sourceFile2, null);
        ProcessAdapter process=executionPy.execute(sourceFilePath2, null);
        process.startProcess();
        assertEquals("HELLO WORLD\n", process.getStandardOutput());
    }
}

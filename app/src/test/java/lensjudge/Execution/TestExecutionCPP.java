package lensjudge.Execution;

import lensjudge.compilation.CompilerCPP;
import lensjudge.process.ProcessAdapter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestExecutionCPP {
    @Test
    @DisplayName("Test ExecutionCPP")
    public void testExecute() {
        ExecutionCPP executionCC = new ExecutionCPP();
        String sourceFilePath = "app/src/test/resources/ProgTestSae/timethroughtheglass.cc";
        File sourceFile=new File(sourceFilePath);
        CompilerCPP compilerCPP=new CompilerCPP();
        String binaryFileName;
        binaryFileName= compilerCPP.getBinaryFileName(sourceFilePath);
        compilerCPP.executeCompilerCommand(sourceFile, binaryFileName);
        ProcessAdapter process=executionCC.execute(sourceFilePath, binaryFileName);
        process.startProcess();
        assertEquals("Bonjour !\n", process.getStandardOutput());
    }
}

package lensjudge.testcompiler;

import lensjudge.compilation.CompilerC;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCompilerC {

    @Test
    @DisplayName("Test isCompatible()")
    public void testIsCompatible() {
        CompilerC compilerC = new CompilerC();
        assertTrue(compilerC.isCompatible("c"));
        assertFalse(compilerC.isCompatible("python"));
    }

    @Test
    @DisplayName("Test getBinaryFileName()")
    public void testGetBinaryFileName() {
        CompilerC compilerC = new CompilerC();
        String sourceFileName = "test.c";
        String expected = "test.exe";
        String actual = compilerC.getBinaryFileName(sourceFileName);
        assertTrue(expected.equals(actual));
    }

    @Test
    @DisplayName("Test executeCompilerCommand()")
    public void testExecuteCompilerCommand() {
        CompilerC compilerC = new CompilerC();
        File sourceFile = new File("/export/etu/simon.caillieret/Documents/QDEV/SAE/groupe-b2-s3.a.01/ProgTestSae/timethroughtheglass.c");
        String binaryFileName = "/export/etu/simon.caillieret/Documents/QDEV/SAE/groupe-b2-s3.a.01/ProgTestSae/timethroughtheglassC.exe";
        try {
            compilerC.executeCompilerCommand(sourceFile, binaryFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
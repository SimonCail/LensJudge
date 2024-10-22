package lensjudge.testcompiler;

import lensjudge.compilation.CompilerPython;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCompilerPython {
    @Test
    @DisplayName("Test isCompatible()")
    public void testIsCompatible() {
        CompilerPython compilerPython = new CompilerPython();
        assertTrue(compilerPython.isCompatible("python"));
        assertFalse(compilerPython.isCompatible("java"));
    }

    @Test
    @DisplayName("Test getBinaryFileName()")
    public void testGetBinaryFileName() {
        CompilerPython compilerPython = new CompilerPython();
        String sourceFileName = "test.py";
        String expected = "test.py";
        String actual = compilerPython.getBinaryFileName(sourceFileName);
        assertTrue(expected.equals(actual));
    }

    @Test
    @DisplayName("Test executeCompilerCommand()")
    public void testExecuteCompilerCommand() {
        CompilerPython compilerPython = new CompilerPython();
        String sourceFileName = "/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae/timethroughtheglass.py";
        String binaryFileName = "/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae/timethroughtheglass.py";
        try {
            compilerPython.executeCompilerCommand(sourceFileName, binaryFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

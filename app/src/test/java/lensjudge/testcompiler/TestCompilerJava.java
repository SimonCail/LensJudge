package lensjudge.testcompiler;

import lensjudge.compilation.CompilerJava;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCompilerJava {

    @Test
    @DisplayName("Test isCompatible()")
    public void testIsCompatible() {
        CompilerJava compilerJava = new CompilerJava();
        assertTrue(compilerJava.isCompatible("java"));
        assertFalse(compilerJava.isCompatible("cpp"));
    }

    @Test
    @DisplayName("Test getBinaryFileName()")
    public void testGetBinaryFileName() {
        CompilerJava compilerJava = new CompilerJava();
        String sourceFileName = "test.java";
        String expected = "test.class";
        String actual = compilerJava.getBinaryFileName(sourceFileName);
        assertTrue(expected.equals(actual));
    }

    @Test
    @DisplayName("Test executeCompilerCommand()")
    public void testExecuteCompilerCommand() {
        CompilerJava compilerJava = new CompilerJava();
        File sourceFile = new File("/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae/timethroughtheglass.java");
        String binaryFileName = "/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae/timethroughtheglass.class";
        try {
            compilerJava.executeCompilerCommand(sourceFile, binaryFileName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
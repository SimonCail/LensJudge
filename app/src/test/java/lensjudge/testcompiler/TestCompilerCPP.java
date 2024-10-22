package lensjudge.testcompiler;

import lensjudge.compilation.CompilerCPP;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCompilerCPP {

    @Test
    @DisplayName("Test isCompatible()")
    public void testIsCompatible() {
        CompilerCPP compilerCPP = new CompilerCPP();
        assertTrue(compilerCPP.isCompatible("cpp"));
        assertFalse(compilerCPP.isCompatible("java"));
    }

    @Test
    @DisplayName("Test getBinaryFileName()")
    public void testGetBinaryFileName() {
        CompilerCPP compilerCPP = new CompilerCPP();
        String sourceFileName = "test.cpp";
        String expected = "test.exe";
        String actual = compilerCPP.getBinaryFileName(sourceFileName);
        assertTrue(expected.equals(actual));
    }

    @Test
    @DisplayName("Test executeCompilerCommand()")
    public void testExecuteCompilerCommand() {
        CompilerCPP compilerCPP = new CompilerCPP();
        File sourceFile = new File("/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae/timethroughtheglass.cpp");
        File binaryFile = new File("/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae/timethroughtheglass.exe");
        try {
            compilerCPP.executeCompilerCommand(sourceFile, binaryFile);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
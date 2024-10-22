package lensjudge.compilation;

import java.io.File;
import java.io.IOException;

/**
 * Interface for the compiler strategy
 */
public interface ICompilerStrategy {
    void compile(String sourceFileName, String languageSelected) throws IOException , InterruptedException;
    boolean isCompatible(String languageSelected);
    String getBinaryFileName(String sourceFileName);
    void executeCompilerCommand(File sourceFile, File binaryFile) throws IOException , InterruptedException;
}

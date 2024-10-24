package lensjudge.compilation;

import java.io.File;
import java.io.IOException;

/**
 * Interface for the compiler strategy
 */
public interface ICompilerStrategy {
    /**
     * Checks if the language selected is compatible with the compiler
     * @param sourceFileName
     * @param languageSelected
     * @throws IOException
     * @throws InterruptedException
     */
    void compile(String sourceFileName, String languageSelected) throws IOException , InterruptedException;

    /**
     * Checks if the language selected is compatible with the compiler
     * @param languageSelected
     * @return
     */
    boolean isCompatible(String languageSelected);

    /**
     * Returns the binary file name
     * @param sourceFileName
     * @return
     */
    String getBinaryFileName(String sourceFileName);

    /**
     * Executes the compiler command
     * @param sourceFile
     * @param binaryFile
     * @throws IOException
     * @throws InterruptedException
     */
    void executeCompilerCommand(File sourceFile, String binaryFile) throws IOException , InterruptedException;
}

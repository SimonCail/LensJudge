package lensjudge.compilation;

import java.io.File;
import java.io.IOException;

/**
 * Interface for the compiler strategy.
 */
public interface ICompilerStrategy {
    /**
     * Compiles the source file if the language selected is compatible with the compiler.
     *
     * @param sourceFileName the name of the source file
     * @param languageSelected the language selected for compilation
     * @throws IOException if an I/O error occurs
     * @throws InterruptedException if the execution is interrupted
     */
    void compile(String sourceFileName, String languageSelected) throws IOException, InterruptedException;

    /**
     * Checks if the language selected is compatible with the compiler.
     *
     * @param languageSelected the language selected
     * @return true if the language is compatible, false otherwise
     */
    boolean isCompatible(String languageSelected);

    /**
     * Returns the binary file name.
     *
     * @param sourceFileName the name of the source file
     * @return the name of the binary file
     */
    String getBinaryFileName(String sourceFileName);

    /**
     * Executes the compiler command.
     *
     * @param sourceFile the source file
     * @param binaryFile the binary file
     * @throws IOException if an I/O error occurs
     * @throws InterruptedException if the execution is interrupted
     */
    void executeCompilerCommand(File sourceFile, String binaryFile) throws IOException, InterruptedException;
}
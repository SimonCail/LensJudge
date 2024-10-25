package lensjudge.compilation;

import java.io.File;
import java.io.IOException;

/**
 * The CompilerStrategy class is an abstract class that implements the ICompilerStrategy interface.
 * It provides a template method for compiling source files using a specific compiler strategy.
 */
public abstract class CompilerStrategy implements ICompilerStrategy {

    /**
     * Compiles the source file if the language selected is compatible with the compiler.
     *
     * @param sourceFileName the name of the source file
     * @param languageSelected the language selected for compilation
     * @throws IOException if an I/O error occurs
     * @throws InterruptedException if the execution is interrupted
     */
    @Override
    public void compile(String sourceFileName, String languageSelected) throws IOException, InterruptedException {
        if (isCompatible(languageSelected)) {
            File sourceFile = new File(sourceFileName);
            String binaryFileName = getBinaryFileName(sourceFileName);
            executeCompilerCommand(sourceFile, binaryFileName);
        } else {
            throw new IllegalArgumentException("Language not supported or not found");
        }
    }
}

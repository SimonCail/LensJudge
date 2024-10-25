package lensjudge.compilation;

import java.io.File;
import java.io.IOException;

public class CompilerContext {

    /**
     * Strategy for the compiler context
     */
    private ICompilerStrategy strategy;

    /**
     * Set the strategy for the compiler context
     * @param strategy
     */
    public void setStrategy(ICompilerStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Compiles the source file
     * @param sourceFile the source file
     * @param languageSelected the language selected
     * @throws InterruptedException
     * @throws IOException
     */
    public void compile(File sourceFile, String languageSelected) throws IOException , InterruptedException{
        if (strategy == null || !strategy.isCompatible(languageSelected)) {
            throw new IllegalArgumentException("No compatible strategy set for the selected language.");
        }
        String binaryFileName = strategy.getBinaryFileName(sourceFile.getName());
        strategy.executeCompilerCommand(sourceFile, binaryFileName);
    }
}
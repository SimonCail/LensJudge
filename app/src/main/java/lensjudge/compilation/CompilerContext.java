package lensjudge.compilation;

import java.io.File;

/**
 * The CompilerContext class is responsible for managing the compilation process
 * using a specified strategy.
 */
public class CompilerContext {

    /**
     * Strategy for the compiler context.
     */
    private ICompilerStrategy strategy;

    /**
     * Sets the strategy for the compiler context.
     *
     * @param strategy the strategy to be set
     */
    public void setStrategy(ICompilerStrategy strategy) {
        this.strategy = strategy;
    }

    /**
     * Compiles the source file using the set strategy.
     *
     * @param sourceFile the source file to be compiled
     * @param languageSelected the language selected for compilation
     * @throws Exception if no compatible strategy is set or if an error occurs during compilation
     */
    public void compile(File sourceFile, String languageSelected) throws Exception {
        if (strategy == null || !strategy.isCompatible(languageSelected)) {
            throw new IllegalArgumentException("No compatible strategy set for the selected language.");
        }
        String binaryFileName = strategy.getBinaryFileName(sourceFile.getName());
        strategy.executeCompilerCommand(sourceFile, binaryFileName);
    }
}
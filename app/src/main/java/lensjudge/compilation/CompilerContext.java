package lensjudge.compilation;

import java.io.File;

public class CompilerContext {
    private ICompilerStrategy strategy;

    public void setStrategy(ICompilerStrategy strategy) {
        this.strategy = strategy;
    }

    public void compile(File sourceFile, String languageSelected) throws Exception {
        if (strategy == null || !strategy.isCompatible(languageSelected)) {
            throw new IllegalArgumentException("No compatible strategy set for the selected language.");
        }
        String binaryFileName = strategy.getBinaryFileName(sourceFile.getName());
        strategy.executeCompilerCommand(sourceFile, binaryFileName);
    }
}
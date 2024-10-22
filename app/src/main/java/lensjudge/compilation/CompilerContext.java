package lensjudge.compilation;

import java.io.File;

public class CompilerContext {
    private ICompilerStrategy strategy;

    public void setStrategy(ICompilerStrategy strategy) {
        this.strategy = strategy;
    }

    public void compile(String sourceFileName, String languageSelected) throws Exception {
        if (strategy == null || !strategy.isCompatible(languageSelected)) {
            throw new IllegalArgumentException("No compatible strategy set for the selected language.");
        }
        File sourceFile = new File(sourceFileName);
        File binaryFile = new File(strategy.getBinaryFileName(sourceFileName));
        strategy.executeCompilerCommand(sourceFile, binaryFile);
    }
}

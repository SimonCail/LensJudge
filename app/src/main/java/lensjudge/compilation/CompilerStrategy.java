package lensjudge.compilation;

import java.io.IOException;

public abstract class CompilerStrategy {
    protected abstract boolean isCompatible(String languageSelected);
    protected abstract String getBinaryFileName(String sourceFileName);
    protected abstract void executeCompilerCommand(String sourceFileName, String binaryFileName) throws IOException , InterruptedException;

    public void compile(String sourceFileName, String languageSelected) throws IOException, InterruptedException {
        if (isCompatible(languageSelected)) {
            String binaryFileName = getBinaryFileName(sourceFileName);
            executeCompilerCommand(sourceFileName, binaryFileName);
        } else {
            throw new IllegalArgumentException("Language not supported or not found");
        }
    }
}

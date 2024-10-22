package lensjudge.compilation;

import java.io.IOException;

public abstract class CompilerStrategy implements ICompilerStrategy {
    public void compile(String sourceFileName, String languageSelected) throws IOException, InterruptedException {
        if (isCompatible(languageSelected)) {
            String binaryFileName = getBinaryFileName(sourceFileName);
            executeCompilerCommand(sourceFileName, binaryFileName);
        } else {
            throw new IllegalArgumentException("Language not supported or not found");
        }
    }
}

package lensjudge.compilation;

import java.io.IOException;

public interface ICompilerStrategy {
    void compile(String sourceFileName, String languageSelected) throws IOException , InterruptedException;
    boolean isCompatible(String languageSelected);
    String getBinaryFileName(String sourceFileName);
    void executeCompilerCommand(String sourceFileName, String binaryFileName) throws IOException , InterruptedException;
}

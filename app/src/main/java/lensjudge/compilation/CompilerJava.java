package lensjudge.compilation;

import java.io.File;
import java.io.IOException;

public class CompilerJava extends CompilerStrategy {

    /**
     * Checks if the language selected is compatible with the compiler
     * @param languageSelected
     * @return
     */
    @Override
    public boolean isCompatible(String languageSelected) {
        return languageSelected.equals("java");
    }

    /**
     * Returns the binary file name
     * @param sourceFileName
     * @return
     */
    @Override
    public String getBinaryFileName(String sourceFileName) {
        int size = sourceFileName.length();
        String binaryFileName = sourceFileName.substring(0, size - 4);
        binaryFileName = binaryFileName + "class";
        return binaryFileName;
    }

    /**
     * Executes the compiler command
     * @param sourceFile
     * @param binaryFile
     * @throws IOException
     * @throws InterruptedException
     */
    @Override
    public void executeCompilerCommand(File sourceFile, String binaryFile) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder("javac", sourceFile.getAbsolutePath());
        processBuilder.inheritIO();
        Process process = processBuilder.start();
        process.waitFor();
    }

    /**
     * Returns the language
     * @return
     */
    protected String getLanguage() {
        return "java";
    }
}
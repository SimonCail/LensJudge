package lensjudge.compilation;

import java.io.File;
import java.io.IOException;

/**
 * The CompilerJava class extends the CompilerStrategy class and provides
 * the functionality to compile Java programs.
 */
public class CompilerJava extends CompilerStrategy {

    /**
     * Checks if the language selected is compatible with the compiler.
     *
     * @param languageSelected the language selected
     * @return true if the language is compatible, false otherwise
     */
    @Override
    public boolean isCompatible(String languageSelected) {
        return languageSelected.equals("java");
    }

    /**
     * Returns the binary file name.
     *
     * @param sourceFileName the name of the source file
     * @return the name of the binary file
     */
    @Override
    public String getBinaryFileName(String sourceFileName) {
        int size = sourceFileName.length();
        String binaryFileName = sourceFileName.substring(0, size - 4) + "class";
        return binaryFileName;
    }

    /**
     * Executes the compiler command.
     *
     * @param sourceFile the source file
     * @param binaryFile the binary file
     * @throws IOException if an I/O error occurs
     * @throws InterruptedException if the execution is interrupted
     */
    @Override
    public void executeCompilerCommand(File sourceFile, String binaryFile) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder("javac", sourceFile.getAbsolutePath());
        processBuilder.inheritIO();
        Process process = processBuilder.start();
        process.waitFor();
    }

    /**
     * Returns the language supported by this compiler.
     *
     * @return the language supported by this compiler
     */
    protected String getLanguage() {
        return "java";
    }
}
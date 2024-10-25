package lensjudge.compilation;

import java.io.File;

/**
 * The CompilerCPP class extends the CompilerStrategy class and provides
 * the functionality to compile C++ programs.
 */
public class CompilerCPP extends CompilerStrategy {

    /**
     * Checks if the language selected is compatible with the compiler.
     *
     * @param languageSelected the language selected
     * @return true if the language is compatible, false otherwise
     */
    @Override
    public boolean isCompatible(String languageSelected) {
        return languageSelected.equals("cc");
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
        String binaryFileName = sourceFileName.substring(0, size - 2) + "exe";
        return binaryFileName;
    }

    /**
     * Executes the compiler command.
     *
     * @param sourceFile the source file
     * @param binaryFile the binary file
     */
    @Override
    public void executeCompilerCommand(File sourceFile, String binaryFile) {
        ProcessBuilder processBuilder = new ProcessBuilder("g++", "-x", "c++", "-Wall", "-O2", "-pipe", "-lm", "-o", binaryFile, sourceFile.getAbsolutePath());
        processBuilder.inheritIO();
        try {
            Process process = processBuilder.start();
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Returns the language supported by this compiler.
     *
     * @return the language supported by this compiler
     */
    protected String getLanguage() {
        return "cc";
    }
}
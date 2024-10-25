package lensjudge.compilation;

import java.io.File;

/**
 * The CompilerPython class extends the CompilerStrategy class and provides
 * the functionality to compile Python programs.
 */
public class CompilerPython extends CompilerStrategy {

    /**
     * Checks if the language selected is compatible with the compiler.
     *
     * @param languageSelected the language selected
     * @return true if the language is compatible, false otherwise
     */
    @Override
    public boolean isCompatible(String languageSelected) {
        return "python".equalsIgnoreCase(languageSelected);
    }

    /**
     * Returns the binary file name.
     *
     * @param sourceFileName the name of the source file
     * @return the name of the binary file
     */
    @Override
    public String getBinaryFileName(String sourceFileName) {
        return sourceFileName;
    }

    /**
     * Executes the compiler command.
     *
     * @param sourceFile the source file
     * @param binaryFile the binary file
     */
    @Override
    public void executeCompilerCommand(File sourceFile, String binaryFile) {
        ProcessBuilder processBuilder = new ProcessBuilder("python3", "-m", "py_compile", sourceFile.getAbsolutePath());
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
        return "python";
    }
}

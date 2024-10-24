package lensjudge.compilation;

import java.io.File;

public class CompilerPython extends CompilerStrategy {

    /**
     * Checks if the language selected is compatible with the compiler
     * @param languageSelected
     * @return
     */
    @Override
    public boolean isCompatible(String languageSelected) {
        return "python".equalsIgnoreCase(languageSelected);
    }

    /**
     * Returns the binary file name
     * @param sourceFileName
     * @return
     */
    @Override
    public String getBinaryFileName(String sourceFileName) {
        return sourceFileName;
    }

    /**
     * Executes the compiler command
     * @param sourceFile
     * @param binaryFile
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
     * Returns the language
     * @return
     */
    protected String getLanguage() {
        return "python";
    }
}

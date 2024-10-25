package lensjudge.compilation;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The CompilerC class extends the CompilerStrategy class and provides
 * the functionality to compile C programs.
 */
public class CompilerC extends CompilerStrategy {

    private static final Logger LOGGER = Logger.getLogger(CompilerC.class.getName());

    /**
     * Checks if the language selected is compatible with the compiler.
     *
     * @param languageSelected the language selected
     * @return true if the language is compatible, false otherwise
     */
    @Override
    public boolean isCompatible(String languageSelected) {
        return languageSelected.equals("c");
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
        String binaryFileName = sourceFileName.substring(0, size - 1) + "exe";
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
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("gcc", "-x", "c", "-Wall", "-O2", "-pipe", "-lm", "-o", binaryFile, sourceFile.getAbsolutePath());
            processBuilder.inheritIO();
            Process process = processBuilder.start();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            LOGGER.log(Level.SEVERE, "Exception occurred during compilation", e);
            Thread.currentThread().interrupt();
        }
    }

    /**
     * Returns the language supported by this compiler.
     *
     * @return the language supported by this compiler
     */
    protected String getLanguage() {
        return "c";
    }
}
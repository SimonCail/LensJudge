package lensjudge.compilation;

import java.io.File;

public class CompilerC extends CompilerStrategy {

    /**
     * Checks if the language selected is compatible with the compiler
     * @param languageSelected the language selected
     * @return true if the language is compatible, false otherwise
     */
    @Override
    public boolean isCompatible(String languageSelected) {
        return languageSelected.equals("c");
    }

    /**
     * Returns the binary file name
     * @param sourceFileName
     * @return
     */
    @Override
    public String getBinaryFileName(String sourceFileName) {
        return sourceFileName.replace("C.c", ".exe");
    }

    /**
     * Executes the compiler command
     * @param sourceFile the source file
     * @param binaryFile the binary file
     */
    @Override
    public void executeCompilerCommand(File sourceFile, String binaryFile) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("gcc", "-x", "c" , "-Wall" , "-O2" , "-pipe" , "-lm" , "-o" , binaryFile, sourceFile.getAbsolutePath());
            processBuilder.inheritIO();
            Process process = processBuilder.start();
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected String getLanguage() {
        return "c";
    }
}

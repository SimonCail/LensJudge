package lensjudge.compilation;

import java.io.File;

public class CompilerCPP extends CompilerStrategy {

    /**
     * Checks if the language selected is compatible with the compiler
     * @param languageSelected
     * @return
     */
    @Override
    public boolean isCompatible(String languageSelected) {
        return languageSelected.equals("cpp");
    }

    /**
     * Returns the binary file name
     * @param sourceFileName
     * @return
     */
    @Override
    public String getBinaryFileName(String sourceFileName) {
        return sourceFileName.replace(".cpp", ".exe");
    }

    /**
     * Executes the compiler command
     * @param sourceFile
     * @param binaryFile
     */
    @Override
    public void executeCompilerCommand(File sourceFile, String binaryFile) {
        ProcessBuilder processBuilder = new ProcessBuilder("g++", "-x", "c++" , "-Wall" , "-O2" , "-pipe" , "-lm" , "-o" , binaryFile, sourceFile.getAbsolutePath());
        processBuilder.inheritIO();
        try {
            Process process = processBuilder.start();
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected String getLanguage() {
        return "cpp";
    }
}

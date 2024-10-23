package lensjudge.compilation;

import java.io.File;

public class CompilerCPP extends CompilerStrategy {

    @Override
    public boolean isCompatible(String languageSelected) {
        return languageSelected.equals("cc");
    }

    @Override
    public String getBinaryFileName(String sourceFileName) {
        return sourceFileName.replace(".cc", ".exe");
    }

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
        return "cc";
    }
}

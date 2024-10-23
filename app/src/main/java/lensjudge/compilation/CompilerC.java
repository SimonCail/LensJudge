package lensjudge.compilation;

import java.io.File;

public class CompilerC extends CompilerStrategy {

    @Override
    public boolean isCompatible(String languageSelected) {
        return languageSelected.equals("c");
    }

    @Override
    public String getBinaryFileName(String sourceFileName) {
        return sourceFileName.replace("s.c", ".exe");
    }

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

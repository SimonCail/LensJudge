package lensjudge.compilation;

import java.io.File;

public class CompilerCPP extends CompilerStrategy {

    @Override
    public boolean isCompatible(String languageSelected) {
        return languageSelected.equals("cpp");
    }

    @Override
    public String getBinaryFileName(String sourceFileName) {
        return sourceFileName.replace(".cpp", ".exe");
    }

    @Override
    public void executeCompilerCommand(File sourceFile, File binaryFile) {
        ProcessBuilder processBuilder = new ProcessBuilder("g++", "-x", "c++" , "-Wall" , "-O2" , "-pipe" , "-lm" , "-o" , binaryFile.getAbsolutePath(), sourceFile.getAbsolutePath());
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

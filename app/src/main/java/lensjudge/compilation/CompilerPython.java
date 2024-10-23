package lensjudge.compilation;

import java.io.File;

public class CompilerPython extends CompilerStrategy {

    @Override
    public boolean isCompatible(String languageSelected) {
        return "python".equalsIgnoreCase(languageSelected);
    }

    @Override
    public String getBinaryFileName(String sourceFileName) {
        return sourceFileName;
    }

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

    protected String getLanguage() {
        return "python";
    }
}

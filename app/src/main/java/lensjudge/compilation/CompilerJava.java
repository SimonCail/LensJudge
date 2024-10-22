package lensjudge.compilation;

import java.io.IOException;

public class CompilerJava extends CompilerStrategy{

    @Override
    public boolean isCompatible(String languageSelected) {
        return languageSelected.equals("java");
    }

    @Override
    public String getBinaryFileName(String sourceFileName) {
        return sourceFileName.replace(".java", ".class");
    }

    @Override
    public void executeCompilerCommand(String sourceFileName, String binaryFileName) throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder("javac", "-d", "compilation", sourceFileName);
        processBuilder.inheritIO();
        Process process = processBuilder.start();
        process.waitFor();
    }
}

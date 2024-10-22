package lensjudge.compilation;

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
    public void executeCompilerCommand(String sourceFileName, String binaryFileName) {
        ProcessBuilder processBuilder = new ProcessBuilder("python3", "-m", "py_compile", sourceFileName);
        processBuilder.inheritIO();
        try {
            Process process = processBuilder.start();
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

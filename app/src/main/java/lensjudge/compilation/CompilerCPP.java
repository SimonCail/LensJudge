package lensjudge.compilation;

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
    public void executeCompilerCommand(String sourceFileName, String binaryFileName) {
        ProcessBuilder processBuilder = new ProcessBuilder("g++", "-x", "c++" , "-Wall" , "-O2" , "-pipe" , "-lm" , "-o" , binaryFileName, sourceFileName);
        processBuilder.inheritIO();
        try {
            Process process = processBuilder.start();
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

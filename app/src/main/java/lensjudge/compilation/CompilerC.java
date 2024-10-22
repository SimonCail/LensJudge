package lensjudge.compilation;

public class CompilerC extends CompilerStrategy {

    @Override
    public boolean isCompatible(String languageSelected) {
        return languageSelected.equals("c");
    }

    @Override
    public String getBinaryFileName(String sourceFileName) {
        return "exe";
    }

    @Override
    public void executeCompilerCommand(String sourceFileName, String binaryFileName) {
        try {
            ProcessBuilder processBuilder = new ProcessBuilder("gcc", "-x", "c" , "-Wall" , "-02" , "-pipe" , "-lm" , "-o" , binaryFileName, sourceFileName);
            processBuilder.inheritIO();
            Process process = processBuilder.start();
            process.waitFor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

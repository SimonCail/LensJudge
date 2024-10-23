package lensjudge.runnerbuilder;

import lensjudge.compilation.ICompilerStrategy;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Runner {
    private File sourceFile;
    private String inputFileName;
    private String outputFileName;
    private ICompilerStrategy compilerStrategy;

    public Runner(File sourceFile, String inputFileName, String outputFileName, ICompilerStrategy compilerStrategy) {
        this.sourceFile = sourceFile;
        this.inputFileName = inputFileName;
        this.outputFileName = outputFileName;
        this.compilerStrategy = compilerStrategy;
    }

    public String run() {
        try {
            compile();
            String result = execute();
            if (verify(result)) {
                return "Correct";
            } else {
                return "Wrong Answer";
            }
        } catch (Exception e) {
            return "Compilation Error: " + e.getMessage();
        }
    }

    private void compile() throws IOException, InterruptedException {
        compilerStrategy.compile(sourceFile.getPath(), getLanguage(new File(sourceFile.getName())));
    }

    private String execute() throws IOException, InterruptedException {
        ProcessBuilder processBuilder = new ProcessBuilder("java", compilerStrategy.getBinaryFileName(sourceFile.getName()));
        processBuilder.redirectInput(new File(inputFileName));
        processBuilder.redirectOutput(ProcessBuilder.Redirect.PIPE);
        Process process = processBuilder.start();
        process.waitFor();
        return new String(process.getInputStream().readAllBytes());
    }

    private boolean verify(String actualOutput) throws IOException {
        String expectedOutput = new String(Files.readAllBytes(Paths.get(outputFileName)));
        return actualOutput.trim().equals(expectedOutput.trim());
    }

    private String getLanguage(File sourceFile){
        switch (sourceFile.getName().substring(sourceFile.getName().lastIndexOf('.') + 1)) {
            case "c":
                return "c";
            case "cpp":
                return "cpp";
            case "java":
                return "java";
            case "py":
                return "python";
            default:
                throw new IllegalArgumentException("Unsupported language");
        }
    }
}
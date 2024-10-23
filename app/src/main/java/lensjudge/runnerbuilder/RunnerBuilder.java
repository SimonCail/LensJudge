package lensjudge.runnerbuilder;

import lensjudge.compilation.*;

import java.io.File;

public class RunnerBuilder implements IRunnerBuilder{

    private File sourceFile;
    private String inputFileName;
    private String outputFileName;

    @Override
    public RunnerBuilder setSourceFile(File sourceFile) {
        this.sourceFile = sourceFile;
        return this;
    }

    @Override
    public RunnerBuilder setInputFileName(String inputFileName) {
        this.inputFileName = inputFileName;
        return this;
    }

    @Override
    public RunnerBuilder setOutputFileName(String outputFileName) {
        this.outputFileName = outputFileName;
        return this;
    }

    @Override
    public Runner build() {
        ICompilerStrategy compilerStrategy = chooseCompiler(sourceFile);
        return new Runner(sourceFile, inputFileName, outputFileName , compilerStrategy);
    }

    private ICompilerStrategy chooseCompiler(File sourceFile) {
        switch (sourceFile.getName().substring(sourceFile.getName().lastIndexOf('.') + 1)) {
            case "c":
                return new CompilerC();
            case "cpp":
                return new CompilerCPP();
            case "java":
                return new CompilerJava();
            case "py":
                return new CompilerPython();
            default:
                throw new IllegalArgumentException("Invalid file extension");
        }
    }
}

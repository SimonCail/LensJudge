package lensjudge.runnerbuilder;

import lensjudge.Execution.*;
import lensjudge.compilation.*;
import lensjudge.problem.ConstructProblem;
import lensjudge.problem.TestCase;
import lensjudge.process.ProcessAdapter;
import lensjudge.verification.IVerification;

import java.io.File;
import java.io.IOException;

public class Runner implements IRunnerBuilder {

    private File sourceFile;
    private TestCase testCase;
    private ConstructProblem constructProblem;
    private ICompilerStrategy compilerStrategy;
    private IExecution execution;
    private IVerification verification;

    public Runner(File sourceFile) {
        this.sourceFile = sourceFile;
//        this.testCase = testCase;
//        this.constructProblem = constructProblem;
    }

    public void setTestCase(TestCase testCase) {
        this.testCase = testCase;
    }

    public void setConstructProblem(ConstructProblem constructProblem) {
        this.constructProblem = constructProblem;
    }

    public TestCase getTestCase() {
        return testCase;
    }

    public ConstructProblem getConstructProblem() {
        return constructProblem;
    }

    public void run() throws IOException {
        String extension = sourceFile.getName().substring(sourceFile.getName().lastIndexOf(".") + 1);
        switch (extension) {
            case "c":

                compilerStrategy = new CompilerC();
                execution = new ExecutionC();
                break;
            case "java":
                compilerStrategy = new CompilerJava();
                execution = new ExecutionJava();
                break;
            case "py":
                compilerStrategy = new CompilerPython();
                execution = new ExecutionPy();
                break;
            case "cc":
                compilerStrategy = new CompilerCPP();
                execution = new ExecutionCPP();
                break;
            default:
                throw new IllegalArgumentException("Language not supported or not found");
        }
        try {
            compilerStrategy.executeCompilerCommand(sourceFile, compilerStrategy.getBinaryFileName(sourceFile.getAbsolutePath()));
            ProcessAdapter process;
            process = execution.execute(sourceFile.getAbsolutePath() , compilerStrategy.getBinaryFileName(sourceFile.getAbsolutePath()));
            process.startProcess();
            System.out.println(process.getStandardOutput());
            verification.verify(process.getStandardOutput(), testCase.getPathFileOut());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
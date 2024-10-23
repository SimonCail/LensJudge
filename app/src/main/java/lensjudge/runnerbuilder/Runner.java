package lensjudge.runnerbuilder;

import lensjudge.compilation.*;
import lensjudge.problem.ConstructProblem;
import lensjudge.problem.TestCase;
import lensjudge.verification.IVerification;

import java.io.File;
import java.io.IOException;

public class Runner implements IRunnerBuilder {

    private File sourceFile;
    private TestCase testCase;
    private ConstructProblem constructProblem;
    private ICompilerStrategy compilerStrategy;
    private IVerification verification;

    public Runner(File sourceFile, TestCase testCase, ConstructProblem constructProblem) {
        this.sourceFile = sourceFile;
        this.testCase = testCase;
        this.constructProblem = constructProblem;
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
                break;
            case "java":
                compilerStrategy = new CompilerJava();
                break;
            case "py":
                compilerStrategy = new CompilerPython();
                break;
            case "cpp":
                compilerStrategy = new CompilerCPP();
                break;
            default:
                throw new IllegalArgumentException("Language not supported or not found");
        }
        try {
            compilerStrategy.compile(sourceFile.getAbsolutePath() , compilerStrategy.getBinaryFileName(sourceFile.getName()));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
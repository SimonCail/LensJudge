package lensjudge.runnerbuilder;

import lensjudge.Execution.*;
import lensjudge.compilation.*;
import lensjudge.problem.ConstructProblem;
import lensjudge.problem.TestCase;
import lensjudge.process.ProcessAdapter;
import lensjudge.process.TimeProcessDecorator;
import lensjudge.verification.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Runner implements IRunnerBuilder {

    static Scanner scanner = new Scanner(System.in);
    private File sourceFile;
    private TestCase testCase;
    private ConstructProblem constructProblem;
    private ICompilerStrategy compilerStrategy;
    private IExecution execution;
    private IVerification verification;

    public Runner(File sourceFile, TestCase testCase) {
        this.sourceFile = sourceFile;
        this.testCase = testCase;
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

    public void run(IVerification verification) throws IOException {
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
                System.out.println(TypeVerification.COMPILATION_ERROR);
                System.exit(0);
        }

        try {
            compilerStrategy.executeCompilerCommand(sourceFile, compilerStrategy.getBinaryFileName(sourceFile.getAbsolutePath()));
            ProcessAdapter process = execution.execute(sourceFile.getAbsolutePath(), compilerStrategy.getBinaryFileName(sourceFile.getAbsolutePath()));
            TimeProcessDecorator timeProcess = new TimeProcessDecorator(process, 1000);
            timeProcess.startProcess();
            int exit = timeProcess.waitForProcess();
            String output = timeProcess.getStandardOutput();
            String errorOutput = timeProcess.getErrorOutput();
            if (exit != 0) {
                System.out.println(errorOutput);
                System.exit(0);
            }
            TypeVerification result = verification.verify(new ByteArrayInputStream(output.getBytes()), testCase.getPathFileOut());
            System.out.println("Vérification : " + result);
        } catch (InterruptedException e) {
            System.out.println(TypeVerification.TIMEOUT);
        } catch (IOException e) {
            System.out.println(TypeVerification.ERROR);
        }
    }
}
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
            System.out.println("Compiling: " + sourceFile.getAbsolutePath());
            compilerStrategy.executeCompilerCommand(sourceFile, compilerStrategy.getBinaryFileName(sourceFile.getAbsolutePath()));
            ProcessAdapter process = execution.execute(sourceFile.getAbsolutePath(), compilerStrategy.getBinaryFileName(sourceFile.getAbsolutePath()));
            process.startProcess();
            TimeProcessDecorator time = new TimeProcessDecorator(process, 1000);
            String output = process.getStandardOutput();
            String errorOutput = process.getErrorOutput();
            System.out.println("Standard Output: " + output);
            System.out.println("Error Output: " + errorOutput);
            System.out.println("Veuillez choisir votre type de vérification : ");
            System.out.println("1. Vérification stricte");
            System.out.println("2. Vérification sans tenir compte de l'ordre");
            System.out.println("3. Vérification sans tenir compte de la casse et des espaces");
            System.out.println("4. Vérification avec des arrondies sur les nombres");
            System.out.println("5. Vérification d'une solution parmi plusieurs \n" );
            int verifChoice = scanner.nextInt();
            switch (verifChoice){
                case 1:
                    verification = new StrictVerification();
                    break;
                case 2:
                    verification = new OrderVerification();
                    break;
                case 3:
                    verification = new CaseVerification();
                    break;
                case 4:
                    verification = new RealVerification();
                    break;
                case 5:
                    verification = new OneOfSeveralVerification();
                    break;
                default:
                    System.out.println("Invalid choice , defaulting to strict verification");
                    verification = new StrictVerification();
            }
            boolean result = verification.verify(new ByteArrayInputStream(output.getBytes()), testCase.getPathFileOut());
            System.out.println("Vérification : " + result);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
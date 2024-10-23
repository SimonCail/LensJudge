package lensjudge.runnerbuilder;

import lensjudge.compilation.*;
import lensjudge.problem.ConstructProblem;
import lensjudge.problem.TestCase;
import lensjudge.verification.IVerification;

import java.io.File;
import java.io.IOException;

public class Runner {

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

    public TestCase getTestCase(){
        return testCase;
    }

    public ConstructProblem getConstructProblem(){
        return constructProblem;
    }

    public void run() throws IOException {
        String extension = sourceFile.getName().substring(sourceFile.getName().lastIndexOf("."));
        if(extension == ".c"){
            compilerStrategy = new CompilerC();
        } else if(extension == ".java"){
            compilerStrategy = new CompilerJava();
        } else if(extension == ".py"){
            compilerStrategy = new CompilerPython();
        } else if(extension == ".cc"){
            compilerStrategy = new CompilerCPP();
        } else {
            throw new IllegalArgumentException("Language not supported or not found");
        }
    }




}
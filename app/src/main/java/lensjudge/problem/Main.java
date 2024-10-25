/*
package lensjudge.problem;

import lensjudge.verification.CaseVerification;

import java.io.File;

public class Main {
    private static final String PATH = "app/src/main/java/lensjudge/problem/file/";

    public static void main(String[] args) {
        File fileIn1 = new File(PATH + "test1.in");
        File fileOut1 = new File(PATH +"test1.ans");
        File fileIn2 = new File(PATH + "test2.in");
        File fileOut2 = new File(PATH + "test2.ans");

        ConstructProblem problem = ConstructProblem.newInstance()
                .withTestCases(new TestCase("Test 1", fileIn1, fileOut1), new TestCase("Test 2", fileIn2, fileOut2))
                .withTimeLimit(2000)
                .withMemoryLimit(512)
                .withVerification(new CaseVerification())
                .build();

        System.out.println(problem.getMemoryLimit());
        System.out.println(problem.getTimeLimit());

        for (TestCase testCase : problem) {
            System.out.println("Test case: " + testCase.getFileName());
            System.out.println("File in: " + testCase.getPathFileIn());
            System.out.println("File out: " + testCase.getPathFileOut());
            System.out.println("Files exist: " + testCase.exists());
            System.out.println("--------------------");
        }
    }
}
*/

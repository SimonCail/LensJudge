package lensjudge.problem;

import lensjudge.verification.CaseVerification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestProblemMain {

    private ConstructProblem problem;

    @BeforeEach
    public void setUp() {
        File fileIn1 = new File("src/test/resources/test1.in");
        File fileOut1 = new File("src/test/resources/test1.ans");
        File fileIn2 = new File("src/test/resources/test2.in");
        File fileOut2 = new File("src/test/resources/test2.ans");

        problem = ConstructProblem.newInstance()
                .withTestCases(new TestCase("Test 1", fileIn1, fileOut1), new TestCase("Test 2", fileIn2, fileOut2))
                .withTimeLimit(2000)
                .withMemoryLimit(512)
                .withVerification(new CaseVerification())
                .build();
    }

    @Test
    public void testConstructProblemInitialization() {
        assertNotNull(problem, "Problem instance should not be null");
        assertEquals(2000, problem.getTimeLimit(), "Time limit should be set to 2000");
        assertEquals(512, problem.getMemoryLimit(), "Memory limit should be set to 512");

        List<TestCase> testCases = problem.getTestCases();
        assertNotNull(testCases, "Test cases list should not be null");
        assertEquals(2, testCases.size(), "There should be 2 test cases");
    }

    @Test
    public void testDisplayProblemInfo() {
      for (TestCase testCase : problem) {
          System.out.println("Test case: " + testCase.getFileName());
          System.out.println("Input file: " + testCase.getPathFileIn());
          System.out.println("Output file: " + testCase.getPathFileOut());
          System.out.println("Exists: " + testCase.exists());
          assertNotNull(testCase.getFileName(), "File name should not be null");
          assertNotNull(testCase.getPathFileIn(), "Input path should not be null");
          assertNotNull(testCase.getPathFileOut(), "Output path should not be null");
          assertTrue(testCase.exists(), "Files should exist for the test case");
      }
    }
}

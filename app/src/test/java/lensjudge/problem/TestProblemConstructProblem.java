package lensjudge.problem;

import lensjudge.verification.CaseVerification;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class TestProblemConstructProblem {

    private TestCase testCase1;
    private TestCase testCase2;

    @BeforeEach
    public void setUp() {
        testCase1 = new TestCase("Test 1", new File("src/test/resources/input1.txt"), new File("src/test/resources/output1.txt"));
        testCase2 = new TestCase("Test 2", new File("src/test/resources/input2.txt"), new File("src/test/resources/output2.txt"));
    }

    @Test
    @DisplayName("Test the new instance method")
    public void testNewInstance() {
        ConstructProblem problem = ConstructProblem.newInstance();
        assertNotNull(problem, "The problem instance should not be null");
    }

    @Test
    @DisplayName("Test the withTestCases method")
    public void testWithTestCases() {
        ConstructProblem problem = ConstructProblem.newInstance()
                .withTestCases(testCase1, testCase2);

        List<TestCase> testCases = problem.getTestCases();
        assertNotNull(testCases, "The test cases list should not be null");
        assertEquals(2, testCases.size(), "There should be 2 test cases");
        assertEquals(testCase1.getFileName(), testCases.get(0).getFileName(), "The first test case should be Test 1");
        assertEquals(testCase2.getFileName(), testCases.get(1).getFileName(), "The second test case should be Test 2");
    }

    @Test
    @DisplayName("Test the withTimeLimit method")
    public void testWithTimeLimit() {
        ConstructProblem problem = ConstructProblem.newInstance()
                .withTimeLimit(100);

        assertEquals(100, problem.getTimeLimit(), "The time limit should be set to 100");
    }


    @Test
    @DisplayName("Test the withVerification method")
    public void testWithVerification() {
        CaseVerification verification = new CaseVerification();
        ConstructProblem problem = ConstructProblem.newInstance()
                .withVerification(verification);

        assertSame(verification, problem.getVerification(), "The verification should be set correctly");
    }

    @Test
    @DisplayName("Test the iterator method")
    public void testIterator() {
        ConstructProblem problem = ConstructProblem.newInstance()
                .withTestCases(testCase1, testCase2);

        Iterator<TestCase> iterator = problem.iterator();
        assertTrue(iterator.hasNext(), "Iterator should have next element");
        assertEquals(testCase1, iterator.next(), "The first element should be Test 1");
        assertTrue(iterator.hasNext(), "Iterator should have next element");
        assertEquals(testCase2, iterator.next(), "The second element should be Test 2");
        assertFalse(iterator.hasNext(), "Iterator should not have more elements");
    }

    @Test
    @DisplayName("Test the forEach method")
    public void testForEach() {
        ConstructProblem problem = ConstructProblem.newInstance()
                .withTestCases(testCase1, testCase2);

        StringBuilder output = new StringBuilder();
        problem.forEach(testCase -> output.append(testCase.getFileName()).append(" "));

        assertEquals("Test 1 Test 2", output.toString().trim(), "The forEach method should concatenate file names");
    }

}

package lensjudge.problem;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

public class TestProblemTestCase {

    private static final String TEST_PATH = "src/test/resources/";

    @Test
    @DisplayName("Test the constructor and getters")
    public void testConstructorAndGetters() {
        File fileIn = new File(TEST_PATH + "test1.in");
        File fileOut = new File(TEST_PATH + "test1.ans");

        TestCase testCase = new TestCase("Test 1", fileIn, fileOut);

        assertEquals("Test 1", testCase.getFileName());
        assertEquals(fileIn.getAbsolutePath(), testCase.getPathFileIn());
        assertEquals(fileOut.getAbsolutePath(), testCase.getPathFileOut());
    }

    @Test
    @DisplayName("Test the exists method")
    public void testExistsWhenFilesExist() {
        File fileIn = new File(TEST_PATH + "test1.in");
        File fileOut = new File(TEST_PATH + "test1.ans");

        TestCase testCase = new TestCase("Test 1", fileIn, fileOut);

        assertTrue(testCase.exists(), "The test case files should exist");
    }

    @Test
    @DisplayName("Test the exists method")
    public void testExistsWhenFilesDoNotExist() {
        File fileIn = new File(TEST_PATH + "nonexistent.in");
        File fileOut = new File(TEST_PATH + "nonexistent.ans");

        TestCase testCase = new TestCase("Nonexistent Test", fileIn, fileOut);

        assertFalse(testCase.exists(), "The test case files should not exist");
    }

}

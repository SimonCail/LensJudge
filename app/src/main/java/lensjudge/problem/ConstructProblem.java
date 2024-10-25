package lensjudge.problem;

import lensjudge.verification.CaseVerification;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * Represents the problem to be solved
 */
public class ConstructProblem implements Iterable<TestCase>{
    /**
     * List of test cases
     */
    private List<TestCase> testCases;

    /**
     * Time limit for the problem
     */
    private int timeLimit;

    /**
     * Memory limit for the problem
     */
    private int memoryLimit;

    /**
     * Verification for the problem
     */
    private CaseVerification verification;

    /**
     * Iterator for the test cases
     *
     * @return Iterator<TestCase>
     */
    @Override
    public Iterator<TestCase> iterator() {
        return testCases.iterator();
    }

    /**
     * Performs the given action for each element of the Iterable until all elements have been processed or the action throws an exception.
     *
     * @param action The action to be performed for each element
     */
    @Override
    public void forEach(Consumer<? super TestCase> action) {
        Iterable.super.forEach(action);
    }

    /**
     * Creates a Spliterator over the elements described by this Iterable.
     *
     * @return Spliterator<TestCase>
     */
    @Override
    public Spliterator<TestCase> spliterator() {
        return Iterable.super.spliterator();
    }

    /**
     * Constructor for ConstructProblem
     */
    private ConstructProblem() {
        this.testCases = null;
        this.timeLimit = 0;
        this.memoryLimit = 0;
        this.verification = new CaseVerification();
    }

    // ============ GETTERS / SETTERS =====================


    /**
     * Get the list of test cases
     *
     * @return List<TestCase>
     */
    public List<TestCase> getTestCases() {
        return testCases;
    }

    /**
     * Get the time limit for the problem
     *
     * @return int
     */
    public int getTimeLimit() {
        return timeLimit;
    }

    /**
     * Get the memory limit for the problem
     *
     * @return int
     */
    public int getMemoryLimit() {
        return memoryLimit;
    }

    /**
     * Get the verification for the problem
     *
     * @return CaseVerification
     */
    public CaseVerification getVerification() {
        return verification;
    }

    // ============ BUILDER =====================

    /**
     * Create a new ConstructProblem object
     *
     * @return ConstructProblem
     */
    public static ConstructProblem newInstance() {
        return new ConstructProblem();
    }

    /**
     * Set the test cases for the problem
     *
     * @param testCases List of test cases
     * @return ConstructProblem
     */
    public ConstructProblem withTestCases(TestCase... testCases) {
        this.testCases = Arrays.asList(testCases);
        return this;
    }

    /**
     * Set the time limit for the problem
     *
     * @param timeLimit Time limit for the problem
     * @return ConstructProblem
     */
    public ConstructProblem withTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
        return this;
    }

    /**
     * Set the memory limit for the problem
     *
     * @param memoryLimit Memory limit for the problem
     * @return
     */
    public ConstructProblem withMemoryLimit(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        return this;
    }

    /**
     * Set the verification for the problem
     *
     * @param verification Verification for the problem
     * @return ConstructProblem
     */
    public ConstructProblem withVerification(CaseVerification verification) {
        this.verification = verification;
        return this;
    }

    /**
     * Create a new ConstructProblem object
     *
     * @return ConstructProblem
     */
    public ConstructProblem build() {
        return this;
    }


}

package lensjudge.problem;

import lensjudge.verification.CaseVerification;
import org.checkerframework.checker.units.qual.C;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Spliterator;
import java.util.function.Consumer;

public class ConstructProblem implements Iterable<TestCase>{
    private List<TestCase> testCases;
    private int timeLimit;
    private int memoryLimit;
    private CaseVerification verification;

    @Override
    public Iterator<TestCase> iterator() {
        return testCases.iterator();
    }

    @Override
    public void forEach(Consumer<? super TestCase> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<TestCase> spliterator() {
        return Iterable.super.spliterator();
    }

    private ConstructProblem() {
        this.testCases = null;
        this.timeLimit = 0;
        this.memoryLimit = 0;
        this.verification = new CaseVerification();
    }

    // ============ GETTERS / SETTERS =====================


    public List<TestCase> getTestCases() {
        return testCases;
    }

    public int getTimeLimit() {
        return timeLimit;
    }

    public int getMemoryLimit() {
        return memoryLimit;
    }

    public CaseVerification getVerification() {
        return verification;
    }

    // ============ BUILDER =====================

    public static ConstructProblem newInstance() {
        return new ConstructProblem();
    }

    public ConstructProblem withTestCases(TestCase... testCases) {
        this.testCases = Arrays.asList(testCases);
        return this;
    }

    public ConstructProblem withTimeLimit(int timeLimit) {
        this.timeLimit = timeLimit;
        return this;
    }

    public ConstructProblem withMemoryLimit(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        return this;
    }

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

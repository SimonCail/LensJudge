package lensjudge.runnerbuilder;


import lensjudge.problem.ConstructProblem;
import lensjudge.problem.TestCase;
import lensjudge.verification.IVerification;

import java.io.IOException;

public class RunnerBuilder implements IRunnerBuilder {

    @Override
    public void setTestCase(TestCase testCase) {
        // Do nothing
    }

    @Override
    public void setConstructProblem(ConstructProblem constructProblem) {
        //Do nothing
    }

    @Override
    public TestCase getTestCase() {
        return null;
    }

    @Override
    public ConstructProblem getConstructProblem() {
        return null;
    }

    @Override
    public void run(IVerification verification) throws IOException {
        // Do nothing
    }
}

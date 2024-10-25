package lensjudge.runnerbuilder;

import lensjudge.compilation.*;
import lensjudge.problem.ConstructProblem;
import lensjudge.problem.TestCase;
import lensjudge.verification.IVerification;

import java.io.File;
import java.io.IOException;

public class RunnerBuilder implements IRunnerBuilder {

    @Override
    public void setTestCase(TestCase testCase) {

    }

    @Override
    public void setConstructProblem(ConstructProblem constructProblem) {

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

    }
}

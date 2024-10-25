package lensjudge.runnerbuilder;

import lensjudge.problem.ConstructProblem;
import lensjudge.problem.TestCase;
import lensjudge.verification.IVerification;

import java.io.File;
import java.io.IOException;

public interface IRunnerBuilder {
    void setTestCase(TestCase testCase);
    void setConstructProblem(ConstructProblem constructProblem);
    TestCase getTestCase();
    ConstructProblem getConstructProblem();
    void run(IVerification verification) throws IOException;
}

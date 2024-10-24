package lensjudge.runnerbuilder;

import lensjudge.problem.ConstructProblem;
import lensjudge.problem.TestCase;

import java.io.File;
import java.io.IOException;

public interface IRunnerBuilder {
    void setTestCase(TestCase testCase);
    void setConstructProblem(ConstructProblem constructProblem);
    TestCase getTestCase();
    ConstructProblem getConstructProblem();
    void run() throws IOException;
}

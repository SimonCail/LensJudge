package lensjudge.runnerbuilder;

import java.io.File;

public interface IRunnerBuilder {
    RunnerBuilder setSourceFile(File sourceFile);
    RunnerBuilder setInputFileName(String inputFileName);
    RunnerBuilder setOutputFileName(String outputFileName);
    Runner build();
}

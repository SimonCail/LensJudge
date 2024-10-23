package lensjudge;

import lensjudge.problem.TestCase;
import lensjudge.runnerbuilder.IRunnerBuilder;
import lensjudge.runnerbuilder.Runner;
import lensjudge.runnerbuilder.RunnerBuilder;

import java.io.File;
import java.io.IOException;

public class MainRunner {
    public static void main(String[] args) throws IOException {
        TestCase testCase = new TestCase("test", new File("/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae/runnerTest"), new File("/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae/runnerTest"));
        Runner runner = new Runner(new File("/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae/timethroughtheglass.cc"), testCase);
        runner.run();
    }
}

package lensjudge;

import lensjudge.runnerbuilder.Runner;
import lensjudge.runnerbuilder.RunnerBuilder;

import java.io.File;

public class MainRunner {
    public static void main(String[] args){
        Runner runner = new RunnerBuilder()
                .setSourceFile(new File("ProgTestSae/test.c"))
                .setInputFileName("ProgTestSae/2.in")
                .setOutputFileName("ProgTestSae/2.ans")
                .build();

        String result = runner.run();
        System.out.println("Result: " + result);

    }
}

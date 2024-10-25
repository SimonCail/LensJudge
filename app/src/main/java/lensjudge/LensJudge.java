package lensjudge;

import lensjudge.problem.TestCase;
import lensjudge.runnerbuilder.Runner;
import org.fusesource.jansi.Ansi;
import org.fusesource.jansi.AnsiConsole;

import java.io.File;
import java.io.IOException;

public class LensJudge {
    public static void main(String[] args) throws IOException {
        if (args.length != 3) {
            System.err.println("Usage: lensjudge <source.lang> <test.in> <test.ans>");
            System.exit(1);
        }

        String sourceFilePath = args[0];
        String inputFilePath = args[1];
        String expectedOutputFilePath = args[2];

        File sourceFile = new File("/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae");
        File inputFile = new File("/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae/1.in");
        File expectedOutputFile = new File("/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae/1.ans");

        TestCase testCase = new TestCase("test", inputFile, expectedOutputFile);

        Runner runner = new Runner(sourceFile, testCase);
        AnsiConsole.systemInstall();
        try {
            runner.run();
            System.out.println(Ansi.ansi().fg(Ansi.Color.GREEN).a("CORRECT").reset());
        } catch (Exception e) {
            System.out.println(Ansi.ansi().fg(Ansi.Color.RED).a("Test failed for: " + testCase.getFileName()).reset());
            System.exit(1);
        } finally {
            AnsiConsole.systemUninstall();
        }
    }
}
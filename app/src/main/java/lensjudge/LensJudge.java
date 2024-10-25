package lensjudge;

import lensjudge.problem.TestCase;
import lensjudge.runnerbuilder.Runner;
import lensjudge.verification.*;
import org.apache.commons.cli.*;

import java.io.File;
import java.io.IOException;

public class LensJudge {
    public static void main(String[] args) throws IOException, ParseException {

        Options options = new Options();
        options.addOption("v", "verification", true, "Select the type of verification (1-5): 1 - Strict, 2 - Order, 3 - Case, 4 - Real numbers, 5 - One of several");

        CommandLineParser parser = new DefaultParser();
        CommandLine cmd;

        cmd = parser.parse(options, args);

        if (!cmd.hasOption("v")) {
            System.err.println("Missing required option: v");
            System.exit(1);
        }

        if (args.length < 3) {
            System.err.println("Usage: lensjudge <source.lang> <test.in> <test.ans> <verificationType>");
            System.exit(1);
        }

        String sourceFilePath = args[0];
        String inputFilePath = args[1];
        String expectedOutputFilePath = args[2];
        String verificationType = cmd.getOptionValue("v");

        File sourceFile = new File(sourceFilePath);
        File inputFile = new File(inputFilePath);
        File expectedOutputFile = new File(expectedOutputFilePath);

        IVerification verification;

        switch (verificationType) {
            case "1":
                verification = new StrictVerification();
                break;
            case "2":
                verification = new OrderVerification();
                break;
            case "3":
                verification = new CaseVerification();
                break;
            case "4":
                verification = new RealVerification();
                break;
            case "5":
                verification = new OneOfSeveralVerification();
                break;
            default:
                System.out.println("Invalid choice , defaulting to strict verification");
                verification = new StrictVerification();
        }

        TestCase testCase = new TestCase("Fichier à tester", inputFile, expectedOutputFile);

        Runner runner = new Runner(sourceFile, testCase);

        runner.run(verification);

        System.exit(0);
    }
}
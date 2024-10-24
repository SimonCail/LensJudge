package lensjudge;

import lensjudge.problem.TestCase;
import lensjudge.runnerbuilder.IRunnerBuilder;
import lensjudge.runnerbuilder.Runner;
import lensjudge.runnerbuilder.RunnerBuilder;

import java.io.File;
import java.io.IOException;

public class MainRunner {
    public static void main(String[] args) throws IOException {
        /*
        System.out.println("True test 1");
        TestCase testCase = new TestCase("test", new File("/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae/runnerTest"), new File("/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae/runnerTest"));
        Runner runner = new Runner(new File("/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae/timethroughtheglass.cc"), testCase);
        runner.run();
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("False test 1");
        TestCase testCase2 = new TestCase("test2" , new File("/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae/runnerTest2"), new File("/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae/runnerTest2"));
        Runner runner2 = new Runner(new File("/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae/timethroughtheglass.cc"), testCase2);
        runner2.run();
        System.out.println("--------------------------------------------------------------------------");
         */
        /*
        System.out.println("--------------------------------------------------------------");
        System.out.println("True test 2");
        TestCase testCase2 = new TestCase("test4" , new File("/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae/runnerTest4"), new File("/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae/runnerTest4"));
        Runner runner2 = new Runner(new File("/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae/timethroughtheglass.py"), testCase2);
        runner2.run();
        System.out.println("--------------------------------------------------------------");
        System.out.println("False test 2");
        TestCase testCase3 = new TestCase("test5" , new File("/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae/runnerTest1"), new File("/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae/runnerTest1"));
        Runner runner3 = new Runner(new File("/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae/timethroughtheglass.py"), testCase3);
        runner3.run();
        /*
        /*
        System.out.println("True test 3");
        TestCase testCase3 = new TestCase("test3" , new File("/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae/runnerTest3"), new File("/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae/runnerTest3"));
        Runner runner3 = new Runner(new File("/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae/timethroughtheglass.cc"), testCase3);
        runner3.run();
        System.out.println("--------------------------------------------------------------------------");
        System.out.println("False test 3");
        TestCase testCase4 = new TestCase("test3" , new File("/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae/runnerTest2"), new File("/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae/runnerTest2"));
        Runner runner4 = new Runner(new File("/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae/timethroughtheglass.cc"), testCase4);
        runner4.run();
        System.out.println("--------------------------------------------------------------------------");
         */
        /*
        System.out.println("--------------------------------------------------------------");
        System.out.println("True test 4");
        TestCase testCase4 = new TestCase("test4" , new File("/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae/runnerTest5"), new File("/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae/runnerTest5"));
        Runner runner4 = new Runner(new File("/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae/timethroughtheglass.py"), testCase4);
        runner4.run();
        System.out.println("--------------------------------------------------------------");
        System.out.println("False test 4");
        TestCase testCase5 = new TestCase("test5" , new File("/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae/runnerTest5_2"), new File("/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae/runnerTest5_2"));
        Runner runner5 = new Runner(new File("/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae/timethroughtheglass.py"), testCase5);
        runner5.run();
        */
        System.out.println("--------------------------------------------------------------");
        System.out.println("True test 5");
        TestCase testCase5 = new TestCase("test5" , new File("/export/etu/matheo.dalmasso/Documents/BUT2/SAE/SAE3.01/groupe-b2-s3.a.01/ProgTestSae/runnerTest6"), new File("/export/etu/matheo.dalmasso/Documents/BUT2/SAE/SAE3.01/groupe-b2-s3.a.01/ProgTestSae/runnerTest6"));
        Runner runner5 = new Runner(new File("/export/etu/matheo.dalmasso/Documents/BUT2/SAE/SAE3.01/groupe-b2-s3.a.01/ProgTestSae/timethroughtheglass.cc"), testCase5);
        runner5.run();
        System.out.println("--------------------------------------------------------------");
        System.out.println("False test 5");
        TestCase testCase6 = new TestCase("test6" , new File("/export/etu/matheo.dalmasso/Documents/BUT2/SAE/SAE3.01/groupe-b2-s3.a.01/ProgTestSae/runnerTest2"), new File("/export/etu/matheo.dalmasso/Documents/BUT2/SAE/SAE3.01/groupe-b2-s3.a.01/ProgTestSae/runnerTest2"));
        Runner runner6 = new Runner(new File("/export/etu/matheo.dalmasso/Documents/BUT2/SAE/SAE3.01/groupe-b2-s3.a.01/ProgTestSae/timethroughtheglass.cc"), testCase6);
        runner6.run();
    }
}

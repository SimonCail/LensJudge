package lensjudge;

import lensjudge.Execution.ExecutionC;
import lensjudge.Execution.ExecutionPy;

public class Main2 {
    public static void main(String[] args) {
        ExecutionC executionC = new ExecutionC();
        String sourceFilePath = "/export/etu/simon.caillieret/Documents/QDEV/SAE/groupe-b2-s3.a.01/ProgTestSae/timethroughtheglass.c";
        executionC.execute(sourceFilePath);
        System.out.println("--------------------------------------------------------------------------------");
        ExecutionPy executionPy = new ExecutionPy();
        String sourceFilePath2 = "/export/etu/simon.caillieret/Documents/QDEV/SAE/groupe-b2-s3.a.01/ProgTestSae/timethroughtheglass.py";
        executionPy.execute(sourceFilePath2);
        System.out.println("-----------------------------------------------------------------------------------");
    }
}

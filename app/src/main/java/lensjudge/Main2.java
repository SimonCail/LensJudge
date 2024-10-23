package lensjudge;

import lensjudge.Execution.ExecutionC;
import lensjudge.Execution.ExecutionCPP;
import lensjudge.Execution.ExecutionJava;
import lensjudge.Execution.ExecutionPy;
import lensjudge.compilation.CompilerC;
import lensjudge.compilation.CompilerCPP;
import lensjudge.compilation.CompilerPython;
import lensjudge.process.ProcessAdapter;

import java.io.File;

public class Main2 {
    public static void main(String[] args) {
        ProcessAdapter process;
        ProcessAdapter process2;
        ProcessAdapter process3;
        ProcessAdapter process4;

        ExecutionPy executionPy = new ExecutionPy();
        String sourceFilePath2 = "/export/etu/simon.caillieret/Documents/QDEV/SAE/groupe-b2-s3.a.01/ProgTestSae/timethroughtheglass.py";
        File sourceFile2=new File(sourceFilePath2);
        CompilerPython compilerPython = new CompilerPython();
        compilerPython.executeCompilerCommand(sourceFile2, null);
        process2=executionPy.execute(sourceFilePath2, null);
        process2.startProcess();
        System.out.println(process2.getStandardOutput());
        System.out.println("-----------------------------------------------------------------------------------");

        ExecutionC executionC = new ExecutionC();
        String sourceFilePath3 = "/export/etu/simon.caillieret/Documents/QDEV/SAE/groupe-b2-s3.a.01/ProgTestSae/timethroughtheglassC.c";
        File sourceFile3=new File(sourceFilePath3);
        CompilerC compilerC=new CompilerC();
        String binaryFileName2;
        binaryFileName2= compilerC.getBinaryFileName(sourceFilePath3);
        compilerC.executeCompilerCommand(sourceFile3, binaryFileName2);
        process3=executionC.execute(sourceFilePath3, binaryFileName2);
        process3.startProcess();
        System.out.println(process3.getStandardOutput());
        System.out.println("--------------------------------------------------------------------------------");

        ExecutionCPP executionCPP = new ExecutionCPP();
        String sourceFilePath = "/export/etu/simon.caillieret/Documents/QDEV/SAE/groupe-b2-s3.a.01/ProgTestSae/timethroughtheglass.cc";
        File sourceFile=new File(sourceFilePath);
        CompilerCPP compilerCPP=new CompilerCPP();
        String binaryFileName;
        binaryFileName= compilerCPP.getBinaryFileName(sourceFilePath);
        compilerCPP.executeCompilerCommand(sourceFile, binaryFileName);
        process=executionCPP.execute(sourceFilePath, binaryFileName);
        process.startProcess();
        System.out.println(process.getStandardOutput());
        System.out.println("--------------------------------------------------------------------------------");
    }
}

/*
        ExecutionJava executionJava = new ExecutionJava();
        String sourceFilePath4 = "/export/etu/simon.caillieret/Documents/QDEV/SAE/groupe-b2-s3.a.01/ProgTestSae/timethroughtheglass.cc";
        process4=executionCPP.execute(sourceFilePath4);
        System.out.println(process4.getStandardOutput());
        System.out.println("--------------------------------------------------------------------------------");

 */



package lensjudge;

import lensjudge.Execution.ExecutionC;
import lensjudge.Execution.ExecutionCPP;
import lensjudge.Execution.ExecutionJava;
import lensjudge.Execution.ExecutionPy;
import lensjudge.compilation.CompilerC;
import lensjudge.compilation.CompilerCPP;
import lensjudge.compilation.CompilerJava;
import lensjudge.compilation.CompilerPython;
import lensjudge.process.ProcessAdapter;

import java.io.File;
import java.io.IOException;

public class Main2 {
    public static void main(String[] args) throws IOException, InterruptedException {
        ProcessAdapter process;
        ProcessAdapter process2;
        ProcessAdapter process3;
        ProcessAdapter process4;

        ExecutionPy executionPy = new ExecutionPy();
        String sourceFilePath2 = "C:/Users/Benji/Documents/COUR/BUT2/SAEA3.01/groupe-b2-s3.a.01/ProgTestSae/timethroughtheglass.py";
        File sourceFile2=new File(sourceFilePath2);
        CompilerPython compilerPython = new CompilerPython();
        compilerPython.executeCompilerCommand(sourceFile2, null);
        process2=executionPy.execute(sourceFilePath2, null);
        process2.startProcess();
        System.out.println(process2.getStandardOutput());
        System.out.println("-----------------------------------------------------------------------------------");

        ExecutionC executionC = new ExecutionC();
        String sourceFilePath3 = "C:/Users/Benji/Documents/COUR/BUT2/SAEA3.01/groupe-b2-s3.a.01/ProgTestSae/timethroughtheglassC.c";
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
        String sourceFilePath = "C:/Users/Benji/Documents/COUR/BUT2/SAEA3.01/groupe-b2-s3.a.01/ProgTestSae/timethroughtheglass.cc";
        File sourceFile=new File(sourceFilePath);
        CompilerCPP compilerCPP=new CompilerCPP();
        String binaryFileName3;
        binaryFileName3= compilerCPP.getBinaryFileName(sourceFilePath);
        compilerCPP.executeCompilerCommand(sourceFile, binaryFileName3);
        process=executionCPP.execute(sourceFilePath, binaryFileName3);
        process.startProcess();
        System.out.println(process.getStandardOutput());
        System.out.println("--------------------------------------------------------------------------------");

        ExecutionJava executionJava = new ExecutionJava();
        String sourceFilePath4 = "C:/Users/Benji/Documents/COUR/BUT2/SAEA3.01/groupe-b2-s3.a.01/ProgTestSae/TimeThroughTheGlass.java";
        File sourceFile4=new File(sourceFilePath4);
        CompilerJava compilerJava=new CompilerJava();
        String className = compilerJava.getBinaryFileName(sourceFilePath4);
        compilerJava.executeCompilerCommand(sourceFile4,className);
        process4=executionJava.execute(sourceFilePath4, className);
        process4.startProcess();
        System.out.println(process4.getStandardOutput());
        System.out.println("--------------------------------------------------------------------------------");
    }
}
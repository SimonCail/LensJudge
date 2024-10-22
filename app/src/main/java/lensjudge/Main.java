package lensjudge;

import lensjudge.compilation.CompilerJava;
import lensjudge.compilation.CompilerC;
import lensjudge.compilation.CompilerCPP;
import lensjudge.compilation.CompilerPython;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        CompilerJava compilerJava = new CompilerJava();
        CompilerC compilerC = new CompilerC();
        CompilerCPP compilerCPP = new CompilerCPP();
        CompilerPython compilerPython = new CompilerPython();

        File sourceFileC = new File("/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae/timethroughtheglass.c");
        File binaryFileC = new File("/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae/timethroughtheglass_c.exe");
        try {
            compilerC.executeCompilerCommand(sourceFileC, binaryFileC);
            System.out.println("C Compilation success");
        } catch (Exception e) {
            e.printStackTrace();
        }

        File sourceFileCPP = new File("/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae/timethroughtheglass.cc");
        File binaryFileCPP = new File("/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae/timethroughtheglass_cpp.exe");
        try {
            compilerCPP.executeCompilerCommand(sourceFileCPP, binaryFileCPP);
            System.out.println("CPP Compilation success");
        } catch (Exception e) {
            e.printStackTrace();
        }

        File sourceFileJava = new File("/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae/TimeThroughTheGlass.java");
        File binaryFileJava = new File("/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae/TimeThroughTheGlass.class");
        try {
            compilerJava.executeCompilerCommand(sourceFileJava, binaryFileJava);
            System.out.println("Java Compilation success");
        } catch (Exception e) {
            e.printStackTrace();
        }

        File sourceFilePython = new File("/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae/timethroughtheglass.py");
        try {
            compilerPython.executeCompilerCommand(sourceFilePython, sourceFilePython);
            System.out.println("Python Syntax check success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
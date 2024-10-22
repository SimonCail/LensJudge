package lensjudge;

import lensjudge.compilation.CompilerJava;
import lensjudge.compilation.CompilerC;
import lensjudge.compilation.CompilerCPP;
import lensjudge.compilation.CompilerPython;

public class Main {
    public static void main(String[] args) {
        CompilerJava compilerJava = new CompilerJava();
        CompilerC compilerC = new CompilerC();
        CompilerCPP compilerCPP = new CompilerCPP();
        CompilerPython compilerPython = new CompilerPython();

        String sourceFileNameC = "/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae/timethroughtheglass.c";
        String binaryFileNameC = "/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae/timethroughtheglass_c.exe";
        try {
            compilerC.executeCompilerCommand(sourceFileNameC, binaryFileNameC);
            System.out.println("C Compilation success");
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sourceFileNameCPP = "/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae/timethroughtheglass.cc";
        String binaryFileNameCPP = "/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae/timethroughtheglass_cpp.exe";
        try {
            compilerCPP.executeCompilerCommand(sourceFileNameCPP, binaryFileNameCPP);
            System.out.println("CPP Compilation success");
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sourceFileNamePython = "/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae/timethroughtheglass.py";
        String binaryFileNamePython = "/export/etu/mathias.morel/Documents/BUT2/SAE/groupe-b2-s3.a.01/ProgTestSae/timethroughtheglass.py";
        try {
            compilerPython.executeCompilerCommand(sourceFileNamePython, binaryFileNamePython);
            System.out.println("Python Compilation success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
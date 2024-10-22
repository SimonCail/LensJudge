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

        File sourceFileC = new File("./ProgTestSae/timethroughtheglass.c");
        String binaryFileC = "test/timethroughtheglass_c.exe";
        try {
            compilerC.executeCompilerCommand(sourceFileC, binaryFileC);
            System.out.println("C Compilation success");
        } catch (Exception e) {
            e.printStackTrace();
        }

        File sourceFileCPP = new File("./ProgTestSae/timethroughtheglass.cc");
        String binaryFileCPP = "test/timethroughtheglass_cpp.exe";
        try {
            compilerCPP.executeCompilerCommand(sourceFileCPP, binaryFileCPP);
            System.out.println("CPP Compilation success");
        } catch (Exception e) {
            e.printStackTrace();
        }

        File sourceFileJava = new File("test/TimeThroughTheGlass.java");
        String binaryFileJava = "test/TimeThroughTheGlass.class";
        try {
            compilerJava.executeCompilerCommand(sourceFileJava, binaryFileJava);
            System.out.println("Java Compilation success");
        } catch (Exception e) {
            e.printStackTrace();
        }

        File sourceFilePython = new File("test/timethroughtheglass.py");
        String binaryFilePython = "test/timethroughtheglass.pyc";
        try {
            compilerPython.executeCompilerCommand(sourceFilePython, binaryFilePython);
            System.out.println("Python Syntax check success");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
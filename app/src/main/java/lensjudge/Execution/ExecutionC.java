package lensjudge.Execution;

import lensjudge.compilation.CompilerC;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class ExecutionC implements IExecution {
    public void execute(String sourceFilePath) {
        CompilerC compiler = new CompilerC();
        String binaryFileName = null;
        try {
            binaryFileName = compiler.getBinaryFileName(sourceFilePath);
        } catch (Exception e) {
            System.out.println("Exception occurred while getting binary file name: " + e.getMessage());
            e.printStackTrace();
        }

        try {
            compiler.executeCompilerCommand(new File(sourceFilePath), binaryFileName);
        } catch (Exception e) {
            System.out.println("Exception occurred while executing compiler command: " + e.getMessage());
            e.printStackTrace();
        }

        File binaryFile = new File(binaryFileName);
        try (BufferedReader reader = new BufferedReader(new FileReader(binaryFile))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("Exception occurred while reading binary file: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

package lensjudge.Execution;

import lensjudge.compilation.CompilerC;
import lensjudge.compilation.CompilerPython;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

public class ExecutionPy implements IExecution {
     public void execute(String sourceFilePath) {
        CompilerPython compiler = new CompilerPython();
        try {
            File sourceFile = new File(sourceFilePath);
            compiler.executeCompilerCommand(sourceFile, null);

            ProcessBuilder processBuilder = new ProcessBuilder("python3", sourceFile.getAbsolutePath());
            processBuilder.directory(sourceFile.getParentFile());
            Process process = processBuilder.start();

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            }
            process.waitFor();
        } catch (Exception e) {
            System.out.println("Exception occurred while executing Python script: " + e.getMessage());
            e.printStackTrace();
        }
    }
}

package lensjudge.Execution;

import lensjudge.compilation.CompilerPython;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class ExecutionPy implements IExecution {
    public void execute(String sourceFilePath) {
        try {
            // Compile the Java source file
            CompilerPython compiler = new CompilerPython();
            String binaryFileName = compiler.getBinaryFileName(sourceFilePath);
            compiler.executeCompilerCommand(new File(sourceFilePath), new File(sourceFilePath).getParentFile());

            // Run the compiled Java class
            ProcessBuilder runProcessBuilder = new ProcessBuilder("python3", sourceFilePath);
            runProcessBuilder.directory(new File(sourceFilePath).getParentFile());
            Process runProcess = runProcessBuilder.start();

            // Read and print the output of the Java program
            BufferedReader reader = new BufferedReader(new InputStreamReader(runProcess.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            runProcess.waitFor();
        } catch (Exception e) {
            System.out.println("An error occurred while executing the Java program.");
        }
    }
}

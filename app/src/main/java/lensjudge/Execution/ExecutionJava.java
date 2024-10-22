package lensjudge.Execution;

import lensjudge.compilation.CompilerJava;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class ExecutionJava implements IExecution {
    public void execute(String sourceFilePath) {
        try {
            // Compile the Java source file
            CompilerJava compiler = new CompilerJava();
            compiler.executeCompilerCommand(new File(sourceFilePath), null);
// Extract the class name from the source file path
            String className = new File(sourceFilePath).getName().replace(".class", "");

// Run the compiled Java class
            ProcessBuilder runProcessBuilder = new ProcessBuilder("java", className);
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

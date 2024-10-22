package lensjudge.Execution;

import lensjudge.compilation.CompilerC;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class ExecutionC implements IExecution {
    public void execute(String sourceFilePath) {
        try {
            // Compile the Java source file
            CompilerC compiler = new CompilerC();
            compiler.executeCompilerCommand(sourceFilePath, compiler.getBinaryFileName(sourceFilePath));

            // Run the compiled C executable
            ProcessBuilder runProcessBuilder = new ProcessBuilder("./" + compiler.getBinaryFileName(sourceFilePath));
            runProcessBuilder.directory(new File(sourceFilePath).getParentFile());
            Process runProcess = runProcessBuilder.start();

            // Read and print the output of the C program
            BufferedReader reader = new BufferedReader(new InputStreamReader(runProcess.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            runProcess.waitFor();
        } catch (Exception e) {
            System.out.println("An error occurred while executing the C program.");
        }
    }
}

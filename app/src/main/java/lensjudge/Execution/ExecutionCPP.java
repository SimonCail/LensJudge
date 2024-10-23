package lensjudge.Execution;

import lensjudge.compilation.CompilerCPP;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class ExecutionCPP implements IExecution {
    public void execute(String sourceFilePath) {
        try {
            CompilerCPP compiler = new CompilerCPP();
            String binaryFileName = compiler.getBinaryFileName(sourceFilePath);
            compiler.executeCompilerCommand(new File(sourceFilePath), binaryFileName);

            // Run the compiled C++ executable
            ProcessBuilder runProcessBuilder = new ProcessBuilder("./" + binaryFileName);
            runProcessBuilder.directory(new File(sourceFilePath).getParentFile());
            Process runProcess = runProcessBuilder.start();

            // Read and print the output of the C++ program
            BufferedReader reader = new BufferedReader(new InputStreamReader(runProcess.getInputStream()));
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            runProcess.waitFor();
        } catch (Exception e) {
            System.out.println("An error occurred while executing the C++ program.");
        }
    }
}

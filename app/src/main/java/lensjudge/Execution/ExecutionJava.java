package lensjudge.Execution;

import lensjudge.process.ProcessAdapter;
import java.io.File;
import java.io.IOException;

/**
 * The ExecutionJava class implements the IExecution interface and provides
 * the functionality to execute a Java program.
 */
public class ExecutionJava implements IExecution {

    /**
     * Executes the given binary file.
     *
     * @param sourceFilePath the path to the source file
     * @param binaryFileName the name of the binary file to execute
     * @return a ProcessAdapter instance that represents the running process
     * @throws IOException if an I/O error occurs
     * @throws InterruptedException if the execution is interrupted
     */
    public ProcessAdapter execute(String sourceFilePath, String binaryFileName) throws IOException, InterruptedException {
        String className = binaryFileName.replace(".class", "");
        ProcessAdapter processAdapter = new ProcessAdapter("java", className);
        processAdapter.setDirectory(new File(sourceFilePath).getParent());
        return processAdapter;
    }
}

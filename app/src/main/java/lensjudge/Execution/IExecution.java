package lensjudge.Execution;

import lensjudge.process.ProcessAdapter;

import java.io.IOException;

/**
 * The IExecution interface defines a method for executing a program.
 */
public interface IExecution {

    /**
     * Executes the given binary file.
     *
     * @param sourceFilePath the path to the source file
     * @param binaryFileName the name of the binary file to execute
     * @return a ProcessAdapter instance that represents the running process
     * @throws IOException if an I/O error occurs
     * @throws InterruptedException if the execution is interrupted
     */
    ProcessAdapter execute(String sourceFilePath, String binaryFileName) throws IOException, InterruptedException;
}
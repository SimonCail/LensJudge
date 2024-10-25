package lensjudge.Execution;
import lensjudge.process.ProcessAdapter;


/**
 * The ExecutionPy class implements the IExecution interface and provides
 * the functionality to execute a Python program.
 */
public class ExecutionPy implements IExecution {

    /**
     * Executes the given Python script.
     *
     * @param sourceFilePath the path to the source file
     * @param binaryFileName the name of the binary file to execute
     * @return a ProcessAdapter instance that represents the running process
     */
    public ProcessAdapter execute(String sourceFilePath, String binaryFileName) {
        ProcessAdapter processAdapter = new ProcessAdapter("python3", sourceFilePath);
        return processAdapter;
    }
}

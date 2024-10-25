package lensjudge.Execution;

import lensjudge.process.ProcessAdapter;

/**
 * The ExecutionC class implements the IExecution interface and provides
 * the functionality to execute a C program.
 */
public class ExecutionC implements IExecution {

    /**
     * Executes the given binary file.
     *
     * @param sourceFilePath the path to the source file
     * @param binaryFileName the name of the binary file to execute
     * @return a ProcessAdapter instance that represents the running process
     */
    public ProcessAdapter execute(String sourceFilePath, String binaryFileName) {
        ProcessAdapter processAdapter=new ProcessAdapter(binaryFileName);
        return processAdapter;
    }

}
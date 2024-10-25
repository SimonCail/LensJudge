package lensjudge.Execution;

import lensjudge.compilation.CompilerC;
import lensjudge.compilation.CompilerCPP;
import lensjudge.process.ProcessAdapter;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 * The ExecutionCPP class implements the IExecution interface and provides
 * the functionality to execute a C++ program.
 */
public class ExecutionCPP implements IExecution {

    /**
     * Executes the given binary file.
     *
     * @param sourceFilePath the path to the source file
     * @param binaryFileName the name of the binary file to execute
     * @return a ProcessAdapter instance that represents the running process
     */
    public ProcessAdapter execute(String sourceFilePath, String binaryFileName) {
        ProcessAdapter processAdapter = new ProcessAdapter(binaryFileName);
        return processAdapter;
    }
}

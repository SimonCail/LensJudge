package lensjudge.Execution;

import lensjudge.compilation.CompilerC;
import lensjudge.compilation.CompilerPython;
import lensjudge.process.ProcessAdapter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;

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

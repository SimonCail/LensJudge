package lensjudge.Execution;

import lensjudge.compilation.CompilerC;
import lensjudge.compilation.CompilerJava;
import lensjudge.process.ProcessAdapter;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;

public class ExecutionJava implements IExecution {
    public ProcessAdapter execute(String sourceFilePath, String binaryFileName) throws IOException, InterruptedException {
        ProcessAdapter processAdapter=new ProcessAdapter(binaryFileName);
        processAdapter.startProcess();
        return processAdapter;
    }
}

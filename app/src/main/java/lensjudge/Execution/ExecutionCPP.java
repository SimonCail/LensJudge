package lensjudge.Execution;

import lensjudge.compilation.CompilerC;
import lensjudge.compilation.CompilerCPP;
import lensjudge.process.ProcessAdapter;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class ExecutionCPP implements IExecution {
    public ProcessAdapter execute(String sourceFilePath, String binaryFileName) {
        ProcessAdapter processAdapter=new ProcessAdapter(binaryFileName);
        return processAdapter;
    }
}

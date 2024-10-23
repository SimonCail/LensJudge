package lensjudge.Execution;

import lensjudge.process.ProcessAdapter;

import java.io.IOException;

public interface IExecution {
    ProcessAdapter execute(String sourceFilePath, String binaryFileName) throws IOException, InterruptedException;
}

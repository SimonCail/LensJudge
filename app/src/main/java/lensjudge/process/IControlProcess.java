package lensjudge.process;

import java.io.IOException;

public interface IControlProcess {
    String getErrorOutput() throws IOException;
    String getStandardOutput() throws IOException;

    void startProcess(String... command) throws IOException;
    int waitForProcess() throws InterruptedException;
    void stopProcess();
}

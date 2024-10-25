package lensjudge.process;

import java.io.IOException;

public interface IControlProcess {
    /**
     * Get the error output of the process
     * @return the error output of the process
     * @throws IOException if the error output cannot be read
     */
    String getErrorOutput() throws IOException;

    /**
     * Get the standard output of the process
     * @return the standard output of the process
     * @throws IOException if the standard output cannot be read
     */
    String getStandardOutput() throws IOException;

    /**
     * Start the process
     * @throws IOException if the process cannot be started
     */
    void startProcess() throws IOException;

    /**
     * Wait for the process to finish
     * @return the exit code of the process
     * @throws InterruptedException if the process is interrupted
     */
    int waitForProcess() throws InterruptedException;

    /**
     * Stop the process
     */
    void stopProcess();
}

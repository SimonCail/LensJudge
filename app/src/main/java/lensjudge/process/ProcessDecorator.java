package lensjudge.process;

import java.io.IOException;

/**
 * Decorator class for the IControlProcess interface that adds a time limit to the process
 */
public abstract class ProcessDecorator implements IControlProcess {
    /**
     * The process to be decorated
     */
    private final IControlProcess processControl;

    /**
     * Constructor for the ProcessDecorator
     *
     * @param processControl the process to be decorated
     */
    protected ProcessDecorator(IControlProcess processControl) {
        this.processControl = processControl;
    }

    /**
     * Start the process
     *
     * @throws IOException if the process cannot be started
     */
    @Override
    public void startProcess() throws IOException {
        processControl.startProcess();
    }

    /**
     * Wait for the process to finish
     *
     * @return the exit value of the process
     * @throws InterruptedException if the process is interrupted
     */
    @Override
    public int waitForProcess() throws InterruptedException {
        return processControl.waitForProcess();
    }

    /**
     * Get the standard output of the process
     *
     * @return the standard output of the process
     * @throws IOException if the process cannot be started
     */
    @Override
    public String getStandardOutput() throws IOException {
        return processControl.getStandardOutput();
    }

    /**
     * Get the error output of the process
     *
     * @return the error output of the process
     * @throws IOException if the process cannot be started
     */
    @Override
    public String getErrorOutput() throws IOException {
        return processControl.getErrorOutput();
    }

    /**
     * Stop the process
     */
    @Override
    public void stopProcess() {
        processControl.stopProcess();
    }

}

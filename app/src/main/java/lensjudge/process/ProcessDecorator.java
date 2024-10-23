package lensjudge.process;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public abstract class ProcessDecorator implements IControlProcess {
    private final IControlProcess processControl;

    public ProcessDecorator(IControlProcess processControl) {
        this.processControl = processControl;

    }

    @Override
    public void startProcess() throws IOException {
        processControl.startProcess();
    }

    @Override
    public int waitForProcess() throws InterruptedException {
        return processControl.waitForProcess();
    }

    @Override
    public String getStandardOutput() throws IOException {
        return processControl.getStandardOutput();
    }

    @Override
    public String getErrorOutput() throws IOException {
        return processControl.getErrorOutput();
    }

    @Override
    public void stopProcess() {
        processControl.stopProcess();
    }

}

package lensjudge.process;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class ProcessDecorator implements IControlProcess {
    private final IControlProcess processControl;
    private final long timeLimitMs;

    public ProcessDecorator(IControlProcess processControl, long timeLimitMs) {
        this.processControl = processControl;
        this.timeLimitMs = timeLimitMs;
    }

    @Override
    public void startProcess() throws IOException {
        processControl.startProcess();
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                processControl.stopProcess();
            }
        }, timeLimitMs);
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

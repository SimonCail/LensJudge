package lensjudge.process;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class TimeProcessDecorator extends ProcessDecorator {
    private final long timeLimitMs;

    public TimeProcessDecorator(IControlProcess processControl, long timeLimitMs) {
        super(processControl);
        this.timeLimitMs = timeLimitMs;
    }

    public void startProcess() throws IOException {
        super.startProcess();
        Timer timer = new Timer();
        timer.schedule(new StopProcess(), timeLimitMs);
    }

    protected class StopProcess extends TimerTask {
        public void run(){
            stopProcess();
        }
    }

}

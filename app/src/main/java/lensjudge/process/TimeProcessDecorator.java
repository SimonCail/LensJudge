/**
 * TimeProcessDecorator.java
 */
package lensjudge.process;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Decorator class for the IControlProcess interface that adds a time limit to the process
 */
public class TimeProcessDecorator extends ProcessDecorator {
    /**
     * The time limit in milliseconds
     */
    private final long timeLimitMs;

    /**
     * Constructor for the TimeProcessDecorator
     * @param processControl the process to be decorated
     * @param timeLimitMs the time limit in milliseconds
     */
    public TimeProcessDecorator(IControlProcess processControl, long timeLimitMs) {
        super(processControl);
        this.timeLimitMs = timeLimitMs;
    }

    /**
     * Start the process and set a timer to stop it after the time limit
     * @throws IOException if the process cannot be started
     */
    @Override
    public void startProcess() throws IOException {
        super.startProcess();
        Timer timer = new Timer();
        timer.schedule(new StopProcess(), timeLimitMs);
    }

    /**
     * Stop the process when the time limit is reached
     */
    protected class StopProcess extends TimerTask {
        public void run(){
            stopProcess();
        }
    }

}

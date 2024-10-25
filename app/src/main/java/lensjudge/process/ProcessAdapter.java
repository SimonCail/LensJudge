package lensjudge.process;

import lensjudge.verification.TypeVerification;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;


import java.io.*;



/**
 * Adapter class for the IControlProcess interface that adapts the ProcessBuilder class
 */
public class ProcessAdapter implements IControlProcess {
    private static final Logger LOGGER = LogManager.getLogger(ProcessAdapter.class.getPackageName());

    /**
     * The ProcessBuilder object
     */
    private final ProcessBuilder processBuilder;

    /**
     * The Process object
     */
    private Process process;

    /**
     * The error message for when the process has not been started
     */
    private static final String PROCESSNOTSTARTED = "Proces has not been started.";

    /**
     * Constructor for the ProcessAdapter
     *
     * @param command the command to be executed
     */
    public ProcessAdapter(String... command) {
        this.processBuilder = new ProcessBuilder(command);
    }

    /**
     * Get the error output of the process
     *
     * @return the error output of the process
     */
    @Override
    public String getErrorOutput() {
        if (process == null) {
            throw new IllegalStateException(PROCESSNOTSTARTED);
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        StringBuilder errorOutput = new StringBuilder();
        try {
            String line = reader.readLine();
            while (line != null) {
                errorOutput.append(line).append("\n");
                line = reader.readLine();
            }
        } catch (IOException e) {
            return TypeVerification.TIMEOUT.toString();
        }
        return errorOutput.toString();
    }

    /**
     * Set the working directory of the process
     *
     * @param directory the working directory of the process
     */
    public void setDirectory(String directory) {
        processBuilder.directory(new File(directory));
    }

    /**
     * Get the input stream of the process
     *
     * @return the input stream of the process
     */
    public InputStream getInputStream() {
        return process.getInputStream();
    }

    /**
     * Get the standard output of the process
     *
     * @return the standard output of the process
     */
    @Override
    public String getStandardOutput() {
        if (process == null) {
            throw new IllegalStateException(PROCESSNOTSTARTED);
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        StringBuilder standardOutput = new StringBuilder();
        try {
            String line = reader.readLine();
            while (line != null) {
                standardOutput.append(line).append("\n");
                line = reader.readLine();
            }
            return standardOutput.toString();
        } catch (IOException e) {
            return TypeVerification.TIMEOUT.toString();
        }
    }

    /**
     * Start the process
     */
    @Override
    public void startProcess() {
        try {
            this.process = processBuilder.start();
        }catch (IOException e){
            e.printStackTrace();
            LOGGER.printf(Level.WARN, PROCESSNOTSTARTED);
        }
    }

    /**
     * Wait for the process to finish
     *
     * @return the exit value of the process
     */
    @Override
    public int waitForProcess()  {
        int result = 0;
        try {
            result = process.waitFor();
        }catch (InterruptedException e){
            LOGGER.printf(Level.WARN, PROCESSNOTSTARTED);
            Thread.currentThread().interrupt();
        }
        return result;
    }

    /**
     * Stop the process
     */
    @Override
    public void stopProcess() {
        try {
            process.destroy();
        }catch (Exception e){
            LOGGER.printf(Level.WARN,PROCESSNOTSTARTED);
        }
    }
}

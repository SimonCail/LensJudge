package lensjudge.process;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ProcessAdapter implements IControlProcess {
    private ProcessBuilder processBuilder;
    private Process process;

    @Override
    public String getErrorOutput() {
        if (process == null) {
            throw new IllegalStateException("Process has not been started.");
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getErrorStream()));
        try {
            StringBuilder errorOutput = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                errorOutput.append(line).append(System.lineSeparator());
            }
            return errorOutput.toString();
        } catch (IOException e) {
            throw new RuntimeException("Error reading process error output", e);
        }
    }

    @Override
    public String getStandardOutput() {
        if (process == null) {
            throw new IllegalStateException("Process has not been started.");
        }
        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
        try {
            StringBuilder standardOutput = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                standardOutput.append(line).append(System.lineSeparator());
            }
            return standardOutput.toString();
        } catch (IOException e) {
            throw new RuntimeException("Error reading process output", e);
        }
    }

    @Override
    public void startProcess(String... command) throws IOException {
        processBuilder = new ProcessBuilder(command);
        process = processBuilder.start();
    }

    @Override
    public int waitForProcess() throws InterruptedException {
        if (process == null) {
            throw new IllegalStateException("Process has not been started.");
        }
        return process.waitFor();
    }

    @Override
    public void stopProcess() {
        if(process == null){
            throw new IllegalStateException("Process has not been started.");
        }
        process.destroy();
    }
}

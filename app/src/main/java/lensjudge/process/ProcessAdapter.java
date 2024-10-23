package lensjudge.process;

import java.io.*;

public class ProcessAdapter implements IControlProcess {
    private final ProcessBuilder processBuilder;
    private Process process;
    private static final String PROCESSNOTSTARTED = "Proces has not been started.";

    public ProcessAdapter(String... command) {
        this.processBuilder = new ProcessBuilder(command);
    }

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
            throw new RuntimeException("Error reading process error output", e);
        }
        return errorOutput.toString();
    }

    public void setDirectory(String directory) {
        processBuilder.directory(new File(directory));
    }

    public InputStream getInputStream() {
        return process.getInputStream();
    }

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
            throw new RuntimeException("Error reading process output", e);
        }
    }

    @Override
    public void startProcess() {
        try {
            this.process = processBuilder.start();
        }catch (IOException e){
            e.printStackTrace();
            System.out.println(PROCESSNOTSTARTED);
        }
    }

    @Override
    public int waitForProcess()  {
        int result = 0;
        try {
            result = process.waitFor();
        }catch (InterruptedException e){
            System.out.println(PROCESSNOTSTARTED);
        }
        return result;
    }

    @Override
    public void stopProcess() {
        try {
            process.destroy();
        }catch (Exception e){
            System.out.println(PROCESSNOTSTARTED);
        }
    }
}

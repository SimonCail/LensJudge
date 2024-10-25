package lensjudge.process;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import static java.lang.Math.round;
import static org.junit.jupiter.api.Assertions.*;

class ProcessAdapterTest {
    @Test
    @DisplayName("Return the standard output of a Java program")
    void testGetStandardOutput() {
        IControlProcess process = new ProcessAdapter("java", "C:/Users/Benji/Documents/COUR/BUT2/SAEA3.01/groupe-b2-s3.a.01/app/src/test/resources/Test.java");
        TimeProcessDecorator timedProcess = new TimeProcessDecorator(process, 5000);
        try{
            timedProcess.startProcess();
            int exitCode = timedProcess.waitForProcess();
            if(exitCode == 0){
                String result = timedProcess.getStandardOutput();
                System.out.println(result);
                assertEquals("if u see this thats good", result.trim());
            }
        }catch (Exception e){
            System.err.println("Erreur : " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Test.java error output for missing main class")
    void testGetErrorOutputForMissingMainClass() {
        IControlProcess process = new ProcessAdapter("java", "class.java");
        TimeProcessDecorator timedProcess = new TimeProcessDecorator(process, 30000);

        try {
            timedProcess.startProcess();

            int exitCode = timedProcess.waitForProcess();

            if (exitCode == 1) {
                String errorOutput = timedProcess.getErrorOutput();
                System.out.println("Error output: " + errorOutput);
                assertTrue(errorOutput.contains("Error: Could not find or load main class"));
            }
        } catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Return the result of the dir command")
    void testDir(){
        IControlProcess process = new ProcessAdapter("cmd", "/c", "dir"); // Windows command for listing files in a directory
        try {
            process.startProcess();
            String result = process.getStandardOutput(); 
            System.out.println(result);
            assertNotNull(result);
        } catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Test the time limit of a process")
    void testTimeLimit() {
        IControlProcess process = new ProcessAdapter("ping", "localhost", "-n", "5"); // Windows command for waiting 5 sec

        TimeProcessDecorator timedProcess = new TimeProcessDecorator(process, 200); // Limit the process to 2 sec

        try {
            long startTime = System.currentTimeMillis();
            timedProcess.startProcess();
            timedProcess.waitForProcess();
            long endTime = System.currentTimeMillis();

            long processDuration = endTime - startTime;

            processDuration = round(processDuration / 100.0) * 100;
            System.out.println(processDuration);

            assertEquals(200, processDuration, "Process duration: " + processDuration);
        } catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
        }
    }

    @Test
    void testGetInputStream() throws IOException {
        ProcessAdapter processAdapter = new ProcessAdapter("cmd", "/c", "echo", "test"); // Commands for windows
        processAdapter.startProcess();

        InputStream inputStream = processAdapter.getInputStream();

        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        StringBuilder output = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            output.append(line).append("\n");
            System.out.println(line);
        }

        String expectedOutput = "test";
        assertTrue(output.toString().trim().contains(expectedOutput));
        System.out.println();
        reader.close();
    }

    @Test
    @DisplayName("Test stopping a process")
    void testStopProcessWhenNotStarted() {
        ProcessAdapter processAdapter = new ProcessAdapter("cmd", "/c", "echo", "test");
        processAdapter.stopProcess();

        assertDoesNotThrow(() -> processAdapter.stopProcess(), "Should not throw an exception when stopping a non-started process.");
    }

    @Test
    @DisplayName("Test setting the directory of a process")
    void testSetDirectoryMethod() {
        ProcessAdapter processAdapter = new ProcessAdapter("cmd", "/c", "echo", "test"); // Commands for windows
        processAdapter.setDirectory("invalid/directory/path");
        assertDoesNotThrow(() -> processAdapter.startProcess());
    }


}

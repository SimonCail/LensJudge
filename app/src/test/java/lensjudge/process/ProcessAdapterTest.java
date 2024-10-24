package lensjudge.process;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class ProcessAdapterTest {
    @Test
    @DisplayName("Return the standard output of a Java program")
    public void testGetStandardOutput() {
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
    public void testGetErrorOutputForMissingMainClass() {
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
    public void testDir(){
        IControlProcess process = new ProcessAdapter("cmd", "/c", "dir"); // Windows command for listing files in a directory
        try {
            process.startProcess();
            String result = process.getStandardOutput(); 
            System.out.println(result);
        } catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Test the time limit of a process")
    public void testTimeLimit() {
        IControlProcess process = new ProcessAdapter("java", "C:/Users/Benji/Documents/COUR/BUT2/SAEA3.01/groupe-b2-s3.a.01/app/src/test/resources/Test.java");
        TimeProcessDecorator timedProcess = new TimeProcessDecorator(process, 10000);
        try {
            timedProcess.startProcess();
            long startTime = System.currentTimeMillis();
            int exitCode = timedProcess.waitForProcess();
            timedProcess.stopProcess();
            long endTime = System.currentTimeMillis();
            assertEquals(10, exitCode);
        } catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
        }
    }


}

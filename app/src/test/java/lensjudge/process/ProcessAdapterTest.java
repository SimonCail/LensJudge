package lensjudge.process;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class ProcessAdapterTest {
    @Test
    @DisplayName("Return the standard output")
    public void testGetStandardOutput() throws IOException, InterruptedException {
        IControlProcess process = new ProcessAdapter("java", "C:/Users/Benji/Documents/COUR/BUT2/SAEA3.01/groupe-b2-s3.a.01/app/src/test/java/lensjudge/process/Test.java");
        TimeProcessDecorator timedProcess = new TimeProcessDecorator(process, 5000);
        try{
            timedProcess.startProcess();
            int exitCode = timedProcess.waitForProcess();
            if(exitCode == 0){
                String result = timedProcess.getStandardOutput();
                System.out.println(result);
                assertTrue(result.trim().equals("if u see this thats good"));
            }
        }catch (Exception e){
            System.err.println("Erreur : " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Return the error output for missing main class")
    public void testGetErrorOutputForMissingMainClass() throws IOException, InterruptedException {
        IControlProcess process = new ProcessAdapter("java", "C:/Users/Benji/Documents/COUR/BUT2/SAEA3.01/groupe-b2-s3.a.01/app/src/test/java/lensjudge/process/Test.java");
        TimeProcessDecorator timedProcess = new TimeProcessDecorator(process, 5000);
        try {
            timedProcess.startProcess();
            int exitCode = timedProcess.waitForProcess();
            String result = timedProcess.getErrorOutput();
            System.out.println("Error Output: " + result);

        } catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
        }
    }


    @Test
    @DisplayName("Return the result of the dir command")
    public void testDir() throws IOException {
        IControlProcess process = new ProcessAdapter("cmd", "/c", "dir"); // Commande Windows pour lister les fichiers
        try {
            process.startProcess();
            String result = process.getStandardOutput(); 
            System.out.println(result);
        } catch (Exception e) {
            System.err.println("Erreur : " + e.getMessage());
        }
    }


}

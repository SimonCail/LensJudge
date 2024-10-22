package lensjudge.process;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ProcessAdapterTest {
    @Test
    @DisplayName("Return the standard output")
    public void testGetStandardOutput() throws IOException, InterruptedException {
        IControlProcess process = new ProcessAdapter("java", "C:/Users/Benji/Documents/COUR/BUT2/SAEA3.01/groupe-b2-s3.a.01/app/src/test/java/lensjudge/process/Test.java");
        ProcessDecorator timedProcess = new ProcessDecorator(process, 5000);
        try{
            timedProcess.startProcess();
            int exitCode = timedProcess.waitForProcess();
            if(exitCode == 0){
                String result = timedProcess.getStandardOutput();
                assertTrue(result.trim().equals("if u see this thats good"));
            }
        }catch (Exception e){
            System.err.println("Erreur : " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Return the error output")
    public void testGetErrorOutput() throws IOException, InterruptedException {
        IControlProcess process = new ProcessAdapter("java", "C:/Users/Benji/Documents/COUR/BUT2/SAEA3.01/groupe-b2-s3.a.01/app/src/test/java/lensjudge/process/Test.java");
        ProcessDecorator timedProcess = new ProcessDecorator(process, 5000);
        try{
            timedProcess.startProcess();
            int exitCode = timedProcess.waitForProcess();
            if(exitCode == 1){
                String result = timedProcess.getErrorOutput();
                assertTrue(result.trim().equals("Error: Could not find or load main class C:/Users/Benji/Documents/COUR/BUT2/SAEA3.01/groupe-b2-s3.a.01/app/src/test/java/lensjudge/process/Test.java"));
            }
        }catch (Exception e){
            System.err.println("Erreur : " + e.getMessage());
        }
    }
}

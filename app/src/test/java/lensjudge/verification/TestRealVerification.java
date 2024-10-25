package lensjudge.verification;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestRealVerification {

    @Test
    @DisplayName("Test RealVerification with matching lines")
    public void testVerifyWithMatchingLines() throws IOException {
        // Setup
        String inputContent = "line1\nline2\nline3\n";
        String outputContent = "line1\nline2\nline3\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputContent.getBytes());
        Path outputPath = Files.createTempFile("output", ".txt");
        FileWriter writer = new FileWriter(outputPath.toFile());
        writer.write(outputContent);
        writer.close();

        // Test
        RealVerification verification = new RealVerification();
        TypeVerification result = verification.verify(inputStream, outputPath.toString());

        // Display result
        System.out.println(result);

        // Verify
        assertEquals(TypeVerification.CORRECT, result);

        // Cleanup
        Files.delete(outputPath);
    }

    @Test
    @DisplayName("Test RealVerification with non-matching lines")
    public void testVerifyWithNonMatchingLines() throws IOException {
        // Setup
        String inputContent = "line1\nline2\nline4\n";
        String outputContent = "line1\nline2\nline3\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputContent.getBytes());
        Path outputPath = Files.createTempFile("output", ".txt");
        FileWriter writer = new FileWriter(outputPath.toFile());
        writer.write(outputContent);
        writer.close();

        // Test
        RealVerification verification = new RealVerification();
        TypeVerification result = verification.verify(inputStream, outputPath.toString());

        // Display result
        System.out.println(result);

        // Verify
        assertEquals(TypeVerification.WRONG, result);

        // Cleanup
        Files.delete(outputPath);
    }

    @Test
    @DisplayName("Test RealVerification with empty output file")
    public void testVerifyWithEmptyOutputFile() throws IOException {
        // Setup
        String inputContent = "line1\nline2\nline3\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputContent.getBytes());
        Path outputPath = Files.createTempFile("output", ".txt");

        // Test
        RealVerification verification = new RealVerification();
        TypeVerification result = verification.verify(inputStream, outputPath.toString());

        // Display result
        System.out.println(result);

        // Verify
        assertEquals(TypeVerification.WRONG, result);

        // Cleanup
        Files.delete(outputPath);
    }
}
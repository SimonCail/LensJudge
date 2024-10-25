package lensjudge.verification;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestOneOfSeveralVerification {

    @Test
    @DisplayName("Test OneOfSeveralVerification with matching line")
    public void testVerifyWithMatchingLine() throws IOException {
        // Setup
        String inputContent = "test line\n";
        String outputContent = "test line\nanother line\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputContent.getBytes());
        Path outputPath = Files.createTempFile("output", ".txt");
        FileWriter writer = new FileWriter(outputPath.toFile());
        writer.write(outputContent);
        writer.close();

        // Test
        OneOfSeveralVerification verification = new OneOfSeveralVerification();
        TypeVerification result = verification.verify(inputStream, outputPath.toString());

        System.out.println(result); // Return CORRECT
        // Verify
        assertEquals(TypeVerification.CORRECT, result);
    }

    @Test
    @DisplayName("Test OneOfSeveralVerification with non-matching line")
    public void testVerifyWithNonMatchingLine() throws IOException {
        // Setup
        String inputContent = "non-matching line\n";
        String outputContent = "test line\nanother line\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputContent.getBytes());
        Path outputPath = Files.createTempFile("output", ".txt");
        FileWriter writer = new FileWriter(outputPath.toFile());
        writer.write(outputContent);
        writer.close();

        // Test
        OneOfSeveralVerification verification = new OneOfSeveralVerification();
        TypeVerification result = verification.verify(inputStream, outputPath.toString());

        // Verify
        System.out.println(result); // Return WRONG
        assertEquals(TypeVerification.WRONG, result);

    }

    @Test
    @DisplayName("Test OneOfSeveralVerification with empty output file")
    public void testVerifyWithEmptyOutputFile() throws IOException {
        // Setup
        String inputContent = "test line\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputContent.getBytes());
        Path outputPath = Files.createTempFile("output", ".txt");

        // Test
        OneOfSeveralVerification verification = new OneOfSeveralVerification();
        TypeVerification result = verification.verify(inputStream, outputPath.toString());

        // Verify
        System.out.println(result); // Return WRONG
        assertEquals(TypeVerification.WRONG, result);

        // Cleanup
        Files.delete(outputPath);
    }
}
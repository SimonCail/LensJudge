package lensjudge.verification;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestOrderVerification {

    @Test
    @DisplayName("Test OrderVerification with matching lines in order")
    public void testVerifyWithMatchingLinesInOrder() throws IOException {
        // Setup
        String inputContent = "line1\nline2\nline3\n";
        String outputContent = "line1\nline2\nline3\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputContent.getBytes());
        Path outputPath = Files.createTempFile("output", ".txt");
        FileWriter writer = new FileWriter(outputPath.toFile());
        writer.write(outputContent);
        writer.close();

        // Test
        OrderVerification verification = new OrderVerification();
        TypeVerification result = verification.verify(inputStream, outputPath.toString());

        // Verify
        System.out.println(result); // Return CORRECT
        assertEquals(TypeVerification.CORRECT, result);
    }

    @Test
    @DisplayName("Test OrderVerification with non-matching lines")
    public void testVerifyWithNonMatchingLines() throws IOException {
        // Setup
        String inputContent = "line1\nline2\nline4\n";
        String outputContent = "line1\nline2\nline3\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputContent.getBytes());
        Path outputPath = Files.createTempFile("output", ".txt");

        // Test
        OrderVerification verification = new OrderVerification();
        TypeVerification result = verification.verify(inputStream, outputPath.toString());

        // Verify
        System.out.println(result); // Return WRONG
        assertEquals(TypeVerification.WRONG, result);

        // Cleanup
        Files.delete(outputPath);
    }

    @Test
    @DisplayName("Test OrderVerification with empty output file")
    public void testVerifyWithEmptyOutputFile() throws IOException {
        // Setup
        String inputContent = "line1\nline2\nline3\n";
        ByteArrayInputStream inputStream = new ByteArrayInputStream(inputContent.getBytes());
        Path outputPath = Files.createTempFile("output", ".txt");

        // Test
        OrderVerification verification = new OrderVerification();
        TypeVerification result = verification.verify(inputStream, outputPath.toString());

        // Verify
        System.out.println(result); // Return WRONG
        assertEquals(TypeVerification.WRONG, result);

        // Cleanup
        Files.delete(outputPath);
    }
}
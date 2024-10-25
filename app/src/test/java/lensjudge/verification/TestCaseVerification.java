package lensjudge.verification;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import static org.junit.jupiter.api.Assertions.*;

public class TestCaseVerification {

    @Test
    public void testIsNotEmpty() {
        CaseVerification verifier = new CaseVerification();
        assertTrue(verifier.isNotEmpty("path/to/nonempty/file"));
        assertFalse(verifier.isNotEmpty("path/to/empty/file"));
    }

    @Test
    public void testIsFileExists() {
        CaseVerification verifier = new CaseVerification();
        assertTrue(verifier.isFileExists("path/to/existing/file"));
        assertFalse(verifier.isFileExists("path/to/nonexistent/file"));
    }

    @Test
    public void testVerify() {
        CaseVerification verifier = new CaseVerification();
        String inputContent = "Hello World";
        InputStream inputStream = new ByteArrayInputStream(inputContent.getBytes());
        assertEquals(TypeVerification.CORRECT, verifier.verify(inputStream, "path/to/correct/file"));
        assertEquals(TypeVerification.WRONG, verifier.verify(inputStream, "path/to/incorrect/file"));
    }
}
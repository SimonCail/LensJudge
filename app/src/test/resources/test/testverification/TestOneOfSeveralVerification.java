package lensjudge.testverification;

import lensjudge.verification.OneOfSeveralVerification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestOneOfSeveralVerification {

    @Test
    @DisplayName("Test isNotEmpty")
    public void testIsNotEmpty() {
        OneOfSeveralVerification oneOfSeveralVerification = new OneOfSeveralVerification();
        Assertions.assertTrue(oneOfSeveralVerification.isNotEmpty("/export/etu/matheo.dalmasso/Documents/BUT2/SAE/SAE3.01/groupe-b2-s3.a.01/app/src/test/resources/notEmpty.txt"));
        Assertions.assertFalse(oneOfSeveralVerification.isNotEmpty("/export/etu/matheo.dalmasso/Documents/BUT2/SAE/SAE3.01/groupe-b2-s3.a.01/app/src/test/resources/empty.txt"));
    }

    @Test
    @DisplayName("Test isFileExists")
    public void testIsFileExists() {
        OneOfSeveralVerification oneOfSeveralVerification = new OneOfSeveralVerification();
        Assertions.assertTrue(oneOfSeveralVerification.isFileExists("/export/etu/matheo.dalmasso/Documents/BUT2/SAE/SAE3.01/groupe-b2-s3.a.01/app/src/test/resources/notEmpty.txt"));
        Assertions.assertFalse(oneOfSeveralVerification.isFileExists("/export/etu/matheo.dalmasso/Documents/BUT2/SAE/SAE3.01/groupe-b2-s3.a.01/app/src/test/resources/notexists.txt"));
    }

    @Test
    @DisplayName("Test verify")
    public void testVerify() {
        OneOfSeveralVerification oneOfSeveralVerification = new OneOfSeveralVerification();
        Assertions.assertTrue(oneOfSeveralVerification.verify("/export/etu/matheo.dalmasso/Documents/BUT2/SAE/SAE3.01/groupe-b2-s3.a.01/app/src/test/resources/oneSeveralTest", "/export/etu/matheo.dalmasso/Documents/BUT2/SAE/SAE3.01/groupe-b2-s3.a.01/app/src/test/resources/oneSeveral2"));
        Assertions.assertFalse(oneOfSeveralVerification.verify("/export/etu/matheo.dalmasso/Documents/BUT2/SAE/SAE3.01/groupe-b2-s3.a.01/app/src/test/resources/oneSeveralTest", "/export/etu/matheo.dalmasso/Documents/BUT2/SAE/SAE3.01/groupe-b2-s3.a.01/app/src/test/resources/testOrder"));
    }
}

package lensjudge.testverification;

import lensjudge.verification.RealVerification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestRealVerification {

    @Test
    @DisplayName("Test isNotEmpty")
    public void testIsNotEmpty() {
        RealVerification realVerification = new RealVerification();
        Assertions.assertFalse(realVerification.isNotEmpty("/export/etu/matheo.dalmasso/Documents/BUT2/SAE/SAE3.01/groupe-b2-s3.a.01/app/src/test/resources/empty.txt"));
        Assertions.assertTrue(realVerification.isNotEmpty("/export/etu/matheo.dalmasso/Documents/BUT2/SAE/SAE3.01/groupe-b2-s3.a.01/app/src/test/resources/testReel.txt"));
    }

    @Test
    @DisplayName("Test isFileExists")
    public void testIsFileExists() {
        RealVerification realVerification = new RealVerification();
        Assertions.assertTrue(realVerification.isFileExists("/export/etu/matheo.dalmasso/Documents/BUT2/SAE/SAE3.01/groupe-b2-s3.a.01/app/src/test/resources/testReel.txt"));
        Assertions.assertFalse(realVerification.isFileExists("../resources/notexist.txt"));
    }

    @Test
    @DisplayName("Test verify")
    public void testVerify() {
        RealVerification realVerification = new RealVerification();
        Assertions.assertTrue(realVerification.verify("/export/etu/matheo.dalmasso/Documents/BUT2/SAE/SAE3.01/groupe-b2-s3.a.01/app/src/test/resources/testReel.txt", "/export/etu/matheo.dalmasso/Documents/BUT2/SAE/SAE3.01/groupe-b2-s3.a.01/app/src/test/resources/testReel2.txt"));
        Assertions.assertFalse(realVerification.verify("/export/etu/matheo.dalmasso/Documents/BUT2/SAE/SAE3.01/groupe-b2-s3.a.01/app/src/test/resources/testReel.txt", "/export/etu/matheo.dalmasso/Documents/BUT2/SAE/SAE3.01/groupe-b2-s3.a.01/app/src/test/resources/testReel3.txt"));
    }
}

package lensjudge.testverification;

import lensjudge.verification.CaseVerification;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestCaseVerification {

    @Test
    @DisplayName("Test isNotEmpty")
    public void testIsNotEmpty() {
        CaseVerification caseVerification = new CaseVerification();
        assertFalse(caseVerification.isNotEmpty("/export/etu/matheo.dalmasso/Documents/BUT2/SAE/SAE3.01/groupe-b2-s3.a.01/app/src/test/resources/empty.txt"));
        assertTrue(caseVerification.isNotEmpty("/export/etu/matheo.dalmasso/Documents/BUT2/SAE/SAE3.01/groupe-b2-s3.a.01/app/src/test/resources/notEmpty.txt"));
    }

    @Test
    @DisplayName("Test isFileExists")
    public void testIsFileExists() {
        CaseVerification caseVerification = new CaseVerification();
        assertTrue(caseVerification.isFileExists("/export/etu/matheo.dalmasso/Documents/BUT2/SAE/SAE3.01/groupe-b2-s3.a.01/app/src/test/resources/empty.txt"));
        assertFalse(caseVerification.isFileExists("../resources/notexist.txt"));
    }

    @Test
    @DisplayName("Test verify")
    public void testVerify() {
        CaseVerification caseVerification = new CaseVerification();
        assertTrue(caseVerification.verify("/export/etu/matheo.dalmasso/Documents/BUT2/SAE/SAE3.01/groupe-b2-s3.a.01/app/src/test/resources/testCase", "/export/etu/matheo.dalmasso/Documents/BUT2/SAE/SAE3.01/groupe-b2-s3.a.01/app/src/test/resources/testCase2"));
        assertFalse(caseVerification.verify("/export/etu/matheo.dalmasso/Documents/BUT2/SAE/SAE3.01/groupe-b2-s3.a.01/app/src/test/resources/notEmpty.txt", "/export/etu/matheo.dalmasso/Documents/BUT2/SAE/SAE3.01/groupe-b2-s3.a.01/app/src/test/resources/testCase.txt"));
    }
}

package lensjudge.testverification;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestOrderVerification {

    @Test
    @DisplayName("Test isNotEmpty")
    public void testIsNotEmpty() {
        OrderVerication orderVerication = new OrderVerication();
        assertFalse(orderVerication.isNotEmpty("/export/etu/matheo.dalmasso/Documents/BUT2/SAE/SAE3.01/groupe-b2-s3.a.01/app/src/test/resources/empty.txt"));
        assertTrue(orderVerication.isNotEmpty("/export/etu/matheo.dalmasso/Documents/BUT2/SAE/SAE3.01/groupe-b2-s3.a.01/app/src/test/resources/notEmpty.txt"));
    }

    @Test
    @DisplayName("Test isFileExists")
    public void testIsFileExists() {
        OrderVerication orderVerication = new OrderVerication();
        assertTrue(orderVerication.isFileExists("/export/etu/matheo.dalmasso/Documents/BUT2/SAE/SAE3.01/groupe-b2-s3.a.01/app/src/test/resources/empty.txt"));
        assertFalse(orderVerication.isFileExists("../resources/notexist.txt"));
    }

    @Test
    @DisplayName("Test verify")
    public void testVerify() {
        OrderVerication orderVerication = new OrderVerication();
        assertTrue(orderVerication.verify("/export/etu/matheo.dalmasso/Documents/BUT2/SAE/SAE3.01/groupe-b2-s3.a.01/app/src/test/resources/testOrder2", "/export/etu/matheo.dalmasso/Documents/BUT2/SAE/SAE3.01/groupe-b2-s3.a.01/app/src/test/resources/testOrder"));
        assertFalse(orderVerication.verify("/export/etu/matheo.dalmasso/Documents/BUT2/SAE/SAE3.01/groupe-b2-s3.a.01/app/src/test/resources/testOrder.txt", "/export/etu/matheo.dalmasso/Documents/BUT2/SAE/SAE3.01/groupe-b2-s3.a.01/app/src/test/resources/testReel.txt"));
    }
}

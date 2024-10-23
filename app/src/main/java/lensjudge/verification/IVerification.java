package lensjudge.verification;

import java.io.InputStream;

public interface IVerification {
    boolean isNotEmpty(String pathFileIn);
    boolean isFileExists(String pathFileIn);
    boolean verify(InputStream input, String pathFileOut);
}

package lensjudge.verification;

import java.io.InputStream;

public interface IVerification {
    boolean isNotEmpty(String pathFileIn);
    boolean isFileExists(String pathFileIn);
    TypeVerification verify(InputStream input, String pathFileOut);
}

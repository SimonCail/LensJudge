package lensjudge.verification;

public interface IVerification {
    boolean isNotEmpty(String pathFileIn, String pathFileOut);
    boolean isFileExists(String pathFileIn, String pathFileOut);
    boolean verify(String pathFileIn, String pathFileOut);
}

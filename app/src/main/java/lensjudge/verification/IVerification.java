package lensjudge.verification;

public interface IVerification {
    boolean isNotEmpty(String pathFileIn);
    boolean isFileExists(String pathFileIn);
    boolean verify(String pathFileIn, String pathFileOut);
}

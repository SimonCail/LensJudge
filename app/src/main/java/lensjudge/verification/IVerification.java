package lensjudge.verification;

import java.io.InputStream;

/**
 * The IVerification interface provides methods to verify the contents of files.
 */
public interface IVerification {
    /**
     * Checks if the file at the given path is not empty.
     *
     * @param pathFileIn the path to the file
     * @return true if the file is not empty, false otherwise
     */
    boolean isNotEmpty(String pathFileIn);

    /**
     * Checks if the file at the given path exists.
     *
     * @param pathFileIn the path to the file
     * @return true if the file exists, false otherwise
     */
    boolean isFileExists(String pathFileIn);

    /**
     * Verifies the contents of the input stream against the contents of the file at the given path.
     *
     * @param input the input stream to verify
     * @param pathFileOut the path to the file to compare against
     * @return the result of the verification
     */
    TypeVerification verify(InputStream input, String pathFileOut);
}
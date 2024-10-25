package lensjudge.verification;

/**
 * The TypeVerification enum represents the possible outcomes of a verification process.
 */
public enum TypeVerification {
    /**
     * Indicates that the verification was successful.
     */
    CORRECT,

    /**
     * Indicates that the verification failed.
     */
    WRONG,

    /**
     * Indicates that the verification process timed out.
     */
    TIMEOUT,
    ERROR,
    COMPILATION_ERROR
}

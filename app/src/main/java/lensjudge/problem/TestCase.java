package lensjudge.problem;

import java.io.File;

/**
 * Represents a test case for the problem
 */
public class TestCase {
    /**
     * Name of the file
     */
    private String fileName;

    /**
     * Path for the input and output files
     */
    private String pathFileIn;

    /**
     * Path for the output file
     */
    private String pathFileOut;

    /**
     * Constructor for the test case
     *
     * @param fileName Name of the file
     * @param fileIn File for the input
     * @param fileOut File for the output
     */
    public TestCase(String fileName, File fileIn, File fileOut) {
        this.fileName = fileName;
        this.pathFileIn = fileIn.getAbsolutePath();
        this.pathFileOut = fileOut.getAbsolutePath();
    }

    /**
     * Get the name of the file
     *
     * @return String
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Get the file for the input
     *
     * @return File
     */
    public String getPathFileIn() {
        return pathFileIn;
    }

    /**
     * Get the file for the output
     *
     * @return File
     */
    public String getPathFileOut() {
        return pathFileOut;
    }

    /**
     * Check if the files exist
     *
     * @return boolean
     */
    public boolean exists () {
        /**
         * File for the input
         */
        File fileIn = new File(pathFileIn);
        /**
         * File for the output
         */
        File fileOut = new File(pathFileOut);
        return fileIn.exists() && fileOut.exists();
    }
}

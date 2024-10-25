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
     * File for the input
     */
    private File fileIn;

    /**
     * File for the output
     */
    private File fileOut;

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
        fileIn = new File(pathFileIn);
        fileOut = new File(pathFileOut);
        return fileIn.exists() && fileOut.exists();
    }
}

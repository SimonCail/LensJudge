package lensjudge.problem;

import java.io.File;

public class TestCase {
    private String fileName;
    private File fileIn;
    private File fileOut;
    private String pathFileIn;
    private String pathFileOut;

    public TestCase(String fileName, File fileIn, File fileOut) {
        this.fileName = fileName;
        this.pathFileIn = fileIn.getAbsolutePath();
        this.pathFileOut = fileOut.getAbsolutePath();
    }

    public String getFileName() {
        return fileName;
    }

    public String getPathFileIn() {
        return pathFileIn;
    }

    public String getPathFileOut() {
        return pathFileOut;
    }
    public boolean exists () {
        fileIn = new File(pathFileIn);
        fileOut = new File(pathFileOut);
        return fileIn.exists() && fileOut.exists();
    }
}

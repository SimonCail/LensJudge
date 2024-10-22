package lensjudge.problem;

import java.io.File;

public class TestCase {
    private String fileName;
    private String pathFileIn;
    private String pathFileOut;

    public TestCase(String fileName) {
        this.fileName = fileName;
        this.pathFileIn = "/"+ fileName + ".in";
        this.pathFileOut = "/"+ fileName + ".out";
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
        File fileIn = new File(pathFileIn);
        File fileOut = new File(pathFileOut);
        return fileIn.exists() && fileOut.exists();
    }
}

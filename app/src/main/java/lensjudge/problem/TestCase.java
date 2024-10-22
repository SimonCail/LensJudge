package lensjudge.problem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class TestCase {
    private String fileName;
    private String linkFileIn;
    private String linkFileOut;

    public TestCase(String fileName) {
        this.fileName = fileName;
        this.linkFileIn = "/"+ fileName + ".in";
        this.linkFileOut = "/"+ fileName + ".out";
    }

    public String getFileName() {
        return fileName;
    }

    public String getLinkFileIn() {
        return linkFileIn;
    }

    public String getLinkFileOut() {
        return linkFileOut;
    }
    public boolean exists () {
        File fileIn = new File(linkFileIn);
        File fileOut = new File(linkFileOut);
        return fileIn.exists() && fileOut.exists();
    }
}

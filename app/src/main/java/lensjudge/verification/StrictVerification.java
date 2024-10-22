package lensjudge.verification;

import java.io.*;

public class StrictVerification implements IVerification {
    @Override
    public boolean isNotEmpty(String pathFileIn, String pathFileOut) {
        if (isFileExists(pathFileIn, pathFileOut)) {
            File fileIn = new File(pathFileIn);
            File fileOut = new File(pathFileOut);
            return fileIn.length() > 0 && fileOut.length() > 0;
        }
        return false;
    }

    @Override
    public boolean isFileExists(String pathFileIn, String pathFileOut) {
        File fileIn = new File(pathFileIn);
        File fileOut = new File(pathFileOut);
        return fileIn.exists() && fileOut.exists();
    }

    @Override
    public boolean verify(String pathFileIn, String pathFileOut) {
        if (isNotEmpty(pathFileIn, pathFileOut)) {
            try {
                File fileIn = new File(pathFileIn);
                File fileOut = new File(pathFileOut);
                BufferedReader br = new BufferedReader(new FileReader(fileIn));
                BufferedReader br2 = new BufferedReader(new FileReader(fileOut));
                String lineIn;
                String lineOut;
                if (fileIn.length() != fileOut.length()) {
                    return false;
                }
                while ((lineIn = br.readLine()) != null && (lineOut = br2.readLine()) != null) {
                    if (!lineIn.equals(lineOut)) {
                        return false;
                    }
                }
                return true;
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return false;
    }
}

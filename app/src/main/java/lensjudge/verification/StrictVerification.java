package lensjudge.verification;

import java.io.*;

public class StrictVerification implements IVerification {
    @Override
    public boolean isNotEmpty(String pathFileIn) {
        if (isFileExists(pathFileIn)) {
            File fileIn = new File(pathFileIn);
            return fileIn.length() > 0;
        }
        return false;
    }

    @Override
    public boolean isFileExists(String pathFileIn) {
        File fileIn = new File(pathFileIn);
        return fileIn.exists();
    }

    @Override
    public boolean verify(String pathFileIn, String pathFileOut) {
        if (isNotEmpty(pathFileIn) && isNotEmpty(pathFileOut)) {
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

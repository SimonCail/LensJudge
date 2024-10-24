package lensjudge.verification;

import java.io.*;

public class CaseVerification implements IVerification {
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
    public boolean verify(InputStream input, String pathFileOut) {
        if (isNotEmpty(pathFileOut)) {
            try {
                File fileOut = new File(pathFileOut);
                BufferedReader br = new BufferedReader(new InputStreamReader(input));
                BufferedReader br2 = new BufferedReader(new FileReader(fileOut));
                String lineIn;
                String lineOut;
                while ((lineIn = br.readLine()) != null && (lineOut = br2.readLine()) != null) {
                    lineIn = lineIn.replaceAll("\\s", "");
                    lineOut = lineOut.replaceAll("\\s", "");
                    lineIn = lineIn.toLowerCase();
                    lineOut = lineOut.toLowerCase();
                    System.out.println("Comparing lineIn: " + lineIn + " with lineOut: " + lineOut);
                    if (!lineIn.equals(lineOut)) {
                        System.out.println("Mismatch: " + lineIn + " does not match " + lineOut);
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

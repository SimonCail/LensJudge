package lensjudge.verification;

import java.io.*;
import java.util.ArrayList;


public class OrderVerification implements IVerification {
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
                ArrayList<String> arrOut = new ArrayList<>();

                System.out.println("Reading output file: " + pathFileOut);
                while ((lineOut = br2.readLine()) != null) {
                    arrOut.add(lineOut);
                    System.out.println("Read from output file: " + lineOut);
                }

                System.out.println("Comparing input stream with output file");
                while ((lineIn = br.readLine()) != null) {
                    System.out.println("Comparing line: " + lineIn);
                    if (!arrOut.contains(lineIn)) {
                        System.out.println("Mismatch: " + lineIn + " not found in output file");
                        return false;
                    }
                    arrOut.remove(lineIn);
                }

                return true;
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return false;
    }
}

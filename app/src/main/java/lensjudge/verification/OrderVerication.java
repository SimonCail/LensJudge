package lensjudge.verification;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class OrderVerication implements IVerification {
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
                ArrayList<String> arrOut = new ArrayList<>();
                while ((lineOut = br2.readLine()) != null) {
                    arrOut.add(lineOut);
                }
                while((lineIn = br.readLine()) != null) {
                    if (!arrOut.contains(lineIn)) {
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

package lensjudge.verification;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class RealVerification implements IVerification {
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
                float[] arrIn = new float[10];
                float[] arrOut = new float[10];
                int compt = 0;
                if (fileIn.length() != fileOut.length()) {
                    return false;
                }
                while ((lineIn = br.readLine()) != null && (lineOut = br2.readLine()) != null) {
                    arrIn[compt] = Float.parseFloat(lineIn);
                    arrOut[compt] = Float.parseFloat(lineOut);
                    compt++;
                    if (arrIn[compt] - arrOut[compt] >= 0.00001 || arrIn[compt] - arrOut[compt] <= -0.00001) {
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

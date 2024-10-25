package lensjudge.verification;

import java.io.*;

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
    public TypeVerification verify(InputStream input, String pathFileOut) {
        if (isNotEmpty(pathFileOut)) {
            try {
                File fileOut = new File(pathFileOut);
                BufferedReader br = new BufferedReader(new InputStreamReader(input));
                BufferedReader br2 = new BufferedReader(new FileReader(fileOut));
                String lineIn;
                String lineOut;
                float[] arrIn = new float[100];
                float[] arrOut = new float[100];
                int compt = 0;
                while ((lineIn = br.readLine()) != null && (lineOut = br2.readLine()) != null) {
                    arrIn[compt] = Float.parseFloat(lineIn);
                    arrOut[compt] = Float.parseFloat(lineOut);
                    if (Math.abs(arrIn[compt] - arrOut[compt]) > 0.0001) {
                        return TypeVerification.WRONG;
                    }
                    compt++;
                }
                return TypeVerification.CORRECT;
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return TypeVerification.WRONG;
    }
}

package lensjudge.verification;

import java.io.*;

/**
 * The RealVerification class implements the IVerification interface and provides
 * methods to verify if the floating-point numbers from an input stream match the numbers in a specified file.
 */
public class RealVerification implements IVerification {

    /**
     * Checks if the file at the given path is not empty.
     *
     * @param pathFileIn the path to the file
     * @return true if the file is not empty, false otherwise
     */
    @Override
    public boolean isNotEmpty(String pathFileIn) {
        if (isFileExists(pathFileIn)) {
            File fileIn = new File(pathFileIn);
            return fileIn.length() > 0;
        }
        return false;
    }

    /**
     * Checks if the file at the given path exists.
     *
     * @param pathFileIn the path to the file
     * @return true if the file exists, false otherwise
     */
    @Override
    public boolean isFileExists(String pathFileIn) {
        File fileIn = new File(pathFileIn);
        return fileIn.exists();
    }

    /**
     * Verifies if the floating-point numbers from the input stream match the numbers in the file at the given path.
     *
     * @param input the input stream to verify
     * @param pathFileOut the path to the file to compare against
     * @return the result of the verification
     */
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

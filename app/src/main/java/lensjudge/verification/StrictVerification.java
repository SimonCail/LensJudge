package lensjudge.verification;

import java.io.*;

/**
 * The StrictVerification class implements the IVerification interface and provides
 * methods to strictly verify if the lines from an input stream match the lines in a specified file.
 */
public class StrictVerification implements IVerification {

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
     * Verifies if the lines from the input stream strictly match the lines in the file at the given path.
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

                while ((lineIn = br.readLine()) != null && (lineOut = br2.readLine()) != null) {
                    if (!lineIn.equals(lineOut)) {
                        return TypeVerification.WRONG;
                    }
                }

                return TypeVerification.CORRECT;
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return TypeVerification.WRONG;
    }
}
package lensjudge.verification;

import java.io.*;
import java.util.ArrayList;

/**
 * The OrderVerification class implements the IVerification interface and provides
 * methods to verify if the lines from an input stream match the lines in a specified file in order.
 */
public class OrderVerification implements IVerification {

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
     * Verifies if the lines from the input stream match the lines in the file at the given path in order.
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
                        return TypeVerification.WRONG;
                    }
                    arrOut.remove(lineIn);
                }

                return TypeVerification.CORRECT;
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return TypeVerification.WRONG;
    }
}
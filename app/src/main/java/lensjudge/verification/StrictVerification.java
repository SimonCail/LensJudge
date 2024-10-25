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
    public TypeVerification verify(InputStream input, String pathFileOut) {
        if (isNotEmpty(pathFileOut)) {
            try {
                File fileOut = new File(pathFileOut);
                BufferedReader br = new BufferedReader(new InputStreamReader(input));
                BufferedReader br2 = new BufferedReader(new FileReader(fileOut));

                String lineIn;
                String lineOut;

                System.out.println("Comparaison du fichier avec : " + pathFileOut);
                while ((lineIn = br.readLine()) != null && (lineOut = br2.readLine()) != null) {
                    System.out.println("lineIn: " + lineIn + " | lineOut: " + lineOut); // Affiche les lignes comparées
                    if (!lineIn.equals(lineOut)) {
                        System.out.println("Mismatch: lineIn (" + lineIn + ") != lineOut (" + lineOut + ")");
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

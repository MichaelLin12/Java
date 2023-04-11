import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class StringGenerator {
    private static final String LOWERCASE_ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static String generateRandomString(int length) {
        StringBuilder sb = new StringBuilder(length);
        Random random = new Random();
        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(LOWERCASE_ALPHABET.length());
            char randomChar = LOWERCASE_ALPHABET.charAt(randomIndex);
            sb.append(randomChar);
        }
        return sb.toString();
    }
    
    public static void writeRandomStringsToFile(String filePath, int numberOfStrings, int stringLength) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filePath));
        for (int i = 0; i < numberOfStrings; i++) {
            String randomString = generateRandomString(stringLength);
            writer.write(randomString);
            writer.newLine();
        }
        writer.close();
    }
    
    public static void main(String[] args) throws IOException {
        String filePath = "random_strings.txt";
        int numberOfStrings = 1000000;
        int stringLength = 100;
        writeRandomStringsToFile(filePath, numberOfStrings, stringLength);
    }
}

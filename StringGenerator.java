public class StringGenerator {
    public static void main(String[] args) {
        // Generate a random string of length 100 using only lowercase letters
        String[] records = generateRandomStrings(100,100,26, 97);

        // Print the generated string
        for (int i = 0; i < records.length; i++) {
            System.out.println(records[i]);
        }
    }

    public static String[] generateRandomStrings(int size, int length, int range, int offset) {
        String[] records = new String[size];
        for (int i = 0; i < size; i++) {
            records[i] = generateRandomString(length, range, offset);
        }
        return records;
    }

    public static String generateRandomString(int length, int range, int offset) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append((char) (Math.random() * range + offset));
        }
        return sb.toString();
    }
}

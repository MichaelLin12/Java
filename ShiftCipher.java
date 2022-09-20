import java.util.ArrayList;
import java.util.List;

public class ShiftCipher{
    public static void main(String[] args){
        // List<String> possibilities = hackShiftCipher("DIBSMFT GNKBCDGVJ KISVKI MLEIZL");
        // for(int i = 0; i < possibilities.size(); i++){
        //     System.out.println("key="+ i + " "+ possibilities.get(i));
        // }

        // System.out.println(encryptPlainText("EDWARD",8));

        int i = 1;
        while(Math.pow(2,i)%26 != 1){
            i++;
        }
        System.out.println("i: " + i);
    }

    public static List<String> hackShiftCipher(String cipherText){
        ArrayList<String> values = new ArrayList<>();
        for(int key = 0; key < 26; key++){
            String temp = "";
            for(int i = 0; i < cipherText.length(); i++){
                if(cipherText.charAt(i) == ' '){
                    temp+=" ";
                    continue;
                }
                int tempVal = cipherText.charAt(i) - 'A';
                tempVal = (tempVal - key < 0)? (26+(tempVal - key)): tempVal - key;
                temp += (char)(tempVal+'A');
            }
            values.add(temp);
        }
        return values;
       }

       public static StringBuilder encryptPlainText(String plainText, int key){
        StringBuilder cipherText = new StringBuilder();

        for(int i = 0; i < plainText.length(); i++){
            char character = plainText.charAt(i);
            int val = character - 'A';
            val = (val + key >= 26)? val + key - 26: val + key;
            cipherText.append("" + (char)(val + 'A'));
        }

        return cipherText;
       }
}
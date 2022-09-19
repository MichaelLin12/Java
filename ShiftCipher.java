import java.util.ArrayList;
import java.util.List;

public class ShiftCipher{
    public static void main(String[] args){
        List<String> possibilities = decryptShiftCipher("DIBSMFT GNKBCDGVJ KISVKI");
        for(int i = 0; i < possibilities.size(); i++){
            System.out.println("key="+ i + " "+ possibilities.get(i));
        }
    }

    public static List<String> decryptShiftCipher(String cipherText){
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
}
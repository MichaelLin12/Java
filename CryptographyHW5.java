import java.util.ArrayList;

public class CryptographyHW5 {
    public static void main(String[] args){
        String PT = "0101000001001101";
        String CT = "11101010110010 0 1 1 1 1 0 0 1 0 1 1 0 1 0 1 1 0 00 0 1 0 0 0 1 0 0 1 0 1 1 0 1 0 0 0 1 1 0 0 1 1 1 0 0 0 1 0 0 11 0 1 0 1 0 0 1 0 1 0 1 1 0 1 0 1 0 0 0 1 1 1 0 1 1 0 0 0 0 1 11 0 0 1 0 0 1 1 0 1 1 0 0 0 0 0 1 1 0 1 1 0 0 0 0 1 0 0 1 1 1 01 1 1 0 0 1 1 0 0 0 0 0 0 1 1 1 0 1 1 1 1 1 1 1 0 1 1 0 0 0 0 00 0 0 0 0 0 1 1";
        ArrayList<String> CTDiv = separateIntoBytes(CT,2);
        //System.out.println(CTDiv);

        ArrayList<String> keyStream = findKeys(PT,CTDiv);
        System.out.println(keyStream);
    }

    public static ArrayList<String> separateIntoBytes(String CT, int byteNum){
        CT = CT.replaceAll(" ","");
        ArrayList<String> res = new ArrayList<>();

        for(int i = 0; (i + byteNum * 8)<CT.length();i+=8){
            res.add(CT.substring(i, i+byteNum*8));
        }

        return res;
    }

    public static ArrayList<String> findKeys(String PT, ArrayList<String> CTDiv){
        ArrayList<String> res = new ArrayList<>();

        for(String CT: CTDiv){
            String temp = "";
            for(int i = 0; i < CT.length(); i++){
                char P = PT.charAt(i);
                char C = CT.charAt(i);

                if((P == '1' && C == '1') || (P == '0' && C == '0')){
                    temp += "0";
                }else{
                    temp += "1";
                }
            }
            res.add(temp);
        }
        return res;
    }
}

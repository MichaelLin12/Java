

public class CryptographyHW2 {
    public static void main(String[] args){
        System.out.println(numMatricesModTen());
        // printFrequenciesAndIC("ZYPML YTXYH YBYNM DEYVT MPDMC TINCA CTYEC IVHYN YQTLO QINTL" +
        // "IVCEO CCOMV MPOVP MLEIT OMVTX YKCKI NEIVV YLMPC YVHOV GIQME" +
        // "EKVOQ ITOMV SICZA DLOBI TYEYC CYVGY L");

        // double[] plainTextFRQ = new double[]{8.04/100,1.48/100,3.34/100,3.82/100,12.49/100,2.40/100,1.87/100,5.05/100,7.57/100,0.16/100,0.54/100,4.07/100,2.51/100,7.23/100,7.64/100,2.14/100,0.12/100,6.28/100,6.51/100,9.28/100,2.73/100,1.05/100,1.68/100,0.23/100,1.66/100,0.09/100};
        // double[] cipherTextFRQ = new double[]{2/131.0,2/131.0,12/131.0,3/131.0,8/131.0,0/131.0,2/131.0,3/131.0,11/131.0,0/131.0,3/131.0,7/131.0,11/131.0,5/131.0,9/131.0,5/131.0,4/131.0,0/131.0,1/131.0,10/131.0,0/131.0,13/131.0,0/131.0,2/131.0,16/131.0,2/131.0};
        
        // //System.out.println(plainTextFRQ.length);
        // //System.out.println(cipherTextFRQ.length);
        // System.out.println(getMaxCorrelation(plainTextFRQ,cipherTextFRQ));
        // decryptMessage("ZYPML YTXYH YBYNM DEYVT MPDMC TINCA CTYEC IVHYN YQTLO QINTL" +
        // "IVCEO CCOMV MPOVP MLEIT OMVTX YKCKI NEIVV YLMPC YVHOV GIQME" +
        // "EKVOQ ITOMV SICZA DLOBI TYEYC CYVGY L", 23, 8);

        // // System.out.println((char)('A'+22));

    }

    public static int numMatricesModTen(){
        int ans = 0;

        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                int temp = 4*i - 7*j;
                while(temp < 0){
                    temp+=10;
                }
                if(temp >=10) temp = temp %10;
                if(temp == 3 || temp == 7 || temp == 1 || temp == 9){
                    ans++;
                }
            }
        }
        return ans;
    }

    public static void printFrequenciesAndIC(String s){
        char letter = 'A';

        char[] letters = new char[26];
        int[] freq = new int[26];

        for(int i = 0; i < letters.length; i++){
            letters[i] = letter;
            letter += 1;
        }

        s = s.replaceAll(" ","");

        for(char a: s.toCharArray()){
            freq[a-'A']++;
        }

        for(int i = 0; i < letters.length; i++){
            System.out.println(letters[i]+"="+ freq[i]);
        }

        //find index of coincidence
        double n = s.length();

        double summation = 0;

        for(int i = 0; i < freq.length; i++){
            summation += freq[i]*(freq[i]-1);
        }
        System.out.println(summation);
        System.out.println( "Length:" + n);
        double IC = summation/(n*(n-1));

        System.out.println(IC + " This is the Index of Coincidence");
    }

    public static double getMaxCorrelation(double[] pt, double[] qt){
        double res = Double.MIN_VALUE;
        int multiply = 0;
        int shift = 0;

        int[] a = new int[]{1,3,5,7,9,11,15,17,19,21,23,15};

        for(int b = 0; b<26;b++){
            for(int mul:a){
                double summation = 0;
                for(int i = 0;i<pt.length; i++){
                    int indexQT = (mul * i + b)%26;
                    summation += pt[i]*qt[indexQT];
                }
                if(summation > res){
                    res = summation;
                    multiply = mul;
                    shift = b;
                }
            }
        }
        System.out.println("multiply:" + multiply);
        System.out.println("shift:" + shift);
        System.out.println("Highest:"+res);
        return res;
    }

    public static void decryptMessage(String s, int a, int b){
        String result = "";

        for(int i = 0; i < s.length(); i++){
            char temp = s.charAt(i);
            if(temp == ' '){
                result += temp;
                continue;
            }
            int num = temp - 'A';
            num = a * (num - b);
            if(num > 26){
                num = num%26;
            }

            while(num < 0){
                num += 26;
            }

            temp = (char)(num+'A');
            result += temp;
        }

        System.out.println(result);
    }
}

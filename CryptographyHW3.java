import java.util.ArrayList;

public class CryptographyHW3 {
    public static void main(String[] args){
        //Q1A("ZUNEH TDTHR IFTAD JBFCA TWHHZ TSKXK ZRPED BCTIX TBVGJ KDGVS JJIWF NJUPS UDSCN TETXV CYVCH VEFJH JUDSK DYYTS VMYXT SVGFK XTEHT WRWVP YLGJJ LMRIX KPYVB JEIBF JQURT EIFZC YYTRF HYZCK FGRRI NFCNE IMVUJ NTXKL TISXZ QJCXJ MTNKX XKWJR ITDXH YNUFI MVHNJ DWKWJ RITDX HWPHK DWNWF KTAVG DFJBZ HMKDH RAQZI YYPYR AQKWN EVXRG JDPIV DKRIT DHQZI YCTUR GYZRQ VHYYP YDDAV PWFJS UXSGT WGTYL PQDDY ZDSRI YIPHK XSXTF TWTKW JILMV CYYTD RGJRA NKIQV SNJIF ERJRE FIIGL IWVEJ CANEV ZGDSS TNEVX HJJVO JUITX TYYTW ZCYYP YFCJJ TSKTS TTDFJ BZAQJ TJKWJ ITNJP SVCTI BTLHF DDZEI TWXSW DWDPY ZDSRQ TLIYY TBFGQ UXKAJ XKPQZ IYCTN DPLZC FKXTE PSUIM ZCPZC LRGJR EUCXJ U");
        Q1B("ZUNEH TDTHR IFTAD JBFCA TWHHZ TSKXK ZRPED BCTIX TBVGJ KDGVS JJIWF NJUPS UDSCN TETXV CYVCH VEFJH JUDSK DYYTS VMYXT SVGFK XTEHT WRWVP YLGJJ LMRIX KPYVB JEIBF JQURT EIFZC YYTRF HYZCK FGRRI NFCNE IMVUJ NTXKL TISXZ QJCXJ MTNKX XKWJR ITDXH YNUFI MVHNJ DWKWJ RITDX HWPHK DWNWF KTAVG DFJBZ HMKDH RAQZI YYPYR AQKWN EVXRG JDPIV DKRIT DHQZI YCTUR GYZRQ VHYYP YDDAV PWFJS UXSGT WGTYL PQDDY ZDSRI YIPHK XSXTF TWTKW JILMV CYYTD RGJRA NKIQV SNJIF ERJRE FIIGL IWVEJ CANEV ZGDSS TNEVX HJJVO JUITX TYYTW ZCYYP YFCJJ TSKTS TTDFJ BZAQJ TJKWJ ITNJP SVCTI BTLHF DDZEI TWXSW DWDPY ZDSRQ TLIYY TBFGQ UXKAJ XKPQZ IYCTN DPLZC FKXTE PSUIM ZCPZC LRGJR EUCXJ U",3);
        //Q1C("ZUNEH TDTHR IFTAD JBFCA TWHHZ TSKXK ZRPED BCTIX TBVGJ KDGVS JJIWF NJUPS UDSCN TETXV CYVCH VEFJH JUDSK DYYTS VMYXT SVGFK XTEHT WRWVP YLGJJ LMRIX KPYVB JEIBF JQURT EIFZC YYTRF HYZCK FGRRI NFCNE IMVUJ NTXKL TISXZ QJCXJ MTNKX XKWJR ITDXH YNUFI MVHNJ DWKWJ RITDX HWPHK DWNWF KTAVG DFJBZ HMKDH RAQZI YYPYR AQKWN EVXRG JDPIV DKRIT DHQZI YCTUR GYZRQ VHYYP YDDAV PWFJS UXSGT WGTYL PQDDY ZDSRI YIPHK XSXTF TWTKW JILMV CYYTD RGJRA NKIQV SNJIF ERJRE FIIGL IWVEJ CANEV ZGDSS TNEVX HJJVO JUITX TYYTW ZCYYP YFCJJ TSKTS TTDFJ BZAQJ TJKWJ ITNJP SVCTI BTLHF DDZEI TWXSW DWDPY ZDSRQ TLIYY TBFGQ UXKAJ XKPQZ IYCTN DPLZC FKXTE PSUIM ZCPZC LRGJR EUCXJ U",3);
    }

    public static void Q1A(String text){
        String newText = text.replaceAll(" ","");
        int n  = newText.indexOf("QZIYCT");
        int m = newText.indexOf("QZIYCT",n+6);
        System.out.println(newText.substring(n,m+6));
        System.out.println(m-n);
    }

    public static ArrayList<StringBuffer> getDecimations(String newText,int m){
        System.out.println("Hi:"+newText.length());
        ArrayList<StringBuffer> decimations = new ArrayList<>();
        for(int i = 0; i<m; i++){
            StringBuffer temp = new StringBuffer();
            for(int index = i; index < newText.length(); index+=m){
                temp.append(newText.charAt(index)+"");
            }
            decimations.add(temp);
        }

        return decimations;
    }

    public static void Q1B(String text, int m){
        String newText = text.replaceAll(" ","");

        ArrayList<StringBuffer> decimations = getDecimations(newText, m);
        // System.out.println(decimations.get(0));
        // System.out.println(decimations.get(1));
        // System.out.println(decimations.get(2));

        //For each decimation, compute the index of coincidence
        double total = 0;
        for(StringBuffer decimation:decimations){
            double totall = computeIC(decimation.toString());
            total += totall;
            System.out.println(totall);
        }

        System.out.println(total/m);
    }

    public static double computeIC(String text){
        int[] chars = new int[26];

        for(int i = 0; i < text.length(); i++){
            chars[text.charAt(i) - 'A']++;
        }

        double IC = 0;

        for(int f: chars){
            IC += f*(f-1);
        }
        

        double n = text.length();
        System.out.println((n*(n-1)) + " n");
        
        IC = IC/(n*(n-1));
System.out.println(IC);

        return IC;
    }
    
    public static void Q1C(String text, int m){
        //get rid of spaces
        String newText = text.replaceAll(" ", "");

        //get the m decimations
        ArrayList<StringBuffer> decimations = getDecimations(newText, m);

        //get the frequency tables for decimations i and j
        double[] freqTable = findFrequencyTable(decimations.get(1).toString());
        double[] freqTableJ = findFrequencyTable(decimations.get(0).toString());

        //find the relative distancce of the keys for the two decimations
        double d = findLikelyKey(freqTable,freqTableJ);

        // we combine the two decimations where decimation i is changed by d before adding to j
        decimations = combineDecimations(decimations,1,0,d);

        //repeat as above
        freqTable = findFrequencyTable(decimations.get(1).toString());
        freqTableJ = findFrequencyTable(decimations.get(0).toString());
        d = findLikelyKey(freqTable,freqTableJ);
        decimations = combineDecimations2(decimations,0,1,d);

        //we should only have one decimation left, which is encoded the same way as a shift cipher. Therefore, we apply that logic to shift ciphers.
        freqTable = findFrequencyTable(decimations.get(0).toString());
        double[] plainTextFRQ = new double[]{8.04/100,1.48/100,3.34/100,3.82/100,12.49/100,2.40/100,1.87/100,5.05/100,7.57/100,0.16/100,0.54/100,4.07/100,2.51/100,7.23/100,7.64/100,2.14/100,0.12/100,6.28/100,6.51/100,9.28/100,2.73/100,1.05/100,1.68/100,0.23/100,1.66/100,0.09/100};
        d = findLikelyKey(plainTextFRQ,freqTable);

        //find plaintext
        System.out.println(findPlainText(decimations.get(0), d));


    }

    public static ArrayList<StringBuffer> combineDecimations2(ArrayList<StringBuffer> decimations,int i,int j,double d){
        StringBuffer combination = new StringBuffer();

        StringBuffer dec_1 = decimations.get(0);
        StringBuffer dec_2 = decimations.get(1);
        //System.out.println(dec_1.toString() + " Hellossss");

        int a = 0;
        int b = 0;
        int c = 0;

        while(b < dec_1.length() && c < dec_2.length()){
            if(a % 2 == 0){
                int t1 =(dec_1.charAt(b) - 'A' - (int)d);

                while(t1 < 0){
                    t1+= 26;
                }
                
                char temp = (char)( t1 + 'A');
                combination.append(temp + "");
                b++;

                t1 =(dec_1.charAt(b) - 'A' - (int)d);

                while(t1 < 0){
                    t1+= 26;
                }
                
                temp = (char)( t1 + 'A');
                combination.append(temp + "");
                b++;
            }else{
                combination.append(dec_2.charAt(c) + "");
                c++;
            }
            a++;
            //System.out.println("Combination: "+ combination.toString());
        }
        // System.out.println("Bd: "+dec_1.length());
        // System.out.println("Cd: "+dec_2.length());

        while(c < dec_2.length()){
            // System.out.println("Hello");
            combination.append(dec_2.charAt(c));
            c++;
        }

        while(b < dec_1.length()){
            // System.out.println("Hello2");
            int t1 =(dec_1.charAt(b) - 'A' - (int)d);

            while(t1 < 0){
                t1+= 26;
            }
            
            char temp = (char)( t1 + 'A');
            combination.append(temp + "");
            b++;
        }
        // System.out.println("Combination: "+ combination.toString() + " " + combination.length());
        // System.out.println("B: "+b);
        // System.out.println("C: "+c);
        // System.out.println("A: "+a);

        decimations.remove(0);
        decimations.remove(0);
        decimations.add(0,combination);
        
        return decimations;
    }

    public static String findPlainText(StringBuffer text,double d){
        String res = "";
        for(int i = 0; i < text.length(); i++){
            int neI = text.charAt(i) - 'A' - (int)(d);
            while(neI < 0){
                neI += 26;
            }

            res += ((char)(neI + 'A')) + "";
        }

        return res;
    }

    public static double[] findFrequencyTable(String text){
        double[] res = new double[26];
        int n = text.length();

        for(int i = 0; i < text.length(); i++){
            if(text.charAt(i) == ' ') continue;

            res[text.charAt(i) - 'A']++;
        }

        for(int i = 0; i < res.length; i++){
            res[i] = res[i]/(n);
        }

        return res;
    }

    public static double findLikelyKey(double[] FT,double[] PTF){
        double max = Double.MIN_VALUE;//max val of summation
        int shift = Integer.MIN_VALUE;//shift that corresponds with it

        // i is the shift
        // d is the each number in frequency
        for(int i = 0; i < 26; i++){
            double temp = 0;
            for(int d = 0; d < 26; d++){
                //mod 26
                int number = d - i ;
                
                while(number < 0){
                    number += 26;
                }

                temp += FT[number] * PTF[d];

            }

            if(max < temp){
                max = temp;
                shift = i;
            }
        }

        System.out.println("Shift is and max corelation is");
        System.out.println(max);
        System.out.println(shift);

        return shift;
    }

    public static ArrayList<StringBuffer> combineDecimations(ArrayList<StringBuffer> decimations, int i, int j, double d){
        StringBuffer combination = new StringBuffer();

        StringBuffer dec_1 = decimations.get(0);
        StringBuffer dec_2 = decimations.get(1);

        int a = 0;
        int b = 0;
        int c = 0;

        while(b < dec_1.length() && c < dec_2.length()){
            if(a % 2 == 0){
                int t1 =(dec_1.charAt(b) - 'A' - (int)d);

                while(t1 < 0){
                    t1+= 26;
                }
                
                char temp = (char)( t1 + 'A');
                combination.append(temp + "");
                b++;
            }else{
                combination.append(dec_2.charAt(c) + "");
                c++;
            }
            a++;
            //System.out.println("Combination: "+ combination.toString());
        }
        // System.out.println("Bd: "+dec_1.length());
        // System.out.println("Cd: "+dec_2.length());

        while(c < dec_2.length()){
            // System.out.println("Hello");
            combination.append(dec_2.charAt(c));
            c++;
        }

        while(b < dec_1.length()){
            // System.out.println("Hello2");
            int t1 =(dec_1.charAt(b) - 'A' - (int)d);

            while(t1 < 0){
                t1+= 26;
            }
            
            char temp = (char)( t1 + 'A');
            combination.append(temp + "");
            b++;
        }
        // System.out.println("Combination: "+ combination.toString() + " " + combination.length());
        // System.out.println("B: "+b);
        // System.out.println("C: "+c);
        // System.out.println("A: "+a);

        decimations.remove(0);
        decimations.remove(0);
        decimations.add(0,combination);

        return decimations;
    }
}

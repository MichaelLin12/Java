import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tournament {

    Map<Integer,String> conversion;
    List<Integer> set;

    public Tournament(String[] ele){
        conversion = new HashMap<>();
        set = new ArrayList<>();
        for(int i = 0; i < ele.length; i++){
            set.add(i);
            conversion.put(i,ele[i]);
        }
    }

    public Map<Integer,String> getConversion(){
        return conversion;
    }

    public List<List<Integer>> findCombinations(int r){
        int n = set.size();
        if(r > n || r <= 0){
            return null;
        }else if(r == n){
            List<List<Integer>> res = new ArrayList<>();
            res.add(set);
            return res;
        }

        List<List<Integer>> res = new ArrayList<>();
        List<Integer> copy = new ArrayList<>(set);
        for(int i = 0; i < n - r + 1; i++){
            List<Integer> temp = new ArrayList<>();
            temp.add(copy.get(0));
            copy.remove(0);
            ArrayList<List<Integer>> nxtRes = findCombination(copy,r - 1,temp);
            res.addAll(nxtRes);
        }

        return res;
    }

    private ArrayList<List<Integer>> findCombination(List<Integer> subset, int r,List<Integer> combination){
        if(r == 0){
            ArrayList<List<Integer>> res = new ArrayList<>();
            res.add(combination);
            return res;
        }

        ArrayList<List<Integer>> res = new ArrayList<>();
        List<Integer> copy = new ArrayList<>(subset);
        for(int i = 0; i < subset.size() - r + 1; i++){
            List<Integer> copyComb = new ArrayList<>(combination);
            copyComb.add(subset.get(i));
            copy.remove(0);
            ArrayList<List<Integer>> nxtRes = findCombination(copy,r - 1,copyComb);
            res.addAll(nxtRes);
        }

        return res;
    }

    public List<List<String>> convertWithMap(List<List<Integer>> arg){
        List<List<String>> res = new ArrayList<>();

        for(List<Integer> element:arg){
            List<String> temp = new ArrayList<>();
            for(Integer rep:element){
                temp.add(conversion.get(rep));
            }
            res.add(temp);
        }
        return res;
    }

    public static void main(String[] args){
        Tournament t = new Tournament(new String[]{"Apple","Bananna","Cherry","Orange","Strawberry"});
        System.out.println(t.getConversion());
        List<List<Integer>> result = t.findCombinations(2);
        //System.out.println(result);
        System.out.println(t.convertWithMap(result));
        
    }
    
}

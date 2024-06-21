import java.util.ArrayList;

public class get_all_permutation {
    public  static void main(String[] args){
        System.out.println(permutation("abc"));
    }
    public static ArrayList<String> permutation(String str){
        if(str.isEmpty()){
            ArrayList<String> temp = new ArrayList<>();
            temp.add("");
            return  temp;
        }
        char cc = str.charAt(0);
        String ros = str.substring(1);

        ArrayList<String> rr = permutation(ros);
        ArrayList<String> mr = new ArrayList<>();

        for (String rrs : rr){
            for(int j = 0; j<=rrs.length(); j++){
                String val = rrs.substring(0,j) + cc + rrs.substring(j);
                mr.add(val);
            }}
        return mr;
    }
}

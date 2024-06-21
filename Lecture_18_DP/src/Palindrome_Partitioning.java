import java.util.Arrays;

public class Palindrome_Partitioning {
    public static void main(String[] args) {
        String s = "vyuhhhhhfytfty";
        int[][] arr = new int[s.length()][s.length()];
        for(int i = 0; i<s.length(); i++){
            Arrays.fill(arr[i],-1);
        }
        //System.out.println(Palindrome_Partition_Rec(s,0,s.length()-1));
        System.out.println(Palindrome_Partition_TD(s,0,s.length()-1,arr));
    }

    public static int Palindrome_Partition_Rec(String str, int si, int ei){

        if(isPalindrome(str,si,ei)){
            return 0;
        }
        int min = Integer.MAX_VALUE;

        for(int k = si; k<= ei-1; k++){
            int fp = Palindrome_Partition_Rec(str, 0,k );
            int sp = Palindrome_Partition_Rec(str, k+1,ei);

            int total = fp+sp+1;

            if(total < min){
                min = total;
        }}
        return min;
    }

    public static int Palindrome_Partition_TD(String str, int si, int ei,int[][] strg){
        if(isPalindrome(str,si,ei)){
            return 0;
        }
        if(strg[si][ei] != -1){
            return strg[si][ei];
        }
        int min = Integer.MAX_VALUE;
        for(int k = si; k<= ei-1; k++){
            int fp = Palindrome_Partition_TD(str, si,k,strg );
            int sp = Palindrome_Partition_TD(str, k+1,ei,strg);

            int total = fp+sp+1;

            if(total < min){
                min = total;
            }}
        strg[si][ei] = min;
        return min;
    }
    public static boolean isPalindrome(String s, int si, int ei){
        int l = si;
        int r = ei;
        while (l < r){
            if(s.charAt(si) != s.charAt(ei)){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }
}

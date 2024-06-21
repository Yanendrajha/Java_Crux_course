public class Longest_Common_Subsequence {
    public static void main(String[] args) {
        String s1 = "sdnfhishfushifdhsifhdsuihhihsdihfis";
        String s2 = "shdidsibisbsdbdhbdisbsbdsbsuhsusdbusd";
        //System.out.println(LCS_Recursion(s1,s2));
        //System.out.println(LCS_Recursion_Vidx(s1,s2,0,0));
        int[][] strg = new int[s1.length()][s2.length()];
        for(int i = 0; i < s1.length(); i++){
            for(int j =0; j< s2.length(); j++){
                strg[i][j] = -1;
            }
        }
        System.out.println(LCS_Top_Down_Vidx(s1,s2,0,0,strg));
        System.out.println(LCSBU(s1,s2));
    }

    public static int LCS_Recursion(String s1, String s2){

    if(s1.isEmpty() || s2.isEmpty()){
        return 0;
    }

    char ch1 = s1.charAt(0);
    char ch2 = s2.charAt(0);

    String ros1 = s1.substring(1);
    String ros2 = s2.substring(1);


    int ans  = 0;
    if(ch1 == ch2){
        ans  = LCS_Recursion(ros1,ros2)+1;
    } else {
        int o1 = LCS_Recursion(ros1, s2);
        int o2 = LCS_Recursion(s1, ros2);
        ans = ans + Math.max(o1,o2);
    }
    return ans;
}

    public static int LCS_Recursion_Vidx(String s1, String s2, int vidx1, int vidx2){

        if(vidx1 ==  s1.length() || vidx2 == s2.length()){
            return 0;
        }
        char ch1 = s1.charAt(vidx1);
        char ch2 = s2.charAt(vidx2);
        int ans  = 0;
        if(ch1 == ch2){
            ans  = LCS_Recursion_Vidx(s1,s2,vidx1+1,vidx2+1)+1;
        } else {
            int o1 = LCS_Recursion_Vidx(s1, s2,vidx1+1,vidx2);
            int o2 = LCS_Recursion_Vidx(s1, s2,vidx1,vidx2+1);
            ans = ans + Math.max(o1,o2);
        }
        return ans;
    }

    public static int LCS_Top_Down_Vidx(String s1, String s2, int vidx1, int vidx2, int[][] strg){

        if(vidx1 ==  s1.length() || vidx2 == s2.length()){
            return 0;
        }
        if(strg[vidx1][vidx2] != -1){
            return strg[vidx1][vidx2];
        }
        char ch1 = s1.charAt(vidx1);
        char ch2 = s2.charAt(vidx2);
        int ans  = 0;
        if(ch1 == ch2){
            ans  = LCS_Top_Down_Vidx(s1,s2,vidx1+1,vidx2+1, strg)+1;
        } else {
            int o1 = LCS_Top_Down_Vidx(s1, s2,vidx1,vidx2+1,strg);
            int o2 = LCS_Top_Down_Vidx(s1, s2,vidx1+1,vidx2,strg);
            ans = Math.max(o1,o2);
        }
        strg[vidx1][vidx2] = ans; // Store values
        return ans;
    }

    public static int LCSBU(String s1, String s2){
        int [][] strg = new int[s1.length()+1][s2.length()+1];
        for(int row = s1.length() -1; row>=0; row --){

            for(int col = s2.length()-1; col>= 0; col--){
                if(s1.charAt(row) == s2.charAt(col)){
                    strg[row][col] = 1 + strg[row+1][col+1];
                }else{
                    strg[row][col] = Math.max(strg[row+1][col], strg[row][col+1]);
                }
            }
        }
        return strg[0][0];
    }
}

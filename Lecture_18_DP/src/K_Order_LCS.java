import java.util.Arrays;

public class K_Order_LCS {
    public static void main(String[] args) {
        String str1 = "abcd";
        String str2 = "agcfd";
        int  k = 1;
        int[][][] strg = new int[k+1][str1.length()+1][str2.length()+1];
        for(int i = 0; i<strg.length; i++){
            for(int j = 0; j< strg[0].length; j++){
                Arrays.fill(strg[i][j], -1);
            }
        }
        //System.out.println(k_order_lcs_rr(str1,str2,0,0,k));
        //    System.out.println(k_order_lcs_TD(str1,str2,0,0,k,strg));
        System.out.println(k_order_lcs_BU(str1,str2,k));
    }

    public static int k_order_lcs_rr(String s1,String s2, int vidx1, int vidx2, int k){
        if(s1.length() == vidx1 || s2.length() == vidx2){
            return 0;
        }
        int ans = 0;
        if(s1.charAt(vidx1) == s2.charAt(vidx2)){
           ans =  k_order_lcs_rr(s1,s2,vidx1+1,vidx2+1,k) + 1;
        }else{
            int o1 = k_order_lcs_rr(s1,s2,vidx1,vidx2 + 1,k);
            int o2 = k_order_lcs_rr(s1,s2,vidx1 + 1,vidx2,k);
            int o3 = 0;
            if(k>=1) {
                 o3 = k_order_lcs_rr(s1, s2, vidx1 + 1, vidx2 + 1, k - 1) + 1;
            }
            ans = Math.max(o1,Math.max(o2,o3));
        }
        return ans;
    }
    public static int k_order_lcs_TD(String s1,String s2, int vidx1, int vidx2, int k, int[][][] strg){
        if(s1.length() == vidx1 || s2.length() == vidx2){
            return 0;
        }
        if(strg[k][vidx1][vidx2] != -1){
            return strg[k][vidx1][vidx2];
        }
        int ans = 0;
        if(s1.charAt(vidx1) == s2.charAt(vidx2)){
            ans =  k_order_lcs_TD(s1,s2,vidx1+1,vidx2+1,k,strg) + 1;
        }else{
            int o1 = k_order_lcs_TD(s1,s2,vidx1,vidx2 + 1,k,strg);
            int o2 = k_order_lcs_TD(s1,s2,vidx1 + 1,vidx2,k,strg);
            int o3 = 0;
            if(k>=1) {
                o3 = k_order_lcs_TD(s1, s2, vidx1 + 1, vidx2 + 1, k - 1,strg) + 1;
            }
            ans = Math.max(o1,Math.max(o2,o3));
        }
        strg[k][vidx1][vidx2] = ans;
        return ans;
    }
    public static int k_order_lcs_BU(String s1, String s2, int tk){

        int[][][] strg= new int[tk+1][s1.length()+1][s2.length()+1];

        for(int k = 0; k<= tk; k++){

        for(int row = s1.length()-1; row >= 0; row--){

            for(int col = s2.length() -1; col >= 0; col--){

                int ans = 0;

                if(s1.charAt(row) == s2.charAt(col)){
                    ans =  strg[k][row+1][col+1]+1;
                }else{
                    int o1 = strg[k][row][col+1];
                    int o2 = strg[k][row+1][col];
                    int o3 = 0;
                    if(k>=1) {
                        o3 = strg[k-1][row+1][col+1]+1;
                    }
                    ans = Math.max(o1,Math.max(o2,o3));
                }
                strg[k][row][col] = ans;
            }
        }
    }
    return strg[tk][0][0];
    }
}

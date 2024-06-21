public class Longest_palindromic_SubSequence {
    public static void main(String[] args) {
        String str = "abywuvuwtdgiuqheqbu";
        System.out.println(longest_palindromic_SSRec(str,0,str.length()-1));
        System.out.println(longest_palindromic_SS_TD(str, 0, str.length()-1,new int[str.length()][str.length()]));
        System.out.println(longest_palindromic_SS_BU(str));
    }
    public static int longest_palindromic_SSRec(String str, int si, int ei){
       if(si > ei){
           return 0;
       }
        if(si == ei){
           return 1;
       }
        int ans = 0;

        if(str.charAt(si) == str.charAt(ei)){
            ans = longest_palindromic_SSRec(str,si+1,ei-1) + 2;
        } else{
            // Removing char from the front
            int o1 = longest_palindromic_SSRec(str, si+1,ei);
            // Removing char from the end.
            int o2 = longest_palindromic_SSRec(str, si, ei-1);

            ans  = Math.max(o1,o2);
        }
        return ans;
    }

    public static int longest_palindromic_SS_TD(String str, int si, int ei,int[][] strg){
        if(si > ei){
            return 0;
        }
        if(si == ei){
            return 1;
        }
        if(strg[si][ei] != 0){
            return strg[si][ei];
        }
        int ans = 0;

        if(str.charAt(si) == str.charAt(ei)){
            ans = longest_palindromic_SS_TD(str,si+1,ei-1,strg) + 2;
        } else{
            // Removing char from the front
            int o1 = longest_palindromic_SS_TD(str, si+1,ei,strg);
            // Removing char from the end.
            int o2 = longest_palindromic_SS_TD(str, si, ei-1,strg);

            ans  = Math.max(o1,o2);
        }
        strg[si][ei] = ans;
        return ans;
    }

    public static int longest_palindromic_SS_BU(String str){
        int n = str.length();
        int [][] strg = new int[n][n];

        for(int slide = 0; slide <= n-1; slide++){
            for(int si = 0; si <= n-slide-1; si++){
                int ei = si + slide;

                if(si == ei){
                    strg[si][ei] = 1;
                } else {

                    int ans = 0;
                    if(str.charAt(si) == str.charAt(ei)){
                        ans = strg[si+1][ei-1]+2;
                    } else {
                        int o1 = strg[si+1][ei];
                        int o2 = strg[si][ei-1];
                        ans = Math.max(o1,o2);
                    }
                    strg[si][ei] = ans;
                }
            }
        }
        return strg[0][n-1];
    }
}

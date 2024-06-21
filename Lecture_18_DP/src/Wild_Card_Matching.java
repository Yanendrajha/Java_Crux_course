public class Wild_Card_Matching {
    public static void main(String[] args) {
        String Text = "abcdespodjfwjfjojfdizf";
        String Pattern = "a?*****m***";

        //System.out.println(Wild_Card_Matching_Recursion(Text, Pattern, 0,0));
        //System.out.println(Wild_Card_Matching_TD(Text,Pattern,0,0,new int[Text.length()][Pattern.length()]));
        System.out.println(Wild_Card_Matching_BU(Text,Pattern));

    }

    public static boolean Wild_Card_Matching_Recursion(String src, String pat, int vidx_s, int vidx_p) {
        if (src.length() == vidx_s && pat.length() == vidx_p) {
            return true;
        }
        if (src.length() != vidx_s && pat.length() == vidx_p) {
            return false;
        }
        if (src.length() == vidx_s && pat.length() != vidx_p) {
            for (int i = 0; i < pat.length(); i++) {
                if (pat.charAt(i) != '*') {
                    return false;
                }
            }
            return true;
        }

        char chs = src.charAt(vidx_s);
        char chp = pat.charAt(vidx_p);

        boolean ans;

        if (chp == chs || chp == '?') {
            ans = Wild_Card_Matching_Recursion(src, pat, vidx_s+1, vidx_p+1);
        } else if (chp == '*') {
            boolean blank = Wild_Card_Matching_Recursion(src, pat, vidx_s,vidx_p+1);
            boolean multi = Wild_Card_Matching_Recursion(src, pat, vidx_s+1, vidx_p +1);
            ans = blank || multi;
        } else {
            ans = false;
        }
        return ans;
    }

    public static boolean Wild_Card_Matching_TD(String src, String pat, int vidx_s, int vidx_p, int[][] strg) {
        if (src.length() == vidx_s && pat.length() == vidx_p) {
            return true;
        }
        if (src.length() != vidx_s && pat.length() == vidx_p) {
            return false;
        }
        if (src.length() == vidx_s && pat.length() != vidx_p) {
            for (int i = 0; i < pat.length(); i++) {
                if (pat.charAt(i) != '*') {
                    return false;
                }
            }
            return true;
        }

        if (strg[vidx_s][vidx_p] != 0){
            // It is a comparing operator, so, will return true or false.
            return strg[vidx_s][vidx_p] == 2;
        }

        char chs = src.charAt(vidx_s);
        char chp = pat.charAt(vidx_p);

        boolean ans;

        if (chp == chs || chp == '?') {
            ans = Wild_Card_Matching_TD(src, pat, vidx_s+1, vidx_p+1,strg);
        } else if (chp == '*') {
            boolean blank = Wild_Card_Matching_TD(src, pat, vidx_s,vidx_p+1,strg);
            boolean multi = Wild_Card_Matching_TD(src, pat, vidx_s+1, vidx_p +1,strg);
            ans = blank || multi;
        } else {
            ans = false;
        }
        strg[vidx_s][vidx_p] = (ans ? 2 : 1);
        return ans;
    }

    public static boolean Wild_Card_Matching_BU(String src, String pat){
        boolean[][] strg = new boolean[src.length()+1][pat.length()+1];

        strg[src.length()][pat.length()] = true;

        for(int row  = src.length(); row >= 0; row--){
            for(int col = pat.length()-1; col >= 0; col--){
                if(row == src.length()){
                    if(pat.charAt(col) == '*'){
                        strg[row][col] = strg[row][col+1];
                    } else {
                        strg[row][col] = false;
                    }
                    continue;
                }

                char chs = src.charAt(row);
                char chp = pat.charAt(col);

                boolean ans;

                if (chp == chs || chp == '?') {
                    ans = strg[row+1][col+1];
                } else if (chp == '*') {
                    boolean blank = strg[row][col+1];
                    boolean multi = strg[row+1][col];
                    ans = blank || multi;
                } else {
                    ans = false;
                }
                strg[row][col] = ans;
            }
        }
        return strg[0][0];
    }
}
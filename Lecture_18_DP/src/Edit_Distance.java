import java.util.Arrays;

public class Edit_Distance {

    public static void main(String[] args) {
        String s1 = "sfsdfssfsffwaefsfs";
        String s2 = "dsfedfdsfsfsfwef";
        int[][] strg = new int[s1.length()][s2.length()];
        for(int i =0; i < strg.length ;i ++ ) {
            Arrays.fill(strg[i], -1);
        }
        System.out.println(edit_DistanceRS_Vidx_Top_Down(s1,s2,0,0,strg));
    }

    public static int edit_DistanceRS(String s1, String s2){
        if(s1.isEmpty()){
            return s2.length();
        }
        if(s2.isEmpty()) {
            return s1.length();
        }

        String ros1 = s1.substring(1);
        String ros2 = s2.substring(1);
        int ans = 0;
        if(s1.charAt(0) == s2.charAt(0)){
            ans = edit_DistanceRS(ros1,ros2);
        } else {
            int f1 = 1+ edit_DistanceRS(ros1,ros2);
            int f2 = 1+ edit_DistanceRS(ros1,s2);
            int f3 = 1 + edit_DistanceRS(s1,ros2);
            ans  = 1+  Math.min(f1,Math.min(f2,f3));

        }
        return ans;
    }

    public static int edit_DistanceRS_Vidx(String s1, String s2, int vidx1, int vidx2){
        if(s1.length() == vidx1 || s2.length()==vidx2){
            return Math.max(s1.length()- vidx1, s2.length()-vidx2);
        }
        int ans = 0;
        if(s1.charAt(vidx1) == s2.charAt(vidx2)){
            ans = edit_DistanceRS_Vidx(s1,s2,vidx1+1,vidx2+1);
        } else {
            int f1 = 1+ edit_DistanceRS_Vidx(s1,s2,vidx1+1,vidx2);
            int f2 = 1+ edit_DistanceRS_Vidx(s1,s2,vidx1,vidx2+1);
            int f3 = 1 + edit_DistanceRS_Vidx(s1,s2,vidx1+1,vidx2+1);
            ans  = Math.min(f1,Math.min(f2,f3))+1;

        }
        return ans;
    }

    public static int edit_DistanceRS_Vidx_Top_Down(String s1, String s2, int vidx1, int vidx2, int[][] strg){
        if(s1.length() == vidx1 || s2.length()==vidx2){
            return Math.max(s1.length()- vidx1, s2.length()-vidx2);
        }
        if(strg[vidx1][vidx2] != -1){
            return strg[vidx1][vidx2];
        }
        int ans = 0;
        if(s1.charAt(vidx1) == s2.charAt(vidx2)){
            ans = edit_DistanceRS_Vidx_Top_Down(s1,s2,vidx1+1,vidx2+1,strg);
        } else {
            int f1 = 1+ edit_DistanceRS_Vidx_Top_Down(s1,s2,vidx1+1,vidx2,strg);
            int f2 = 1+ edit_DistanceRS_Vidx_Top_Down(s1,s2,vidx1,vidx2+1,strg);
            int f3 = 1 + edit_DistanceRS_Vidx_Top_Down(s1,s2,vidx1+1,vidx2+1,strg);
            ans  = Math.min(f1,Math.min(f2,f3))+1;
        }
        strg[vidx1][vidx2] = ans;
        return ans;
    }
}

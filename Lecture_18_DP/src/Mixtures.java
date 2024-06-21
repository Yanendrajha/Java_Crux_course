import java.util.Arrays;

public class Mixtures {
    public static void main(String[] args) {
        int[] arr = {40,60,20,50, 45,12, 34};
        int[][] strg = new int[arr.length][arr.length];
        for(int i = 0; i < arr.length; i++){
        Arrays.fill(strg[i],-1);}
        //System.out.println(Mixtures_Recursion(arr, 0 , arr.length-1));
        //System.out.println(Mixtures_TD(arr,0,arr.length-1,strg));
        System.out.println(Mixtures_BU(arr));
    }

    public static int Mixtures_Recursion(int[] arr, int si, int ei){
       if(si == ei){
           return 0;
       }
       int min = Integer.MAX_VALUE;

        for(int k = si; k <= ei-1; k++){
            int fp = Mixtures_Recursion(arr, si, k);
            int sp = Mixtures_Recursion(arr, k+1, ei);

            int sw = color(arr, si, k) * color(arr, k+1, ei);

            int total = fp + sp + sw;
            if(total < min){
                min = total;
            }
        }
        return min;
    }

    public static int Mixtures_TD(int[] arr, int si, int ei, int[][] strg){
        if(si == ei){
            return 0;
        }
        if(strg[si][ei] != -1){
            return strg[si][ei];
        }
        int min = Integer.MAX_VALUE;

        for(int k = si; k <= ei-1; k++){
            int fp = Mixtures_TD(arr, si, k,strg);
            int sp = Mixtures_TD(arr, k+1, ei, strg);

            int sw = color(arr, si, k) * color(arr, k+1, ei);

            int total = fp + sp + sw;
            if(total < min){
                min = total;
            }
        }
        strg[si][ei] = min;
        return min;
    }

    public static  int Mixtures_BU(int[] arr){
          int[][] strg = new int[arr.length][arr.length];
          for(int slide = 0; slide <= arr.length-1; slide++){
              for(int si = 0; si <=arr.length-slide-1; si++){
                  int ei = si+slide;
                  if(si == ei){
                      strg[si][ei] = 0;
                  }else {
                  int min = Integer.MAX_VALUE;

                  for(int k = si; k <= ei-1; k++){
                      int fp = strg[si][k];
                      int sp = strg[k+1][ei];

                      int sw = color(arr, si, k) * color(arr, k+1, ei);

                      int total = fp + sp + sw;
                      if(total < min){
                          min = total;
                      }
                  }
                  strg[si][ei] = min;
              }}
          }
          return strg[0][arr.length-1];
    }

    public static int color(int[] arr, int i, int j){
        int sum = 0;
        for(int k  = i ; k<= j; k++){
            sum += arr[k];
        }
        return sum % 100;
    }
}




import java.util.Arrays;

public class LISn2 {
    public static void main(String[] args) {
        int[]  arr = {3,4,-1,0,6,2,3};
        System.out.println(LIS_N2_BU(arr));
    }

    public static int LIS_N2_BU(int[] arr){

        if(arr.length == 0){
            return 0;
        }

        int[] strg = new int[arr.length];
        Arrays.fill(strg,1);

        int max = 1;

        for(int  i = 0; i<strg.length; i++){
            for(int j = 0; j<i; j++){
                if(arr[i] > arr[j]){
                    strg[i] = Math.max(strg[i], strg[j] + 1);

                    max = Math.max(max, strg[i]);
                }
            }
        }
        return max;
    }
}

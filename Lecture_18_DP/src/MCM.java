public class MCM {
    public static void main(String[] args) {
        int[] arr = {4,2,3,5,1};
        System.out.println(MCM_Recursion(arr,0,arr.length-1));
        System.out.println(MCM_BU(arr));
    }

    public static int MCM_Recursion(int[] arr, int si, int ei){
        if(si+1 == ei){
            return 0;
        }

        int min = Integer.MAX_VALUE;
        // k : splits track
        for(int k = si+1; k<= ei-1; k++){
            int fp = MCM_Recursion(arr, si, k); // arr[si] * arr[k]
            int sp = MCM_Recursion(arr,k, ei); // arr[k] * arr[ei]


            // self work
            int sw = arr[si]*arr[k]*arr[ei];

            int total = fp + sp + sw;

            if(total < min){
                min = total;
            }
        }
        return min;
    }

    public static int MCM_TD(int[] arr, int si, int ei, int[][] strg){
        if(si+1 == ei){
            return 0;
        }

        if(strg[si][ei] != 0){
            return strg[si][ei];
        }

        int min = Integer.MAX_VALUE;
        // k : splits track
        for(int k = si+1; k<= ei-1; k++){
            int fp = MCM_TD(arr, si, k,strg); // arr[si] * arr[k]
            int sp = MCM_TD(arr,k, ei,strg); // arr[k] * arr[ei]


            // self work
            int sw = arr[si]*arr[k]*arr[ei];

            int total = fp + sp + sw;

            if(total < min){
                min = total;
            }
        }
        strg[si][ei] = min;
        return min;
    }

    public static int MCM_BU(int[] arr){
        int n = arr.length;

        int[][] strg = new int[n][n];

        for(int slide = 1; slide <= n-1; slide++){
            for(int si = 0; si <= n-slide-1; si++){
                int ei = si +slide;

                // Logic which was used in Top Down.
                if(si+1 == ei){
                    strg[si][ei] = 0;
                } else {

                int min = Integer.MAX_VALUE;
                // k : splits track
                for(int k = si+1; k<= ei-1; k++){
                    int fp = strg[si][k]; // arr[si] * arr[k]
                    int sp = strg[k][ei]; // arr[k] * arr[ei]

                    // self work
                    int sw = arr[si]*arr[k]*arr[ei];

                    int total = fp + sp + sw;

                    if(total < min){
                        min = total;
                    }
                }
                strg[si][ei] = min;
            }
            }
        }
        return strg[0][n-1];
    }
}

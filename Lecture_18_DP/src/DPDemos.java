public class DPDemos {
    public static void main(String[] args) {
//        int  n = 45;
//        int[] strg = new int[n+1];
//        //System.out.println(fibRS(n, strg));
//        System.out.println(fibIS(45));
        //System.out.println(edit_DistanceISDP("agbg", "acgb"));
//        int ans = Count_Binary_Strings(4);
//        System.out.println(ans);
//        int[] arr = {10,9,2,5,3,7,101,18};
//        System.out.println(lis(arr));
//        System.out.println(fib_BUSE(4));
        int n = 20;
       // System.out.println(Maze_Path_Bottom_Up_Space_Efficient(n,n));
    }

    public static int Count_Binary_Strings(int n){
        int[] ones = new int [n];
        int[] zeroes = new int[n];
        // seed
        ones[0] = 1; zeroes[0] = 1;
        for(int i =1; i<zeroes.length; i++){
            zeroes[i] = zeroes[i-1] + ones[i-1];
            ones[i] = zeroes[i-1];
        }
        int ans = zeroes[n-1] + ones[n-1];
        return ans;
    }

    public static int lis(int[] arr){
        if(arr.length == 0){
            return 0;
        }
        int[] lis = new int[arr.length];
        lis[0] = 1;
        for (int i =1; i<arr.length; i++){
            lis[i] = 1;
            for(int j=0; j<i; j++){
                if(arr[i]>arr[j]){
                    if(lis[j]+1> lis[i]){
                        lis[i] = lis[j]+1;
                    }
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < lis.length; i++){
            if(lis[i] > max){
                max = lis[i];
            }
        }
        return max;
    }


}

public class Fibonacci_Series {
    // TC = n, SC= n + REC EXTRA SPACE (TOP DOWN CASE)
    public static int fibRS(int n,int[] strg){
        if( n == 1){
            return n;
        }
        if( n == 0) {
            return n;
        }
        if(strg[n]!=0){
            return strg[n];
        }
        int fnm1 = fibRS(n-1, strg);
        int fnm2 = fibRS(n-2, strg);
        int fn = fnm1 + fnm2;
        strg[n] = fn;
        return fn;
    }

    // TC = n; SC = n (BOTTOM UP CASE)
    public static int fibIS(int n){
        int[] strg = new int [n+1];

        //seed
        strg[0] = 0;
        strg[1] = 1;

        for(int i = 2; i < n+1; i++){
            int v1 = strg[i-1];
            int v2 = strg[i-2];
            strg[i] = v1+v2;
        }
        return strg[n];
    }

    // TC = n; SC = 1; (BOTTOM UP SPACE EFFICIENT CASE)
    public static int fib_BUSE(int n){
        int[] strg = new int[2];
        strg[0] = 0;
        strg[1] = 1;
        for(int slide = 1; slide<= n-1; slide++){
            int sum = strg[0]  + strg[1];
            strg[0] = strg[1];
            strg[1] = sum;
        }
        return strg[1];
    }
}

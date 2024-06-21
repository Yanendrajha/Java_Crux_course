public class No_Of_BSTs {
    public static void main(String[] args) {
        //System.out.println(No_Of_BSTs_Recursion(5));
        int n = 5;
        //System.out.println(No_Of_BSTs_Top_Down(n, new int[n+1]));
        System.out.println(No_Of_BSTs_Bottom_Up(5));
    }
    public static int No_Of_BSTs_Recursion(int n){
        if(n<=1){
            return 1;
        }
        int total = 0;
        for(int  i = 1; i<=n ; i++){
            int  l = No_Of_BSTs_Recursion(i-1);
            int r = No_Of_BSTs_Recursion(n-i);

            int ans = l*r;
            total += ans;
        }
       return total;
    }

    public static int No_Of_BSTs_Top_Down(int n, int[] strg){
        if(n<=1){
            return 1;
        }
        if(strg[n] != 0){
            return strg[n];
        }

        int total = 0;
        for(int  i = 1; i<=n ; i++){
            int  l = No_Of_BSTs_Top_Down(i-1,strg);
            int r = No_Of_BSTs_Top_Down(n-i,strg);

            int ans = l*r;
            total += ans;
        }
        return total;
    }

    public static int No_Of_BSTs_Bottom_Up(int tn){
        int[] strg  = new int[tn+1];
        strg[0] = strg[1] = 1;
        for(int n = 2; n <  strg.length ; n++){
            int total = 0;
                for(int  i = 1; i<=n ; i++){
                    int  l = strg[i-1];
                    int r = strg[n-i];
                    int ans = l*r;
                    total += ans;
                }
                strg[n] = total;
            }
        return strg[tn];
            }
}

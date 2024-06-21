public class KnapSack {
    public static void main(String[] args) {
        int[] wt = {1,3,4,5};
        int[] price = {1,4,5,7};
        int cap = 7;
        //System.out.println(KnapSack_Recursion(wt,price, 0 ,cap));
        int[][] strg = new int[wt.length][cap+1];
        //System.out.println(KnapSack_TD(wt, price, 0, cap,strg));
        System.out.println(Knapsack_BU(wt,price,cap));
    }

    public static int KnapSack_Recursion(int[] wt, int[] price, int vidx, int cap){

        if(vidx == wt.length || cap == 0){
            return 0;
        }
        // Excluded
        int e =  KnapSack_Recursion(wt, price, vidx+1, cap);
        // Included
        int i = 0;
        if( cap >= wt[vidx])
            i = KnapSack_Recursion(wt, price, vidx + 1, cap - wt[vidx] ) + price[vidx];

        return Math.max(e,i);
    }

    public static int KnapSack_TD(int[] wt, int[] price, int vidx, int cap, int[][] strg){

        if(vidx == wt.length || cap == 0){
            return 0;
        }

        if(strg[vidx][cap] != 0){
            return strg[vidx][cap];
        }

        // Excluded
        int e =  KnapSack_TD(wt, price, vidx+1, cap, strg);
        // Included
        int i = 0;
        if( cap >= wt[vidx])
            i = KnapSack_TD(wt, price, vidx + 1, cap - wt[vidx], strg ) + price[vidx];

        int ans = Math.max(e,i);
        strg[vidx][cap] = ans;

        return ans;
    }

    public static int Knapsack_BU(int[] wt, int[] price, int cap){
        int n = wt.length;
        int[][] strg = new int[n+1][cap+1];

        for(int row = n -1; row >=0; row--){
            for(int col = 1; col <=cap; col++){
                int e = strg[row+1][col];
                int i = 0;
                if(col >= wt[row])
                    i = strg[row + 1][col - wt[row]] + price[row];

                int ans = Math.max(e,i);

                strg[row][col] = ans;
            }
        }

        for(int i = 0; i < strg.length; i++){
            for(int j = 0; j<strg[0].length; j++){
                System.out.print(strg[i][j]+ " ");
            }
            System.out.println();
        }
        return strg[0][cap];
    }
}

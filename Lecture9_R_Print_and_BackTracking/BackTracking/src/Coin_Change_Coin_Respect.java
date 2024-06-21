public class Coin_Change_Coin_Respect {

    public static  void main(String[] args){
        int[] denom = {2,3,5,6};
        CoinChangeCoinRespect(denom,0,10,"");
    }
    public static void CoinChangeCoinRespect(int[] denom, int vidx, int amount, String ans){
        // Positive base case
        if(amount == 0){
            System.out.println(ans);
            return;
        }

        // Negative base case
        if(vidx == denom.length || amount<0){
            return;
        }


        // yes (Coin contributes);
        CoinChangeCoinRespect(denom,vidx,amount-denom[vidx],ans + denom[vidx]+" ");

        // No (Coin Do not Contribute)
        CoinChangeCoinRespect(denom, vidx+1, amount, ans);
    }
}

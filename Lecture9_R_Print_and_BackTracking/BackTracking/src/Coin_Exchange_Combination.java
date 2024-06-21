import java.sql.SQLOutput;

public class Coin_Exchange_Combination {
    public static void main(String[] args){
        int [] coins = {2,3,5,6};
        CEC(coins,10,"",0);
    }

    public  static void CEC(int[] denoms, int amount,String ans, int LastDenomIdx){
        if (amount == 0){
            System.out.println(ans);
            return;
        }
        else if (amount < 0){
            return;
        }
        for(int i = LastDenomIdx ;i < denoms.length; i++){
            if (amount >= denoms[i])
                CEC(denoms, amount-denoms[i], ans+denoms[i], i);
        }
    }
}

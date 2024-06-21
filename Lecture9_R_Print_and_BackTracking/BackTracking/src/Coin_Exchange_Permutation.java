import java.sql.SQLOutput;
public class Coin_Exchange_Permutation {
    public static int count = 0;
        public static void main(String[] args){
            int [] coins = {2,3,5,6};
            CEC(coins,10,"");
        }

        public  static void CEC(int[] denoms, int amount,String ans){
            if (amount == 0){
                count++;
                System.out.println(count + ". " + ans);
                return;
            }
            if (amount < 0){
                return;
            }
            for(int i = 0;i < denoms.length; i++){
                    CEC(denoms, amount-denoms[i], ans+denoms[i]);
            }
        }
    }

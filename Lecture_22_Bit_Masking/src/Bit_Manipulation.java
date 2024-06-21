public class Bit_Manipulation {
    public static void main(String[] args) {
        //extractBit(6,5);
        System.out.println(RightmostsetBit(6));
        System.out.println(addOne(10));
        System.out.println(MagicNo(3));
        System.out.println(pascalSum(2));
        System.out.println(isPowerOf2(7));
        }


    // Checking If the Ith bit Is set Or Not;
    public static void extractBit(int n, int i){
        int j = 1;
        j = 1<<(i-1);
        n = n & j;
        System.out.println(n);
        if(n==0){
            System.out.println("Bit Not set");
        }else{
            System.out.println("Bit is set");
        }
    }

    // Checking If the Ith bit Is set Or Not;
    public static int SetBit(int n, int i){
        int mask = 1;
        mask = 1<<(i-1);
        n = n | mask;
        return n;
    }
    public static int ResetBit(int n, int i){
        int mask = 1;
        mask = ~ (1<<(i-1));
        n = n & mask;
        return n;
    }
    public static int RightmostsetBit(int n){
        int pos = 1;
        int mask = 1;
        while((n & mask) == 0){
            pos++;
            mask = mask<<1;
        }
        return mask;
    }

    public static int addOne(int n){
        int mask = 1;
        while(((n&mask) != 0)){
             n = n ^ mask;
             mask = (mask << 1);
        }
        n = n^ mask;
        return n;
    }

    public static int MagicNo(int i){
        int pow =1;
        int ans = 0;
        while(i !=0){
            pow = pow * 5;
            if((i & 1) != 0){
                ans = ans + pow;
            }
            i = (i>>1);
        }
        return  ans;
    }

    public static int pascalSum(int n){
        int res = (1<<n);
        return res - 1;
    }

    public static boolean isPowerOf2(int n){
        if(n != 0) {
            if ((n & (n - 1)) == 0) {
                return true;
            }
        }
        return false;}
}

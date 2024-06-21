public class Finding_Missing_2_Number {
    public static void main(String[] args) {

        int[] arr = {1,3,4,2,6,8};
        int n = 8;
        int z =0;
        for( int i : arr){
                z = z^i;
        }
        for(int i = 1; i <=n; i++){
            z = z^i;
        }

        int set_bit = z & ~(z-1);
        System.out.println(set_bit);

        int grp1 = 0, grp2= 0;
        for(int i : arr){
            if((i&set_bit) == set_bit){
                grp1 = grp1^i;
            }else {
                grp2 = grp2 ^ i;
            }
        }

        for(int i = 1; i<=n; i++){
            if((i&set_bit) == set_bit){
                grp1 = grp1^i;
            }else {
                grp2 = grp2 ^ i;
            }
        }
        System.out.println("The first number missing is "  + grp1);
        System.out.println("The second number missing is " + grp2);
    }
}

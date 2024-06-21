public class RP_Mazepath_Diagonal_Count {
    public static void main (String[] args){
       int ans = Mazepath(0,0,2,2);
        System.out.println(ans);
    }
    public static int Mazepath(int cc, int cr, int tc, int tr){

        if (cc == tc && cr == tr){
            return 1;
        }
        if (cc > tc || cr > tr){
            return 0;
        }
       int ch = Mazepath(cc+1, cr, tc,tr);
        int cv = Mazepath(cc, cr+1, tc,tr);
        int cd = Mazepath(cc+1,cr+1,tc,tr);
        return cv+cd+ch;
    }
}

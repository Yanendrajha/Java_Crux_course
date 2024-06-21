public class RP_Mazepath_Diagonal {
    public static void main (String[] args){
        Mazepath(0,0,2,2, "");
    }
    public static void Mazepath(int cc, int cr, int tc, int tr, String ans){

        if (cc == tc && cr == tr){
            System.out.println(ans);
            return;
        }
        if (cc > tc || cr > tr){
            return;
        }
            Mazepath(cc+1, cr, tc,tr,ans+"H");
            Mazepath(cc, cr+1, tc,tr,ans+"V");
            Mazepath(cc+1,cr+1,tc,tr,ans+"D");
    }
}

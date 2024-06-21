public class RP_Mazepath {
    public static void main (String[] args){
        Mazepath(0,0,2,2, "");
    }
    public static void Mazepath(int cc, int cr, int tc, int tr, String ans){

        if (cc == tc && cr == tr){
            System.out.println(ans);
        }
        if (cc > tc || cr > tr){
        }
        if (cc < tc){
            Mazepath(cc+1, cr, tc,tr,ans+"H");
        }
        if (cr < tr){
            Mazepath(cc, cr+1, tc,tr,ans+"V");
        }
    }
}

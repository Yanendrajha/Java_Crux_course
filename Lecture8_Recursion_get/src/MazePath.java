import java.util.ArrayList;

public class MazePath {
    public static void main(String[] args ){
        System.out.println(MazePath(0,0,3,3));
    }
    public static ArrayList<String> MazePath(int cr, int cc, int er, int ec){
        if(cr == er && cc == ec){
            ArrayList<String> br = new ArrayList<>();
            br.add("");
            return br;
        }
        if(cr>er || cc>ec){
            return new ArrayList<>();
        }
        ArrayList<String> mr = new ArrayList<>();
        ArrayList<String> rrh = MazePath(cr,cc+1,er,ec);
        for(String hr : rrh){
            mr.add("H"+hr);
        }
        ArrayList<String> rrv = MazePath(cr+1,cc,er,ec);
        for(String vr : rrv){
            mr.add("V"+vr);
        }
    return mr;
    }
}

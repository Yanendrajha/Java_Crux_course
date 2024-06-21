import java.awt.image.AreaAveragingScaleFilter;
import java.security.PublicKey;
import java.util.ArrayList;

public class BoardPath {
    public static void main(String[] args) {
        System.out.println(getBoardPath(0,10));
    }

    public static ArrayList<String> getBoardPath(int curr, int end) {
        if (curr == end) {
            ArrayList<String> val = new ArrayList<>();
            val.add("");
            return val;
        }
        if (curr > end) {
            ArrayList<String> val = new ArrayList<>();
            return val;
        }
        ArrayList<String> mr = new ArrayList<>();
        for (int dice = 1; dice <= 6; dice++) {
            ArrayList<String> rr = getBoardPath(curr + dice, end);
            for (String rrs : rr) {
                mr.add(dice + rrs);
            }}
    return mr;
    }

    }
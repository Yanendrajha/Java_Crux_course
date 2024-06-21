public class Queen_Permutation {
    static int count = 0;
    public static void main(String[] args){
        QP(new boolean[4],2,0,"");
    }
    public static void QP(boolean[] boxes, int tq, int qpsf, String ans){
        if (qpsf == tq){
            count++;
            System.out.println(count+"."+ans);
            return;
        }
        for(int i = 0; i<boxes.length; i++) {
            if (!boxes[i]) {
                boxes[i] = true;
                QP(boxes, tq, qpsf + 1, ans + "Q" + qpsf + "P" + i + " ");
                boxes[i] = false; // Backtracking step.
            }
        }
    }
}

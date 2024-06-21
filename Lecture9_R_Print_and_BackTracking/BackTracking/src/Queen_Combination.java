public class Queen_Combination {
    static int count = 0;
    public static void main(String[] args){
        QC(new boolean[4], 2,0,"",-1);
    }
    // tq = Total Queens
    // qpsf = Queen Placed So Far
    // lbu = Last Box Used
    public static void QC(boolean[] boxes, int tq, int qpsf, String ans, int lbu){
        if(tq == qpsf){
            count++;
            System.out.println(count+". "+ans);
            return;
        }
        for(int i = lbu + 1; i < boxes.length; i++){
                boxes[i] = true;
                QC(boxes,tq,qpsf+1,ans+"Q"+qpsf+"P"+i+" ",i);
                boxes[i] = false; // UNDO
        }
    }
}

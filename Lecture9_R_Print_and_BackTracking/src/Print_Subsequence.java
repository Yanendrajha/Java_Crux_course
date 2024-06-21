public class Print_Subsequence {
    public static void main(String[] args){
        printss("abc","");
    }
    public static void printss(String str, String result){
        if (str.isEmpty()){
            System.out.print(result+ " ");
            return;
        }
        char cc = str.charAt(0);
        String ros = str.substring(1);
        printss(ros,result);
        printss(ros, result+cc);
    }
}

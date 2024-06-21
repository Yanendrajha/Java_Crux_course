public class Print_permutation {
    public static  void main(String[] args){
        String ans = "";
        String ques ="abc";
        print_permutation(ques,ans);
    }
    public static void print_permutation(String que, String ans){
        if (que.isEmpty()) {
            System.out.print(ans+" ");
            return;
        }
        for(int i = 0; i< que.length(); i++) {
            char ch = que.charAt(i);
            String roq = que.substring(0,i) + que.substring(i+1);
            print_permutation(roq, ans+ch);}
    }
}

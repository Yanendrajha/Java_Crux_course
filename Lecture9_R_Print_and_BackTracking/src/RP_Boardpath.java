public class RP_Boardpath {
    public static void main(String[] args){
        Print_Mazepath(0,"", 10);
    }
    public static void Print_Mazepath(int curr, String ans,int target){

            if(curr==target){
                System.out.print(ans+" ");
                return;
            } else if (curr>target){
                return;
            } for(int dice = 1; dice< 7; dice++) {
            Print_Mazepath(curr+dice,ans+dice,target);
    }
}}

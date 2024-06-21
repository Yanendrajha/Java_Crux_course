public class RP_Boardpath_Count {
    public static void main(String[] args){
        int ans = Print_Mazepath_count(0, 10);
        System.out.println(ans);
    }
    public static int Print_Mazepath_count(int curr,int target){
        if(curr==target){
            return 1;
        } else if (curr>target){
            return 0;
        }
        int count = 0;
        for(int dice = 1; dice< 7; dice++) {
            count += Print_Mazepath_count(curr+dice,target);
        }
        return count;
    }}

public class LIS_NlogN {
    public static void main(String[] args) {
        int[] arr = {0,8,4,12,2,10,6,14,1,9,5,13,3,11,7,15};
        System.out.println(LIS_NlogN_BU(arr));
    }

    public static int LIS_NlogN_BU(int[] arr) {
        if(arr.length == 0){
            return 0;
        }

        int[] le = new int[arr.length];

        le[0] = arr[0];
        int len = 1;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > le[len - 1]) {
                le[len] = arr[i];
                len++;
            } else {
                int idx = binarySearch(le,0,len-1,arr[i]);
                le[idx] = arr[i];
            }

            for(int val : le){
                if(val !=0){
                System.out.print(val + " ");
            }}
            System.out.println();
        }
        return len;
    }

    public static int binarySearch(int[] le, int si, int ei, int item){
        int low = si;
        int high = ei;
        while(low <= high){
            int mid = (low+high)/2;
            if(item > le[mid]){
                low = mid+1;
            } else {
                high = mid -1;
            }
        }
        return low;
    }
}
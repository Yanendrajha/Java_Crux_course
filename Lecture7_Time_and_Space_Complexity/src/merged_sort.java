import java.util.*;
public class merged_sort {
    public static void main(String[] args){

//        int[] arr1 = {10,20,30,40,50};
//        int[] arr2 = {5,15,30,45,60,70,80};
//
//        int[] ans = mergeTwoSortedArrays(arr1,arr2 );
//
//        for(int val : ans){
//            System.out.println(val + " ");
//        }

        int[] arr = {20,10,30,50,60,5,80,25};
        int[] ans = mergeSort(arr,0,arr.length-1);
        for(int val : ans) {
            System.out.print(val + " ");
        }
    }

    public static int[] mergeTwoSortedArrays(int[] arr1, int[] arr2){
        int [] merged = new int [arr1.length + arr2.length];

        int i = 0;
        int j = 0;
        int k = 0;

        while (arr1.length > i && arr2.length > j ){
            if (arr1[i] <= arr2[j]){
                merged[k] = arr1[i];
                i++;
                k++;
            } else {
                merged[k] = arr2[j];
                j++;
                k++;
            }}
            if (i==arr1.length){
                while(j<arr2.length){
                    merged[k] = arr2[j];
                    j++;
                    k++;
                }
            } else {
                merged[k] = arr1[i];
                i++;
                k++;
            }
    return merged;

    }

    public static int[] mergeSort(int[] arr, int lo, int hi){

        if (lo == hi ){
            int[] br = new int[1];
            br[0] = arr[lo];

            return br;
        }
        int mid = (lo+hi)/2;

        int[] fh = mergeSort(arr,lo,mid);
        int[] sh = mergeSort(arr,mid+1,hi);
        return mergeTwoSortedArrays(fh,sh);
    }
}

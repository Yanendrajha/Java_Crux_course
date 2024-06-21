import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Maximum_Element_In_Every_Window_Of_Size_K {
    public static void PrintMax(int[] arr, int k){
        Deque<Integer> q = new LinkedList<>();
        int i;
        for(i = 0; i < k; i++){
            while(!q.isEmpty() && arr[i] > arr[q.getLast()]){
                q.removeLast();
            }
            q.addLast(i);
        }
        for (;i<arr.length;i++){
            System.out.print(arr[q.getFirst()]+ " ");
            while(!q.isEmpty() && q.getFirst() < i-k){
                q.removeFirst();
            }
            while(!q.isEmpty() && arr[i] > arr[q.getLast()]){
                q.removeLast();
            }
            q.addLast(i);
        }
        System.out.print(arr[q.getFirst()]);

    }

    public static void main(String[] args){
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt(); // Size of Array
        int[] arr = new int[n];
        for(int i=0;i<arr.length;i++){
            arr[i] = scn.nextInt();
        }
        PrintMax(arr,3);

    }
}

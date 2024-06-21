package Array_Questions;

public class Rotate {
    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40, 50, 60};
        int rotation = -20;
        rotation = rotation % arr.length;
        if(rotation < 0){
            rotation += arr.length;
        }
        rotate2(arr, rotation);
        display(arr);
    }

    public static void display(int[] arr){
        for( int val : arr){
            System.out.print(val +" ");
        }
    }

    public static void rotate(int[] arr, int rotation){
        for(int rot = 1; rot <= rotation; rot++){
            int temp = arr[arr.length-1];
            for(int i = arr.length-1; i>=1; i--){
            arr[i] = arr[i-1];
            }
        arr[0] = temp;}
    }


    public static void rotate2(int[] arr, int rot){
        reverse(arr, 0, arr.length-rot-1); // 0 and 1 here
        reverse(arr,arr.length-rot, arr.length-1); // 2 to 5
        reverse(arr, 0, arr.length-1);
    }

    public static void reverse(int[] arr, int si, int ei){
        int i =si;
        int j = ei;
        while( i <= j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

            i++;
            j--;
        }
    }
}

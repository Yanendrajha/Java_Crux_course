package Generic;

import java.util.Comparator;

public class Generics {
    public static void main(String[] args){
//        Integer[] arr1 = {10,20,30,40,50};
//        display(arr1);
//
//        String[] arrs = {"hello","Yan","He","kkrh","M"};
//        display(arrs);

        Demo_Car[] cars = new Demo_Car[5];
        cars[0] = new Demo_Car(1000,100,"Red");
        cars[1] = new Demo_Car(390,300,"Green");
        cars[2] = new Demo_Car(1200,130,"Black");
        cars[3] = new Demo_Car(580,150,"Orange");
        cars[4] = new Demo_Car(2500,500,"Violet");

        Bubble_Sort(cars,new Car_price_Comparator());
        display(cars);
        Bubble_Sort(cars,new Car_Color_Comparator());
        display(cars);
        Bubble_Sort(cars,new Car_Speed_Comparator());
        display(cars);


    }
    // Generic Array Display
    public static <T> void display(T[] arr_output){
        for(T val : arr_output){
            System.out.print(STR."\{val} ");
        }
        System.out.println();
    }

    // bubble sort Generic
    // Here the "T" or the data type is such that it can be compared.

    /*    public static <T extends Comparable<T>> void Bubble_Sort(T[] arr){
    for(int counter = 0; counter<arr.length-1; counter++){
        for(int j = 0; j<arr.length-1 -counter;j++){
            if(arr[j].compareTo(arr[j+1]) > 0){
                T temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }}*/

    public static <T> void Bubble_Sort(T[] arr,Comparator<T> comparator){
        for(int counter = 0; counter<arr.length-1; counter++){
            for(int j = 0; j<arr.length-1 -counter;j++){
                if(comparator.compare(arr[j],arr[j+1]) > 0){
                    T temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
}}


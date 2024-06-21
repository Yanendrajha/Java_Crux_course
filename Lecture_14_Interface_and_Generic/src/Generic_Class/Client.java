package Generic_Class;

import Generic.Demo_Car;

public class Client {
    public static void main(String[] args){
        Pair<String> pair = new Pair<>();
        pair.one = "abc";
        pair.two = "def";

        Pair<Integer> pair1 = new Pair<>();
        pair1.one = 40;
        pair1.two = 60;

        Pair_Two<String,Integer> pair_2 = new Pair_Two<>();
        pair_2.one = "Yanendra";
        pair_2.two = 9;


        Linked_List_Generic<Demo_Car> Cars_LL= new Linked_List_Generic<>();
        Demo_Car[] cars = new Demo_Car[5];
        cars[0] = new Demo_Car(1000,100,"Red");
        cars[1] = new Demo_Car(390,300,"Green");
        cars[2] = new Demo_Car(1200,130,"Black");
        cars[3] = new Demo_Car(580,150,"Orange");
        cars[4] = new Demo_Car(2500,500,"Violet");

        Cars_LL.addLast(cars[0]);
        Cars_LL.addLast(cars[1]);
        Cars_LL.addLast(cars[2]);
        Cars_LL.addLast(cars[3]);
        Cars_LL.addLast(cars[4]);

        Cars_LL.display();
    }
}

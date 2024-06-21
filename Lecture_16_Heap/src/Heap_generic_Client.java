import Generic.Demo_Car;

public class Heap_generic_Client {
    public static void main(String[] args) {
        Demo_Car[] cars = new Demo_Car[5];
        cars[0] = new Demo_Car(800, 100, "Red");
        cars[1] = new Demo_Car(390, 300, "Green");
        cars[2] = new Demo_Car(1200, 130, "Black");
        cars[3] = new Demo_Car(580, 150, "Orange");
        cars[4] = new Demo_Car(2500, 500, "Violet");

        Heap_Generic<Demo_Car> heapg = new Heap_Generic<Demo_Car>();
        heapg.add(cars[0]);
        heapg.add(cars[1]);
        heapg.add(cars[2]);
        heapg.add(cars[3]);
        heapg.add(cars[4]);

        heapg.display();
        System.out.println("*********");

        System.out.println(heapg.remove());
        System.out.println(heapg.remove());
        System.out.println(heapg.remove());
        System.out.println(heapg.remove());
        System.out.println(heapg.remove());
    }
}
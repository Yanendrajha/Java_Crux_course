public class Heap_Min_Type_Client {
    public static void main(String[] args){
        Heap_Min_Type heap = new Heap_Min_Type();
        heap.add(10);
        heap.display();
        heap.add(20);
        heap.display();
        heap.add(30);
        heap.display();
        heap.add(40);
        heap.display();
        heap.add(5);
        heap.display();
        heap.add(3);
        heap.display();

        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        System.out.println(heap.remove());
        heap.display();
    }
}

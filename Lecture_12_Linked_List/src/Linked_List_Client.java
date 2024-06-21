public class Linked_List_Client {
    public static void main(String[] args) throws Exception{

        Linked_List list = new Linked_List();
        list.addFirst(10);
        list.addFirst(20);
        list.addFirst(30);
        list.addFirst(40);
        list.addAt(100,1);
        System.out.println(list.getLast());
        System.out.println(list.getFirst());
        System.out.println(list.getAt(1));
        System.out.println(list.removeFirst());
        list.display();
        System.out.println(list.removeLast());
        list.display();
        list.addLast(200);
        list.addLast(300);
        list.display();
        System.out.println(list.removeAt(3));
        list.display();

        list.reverse_LL_data();
        list.display();
        System.out.println(list.mid_point_data());
        System.out.println(list.KthNodeFromEnd(3));
    }
}

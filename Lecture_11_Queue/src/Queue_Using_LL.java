import java.util.LinkedList;

public class Queue_Using_LL {
    LinkedList<Integer> queue;
    Queue_Using_LL(){
        queue = new LinkedList<>(); // Linked list does not need Initialisation.
    }
    public boolean isEmpty(){
        return queue.isEmpty();// Previously provided method of linked list.
    }
    public void enQueue(int data){
        queue.addLast(data);
    }
    public void deQueue(){
        queue.removeFirst();
    }
    public int getFront(){
        return  queue.getFirst(); // Previously provided Method
    }

    public static void main(String[] args){
        Queue_Using_LL queue = new Queue_Using_LL();
        for(int i = 1; i <=6; i++ ){
            queue.enQueue(i);
        }
        queue.deQueue();
        queue.deQueue();
        queue.enQueue(8);
        while (!queue.isEmpty()){
            System.out.println(queue.getFront());
            queue.deQueue();
        }
    }
}

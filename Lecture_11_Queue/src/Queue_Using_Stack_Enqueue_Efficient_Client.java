public class Queue_Using_Stack_Enqueue_Efficient_Client {
    public static void main(String[] args) throws Exception{
    Queue_Using_Stack_Enqueue_Efficient queue = new Queue_Using_Stack_Enqueue_Efficient();

    // 10 20 30 40 50
    for(int i = 1; i<=5; i++){
        queue.enqueue(i*10);
    }

    // 10 20 30 40 50
    queue.display();

        System.out.println(queue.dequeue()); //// 10

        queue.display(); // 20 30 40 50

    }}

public class Queue_Using_Circular_Array {
    private  int[] arr;
    private int cs; // Count size
    private  int ms; // Maximum size;
    private int front; //Pointing to the front data of the queue
    private int rear;// Pointing to the last data of the queue

    public static  int Default_Capacity = 10;
    Queue_Using_Circular_Array() {
        this(Default_Capacity);
    }
    public Queue_Using_Circular_Array(int Capacity) {
        this.arr = new int[Capacity];
        this.cs = 0;
        this.ms = Capacity;
        this.front = 0;
        this.rear = Capacity-1;
    }

    public boolean isFull(){
        return this.cs == this.ms;
    }
    public boolean isEmpty(){
        return this.cs == 0;
    }
    public void enQueue(int data){
        if(!isFull()){
            this.rear = (this.rear+1)%this.arr.length;
            this.arr[rear] = data;
            this.cs = this.cs+1;
        }
    }
    public void dequeue(){
        if(!isEmpty()){
            this.front = (this.front+1)%this.arr.length;
            this.cs = this.cs-1;
        }
    }

    public int getFront(){
        return this.arr[this.front];
    }

    public static void main(String[] args){
        Queue_Using_Circular_Array queue = new Queue_Using_Circular_Array();
        for(int i = 1; i<=6; i++){
            queue.enQueue(i);
        }
        queue.dequeue();
        queue.dequeue();
        queue.enQueue(8);
        while (!queue.isEmpty()){
            System.out.println(queue.getFront());
            queue.dequeue();
        }
    }
}

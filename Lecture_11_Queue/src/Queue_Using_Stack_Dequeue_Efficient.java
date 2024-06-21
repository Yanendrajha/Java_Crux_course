import Stack.Dynamic_Stack;

public class Queue_Using_Stack_Dequeue_Efficient {
    private Dynamic_Stack primary;
    private Dynamic_Stack secondary;

    Queue_Using_Stack_Dequeue_Efficient() throws Exception{
        this.primary = new Dynamic_Stack();
        this.secondary = new Dynamic_Stack();
    }
    public boolean isEmpty(){
        return this.primary.isEmpty();
    }
    public int size(){
        return this.primary.size();
    }

    // O(1)
    public void enqueue(int data) throws Exception {
        while (!primary.isEmpty()){
            secondary.push(primary.pop());
        }
        primary.push(data);
        while(!secondary.isEmpty()){
            primary.push(secondary.pop());
        }
    }

    // O(N)
    public int dequeue() throws Exception {
        return this.primary.pop();
    }
    public int front() throws Exception {
        return this.primary.top();
    }
    public  void display() throws Exception{
        this.primary.display();
    }
}

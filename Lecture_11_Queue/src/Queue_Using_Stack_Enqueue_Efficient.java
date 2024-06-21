import Stack.Dynamic_Stack;

public class Queue_Using_Stack_Enqueue_Efficient {
    private Dynamic_Stack primary;
    private Dynamic_Stack secondary;

    Queue_Using_Stack_Enqueue_Efficient() throws Exception{
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
        this.primary.push(data);
    }

    // O(N)
    public int dequeue() throws Exception {
        while (primary.size() != 1){
            secondary.push(primary.pop());
        }
        int rv = primary.pop();
        while(!secondary.isEmpty()){
            primary.push(secondary.pop());
        }
        return rv;
    }
    public int front() throws Exception {
        while (primary.size() != 1){
            secondary.push(primary.pop());
        }
        int rv = primary.top();
        while(!secondary.isEmpty()){
            primary.push(secondary.pop());
        }
        return rv;
    }
    public  void display() throws Exception{
        reverse_stack(primary,secondary,0);
        primary.display();
        reverse_stack(primary,secondary,0);
    }
    public static void reverse_stack(Dynamic_Stack Stack, Dynamic_Stack Helper, int index) throws Exception{
        if(Stack.isEmpty()){
            return;
        }
        int item = Stack.pop();
        reverse_stack(Stack,Helper,index + 1);
        Helper.push(item);
        if(index == 0){
            while(!Helper.isEmpty()){
                Stack.push(Helper.pop());
            }
        }
    }
}


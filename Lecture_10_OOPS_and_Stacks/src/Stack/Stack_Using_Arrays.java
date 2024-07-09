package Stack;
public class Stack_Using_Arrays {
    protected int[] data;
    protected int top;

    public static final int MAX_CAPACITY = 10;
    public Stack_Using_Arrays() throws Exception {
        this(MAX_CAPACITY);
    }
    public Stack_Using_Arrays(int Capacity) throws Exception{
        if (Capacity < 1){
            throw new Exception("Invalid Capacity");
        }
        this.data = new int[Capacity];
        this.top = -1;
    }
    public int size(){
        return this.top+1;
    }

    public boolean isEmpty(){
        return this.size() == 0;
    }
    public void push(int value) throws Exception{
        if (this.size() == this.data.length){
            throw new Exception("Stack is full");
        }

        this.top++;
        this.data[this.top] = value;

    }

    public int pop() throws Exception {
        if(this.size() == 0){
            throw new Exception("Stack is empty");
        }
        int value_poped = this.data[this.top];
        this.data[this.top] = 0;
        this.top--;
        return value_poped;
    }

    public int top() throws Exception{
        if (this.size() == 0){
            throw new Exception("Stack is empty");
        }
        return this.data[this.top];
    }

    public void display() {
        for (int i = this.top; i >= 0; i--) {
            System.out.print(this.data[i] + ", ");
        }
        System.out.println("END");
    }
}

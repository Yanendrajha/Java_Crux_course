package Stack;

public class Dynamic_Stack extends Stack_Using_Arrays{
    public Dynamic_Stack() throws Exception {
        this(MAX_CAPACITY);
    }

    public Dynamic_Stack(int Capacity) throws Exception {
        super(Capacity);
    }

    @Override
    public void push(int value) throws Exception {
        if (this.size() == this.data.length){
            int[] arr = new int[2*this.data.length];
            System.arraycopy(data, 0, arr, 0, this.data.length);
            this.data = arr;
        }
        super.push(value);
    }
}

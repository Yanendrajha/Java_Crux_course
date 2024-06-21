import java.util.ArrayList;

public class Heap_Min_Type {
    // Min Heap type.
    ArrayList<Integer> data = new ArrayList<>();

    public void add(int item){
        data.add(item);
        upheapify(data.size()-1);
    }


    // Unheapify
    private void upheapify(int ci){
        int  pi = (ci -1)/2;
        if(data.get(pi) > data.get(ci)){
            swap(pi,ci);
            upheapify(pi);
        }
    }

    // Swap function
    private void swap (int i, int j){
        int ith = data.get(i);
        int jth = data.get(j);
        data.set(i,jth);
        data.set(j,ith);
    }

    // Display function
    public void display(){
        System.out.println(data);
    }
    //size
    public int size(){
        return this.data.size();
    }
    // Check for empty.
    public boolean isEmpty(){
        return this.size() == 0;
    }

    // Remove element (Always priority Element Get removed)
    public int remove(){
        swap(0,data.size()-1);
        int rv =  this.data.remove(this.data.size()-1);
        downheapify(0);
        return rv;
    }

    private void downheapify(int pi){
        int lci = 2*pi+1;
        int rci = 2*pi+2;

        int mini = pi;
        if(lci < this.data.size() && data.get(lci) < data.get(mini)){
            mini = lci;

        }
        if(rci < this.data.size()  && data.get(rci) < data.get(mini)){
            mini = rci;

        }
        if(mini !=pi){
            swap(mini,pi);
            downheapify(mini);
        }


    }



}

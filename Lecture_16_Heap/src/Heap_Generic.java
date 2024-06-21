import java.util.ArrayList;
import java.util.HashMap;

public class Heap_Generic<T extends Comparable<T>> {
    // Min Heap type.
    ArrayList<T> data = new ArrayList<>();
    HashMap<T,Integer> map = new HashMap<>();
    public void add(T item){
        data.add(item);
        map.put(item,this.data.size()-1);
        upheapify(data.size()-1);
    }


    // Unheapify
    private void upheapify(int ci){
        int  pi = (ci -1)/2;
        if(isLarger(data.get(ci), data.get(pi)) > 0){
            swap(pi,ci);
            upheapify(pi);
        }
    }

    // Swap function
    private void swap (int i, int j){
        T ith = data.get(i);
        T jth = data.get(j);
        data.set(i,jth);
        data.set(j,ith);

        map.put(ith, j);
        map.put(jth ,i );
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

    // Remove an element (priority Element Gets always removed)
    public T remove(){
        swap(0,this.data.size()-1);
        T rv =  this.data.remove(this.data.size()-1);
        map.remove(rv);
        downheapify(0);
        return rv;
    }

    private void downheapify(int pi){
        int lci = 2*pi+1;
        int rci = 2*pi+2;

        int mini = pi;
        if(lci < this.data.size() && isLarger(data.get(lci),data.get(mini)) > 0 ){
            mini = lci;

        }
        if(rci < this.data.size()  && isLarger(data.get(rci),data.get(mini)) > 0 ){
            mini = rci;

        }
        if(mini != pi){
            swap(mini,pi);
            downheapify(mini);
        }
    }
    public T get(){
        return this.data.get(0);
    }

    // If t is having higher priority then returns +ve value else -ve value.
    public int isLarger(T t, T o){
        return t.compareTo(o);
    }

    public void updatePriority (T pair){
        int index = map.get(pair);
            upheapify(index);
    }

}

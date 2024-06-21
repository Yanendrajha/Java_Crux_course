import Generics.Linked_List_Generic;

public class HashTable<K,V> {
    private class HTpair{
        K key;
        V value;
        HTpair(K key, V value){
            this.key = key;
            this.value = value;
        }


        // Equals is over rided to check if the key is there or not.
        public boolean equals(Object other){
            HTpair op = (HTpair) other;
            return this.key.equals(op.key);
        }

        // To string is OverRide to print both Key value pair.
        public String toString(){
            return STR."{\{this.key}-\{this.value}}";
        }

    }

    public static final int DEFAULT_CAPACITY = 10;
    private Linked_List_Generic<HTpair>[] bucketArray;
    private int size;

    // Constructors
        public HashTable(){
        this(DEFAULT_CAPACITY);
    }

        public HashTable(int capacity){
            this.bucketArray = (Linked_List_Generic<HTpair>[]) new Linked_List_Generic[capacity];
            this.size = 0;
    }



    // Adding the value in The HashMap
    public void put(K key, V value) throws Exception {
        int bi = hashFunction(key);
        Linked_List_Generic<HTpair>  bucket = this.bucketArray[bi];
        HTpair pta = new HTpair(key,value);
        if(bucket == null){
           bucket = new Linked_List_Generic<>();
           bucket.addLast(pta);
           this.bucketArray[bi] = bucket;
           this.size++;
        } else {
            int findAt = bucket.find(pta);
            if(findAt == -1){
                bucket.addLast(pta);
                this.size++;
            } else {
                HTpair pair = bucket.getAt(findAt);
                pair.value = value;
            }
        }
        double lambda = (this.size*1.0)/this.bucketArray.length;
        if(lambda > 0.75){
            rehash();
        }
    }

    private void rehash() throws Exception {
        Linked_List_Generic<HTpair>[] oba = this.bucketArray;
        this.bucketArray = (Linked_List_Generic<HTpair>[]) new Linked_List_Generic[2*oba.length];
        this.size = 0;
        for(Linked_List_Generic<HTpair> ob : oba){
            while(ob != null && !ob.isEmpty()){
                HTpair pair = ob.removeFirst();
                this.put(pair.key,pair.value);
            }
        }
    }

    // Gives out HashCode.
    private int hashFunction(K key){
        int hc = key.hashCode();
        hc = Math.abs(hc);
        int bi = hc%this.bucketArray.length;
        return bi;
    }

    // Display the Hashmap
    public void display() throws Exception{
            for(Linked_List_Generic<HTpair> bucket : this.bucketArray) {
                if (bucket != null && !bucket.isEmpty()) {
                    bucket.display();
                } else {
                    System.out.println("NULL");
                    System.out.println("*********************");
                }
            }
                System.out.println("________________________________________");
    }

    //Get Function of Hash Map
    public V get(K key) throws Exception {
            int bi = hashFunction(key);
            Linked_List_Generic<HTpair> bucket = this.bucketArray[bi];
            HTpair ptf = new HTpair(key,null);
            if(bucket == null){
                return null;
            } else {
                int findAt = bucket.find(ptf);
                if (findAt == -1) {
                    return null;
                } else {
                    HTpair pair = bucket.getAt(findAt);
                    return pair.value;
                }
            }
    }

    // Remove Function of HashMap
    public V remove(K key) throws Exception {
        int bi = hashFunction(key);
        Linked_List_Generic<HTpair> bucket = this.bucketArray[bi];
        HTpair ptf = new HTpair(key,null);
        if(bucket == null){
            return null;
        } else {
            int findAt = bucket.find(ptf);
            if (findAt == -1) {
                return null;
            } else {
                HTpair pair = bucket.removeAt(findAt);
                return pair.value;
            }
        }
    }

    //


}

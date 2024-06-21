package Generics;

public class Linked_List_Generic<T> {

    private class Node{
        T data;
        Node next;
    }

    private Node head;
    private Node tail;
    private int size;

    public int size(){
        return this.size;
    }

    public boolean isEmpty(){
        return size() == 0;
    }

    // O(1)
    public T getFirst() throws Exception{
        if (this.size == 0){
            throw new Exception("Linked list is Empty");
        }
        return this.head.data;
    }


    // O(1)
    public T getLast() throws Exception{
        if (this.size == 0){
            throw new Exception("Linked list is Empty");
        }
        return this.tail.data;
    }


    //O(N)
    public T getAt(int index) throws Exception{
        if (this.size == 0){
            throw new Exception("Linked list is Empty");
        }
        if (index < 0 || index >= this.size ){
            throw new Exception("Index Out Of Bound");
        }
        Node temp = this.head;
        for(int i = 1; i<= index; i++){
            temp = temp.next;
        }
        return  temp.data;
    }


    // to add a item at any provided node;
    // O(N);
    public void addAt(T item, int index) throws Exception{
        if (index < 0 || index > this.size ){
            throw new Exception("Index Out Of Bound");
        }
        if(index == 0) {
            addFirst(item);
        }else if(index == this.size){
            addLast(item);
        } else {
            // Creating a new Node
            Node nn = new Node();
            nn.data = item;

            // linking with previous index
            Node nm1 = getNodeAt(index-1);
            Node np1 = nm1.next;
            nm1.next = nn;
            nn.next = np1;

            // Summary Update
            size++;
        }


    }


    //Its made private so,that client does not get the access of any node. If client get
    //the address of any node. They can manipulate it.
    // It's Exclusive for the Linked list class.
    // This function can only be used by Linked_List other Functions.
    // O(N);
    private Node getNodeAt(int index) throws Exception{
        if (this.size == 0){
            throw new Exception("Linked list is Empty");
        }
        if (index < 0 || index >= this.size ){
            throw new Exception("Index Out Of Bound");
        }
        Node temp = this.head;
        for(int i = 1; i<= index; i++){
            temp = temp.next;
        }
        return  temp;
    }

    //Public because we want to access it to see the output.
    public void display(){
        System.out.println("--------------------------");
        Node temp = this.head;
        while( temp != null){
            System.out.print(temp.data+ ", ");
            temp = temp.next;}
        System.out.println(".");
        System.out.println("--------------------------");
    }

    //O(1)
    public void addFirst(T item){
        // Creating a new Node
        Node nn = new Node();
        nn.data = item;

        // Linking with previous Node
        if(this.size >= 1){
            nn.next = head; // Currently head is pointing
            // towards the previous front.
        }

        // Summary Object
        if(size == 0){
            this.head = nn;
            this.tail =nn;
            this.size++;
        } else {
            this.head =nn;
            this.size++;
        }

    }

   //O(1)
    public void addLast(T item) {
        // Creating new Node
        Node nn = new Node();
        nn.data = item;
        nn.next = null;

        // attach
        if (this.size >= 1) {
            this.tail.next = nn;
        }

        // Summary Object
        if (size == 0) {
            this.head = nn;
            this.tail = nn;
            this.size++;
        } else {
            this.tail = nn;
            this.size++;
        }
    }


    // It's used to remove the first Element from the Linked List.
    //O(1)
    public T removeFirst() throws Exception{
        if (this.size == 0){
            throw new Exception("LL is empty");
        }
        // Deletion part
        T rv = this.head.data;
        if(size == 1){
            // Summary object Update
            this.head = null;
            this.tail = null;
            this.size = 0;
        } else {
        // Summary object Update
            this.head = this.head.next;
            size--;
    }
        return rv;}


    //O(N), Because of the presence of getNodeAt();
    // Remove the last node from the LL.
    public T removeLast() throws Exception{
        if (this.size == 0){
            throw new Exception("LL is empty");
        }
        // Deletion part
        T rv = this.tail.data;
        if(size == 1){
            // Summary object Update
            this.head = null;
            this.tail = null;
            this.size = 0;
        } else {
            Node sizem2 = getNodeAt(this.size-2);
            // Summary object Update
            this.tail = sizem2;
            this.tail.next = null;
            size--;
        }
        return rv;}


    public T removeAt(int index) throws Exception{
        if (index < 0 || index >= this.size){
            throw new Exception("LL is empty");
        }
        if (index == 0){
            return removeFirst();
        } else if (index == this.size - 1){
            return removeLast();
        } else {
            // Linking nodes while removing required one.
            Node nm1 = getNodeAt(index -1);
            Node n = nm1.next;
            Node np1 = n.next;
            nm1.next = np1;

            // Summary object update
            this.size--;

            // Returning value
            return n.data;
        }
    }


    public int find(T data){
        int index = 0;
        // This can also be done in For Loop
        for(Node temp = this.head; temp!= null; temp = temp.next) {
            if (temp.data.equals(data)) {
                return index;
            }
            index++;
        }
        return -1;
    }
}


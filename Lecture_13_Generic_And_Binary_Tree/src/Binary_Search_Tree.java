public class Binary_Search_Tree {
    private class Node{
        int data;
        Node left;
        Node right;
    }
    private Node root;

    // Constructor
    public Binary_Search_Tree(int[] arr){
        this.root = construct(arr,0,arr.length-1);
    }
    private Node construct(int[] arr, int lo, int hi){

        // Base Case
        if (lo > hi){
            return null;
        }
        // Mid index
        int mid = (lo+hi)/2;

        // Create a  new Node
        Node nn = new Node();
        nn.data = arr[mid];

        nn.left = construct(arr,lo,mid-1);
        nn.right = construct(arr,mid+1,hi);

        return nn;
    }

    public void display(){
        System.out.println("------------------------");
        display(this.root);
    }
    private void display(Node node) {
        if (node == null){
            return;
        }
        // Self Work
        String str = "";
        if(node.left == null){
            str += ".";
        } else {
            str += node.left.data;
        }

        str += " -> " + node.data + " <- ";

        if(node.right == null){
            str += ".";
        } else {
            str += node.right.data;
        }
        System.out.println(str);
        //left
        display(node.left);
        // right
        display(node.right);
    }

    public boolean find(int tofind){
        return find(this.root, tofind);
    }
    private boolean find(Node node, int ToFind){

        // base Case
        if(node == null){
            return false;
        }
        // Self work
        if(ToFind > node.data){
           return find(node.right,ToFind);
        } else if (ToFind < node.data) {
            return find(node.left,ToFind);
        }
        else{
            return true;
        }
    }

    // Addition in BST
    public void add(int item){
        add(this.root, item);
    }

    private void add(Node node, int item){
        // Recursion call to reach desired location
        if(item > node.data){
            if(node.right == null){
                Node nn = new Node();
                nn.data = item;
                node.right = nn;
            }
            else{
                add(node.right,item);
            }

        } else{
            if(node.left == null){
                Node nn = new Node();
                nn.data = item;
                node.left = nn;
            }
            else{
                add(node.left,item);
            }
        }
    }

    public int max(){
        return  max(root);
    }
    private int max(Node node){
       if(node.right == null){
           return node.data;
       }
       return max(node.right);
    }

    public void remove(int item){
        remove(this.root,null,false,item);
    }

    private void remove(Node node, Node parent, boolean ilc,int item){

        if(item > node.data){
            remove(node.right,node,false,item);
        } else if(item < node.data){
            remove(node.left,node,true,item);
        } else {

            // Case 1 - Deletion node is a Leaf node
            if(node.left == null && node.right == null){
                if(ilc){
                    parent.left = null;
                } else {
                    parent.right = null;
                }
            }

            // Case 2 - left null , right not null;
            else if (node.left == null) {
                if(ilc){
                    parent.left = node.right;
                } else {
                    parent.right = node.right;
                }
            }

            // Case 3 - left not null , right not null;
            else if(node.right == null) {
                if(ilc){
                    parent.left = node.left;
                } else {
                    parent.right = node.left;
                }

            }

            // Case 4 - left & right both not null;
            else{
                int max = max(node.left);
                node.data = max;
                remove(node.left,node,true,max);
            }
        }
    }
}

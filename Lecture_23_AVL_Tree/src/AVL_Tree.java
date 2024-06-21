public class AVL_Tree {
    private class Node{
        int  data;
        Node left;
        Node right;
        int height;
        Node(int data){
            this.data = data;
            this.height = 1;
        }
    }

    private Node root;


    // Inserting an item
    public void insert(int item){
        this.root = insert(this.root, item); }

    private Node insert(Node node, int item){
        if(node == null){
            Node nn = new Node(item);
            return nn;
        }

        if(item > node.data){
            node.right = insert(node.right,item);
        } else if (item < node.data){
            node.left =  insert(node.left,item);
        }
        node.height = Math.max(height(node.left), height(node.right)) + 1;
        int bf = bf(node);

        // LL Case
        if(bf > 1 && item < node.left.data){
            return right_rotate(node);
        }

        // RR case
        if(bf < -1 && item > node.right.data){
            return left_rotate(node);
        }

        // LR case
        if(bf > 1 && node.left.data < item){
                node.left = left_rotate(node.left);
                return right_rotate(node);
        }

        // RL
        if(bf < -1 && node.right.data > item){
           node.right = right_rotate(node.right);
           return left_rotate(node);
        }
        return  node;
    }

    private int height(Node node){
        if(node == null){
            return 0;
        }
        return node.height;
    }

    private int bf(Node node){
        if(node == null){
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    // Right Rotation
    private Node right_rotate(Node c){
       Node b = c.left;
       Node T_3 = b.right;

       // Rotation
        b.right = c;
        c.left = T_3;

        //ht update
        c.height = Math.max(height(c.left), height(c.right))+1;
        b.height = Math.max(height(b.left), height(b.right))+1;

        return b;
    }

    // Left Rotation
    private Node left_rotate(Node c){
        Node b = c.right;
        Node T_2 = b.left;

        // Rotation
        b.left = c;
        c.right = T_2;

        //ht update
        c.height = Math.max(height(c.left), height(c.right))+1;
        b.height = Math.max(height(b.left), height(b.right))+1;

        return b;
    }

    public void display(){
        display(this.root);
    }
    private void display(Node node){
        //Base Case
        if(node == null){
            return;
        }

        // Self work
        String str = "";
        if(node.left == null){
            str +=".";
        } else {
            str += node.left.data;
        }
        str += " => " + node.data +" <= ";

        if(node.right == null){
            str +=".";
        } else {
            str += node.right.data;
        }
        System.out.println(str);
        display(node.left);
        display(node.right);
    }
}

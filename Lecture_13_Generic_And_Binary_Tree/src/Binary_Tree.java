import java.util.LinkedList;
import java.util.Scanner;

public class Binary_Tree {
    private class Node{
        int data;
        Node left;
        Node right;

        Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private Node root;
    private int size;

    Binary_Tree(){
         Scanner scn = new Scanner(System.in);
         this.root = takeInput(scn, null, false);

    }

    private Node takeInput(Scanner scn, Node parent, boolean isLeftOrRight){
        if(parent == null){
            System.out.println("Enter the data for Root node");
        } else  {
            if(isLeftOrRight){
                System.out.println("Enter the data for left child of " + parent.data);
            }
            else{
                System.out.println("Enter the data for right child of " + parent.data);
            }
        }

        int NodeData = scn.nextInt();
        Node node = new Node(NodeData,null,null);
        this.size++;

        boolean choice = false;
        System.out.println("Do you have left child of "+ node.data);
        choice = scn.nextBoolean();

        if (choice){
            node.left = takeInput(scn, node, true);}

        choice = false;
        System.out.println("Do you have Right child of "+ node.data);
        choice = scn.nextBoolean();

        if (choice){
            node.right = takeInput(scn, node, false);
        }

        return node;
    }

    public void display(){
        this.display(this.root);
    }

    private void display(Node node){

        String str = "";
        if (node.left != null){
            str = str+node.left.data+"=>";
        } else {
            str = str +"END=>";
        }
        str = str + node.data;
        if (node.right != null){
            str = str+ "<="+ node.right.data;
        } else {
            str = str +"<= END";
        }
        System.out.println(str);

        if (node.left != null){
            this.display(node.left);
        }
        if(node.right != null){
            this.display(node.right);
        }

}

    public int height(){
        return this.height(this.root);
    }

    private int height(Node node){
       if(node == null){
           return -1;
       }
        int lheight = this.height(node.left);
        int rheight = this.height(node.right);

        int height = Math.max(lheight,rheight) + 1;
        return height;
    }

    public void preOrder(){
        this.preOrder(this.root);
        System.out.println("END");
    }

    private void preOrder(Node node){
        if(node == null){
            return;
        }
        System.out.print(node.data+", ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void postOrder(){
        this.postOrder(this.root);
        System.out.println("END");
    }

    private void postOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data+", ");
    }

    public void inOrder(){
        this.inOrder(this.root);
        System.out.println("END");
    }

    private void inOrder(Node node){
        if(node == null){
            return;
        }
        postOrder(node.left);
        System.out.print(node.data+", ");
        postOrder(node.right);
    }

    public void levelOrder(){
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(this.root);
        while(!queue.isEmpty()){
            Node rv= queue.removeFirst();
            System.out.print(rv.data+", ");
            if(rv.left != null){
                    queue.addLast(rv.left);
            }
            if(rv.right != null){
                queue.addLast(rv.right);
            }
        }
    }

    public boolean isBST(){
        return this.isBST(this.root,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    private boolean isBST(Node node, int min, int max){
        if(node == null){
            return true;
        }
        if(node.data > max || node.data < min){
            return false;
        } else if(!this.isBST(node.left,min,node.data)){
            return false;
        } else if(!this.isBST(node.right,node.data,max)){
            return false;
        }

        return false;
    }

    public int diameter(){
         return this.diameter(this.root);
    }
    private int diameter(Node node){
        if(node == null){
            return 0;
        }

        // When diameter passes through the root
        int case1 = this.height(node.left)+this.height(node.right)+2;
        int case2 = this.diameter(node.left);
        int case3 = this.diameter(node.right);

        int ans = Math.max(case1,Math.max(case2,case3));
        return ans;
    }


    public int DiameterBetter(){
        return this.diameterBetter(this.root).diameter;
    }

    private DiaPair diameterBetter(Node node){
        if(node==null){
            DiaPair bp =new DiaPair(-1,0);
            return bp;
        }
        DiaPair lp = this.diameterBetter(node.left);
        DiaPair rp = this.diameterBetter(node.right);

        DiaPair mp = new DiaPair();
        mp.height = Math.max(lp.height,rp.height)+1;
        mp.diameter = Math.max(lp.height+rp.height+2, Math.max(lp.diameter,rp.diameter));
        return mp;
    }
    public class DiaPair{
        int height;
        int diameter;

        DiaPair(){

        }
        DiaPair(int height, int diameter){
            this.height = height;
            this.diameter = diameter;
        }
    }


    public int sumLeaf(){
        return this.sumLeaf(this.root);
    }

    private int sumLeaf(Node node){
        if (node == null){
            return 0;
        }
        if(node.left == null && node.right== null){
            return node.data;
        }
        int lsum = sumLeaf(node.left);
        int rsum = sumLeaf(node.right);
        int ans = lsum + rsum;
        return ans;
    }
}


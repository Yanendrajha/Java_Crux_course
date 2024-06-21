import java.util.ArrayList;
import java.util.Scanner;

public class Generic_Tree {
    private class Node{
        int data;
        ArrayList<Node> children;
        Node(int data){
            this.data = data;
            this.children = new ArrayList<>();
        }
    }

    private Node root;
    private int size;

    Generic_Tree(){
        Scanner scn = new Scanner(System.in);
        this.root = TakeInput(scn,null,0);
    }

    // To take the input of generic tree.
    private Node TakeInput(Scanner scn, Node Parent, int ithchild){
        if (Parent == null){
            System.out.println("Enter the Data of the Root Node");
        }
        else{
            System.out.println("Enter the data for the "+ithchild+"th child of "+Parent.data);
        }
        int node_data = scn.nextInt();
        Node node = new Node(node_data);
        this.size++;

        System.out.println("Enter the Number of children for " +node.data+ " Node");
        int children  = scn.nextInt();


        // Will be executed According to the value of children
        for (int i = 0;i < children; i++){
            Node child = this.TakeInput(scn, node, i);
            node.children.add(child);
        }
        return node;



    }

    public void display() {
        this.display(this.root);
    }

    private void display (Node node){
        // Node data
        String str  = node.data+" =>";
        for (int i = 0; i<node.children.size();i++){
            // Add Children data of current node
            str = str + node.children.get(i).data+", ";
        }
        str = str +"END";

        //Display the String for the current node.
        System.out.println(str);

        // Display for all Nodes
        for (int i = 0; i<node.children.size();i++){
            this.display(node.children.get(i));
        }
    }

}

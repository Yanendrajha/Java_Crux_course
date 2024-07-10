public class Binary_Tree_Client {
    public static void main(String[] args){

        // Data = 50 true 25 true 38 false false true 48 true 18 false false false true 45 true 85 false false true 60 false false
        Binary_Tree B_tree = new Binary_Tree();
//        B_tree.display();
//        System.out.println("Height is "+ B_tree.height());
//        B_tree.preOrder();
//        B_tree.postOrder();
          B_tree.inOrder();
//        B_tree.levelOrder();
         System.out.println( B_tree.height());
//        System.out.println(B_tree.isBST());
//        System.out.println(B_tree.DiameterBetter());
        //System.out.println(B_tree.sumLeaf());
    }
}

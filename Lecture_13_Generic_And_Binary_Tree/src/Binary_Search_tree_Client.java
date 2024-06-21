public class Binary_Search_tree_Client {
    public static void main(String[] args){

        int[] in = {10,20,30,40,50,60,70};
        Binary_Search_Tree BT = new Binary_Search_Tree(in);
        BT.display();
        System.out.println(BT.find(10));
        System.out.println(BT.max());
        BT.add(55);
        BT.display();
        BT.remove(55);
        BT.display();
    }
}

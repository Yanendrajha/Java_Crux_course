public class LL_as_Stack_Client {
    public static void main(String[] args) throws Exception {
        LinkedList_As_Stack stack = new LinkedList_As_Stack();

        stack.push(10);
        stack.display();

        stack.push(20);
        stack.display();

        stack.push(30);
        stack.display();

        stack.push(40);
        stack.display();

        stack.push(50);
        stack.display();

        System.out.println(stack.pop());
        stack.display();
    }
}

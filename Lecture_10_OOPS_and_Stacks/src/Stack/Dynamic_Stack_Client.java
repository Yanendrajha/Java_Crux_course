package Stack;

public class Dynamic_Stack_Client {
    public static void main(String[] args) throws Exception {
        Stack_Using_Arrays stack = new Dynamic_Stack(5);

        for(int  i = 1; i<= 5; i++){
            stack.push(i*10);
            stack.display();
        }
        System.out.println(stack.top());


        stack.push(49);
        stack.push(68);
        while(!stack.isEmpty()){
            stack.display();
            stack.pop();
        }
    }
}

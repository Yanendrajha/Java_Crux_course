package Stack;

public class Stack_Using_Arrays_Client {
    public static void main(String[] args) throws Exception {
        Stack_Using_Arrays Stack = new Stack_Using_Arrays(6);
        Stack.push(30);
        Stack.top();
        Stack.push(45);
        Stack.push(67);
        Stack.display();
        Stack.pop();
        Stack.isEmpty();
        Stack.size();
        Stack.push(35);
        Stack.display();
    }
}

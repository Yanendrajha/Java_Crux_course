package Stack;

public class Reversing_Stack {
    public static void main(String[] args) throws Exception{
        Stack_Using_Arrays Stack = new Stack_Using_Arrays(5);
        Stack_Using_Arrays Helper = new Stack_Using_Arrays(5);

        for (int i = 1; i <= 5; i++){
            Stack.push(i*10);
        }
        Stack.display();
        reverse_stack(Stack,Helper,0);
        Stack.display();
    }

    public static void reverse_stack(Stack_Using_Arrays Stack, Stack_Using_Arrays Helper, int index) throws Exception{
        if(Stack.isEmpty()){
            return;
        }
        int item = Stack.pop();
        reverse_stack(Stack,Helper,index + 1);
        Helper.push(item);
        if(index == 0){
            while(!Helper.isEmpty()){
                Stack.push(Helper.pop());
            }
        }
    }
}

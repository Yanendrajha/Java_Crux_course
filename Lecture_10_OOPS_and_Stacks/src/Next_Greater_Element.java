import java.util.Stack;

public class Next_Greater_Element {
    public static void main(String[] args) throws Exception {
        int[] array = {2, 1, 3, 8, 6, 7, 5};

        Stack<Integer> stack = new Stack<>();

        for (int j : array) {
            while (!stack.isEmpty() && j > stack.peek()) {
                int poped = stack.pop();
                System.out.println(poped + " -> " + j);
            }
            stack.push(j);
        }
        while (!stack.isEmpty()){
            int poped = stack.pop();
            System.out.println(poped + " -> "+ -1);
        }
    }
}

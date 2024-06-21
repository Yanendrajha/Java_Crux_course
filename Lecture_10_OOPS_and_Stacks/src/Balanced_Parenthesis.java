import java.util.Stack;

public class Balanced_Parenthesis {
    public static void main(String[] args){
        String str = "{(a+b)+(c+d)}";
        System.out.println(isBalanced(str));
    }
    public static Boolean isBalanced(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ('{') || str.charAt(i) == ('[') || str.charAt(i) == ('(')) {
                stack.push(str.charAt(i));
            } else if (str.charAt(i) == ('}') || str.charAt(i) == (']') || str.charAt(i) == (')')) {
                if(stack.isEmpty()){
                    return false;
                }else if (str.charAt(i) =='}') {
                    if (stack.peek() == '{')
                        stack.pop();
                    else
                        return false;
                } else if (str.charAt(i) ==']'){
                        if (stack.peek() == '[')
                            stack.pop();
                        else
                            return false;
                }else if (str.charAt(i) ==')') {
                    if (stack.peek() == '(')
                        stack.pop();
                    else
                        return false;
                } else { // Do nothing
            }}}
        return stack.isEmpty();
}}

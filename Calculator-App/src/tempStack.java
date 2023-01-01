import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class tempStack {

    public static void main(String[] args){
        String string = "5+3×2×1×3+4×0.35";
        //String string = "3+2";
        char [] charArray = string.toCharArray();

        Stack stack = convertStack(charArray);

        Node tree = createTree(stack, true, true);
    }

    static void printTree(Node node){
        System.out.println(node.value);
        if(node.left != null){
            printTree(node.left);
        }
        System.out.println("Left is null");
        if(node.right != null){
            printTree(node.right);
        }
        System.out.println("Right is null");
    }

    static Stack convertStack(char [] charArray){
        Stack<Character> stack = new Stack<>();

        for(char i : charArray){
            stack.add(i);
        }
        return stack;
    }//If input is just a number, will recurse infinitely

    static Node createTree(Stack<Character> stack, boolean hasAdditive, boolean hasMultiplicative){
        //System.out.println(queue + " " + hasAdditive + " " + hasMultiplicative);
        Stack<Character> tempQueue = new Stack<>();
        if (hasAdditive){
            return checkAdditive(stack, tempQueue);
        } else if (hasMultiplicative){
            return checkMultiplicative(stack, tempQueue);
        } else{
            StringBuilder node = new StringBuilder();
            for (char tempChar : stack) {
                node.append(tempChar);
            }
            return new Node(node.toString());
        }
    }

    static Node checkAdditive(Stack<Character> stack, Stack<Character> rightStack){

        if(stack.size() == 1){
            return createTree(stack, false, false);
        } else {
            char lastVal = stack.pop();
            if(lastVal == '+' || lastVal == '-'){
                Queue<Character> tempQueue = new ArrayDeque<>();
                Node node = new Node(String.valueOf(lastVal));
                node.right = createTree(rightStack, false, true);
                node.left = createTree(stack, true, true);

                return node;
            } else {
                rightStack.add(0, lastVal);
                return checkAdditive(stack, rightStack);
            }
        }
    }

    static Node checkMultiplicative(Stack<Character> stack, Stack<Character> rightStack){
        //Node node = null;

        if(stack.size() == 1){
            return createTree(stack, false, false);
        } else {
            char lastVal = stack.pop();
            if(lastVal == '×' || lastVal == '÷'){
                Node node = new Node(String.valueOf(lastVal));
                node.right = createTree(rightStack, false, false);
                node.left = createTree(stack, false, true);

                return node;
            } else {
                rightStack.add(0, lastVal);
                return checkMultiplicative(stack, rightStack);
            }
        }
    }
}

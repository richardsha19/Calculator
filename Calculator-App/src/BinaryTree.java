import java.util.Stack;

// Creates a definition for the Node class that contains a left subnode and right subnode.
class Node {
    String value;
    Node left;
    Node right;

    Node(String value) {
        this.value = value;
        right = null;
        left = null;
    }
}

public class BinaryTree {
    Node BinaryTreeRepresentation;

    // Creating a new class BinaryTree
    BinaryTree(String userInput){
        BinaryTreeRepresentation = wrapper(userInput);
    }

    // Wrapper function that creates a stack representation of the user input.
    static Node wrapper(String userInput){
        Stack<Character> stackRepresentation = convertStack(userInput.toCharArray());

        return createTree(stackRepresentation, true, true);
    }

    // Prints out the values of the tree for testing purposes
    public static void printTree(Node node){
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

    // Converts the character array representation of the user input into a stack
    static Stack<Character> convertStack(char [] charArray){
        Stack<Character> stack = new Stack<>();

        for(char i : charArray){
            stack.add(i);
        }
        return stack;
    }

    // Creates the binary tree representation of the user input
    static Node createTree(Stack<Character> stack, boolean hasAdditive, boolean hasMultiplicative){
        // Creates temporary stack to be used in the checkAdditive and checkMultiplicative functions
        Stack<Character> tempStack = new Stack<>();
        // hasAdditive and hasMultiplicative returns true if there is the possibility that the particular branch
        // represented by stack (before it is processed into a Node) contains addition or subtraction via hasAdditive,
        // or multiplication or division via hasMultiplicative.
        if (hasAdditive){
            // Since addition and subtraction are calculated last via rules of bedmas, addition and subtraction
            // nodes need to appear as ancestors of multiplication nodes.
            return checkAdditive(stack, tempStack);
        } else if (hasMultiplicative){
            return checkMultiplicative(stack, tempStack);
        } else{
            // If the stack does not contain all four possible operators, that means all that are left are numbers,
            // which we append together for processing.
            StringBuilder node = new StringBuilder();
            for (char tempChar : stack) {
                node.append(tempChar);
            }
            return new Node(node.toString());
        }
    }

    static Node checkAdditive(Stack<Character> stack, Stack<Character> rightStack){

        // If the end of the stack has been reached, then that means that if there are no errors in the math input, then
        // the values contained in rightStack contains no addition or subtraction operators.
        if(stack.size() == 0){
            return createTree(rightStack, false, true);
        } else {
            // pops the last value from the stack
            char lastVal = stack.pop();
            if(lastVal == '+' || lastVal == '-'){
                // if the value is addition or subtraction sign, then assigns that symbol to the root, and processes
                // the left and right of the stack for further building of the trees. In this case, it is impossible for
                // rightStack to have either addition or subtraction symbol, so hasAdditive is set to false for when
                // creating the right subtree
                Node node = new Node(String.valueOf(lastVal));
                node.right = createTree(rightStack, false, true);
                node.left = createTree(stack, true, true);

                return node;
            } else {
                // If the lastValue is not addition or subtraction, then we add the last value as the first index in
                // rightStack
                rightStack.add(0, lastVal);
                return checkAdditive(stack, rightStack);
            }
        }
    }

    static Node checkMultiplicative(Stack<Character> stack, Stack<Character> rightStack){

        // Same ideas as checkAdditive function, except in this case hasAdditive is always false since checkMultiplicative
        // is applied after hasAdditive.
        if(stack.size() == 0){
            return createTree(rightStack, false, false);
        } else {
            char lastVal = stack.pop();
            if(lastVal == '×' || lastVal == '÷'){
                Node node = new Node(String.valueOf(lastVal));
                // Similarly to checkAdditive, it is impossible for the rightStack to have either the multiplication or
                // division symbol, so hasMultiplicative is set to false.
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

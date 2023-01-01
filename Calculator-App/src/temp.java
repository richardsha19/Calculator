import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;



public class temp {

    public static void main(String[] args){
        String string = "5+3×2×1×3+4×5";
        //String string = "3+2";
        char [] charArray = string.toCharArray();

        Queue queue = convertQueue(charArray);

        Node tree = createTree(queue, true, true);
        System.out.println(tree.right.value);
        //printTree(tree);
        //System.out.println(tree.left.right.left.left.left.value);
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

    static Queue convertQueue(char [] charArray){
        Queue<Character> queue = new ArrayDeque<>();

        for(char i : charArray){
            queue.add(i);
        }

        return queue;
    }//If input is just a number, will recurse infinitely

    static Node createTree(Queue<Character> queue, boolean hasAdditive, boolean hasMultiplicative){
        System.out.println(queue + " " + hasAdditive + " " + hasMultiplicative);
        LinkedList<Character> tempQueue = new LinkedList<>();
        if (hasAdditive){
            return checkAdditive(queue, tempQueue);
        } else if (hasMultiplicative){
            return checkMultiplicative(queue, tempQueue);
        } else{
            StringBuilder node = new StringBuilder();
            for (char tempChar : queue) {
                node.append(tempChar);
            }
            return new Node(node.toString());
        }
    }

    static Node checkAdditive(Queue<Character> queue, LinkedList<Character> rightQueue){

        if(queue.size() == 1){
            return createTree(queue, false, false);
        } else {
            char lastVal = queue.poll();
            if(lastVal == '+' || lastVal == '-'){
                Queue<Character> tempQueue = new ArrayDeque<>();
                Node node = new Node(String.valueOf(lastVal));
                node.right = createTree(rightQueue, false, true);
                node.left = createTree(queue, true, true);

                return node;
                //System.out.println(node.left + " " + node.value + " " + node.right);
            } else {
                rightQueue.add(0, lastVal);
                return checkAdditive(queue, rightQueue);
            }
        }
    }

    static Node checkMultiplicative(Queue<Character> queue, LinkedList<Character> rightQueue){
        //Node node = null;

        if(queue.size() == 1){
            return createTree(queue, false, false);
        } else {
            char lastVal = queue.poll();
            if(lastVal == '×' || lastVal == '÷'){
                Node node = new Node(String.valueOf(lastVal));
                node.right = createTree(rightQueue, false, false);
                node.left = createTree(queue, false, true);

                return node;
                //System.out.println(node.left + " " + node.value + " " + node.right);
            } else {
                rightQueue.add(0, lastVal);
                return checkMultiplicative(queue, rightQueue);
            }
        }
    }
}
//×
//÷
//+
//-
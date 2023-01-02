public class EqualsButton {
    public static float calculateValue(String input){
        // Creates a binary tree representation of the string input
        BinaryTree BT = new BinaryTree(input);
        Node tree = BT.BinaryTreeRepresentation;

        return calculateTree(tree);
    }

    static float calculateTree(Node BT){

        // Depending on the value of the root of the Node of the binary tree, either return the multiplication,
        // division, addition or subtraction of the values of the left and right subtrees, or return the value of the
        // node (if the value is a number, which means that it is at the leaves of the tree)
        return switch (BT.value) {
            case "×" -> (calculateTree(BT.left) * calculateTree(BT.right));
            case "÷" -> (calculateTree(BT.left) / calculateTree(BT.right));
            case "+" -> (calculateTree(BT.left) + calculateTree(BT.right));
            case "-" -> (calculateTree(BT.left) - calculateTree(BT.right));
            default -> Float.parseFloat(BT.value);
        };
    }
}

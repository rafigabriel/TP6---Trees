public class App {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(new Node(30));
        tree.insert(new Node(10));
        tree.insert(new Node(15));
        tree.insert(new Node(14));
        tree.insert(new Node(19));
        tree.countNode();
        tree.countFathers();
        tree.countLeafNodes();
        tree.treeHeight();
    }
}

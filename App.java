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
        tree.inOrder();
        System.out.println("===============================================================================");
        tree.removePairs();
        System.out.println("Tree after using the method 'removePairs': ");
        tree.inOrder();
        tree.mirrorTree();
        System.out.println("===============================================================================");
        System.out.println("Tree after using the method 'mirrorTree': ");
        tree.inOrder();
    
    }
}

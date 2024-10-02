public class App {
    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.insert(new Node(18));
        tree.insert(new Node(17));
        tree.insert(new Node(4));
        tree.insert(new Node(3));
        tree.insert(new Node(10));
        tree.insert(new Node(11));
        tree.insert(new Node(7));
        tree.insert(new Node(6));
        tree.insert(new Node(8));
        tree.insert(new Node(9));
        tree.countNode();
        tree.countFathers();
        tree.countLeafNodes();
        tree.treeHeight();
        tree.inOrder();
        tree.removePairs();
        System.out.println("===============================================================================");
        System.out.println("Tree after using the method 'removePairs': ");
        tree.inOrder();
        tree.mirrorTree();
        System.out.println("===============================================================================");
        System.out.println("Tree after using the method 'mirrorTree': ");
        tree.inOrder();
        
        System.out.println("===============================================================================");
        System.out.println("Question 7:");
        tree.inOrder();
        System.out.println("===============================================================================");
        tree.preOrder();
        System.out.println("===============================================================================");
        tree.postOrder();
    }
}

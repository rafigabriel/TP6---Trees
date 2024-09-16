public class BinaryTree {
    Node root;
   
    public BinaryTree() {
        root = null;
    }

    private Node newInsert(Node newNode, Node current) {
        if (current == null) {
            return newNode;
        }
        if (current.getValue() > newNode.getValue()) {
            current.setLeft(newInsert(newNode, current.getLeft()));
        } else {
            current.setRight(newInsert(newNode, current.getRight()));
        }
        return current;
    }

    void insert(Node newNode) {
        root = newInsert(newNode, root);
    }

    void preOrder() {
        preOrder(root);
    }

    void inOrder(){
        inOrder(root);
    }

    void postOrder(){
        postOrder(root);
    }

    private void preOrder(Node element) {
        if (element != null) {
            System.out.println("Element: " + element.getValue());// ROOT
            preOrder(element.getLeft());// LEFT
            preOrder(element.getRight());// RIGHT
        }
    }

    private void inOrder(Node element) {
        if (element != null) {
            inOrder(element.getLeft());// LEFT
            System.out.println("Element: " + element.getValue());// ROOT
            inOrder(element.getRight());// RIGHT
        }
    }

    private void postOrder(Node element) {
        if (element != null) {
            postOrder(element.getLeft());// LEFT
            postOrder(element.getRight());// RIGHT
            System.out.println("Element: " + element.getValue());// ROOT
        }
    }

    public boolean remove(int value) {
        if (root == null) {
            return false;
        } else {
            Node fatherNode;
            Node sonNode;
            if (root.getValue() == value) {
                fatherNode = root;
                sonNode = root;
            } else {
                fatherNode = findFatherNode(root, value);
                if (fatherNode.getValue() < value) {
                    sonNode = fatherNode.getRight();
                } else {
                    sonNode = fatherNode.getLeft();
                }
            }
            if (sonNode.getRight() == null && sonNode.getLeft() == null) {
                if (fatherNode.getValue() < value) {
                    fatherNode.setRight(null);
                } else {
                    fatherNode.setLeft(null);
                }
                return true;
            } else if (sonNode.getRight() != null && sonNode.getLeft() != null) {
                Node nodeFatherRightLeft = farLeftNode(sonNode, sonNode.getRight());
                Node substitute = nodeFatherRightLeft.getLeft();
                nodeFatherRightLeft.setLeft(null);
                substitute.setRight(sonNode.getRight());
                substitute.setLeft(sonNode.getLeft());
                sonNode.setLeft(null);
                sonNode.setRight(null);
                if (fatherNode.getValue() < value) {
                    fatherNode.setRight(substitute);
                } else {
                    fatherNode.setLeft(substitute);
                }
            } else {
                if (sonNode.getRight() == null) {
                    if (fatherNode.getValue() > value) {
                        fatherNode.setLeft(sonNode.getLeft());
                    } else {
                        fatherNode.setRight(sonNode.getRight());
                    }
                }
                if (sonNode.getLeft() == null) {
                    if (fatherNode.getValue() > value) {
                        fatherNode.setLeft(sonNode.getRight());
                    } else {
                        fatherNode.setRight(sonNode.getRight());
                    }
                }
                return true;
            }
            return false;
        }
    }

    public Node search(int value){
        return search(root, value);
    }

    private Node search(Node current, int value){
        if(current == null){
            return null;
        }

        if(current.getValue() == value){
            return current;
        }

        if(current.getValue() < value){
            return search(current.getRight(), value);
        }
        if(current.getValue() > value){
            return search(current.getLeft(), value);
        }
        return current;
    }

    public Node findFatherNode(Node current, int value) {
        if (current == null) {
            return null;
        }
        if (value > current.getValue()) {
            if (current.getRight() != null) {
                if (current.getRight().getValue() == value) {
                    return current;
                }
            }

        } else {
            if (current.getLeft() != null) {
                if (current.getLeft().getValue() == value) {
                    return current;
                }
            }
        }
        if (current.getValue() > value) {
            return findFatherNode(current.getLeft(), value);
        }
        if (current.getValue() < value) {
            return findFatherNode(current.getRight(), value);
        }
        return null;
    }

    private Node farLeftNode(Node fatherNode, Node currentSonNode) {
        if (currentSonNode.getLeft() == null) {
            return fatherNode;
        }
        return farLeftNode(currentSonNode, currentSonNode.getLeft());
    }

    private int countNode(Node current){
        if(current == null){
            return 0;
        }
        else{
            return 1 + countNode(current.getLeft()) + countNode(current.getRight());
        }
    }

    private int countFathers(Node current){
        if(current == null){
            return 0;
        }
        else if(current.getLeft() == null && current.getRight() == null){
            return 0;
        }
        else{
            return 1 + countFathers(current.getLeft()) + countFathers(current.getRight());
        }
    
    }

    private int countLeafNodes(Node current){
        if(current == null){
            return 0;
        }
        else if (current.getLeft() == null && current.getRight() == null) {
            return 1;
        }
        else{
            return countLeafNodes(current.getLeft()) + countLeafNodes(current.getRight());
        }
    }

    private int treeHeight(Node current){
        if(current == null){
            return 0;
        }
        else{
            int leftHeight = treeHeight(current.getLeft());
            int rightHeight = treeHeight(current.getRight());

            return 1 + Math.max(leftHeight, rightHeight);
        }
    }

    void countNode(){
        System.out.println("This tree contains " + countNode(root) + " nodes.");
    }

    void countFathers(){
        System.out.println("This tree contains " + countFathers(root) + " non-leaf nodes.");
    }

    void countLeafNodes(){
        System.out.println("This tree contains " + countLeafNodes(root) + " leaf nodes.");
    }

    void treeHeight(){
        System.out.println("The height of this tree is " + treeHeight(root) + ".");
    }
}
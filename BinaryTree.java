/**
 * A classe BinaryTree representa uma árvore binária que permite a inserção de
 * nós,
 * percursos em pré-ordem, em ordem e pós-ordem, remoção de nós, e várias
 * operações
 * sobre a árvore, como contagem de nós, altura da árvore, e espelhamento da
 * estrutura da árvore.
 */

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

    void inOrder() {
        inOrder(root);
    }

    void postOrder() {
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
    
    /**
     * Remove um nó da árvore binária com o valor especificado.
     * 
     * @param value O valor do nó a ser removido.
     * @return true se o nó foi removido com sucesso, false caso contrário.
     */

    // O código faz a remoção de diferentes casos: folha, um filho, dois filhos.
    public boolean remove(int value) {
        if (root == null) {
            return false;
        }
        else {
            Node fatherNode;
            Node sonNode;
            if (root.getValue() == value) {
                fatherNode = root;
                sonNode = root;
                if (root.getLeft() == null && root.getRight() == null) {
                    root = null;
                } else if (root.getLeft() == null) {
                    root = root.getRight();
                } else if (root.getRight() == null) {
                    root = root.getLeft();
                } else {
                    Node nodeFatherRightLeft = farLeftNode(root, root.getRight());
                    Node substitute = nodeFatherRightLeft.getRight();
                    substitute.setLeft(root.getLeft());
                    nodeFatherRightLeft.setLeft(null);
                    root = substitute;
                }
                return true;
            }

            fatherNode = findFatherNode(root, value);
            if (fatherNode == null) {
                return false;
            }
            if (fatherNode.getValue() < value) {
                sonNode = fatherNode.getRight();
            }
            else{
                sonNode = fatherNode.getLeft();
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
                nodeFatherRightLeft.setLeft(substitute.getLeft());
                substitute.setRight(sonNode.getRight());
                substitute.setLeft(sonNode.getLeft());
                sonNode.setRight(null);
                sonNode.setLeft(null);
                if (fatherNode.getValue() < value) {
                    fatherNode.setRight(substitute);
                }
                else {
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
            }
            return true;
        }
        

    }

    public Node search(int value) {
        return search(root, value);
    }

    private Node search(Node current, int value) {
        if (current == null) {
            return null;
        }

        if (current.getValue() == value) {
            return current;
        }

        if (current.getValue() < value) {
            return search(current.getRight(), value);
        }
        if (current.getValue() > value) {
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

    //=================================================================================================================================================================================
    //===============================================================TP 6 ATIVIDADES===================================================================================================
    //=================================================================================================================================================================================


    //QUESTÃO 1

    /**
     * Conta o número total de nós na árvore.
     * 
     * @param current O nó atual.
     * @return O número total de nós.
     */
    private int countNode(Node current) {
        if (current == null) {
            return 0;
        } else {
            //Retorna 1 para o nó atual, mais 0(caso nao haja mais filhos do nó atual) ou 1(caso o nó atual tenha filho.), recursivamente.
            return 1 + countNode(current.getLeft()) + countNode(current.getRight());
        }
    }

    //QUESTÃO 2

    /**
     * Conta o número de nós não-folha (nós que têm pelo menos um filho).
     * 
     * @param current O nó atual.
     * @return O número de nós não-folha.
     */
    private int countFathers(Node current) {
        if (current == null) {
            return 0;
        } else if (current.getLeft() == null && current.getRight() == null) {
            return 0;//Retorna 0 também quando achar algum nó folha, que não é o que estamos procurando aqui.
        } else {
            // Retorna 1 para o nó atual, mais 0 ou 1 no caso de algum filho. 
            return 1 + countFathers(current.getLeft()) + countFathers(current.getRight());
        }

    }

    //QUESTÃO 3

    /**
     * Conta o número de nós folha (nós que não têm filhos).
     * 
     * @param current O nó atual.
     * @return O número de nós folha.
     */
    private int countLeafNodes(Node current) {
        if (current == null) {
            return 0;
        } else if (current.getLeft() == null && current.getRight() == null) {
            return 1;//Retorna 1 e vai somando quando achar algum nó que não nenhum filho.
        } else {
            return countLeafNodes(current.getLeft()) + countLeafNodes(current.getRight());
            //Percorre as sub-arvores recursivamente.
        }
    }

    //QUESTÃO 4

    /**
     * Calcula a altura da árvore a partir de um determinado nó.
     * 
     * @param current O nó atual.
     * @return A altura da árvore.
     */
    private int treeHeight(Node current) {
        if (current == null) {
            return 0;
        } else {
            //Armazena o tamanho da esquerda da árvore em duas variáveis. 
            int leftHeight = treeHeight(current.getLeft());
            int rightHeight = treeHeight(current.getRight());

            //Retorna 1 mais o valor da altura que for maior entre a esquerda e a direita.
            return 1 + Math.max(leftHeight, rightHeight);
        }
    }

    //QUESTÃO 5

    /**
     * Remove todos os nós que contêm valores pares da árvore.
     */
    private void removePairs(Node current) {
        if (current == null) {
            return;
        }
        // Passa a esquerda e a direita do nó raiz para ir percorrendo ambos os lados.
        removePairs(current.getLeft());
        removePairs(current.getRight());
        // Se encontrar algum valor que seja par, chama o método de remoçao da árvore,
        // que já trata de casos se esse nó tiver 1 filho, 2 filhos, nenhum filho
        // ou se o nó for a raiz.
        if (current.getValue() % 2 == 0) {
            remove(current.getValue());
        }
    }

    //QUESTÃO 6

    /**
     * Espelha a estrutura da árvore invertendo os filhos à esquerda e à direita.
     */
    private void mirrorTree(Node current) {
        if (current == null) {
            return;
        }
        Node left = current.getLeft();
        Node right = current.getRight();
        current.setLeft(right);
        current.setRight(left);
        mirrorTree(right);
        mirrorTree(left);
        //É criado dois nós auxiliares  que recebem o conteúdo armazenado a esquerda e a direita da raiz. 
        //Após, a esquerda da raiz é apontado para a direita e vice e versa. 
        //Após isso o método é chamado recursivamente percorrendo as sub-árvores.
    }

    void removePairs() {
        removePairs(root);
    }

    void countNode() {
        System.out.println("This tree contains " + countNode(root) + " nodes.");
    }

    void countFathers() {
        System.out.println("This tree contains " + countFathers(root) + " non-leaf nodes.");
    }

    void countLeafNodes() {
        System.out.println("This tree contains " + countLeafNodes(root) + " leaf nodes.");
    }

    void treeHeight() {
        System.out.println("The height of this tree is " + treeHeight(root) + ".");
    }

    void mirrorTree() {
        mirrorTree(root);
    }
}
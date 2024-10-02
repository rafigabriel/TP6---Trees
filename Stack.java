public class Stack {
    private Node top;

    public Node getTop() {
        return top;
    }

    public void setTop(Node top) {
        this.top = top;
    }

    public Stack() {
        this.top = null;
    }

    public void push(Node item) {
        item.setNext(top);
        top = item;
    }

    public Node pop() {
        if (empty()) {
            return null;
        }
        else {
            Node temp = top;
            top = top.getNext();
            temp.setNext(null);
            return temp;
        }
    }
    
    public boolean empty() {
        return (top == null);
    }
    
}

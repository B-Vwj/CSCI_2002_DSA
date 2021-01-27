package node;

public class DLNode<T> {

    private T data;
    private DLNode<T> prevNode;
    private DLNode<T> nextNode;

    public DLNode(T data) {
        setData(data);
    }

    public DLNode<T> getNextNode() {
        return nextNode;
    }

    public DLNode<T> getPrevNode() {
        return prevNode;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNextNode(DLNode<T> nextNode) {
        this.nextNode = nextNode;
    }

    public void setPrevNode(DLNode<T> prevNode) {
        this.prevNode = prevNode;
    }

    public boolean hasPrev() {
        if (getPrevNode() != null) {
            return true;
        }
        return false;
    }

    public boolean hasNext() {
        if (getNextNode() != null) {
            return true;
        }
        return false;
    }
}

package ss;

import ss.SpecializedStructure;
import pub.DynamicList;
import pub.QueueIdea;

public class Queue<E> extends SpecializedStructure<E> implements QueueIdea<E> {

    // Constructors
    public Queue(DynamicList elements) {
        setElements(elements);
    }

    // Methods/Functions
    @SuppressWarnings("unchecked")
    public void enqueue(E elem) {
        getElements().addLast(elem);
    }

    @SuppressWarnings("unchecked")
    public E dequeue() throws RuntimeException {
       return getElements().removeFirst();
    }

    public E peek() {
        return getElements().first();
    }
}
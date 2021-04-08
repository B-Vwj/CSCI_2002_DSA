package ss;

import ss.SpecializedStructure;
import pub.DynamicList;
import pub.DequeIdea;

public class Dequeue<E> extends SpecializedStructure<E> implements DequeIdea<E> {

    public Dequeue(DynamicList elements) {
        setElements(elements);
    }

    @SuppressWarnings("unchecked")
    public E first() throws RuntimeException {
        return getElements().first();
    }

    @SuppressWarnings("unchecked")
    public E last() throws RuntimeException {
        return getElements().last();
    }

    @SuppressWarnings("unchecked")
    public void addFirst(E newElem) {
        getElements().addFirst(newElem);
    }

    @SuppressWarnings("unchecked")
    public void addLast(E newElem) {
        getElements().addLast(newElem);
    }

    @SuppressWarnings("unchecked")
    public E removeFirst() throws RuntimeException {
        return getElements().removeFirst();
    }

    @SuppressWarnings("unchecked")
    public E removeLast() throws RuntimeException {
        return getElements().removeLast();
    }

}
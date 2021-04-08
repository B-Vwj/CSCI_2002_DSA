package ss;

import pub.StackIdea;
import pub.DynamicList;
import ss.SpecializedStructure;

public class Stack<E> extends SpecializedStructure<E> implements StackIdea<E> {

    // Constructor
    public Stack(DynamicList elements) {
        setElements(elements);
    }

    // Methods/Functions
    public void push(E newElem) {
        getElements().add(newElem);
    }

    public void add(E newElem) {getElements().add(newElem);}

    public E pop() throws RuntimeException {
        return getElements().removeFirst();
    }

    public E peek() {
        return getElements().first();
    }
}
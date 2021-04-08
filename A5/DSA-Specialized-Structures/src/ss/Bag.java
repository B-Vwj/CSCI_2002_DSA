package ss;

import pub.BagIdea;
import pub.DynamicList;
import java.util.function.Function;

public class Bag<E> extends SpecializedStructure<E> implements BagIdea<E> {

    // Constructor
    public Bag(DynamicList elements) {
        setElements(elements);
    }

    // Methods/Functions
    @SuppressWarnings("unchecked")
    public boolean contains(Function<E, Boolean> elem) {
        int index = getElements().find(elem); // returns int
        return elem == getElements().get(index); // returns E then checks boolean
    }

    public E any() throws RuntimeException {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        return getElements().get(0);
    }

    public void add(E elem) {
        getElements().add(elem);
    }

    @SuppressWarnings("unchecked")
    public E remove(Function<E, Boolean> elem) {
        return getElements().remove(elem);
    }
}
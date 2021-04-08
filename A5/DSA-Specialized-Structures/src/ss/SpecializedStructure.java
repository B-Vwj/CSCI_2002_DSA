package ss;

import pub.SpecializedStructureIdea;
import pub.DynamicList;
import java.util.List;

public class SpecializedStructure<E> implements SpecializedStructureIdea<E> {
    private DynamicList elements;

    public SpecializedStructure() {
        this.elements = null;
    }

    public SpecializedStructure(DynamicList elements) {
        setElements(elements);
    }

    @SuppressWarnings("unchecked")
    public void setElements(DynamicList elements) {
        this.elements = elements;
    }

    public DynamicList<E> getElements() {
        return this.elements;
    }

    public int size() {
        return this.elements.size();
    }

    public boolean isEmpty() {
        return this.elements.isEmpty();
    }

    @SuppressWarnings("unchecked")
    public void add(E elem) {
        this.elements.add(elem);
    }

    public void removeAll() {
        this.elements.removeAll();
    }

    @SuppressWarnings("unchecked")
    public List<E> toJavaList() {
        return this.elements.toJavaList();
    }

    public String toString() {
        return this.elements.toString();
    }

}
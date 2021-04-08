package dynarray;

import linkedlist.*;
import java.util.function.Function;
import linearpub.DynamicList;
import java.util.Collections;
import java.util.ArrayList;
import java.util.List;

public class DynArr<E> implements DynamicList<E> {
    private E[] elements;
    private int aGrowthFactor;
    private int size;

    // Constructors
    @SuppressWarnings("unchecked")
    public DynArr() {
        //Set initial capacity to 10, and growth factor to 2
        this.elements = (E[]) new Object[10];
        this.aGrowthFactor = 2;
        this.size = 0;
    }

    @SuppressWarnings("unchecked")
    public DynArr(int capacity, int aGrowthFactor) {
        //Set initial capacity to 10, and use passed growth factor param
        this.elements = (E[]) new Object[capacity];
        this.aGrowthFactor = aGrowthFactor;
        this.size = capacity;
    }

    // Methods
    @SuppressWarnings("unchecked")
    public void append(E element) {
        if (!hasCapacity()) {
            grow();
        }
        this.elements[size] = element;
        size++;
        return;
    }

    public void add(E newElem) {
        if (!hasCapacity()) {
            grow();
        }

        this.elements[size] = newElem;
        size++;
        return;
    }

    @SuppressWarnings("unchecked")
    public boolean hasCapacity() {
        return this.size < this.elements.length;
    }

    @SuppressWarnings("unchecked")
    public void grow() {
        int newCapacity = (this.aGrowthFactor * this.elements.length);
        E[] newArr = (E[]) new Object[newCapacity];
        E[] array = copyElements(newArr);
        this.elements = array;
        this.size = size * newCapacity;
        return;
    }

    @SuppressWarnings("unchecked")
    public E[] copyElements(E[] array) {
        for (int i = 0; i < (size - 1); i++) {
            E element = this.elements[i];
            array[i] = element;
        }
        return array;
    }

    @SuppressWarnings("unchecked")
    public void insert(int index, E elem) throws IndexOutOfBoundsException {
        if (!hasCapacity()) {
            grow();
        }
        shiftRight(index);
        this.elements[index] = elem;
        size++;
    }

    @SuppressWarnings("unchecked")
    public void shiftRight(int index) {
        for (int i = this.elements.length; i > index; i--) {
            this.elements[i + 1] = elements[i];
        }
        return;
    }

    @SuppressWarnings("unchecked")
    public E getElem(int index) throws IndexOutOfBoundsException {
        return this.elements[index];
    }

    // Extras
    public int size() {
        return this.size;
    }

    public E remove(Function<E, Boolean> searchFct) {
        for (int i = 0; i < size; i++) {
            if (searchFct.apply(getElem(i))) {
                E tempElem = elements[i];
                elements[i] = null;
                shiftRight(i);
                return tempElem;
            }
        }
        return null;
    }

    public E removeLast() throws RuntimeException {
        E tempElem = elements[size - 1];
        elements[size - 1] = null;
        return tempElem;
    }

    public E removeFirst() throws RuntimeException {
        E tempElem = elements[0];
//        elements[0] = null;
        for (int i = 0; i < size; i++) {
            elements[i] = elements[i + 1];
        }
        return tempElem;
    }

    public E first() throws RuntimeException {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        return elements[0];
    }

    public E last() throws RuntimeException {
        if (isEmpty()) {
            throw new RuntimeException();
        }
        return elements[(size - 1)];
    }

    public boolean isEmpty() {
        return elements[0] == null;
    }

    public E get(int index) {
        return elements[index];
    }

    public DynamicList<E> subList(int start, int stop) throws IndexOutOfBoundsException {
        DynamicList<E> list = new LinkedList<>(); // New List
        E tempElem = elements[start];
        int count = (stop - start);

        if (isEmpty()) {
            throw new IndexOutOfBoundsException();
        }

        list.add(tempElem);
//        for (int i = 0; i <= count; i++) {
//            start++;
//            tempElem = elements[start];
//            list.add(tempElem);
//        }

        while (tempElem != null) {
            start++;
            tempElem = elements[start];
            list.add(tempElem);
        }

        // Return Dynamic List
        return list;
    }

    public int find(Function<E, Boolean> searchFct) {
        int i = 0;
        E elem = elements[0];
        while (elem != null) {
         if (searchFct.apply(getElem(i)))
             return i;
        }
        return -1;
    }

    public void addFirst(E newElem) {
        if (isEmpty()) {
            this.elements[0] = newElem;
            size++;
        }
        shiftRight(0);
        this.elements[size] = newElem;
        return;
    }

    public void addLast(E newElem) {
        if (isEmpty()) {
            this.elements[0] = newElem;
            size++;
        }
        this.elements[(size + 1)] = newElem;
        return;
    }

    public E removeIndex(int index) throws IndexOutOfBoundsException {
//        E data = get(index);
//        LinkedList<E> ll = new LinkedList<>();
//        DLNode<E> node1 = ll.getFirstNode();
//        DLNode<E> node2 = null;
//        DLNode<E> node3 = null;
//        int i = 0;
//
//        while (node1 != null) {
//            if (i == index) {
//                if (node1.getPrevNode() != null) {
//                    node2 = node1.getPrevNode();
//                }
//
//                if (node1.getNextNode() != null) {
//                    node3 = node1.getNextNode();
//                }
//
//                node2.setNextNode(node3);
//                node3.setPrevNode(node2);
//                return node1.getData();
//            }
//            node1 = node1.getNextNode();
//            i++;
//        }
        return null;
    }

    public void removeAll() {
        if (isEmpty()) {
            return;
        }
        // TODO

    }

    public List<E> toJavaList() {
        List<E> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(elements[i]);
        }
        return list;
    }

}
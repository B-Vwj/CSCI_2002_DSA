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
        this.size = 0;
    }

    // Methods
    public void append(E element) {
        if (!hasCapacity()) {
            grow();
        }
        elements[size] = element;
        size++;
        return;
    }

    public boolean hasCapacity() {
        return this.size < this.elements.length;
    }

    @SuppressWarnings("unchecked")
    public void grow() {
        int newCapacity = (this.aGrowthFactor * this.elements.length);
        E[] newArr = (E[]) new Object[newCapacity];
        E[] array = copyElements(newArr);
        this.elements = array;
        return;
    }

    public E[] copyElements(E[] array) {
        for (int i = 0; i < (size - 1); i++) {
            E element = this.elements[i];
            array[i] = element;
        }
        return array;
    }

    public void insert(int index, E elem) throws IndexOutOfBoundsException {
        if (!hasCapacity()) {
            grow();
        }
        shiftRight(index);
        this.elements[index] = elem;
        size++;
    }

    public void shiftRight(int index) {
        for (int i = this.elements.length; i > index; i--) {
            E element = elements[i - 1];
            this.elements[i] = element;
        }
        return;
    }

    public E getElem(int index) throws IndexOutOfBoundsException {
        return this.elements[index];
    }

    // Extras
    public int size() {
        LinkedList<E> ll = new LinkedList<>();
        if (ll.isEmpty()) {
            return 0;
        }

        // Loop with a counter (i) that increments until `node.nextNode()` is null
        int i = 0;
        DLNode<E> node = ll.getFirstNode();
        while (node != null) {
            i++;
            node = node.getNextNode();
        }
        return i;
    }

    public E remove(Function<E, Boolean> searchFct) {
        // Create Linked List
        LinkedList<E> ll = new LinkedList<>();

        // Then set "node" to the last node of that list to resolve the issue
        DLNode<E> node = ll.getFirstNode();
        DLNode<E> node2 = null;
        DLNode<E> node3 = null;
        E data = null;
        int i = 0;

        while (node != null) {
            if (searchFct.apply(node.getData())) {
                node2.setNextNode(node.getNextNode());
                node3.setPrevNode(node.getPrevNode());

                data = node.getData();
                return data;
            }
            i++;
            node = node.getNextNode();
        }
        return data;
    }

    public E removeLast() throws RuntimeException {
        LinkedList<E> ll = new LinkedList<>();
        DLNode<E> node1 = ll.getLastNode();
        E data = node1.getData();

        if (node1.getPrevNode() == null) {
            node1 = null;
            return data;
        }

        DLNode<E> node2 = node1.getPrevNode();
        node2.setNextNode(null);
        node1.setPrevNode(null);
        node1 = null;
//        this.lastNode = node2;
        ll.setLastNode(node2);
        return data;
    }

    public E removeFirst() throws RuntimeException {
        LinkedList<E> ll = new LinkedList<>();
        DLNode<E> node1 = ll.getFirstNode();
//        DLNode<E> node1 = this.firstNode;
        E data = node1.getData();

        if (node1.getNextNode() == null) {
            node1 = null;
            return data;
        }

        DLNode<E> node2 = node1.getNextNode();
        node1.setNextNode(null);
        node2.setPrevNode(null);
        node1 = null;
//        this.firstNode = node2;
        ll.setFirstNode(node2);
        return data;
    }

//    public void insert(int index, E newElem) throws IndexOutOfBoundsException {
//        int i = 0;
//        LinkedList<E> ll = new LinkedList<>();
//        DLNode<E> node1 = ll.getFirstNode();
////        DLNode<E> node1 = this.firstNode;
//        DLNode<E> node2 = new DLNode<>(newElem);
//        while (node1 != null) {
//            if (i == index) {
//                DLNode<E> node3 = node1.getNextNode();
//                node1.setNextNode(node2);
//                node3.setPrevNode(node2);
//                node2.setPrevNode(node1);
//                node2.setNextNode(node3);
//                return;
//            }
//            node1 = node1.getNextNode();
//            i++;
//        }
//    }

    public E first() {
        LinkedList<E> ll = new LinkedList<>();
        if (ll.isEmpty() == true) {
            return null;
        }
        return ll.getFirstNode().getData();
    }

    public E last() {
        LinkedList<E> ll = new LinkedList<>();
        if (ll.isEmpty()) {
            return null;
        }
        return ll.getLastNode().getData();
    }

    public boolean isEmpty() {
        LinkedList<E> ll = new LinkedList<>();
        return ll.getFirstNode() == null;
    }

    public E get(int index) {
        LinkedList<E> ll = new LinkedList<>();
        // Loop until counter is equal to given index; then do `getData()` on that node
        int i = 0;
        DLNode<E> node = ll.getFirstNode();
        while (node != null) {
            if (i == index) {
                return node.getData();
            }
            node = node.getNextNode();
        }
        return node.getData();
    }

    public DynamicList<E> subList(int start, int stop) throws IndexOutOfBoundsException {
        LinkedList<E> ll = new LinkedList<>();
//        DLNode<E> list1 = this.lastNode;
        DLNode<E> list1 = ll.getLastNode();
        List<E> list2 = new ArrayList<>(); // Context
        DynamicList<E> list3 = new LinkedList<>(); // New List
        int count = 0;

        // Loop from start to stop and count
        // Include start node data, exclude stop
        // node data from list
        while (list1.getPrevNode() != null) {
            list2.add(list1.getData());
            list1 = list1.getPrevNode();
        }

        Collections.reverse(list2);

        for (int i = 0; i < 3; i++) {
            if (start < stop) {
                list3.add(list2.get(i));
            }
        }

        // Return Dynamic List
        return list3;
    }

    public int find(Function<E, Boolean> searchFct) {
        LinkedList<E> ll = new LinkedList<>();
        DLNode<E> node = ll.getFirstNode();
        E data;
        int i = 0;

        while (node != null) {
            if (searchFct.apply(node.getData())) {
                return i;
            }
            i++;
            node = node.getNextNode();
        }
        return -1;
    }

    public void add(E newElem) {
        LinkedList<E> ll = new LinkedList<>();
        // Adding last to an empty list makes it the first node
        if (isEmpty() == true) {
            DLNode<E> node = new DLNode<>(newElem);
            node.setNextNode(null);
            node.setPrevNode(null);
//            this.firstNode = node;
            ll.setFirstNode(node);
//            this.lastNode = node;
            ll.setLastNode(node);
        }

        DLNode<E> node = new DLNode<>(newElem);
//        node.setPrevNode(this.lastNode);
        node.setPrevNode(ll.getLastNode());
//        this.lastNode = node;
        ll.setLastNode(node);

    }

    public void addFirst(E newElem) {
        LinkedList<E> ll = new LinkedList<>();
        if (isEmpty() == true) {
            DLNode<E> node = new DLNode<>(newElem);
            node.setNextNode(null);
            node.setPrevNode(null);
//            this.firstNode = node;
            ll.setFirstNode(node);
//            this.lastNode = node;
            ll.setLastNode(node);
        }

        DLNode<E> node = new DLNode<>(newElem);
//        node.setPrevNode(this.firstNode);
        node.setPrevNode(ll.getFirstNode());
//        this.firstNode = node;
        ll.setFirstNode(node);
    }

    public void addLast(E newElem) {
        LinkedList<E> ll = new LinkedList<>();
        // Adding last to an empty list makes it the first node
        if (isEmpty() == true) {
            DLNode<E> node = new DLNode<>(newElem);
            node.setNextNode(null);
            node.setPrevNode(null);
//            this.firstNode = node;
            ll.setFirstNode(node);
//            this.lastNode = node;
            ll.setLastNode(node);
        }

        DLNode<E> node = new DLNode<>(newElem);
//        node.setNextNode(this.lastNode);
        node.setNextNode(ll.getLastNode());
//        this.lastNode = node;
        ll.setLastNode(node);
    }

    public E removeIndex(int index) throws IndexOutOfBoundsException {
        E data = get(index);
        LinkedList<E> ll = new LinkedList<>();
        DLNode<E> node1 = ll.getFirstNode();
        DLNode<E> node2 = null;
        DLNode<E> node3 = null;
        int i = 0;

        while (node1 != null) {
            if (i == index) {
                if (node1.getPrevNode() != null) {
                    node2 = node1.getPrevNode();
                }

                if (node1.getNextNode() != null) {
                    node3 = node1.getNextNode();
                }

                node2.setNextNode(node3);
                node3.setPrevNode(node2);
                return node1.getData();
            }
            node1 = node1.getNextNode();
            i++;
        }
        return node1.getData();
    }

    public void removeAll() {
        if (isEmpty()) {
            return;
        }
        // TODO

    }

    public List<E> toJavaList() {
        List<E> list = new ArrayList<>();

        // Create Linked List
        LinkedList<E> ll = new LinkedList<>();

        // Then set "node" to the last node of that list to resolve the issue
        DLNode<E> node = ll.getLastNode();

        // Loop  through the LL
        while (node.getPrevNode() != null) {
            list.add(node.getData());
            node = node.getPrevNode();
        }

        // Reverse the list, because going forwards doesn't work
        Collections.reverse(list);
        return list;
    }

}
package linkedlist;

import linearpub.DynamicList;
import linkedlist.DLNode;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;

public class LinkedList<E> implements DynamicList<E> {

    private DLNode<E> firstNode;
    private DLNode<E> lastNode;

    // Empty LL
    public LinkedList() {
        this.firstNode = null;
        this.lastNode = null;
    }

    public DLNode<E> getFirstNode() {
        return firstNode;
    }

    public DLNode<E> getLastNode() {
        return lastNode;
    }

    public void setFirstNode(DLNode<E> firstNode) {
        this.firstNode = firstNode;
    }

    public void setLastNode(DLNode<E> lastNode) {
        this.lastNode = lastNode;
    }

    //-------------------- Basic Statistics ---------------------

    public int size() {
        if (isEmpty()) {
            return 0;
        }

        // Loop with a counter (i) that increments until `node.nextNode()` is null
        int i = 0;
        DLNode<E> node = this.firstNode;
        while (node != null) {
            i++;
            node = node.getNextNode();
        }
        return i;
    }

    public boolean isEmpty() {
        return this.firstNode == null;
    }

    //--------------------- Accessing ---------------------

    public E get(int index) {
        // Loop until counter is equal to given index; then do `getData()` on that node
        int i = 0;
        DLNode<E> node = this.firstNode;
        while (node != null) {
            if (i == index) {
                return node.getData();
            }
            node = node.getNextNode();
        }
        return node.getData();
    }

    /**
     * Return a new list containing the elements of this list
     * between the given index "start" (inclusive) and
     * the given index "stop" (exclusive).
     * Throws IndexOutOfBoundsException if either passed index is invalid.
     */
    public DynamicList<E> subList(int start, int stop) throws IndexOutOfBoundsException {
        DLNode<E> list1 = this.lastNode;
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

    public E first() {
        if (isEmpty() == true) {
            return null;
        }
        return this.firstNode.getData();
    }

    public E last() {
        if (isEmpty()) {
            return null;
        }
        return this.lastNode.getData();
    }

    public int find(Function<E, Boolean> searchFct) {
        DLNode<E> node = this.firstNode;
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

    //--------------------- Adding ---------------------

    public void addFirst(E newElem) {
        if (isEmpty() == true) {
            DLNode<E> node = new DLNode<>(newElem);
            node.setNextNode(null);
            node.setPrevNode(null);
            this.firstNode = node;
            this.lastNode = node;
        }

        DLNode<E> node = new DLNode<>(newElem);
        node.setPrevNode(this.firstNode);
        this.firstNode = node;

    }

    public void addLast(E newElem) {
        // Adding last to an empty list makes it the first node
        if (isEmpty() == true) {
            DLNode<E> node = new DLNode<>(newElem);
            node.setNextNode(null);
            node.setPrevNode(null);
            this.firstNode = node;
            this.lastNode = node;
        }

        DLNode<E> node = new DLNode<>(newElem);
        node.setNextNode(this.lastNode);
        this.lastNode = node;
    }

    public void add(E newElem) {
        // Adding last to an empty list makes it the first node
        if (isEmpty() == true) {
            DLNode<E> node = new DLNode<>(newElem);
            node.setNextNode(null);
            node.setPrevNode(null);
            this.firstNode = node;
            this.lastNode = node;
        }

        DLNode<E> node = new DLNode<>(newElem);
        node.setPrevNode(this.lastNode);
        this.lastNode = node;

    }

    public void insert(int index, E newElem) throws IndexOutOfBoundsException {
        int i = 0;
        DLNode<E> node1 = this.firstNode;
        DLNode<E> node2 = new DLNode<>(newElem);
        while (node1 != null) {
            if (i == index) {
                DLNode<E> node3 = node1.getNextNode();
                node1.setNextNode(node2);
                node3.setPrevNode(node2);
                node2.setPrevNode(node1);
                node2.setNextNode(node3);
                return;
            }
            node1 = node1.getNextNode();
            i++;
        }
    }

    //--------------------- Removing ---------------------

    public E removeFirst() throws RuntimeException {
        DLNode<E> node1 = this.firstNode;
        E data = node1.getData();

        if (node1.getNextNode() == null) {
            node1 = null;
            return data;
        }

        DLNode<E> node2 = node1.getNextNode();
        node1.setNextNode(null);
        node2.setPrevNode(null);
        node1 = null;
        this.firstNode = node2;
        return data;
    }

    public E removeLast() throws RuntimeException {
        DLNode<E> node1 = this.lastNode;
        E data = node1.getData();

        if (node1.getPrevNode() == null) {
            node1 = null;
            return data;
        }

        DLNode<E> node2 = node1.getPrevNode();
        node2.setNextNode(null);
        node1.setPrevNode(null);
        node1 = null;
        this.lastNode = node2;
        return data;
    }

    /**
     * Reset the list so it is empty.
     * No action is performed on the elements.
     *
     */
    public void removeAll() {
        if (isEmpty()) {
            return;
        }
        // TODO

    }

    public E removeIndex(int index) throws IndexOutOfBoundsException {
        E data = get(index);
        DLNode<E> node1 = this.firstNode;
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

    public E remove(Function<E, Boolean> searchFct) {
        DLNode<E> node = this.firstNode;
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

    //--------------------- Convenience ---------------------

    public List<E> toJavaList() {
        List<E> list = new ArrayList<>();
        DLNode<E> node = this.lastNode;

        // Loop  through the LL
        while (node.getPrevNode() != null) {
            list.add(node.getData());
            node = node.getPrevNode();
        }

        // Reverse the list, because going forwards doesn't work
        Collections.reverse(list);
        return list;
    }


    /**
     * Returns one-line user-friendly message about this object
     * Helpful method especially for debugging.
     */
    public String toString() {
        //TODO
        return null;
    }

}
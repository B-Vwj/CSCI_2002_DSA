package nodetest;

import node.DLNode;
import testutil.AbstractTest;

public class DLNodeTest extends AbstractTest {

    public static void main(String[] args) {
        DLNodeTest test = new DLNodeTest();
        test.testHasStrData();
        test.testHasIntData();
        test.testHasPrev();
        test.testHasNext();
        test.printSummary();
    }

    private void testHasStrData() {
        header("Starting -- testHasStrData");
        DLNode<String> node = new DLNode<>("Test");
        assertEquals("Test", node.getData());
    }

    private void testHasIntData() {
        header("Starting -- testHasIntData");
        DLNode<Integer> node = new DLNode<>(100);
        assertEquals(100, node.getData());
    }

    private void testHasPrev() {
        DLNode<String> node1 = new DLNode<>("Foo");
        DLNode<String> node2 = new DLNode<>("Bar");
        node2.setPrevNode(node1);
        assertTrue(node2.hasPrev());
    }

    private void testHasNext() {
        DLNode<Integer> node1 = new DLNode<>(1);
        DLNode<Integer> node2 = new DLNode<>(2);
        node1.setNextNode(node2);
        assertTrue(node1.hasNext());
    }
}

package nodetest;

import node.DLNode;
import testutil.AbstractTest;

public class DLNodeSmokeTest extends AbstractTest {

    public static void main(String[] args) {
        DLNodeSmokeTest test = new DLNodeSmokeTest();
        test.constructorWorks();
        test.testHasNoIntData();
        test.testHasNoStrData();
        test.testHasNoPrev();
        test.testHasNoNext();
        test.printSummary();
    }

    private void constructorWorks() {
        header("Starting -- constructorWorks");
        DLNode<Integer> node = new DLNode<>(0);
        assertEquals(0, node.getData());
    }

    private void testHasNoIntData() {
        header("Starting -- testHasNoIntData");
        DLNode<Integer> node = new DLNode<>(null);
        assertEquals(null, node.getData());
    }

    private void testHasNoStrData() {
        header("Starting -- testHasNoStrData");
        DLNode<String> node = new DLNode<>(null);
        assertEquals(null, node.getData());
    }

    private void testHasNoPrev() {
        DLNode<String> node2 = new DLNode<>("Bar");
        assertEquals(null, node2.getPrevNode());
    }

    private void testHasNoNext() {
        DLNode<Integer> node1 = new DLNode<>(1);
        assertEquals(null, node1.getNextNode());
    }
}

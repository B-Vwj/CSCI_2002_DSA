package assoctest;

import assoc.Association;
import testutil.AbstractTest;

public class AssociationTest extends AbstractTest {

    public static void main(String[] args) {
        AssociationTest test = new AssociationTest();
        test.testIntKey();
        test.testStrKey();
        test.testIntValue();
        test.testStrValue();
        test.printSummary();
    }

    private void testIntKey() {
        header("Starting -- testIntKey");
        Association<Integer, String> assoc = new Association<>(1, "Bar");
        assertEquals(1, assoc.getKey());
    }

    private void testStrKey() {
        header("Starting -- testStrKey");
        Association<String, Integer> assoc = new Association<>("Foo", 2);
        assertEquals("Foo", assoc.getKey());
    }

    private void testIntValue() {
        header("Starting -- testIntValue");
        Association<String, Integer> assoc = new Association<>("Foo", 2);
        assertEquals(2, assoc.getValue());
    }

    private void testStrValue() {
        header("Starting -- testStrValue");
        Association<Integer, String> assoc = new Association<>(1, "Bar");
        assertEquals("Bar", assoc.getValue());
    }
}

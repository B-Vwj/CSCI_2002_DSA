package assoctest;

import assoc.Association;
import testutil.AbstractTest;

public class AssociationSmokeTest extends AbstractTest {

    public static void main(String[] args) {
        AssociationSmokeTest test = new AssociationSmokeTest();
        test.testConstruct();
        test.testAccessors();
        test.printSummary();
    }

    private void testConstruct() {
        header("Starting -- testConstruct");
        Association<String, Integer> assoc = new Association<>("One", 1);
        assertNotEquals(null, assoc);
    }

    private void testAccessors() {
        header("Starting -- testAccessors");
        Association<String, Integer> assoc = new Association<>("Two", 2);
        assertNotEquals(null, assoc.getKey());
        assertNotEquals(null, assoc.getValue());
    }

}

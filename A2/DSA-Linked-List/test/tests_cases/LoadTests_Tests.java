
/*
    DynamicList_OneElement_Scorer.java.java
    02/14/21
    
    Unit: emty list (individual tests will modify)
*/
package tests_cases;

import scorer.MethodTest;
import testutil.BaselineList;
import testutil.Thing;

public class LoadTests_Tests extends Abstract_DynamicList_TestCase {

	// ============================================
	// Constructors

	public LoadTests_Tests(int maxPoints, String constructUnitSnippet) {
		super(maxPoints, "Load Tests", constructUnitSnippet);
	}
	
	public LoadTests_Tests() {
		this(100, null);
	}	

	// ============================================
	// Housekeeping / Test Admin

	protected String[] getTestNames() {
		return new String[] { 
				"test_load", 
				//"test_load_unload", 
		};
	}

	// =====================================================
	// Setup

	public void beforeEach() {
		this.unit = this.getListFactory().newList();
	}
	
	// =====================================================
	// Tests

	public void test_load(MethodTest mt) {
		int cap = 1000;
		BaselineList<Thing> expected = BaselineList.withCapacity(cap);		
		for (int id=1; id<cap; id++) {
			unit().addLast(new Thing(id));
			expected.addLast(new Thing(id));
		}

		mt.worth(25);		
		mt.assertEquals(unit.size(), expected.size(), "size check");

		mt.worth(75);		
		String error = BaselineList.compare(expected, unit());
		mt.assertTrue(error.isEmpty(), "checking elements -- post load");		
	}
	
	public void test_load_unload(MethodTest mt) {
		int cap = 1000;
		BaselineList<Thing> expected = BaselineList.withCapacity(cap);		
		for (int id=1; id<cap; id++) {
			unit().addLast(new Thing(id));
			expected.addLast(new Thing(id));
		}
		for (int id=1; id<cap; id++) {
			unit().removeLast();
			expected.removeLast();
		}		
		mt.assertTrue(unit().isEmpty(), "should be empty added 100k, removed 100k (via removeLast)");		
	}	
	
	//----------------------------------------------------
	//Helpers
	
	
	//----------------------------------------------------
	//Main entry point
	
	public static void main(String[] args) {
		//TODO
		_UnitTestManager.main(args);
	}

}

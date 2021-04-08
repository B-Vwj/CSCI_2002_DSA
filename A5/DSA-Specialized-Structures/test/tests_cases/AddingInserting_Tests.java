
/*
    DynamicList_OneElement_Scorer.java.java
    02/14/21
    
    Unit: emty list (individual tests will modify)
*/
package tests_cases;

import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

import pub.DynamicList;
import scorer.MethodTest;
import testutil.BaselineList;
import testutil.Thing;

public class AddingInserting_Tests extends Abstract_DynamicList_TestCase<Thing> {

	// ============================================
	// Constructors

	public AddingInserting_Tests(int maxPoints, Supplier<DynamicList<Thing>> emptyListGenerator,
			String constructUnitSnippet) {
		super(maxPoints, emptyListGenerator, "Methods That Add/Insert", constructUnitSnippet);
	}
	
	public AddingInserting_Tests() {
		this(100, null, null);
	}	

	// ============================================
	// Housekeeping / Test Admin

	protected String[] getTestNames() {
		return new String[] { 
				"test_construction", 
				"test_addFirst", 
				"test_addLast", 
				"test_add", 
				"test_insert"
		};
	}

	// =====================================================
	// Setup

	public void beforeEach() {
		this.unit = this.getEmptyListGenerator().get();
	}

	// =====================================================
	// Helpers	

	private BaselineList<Thing> newBaselineList(int first, int last, BiConsumer<BaselineList<Thing>, Thing> adder) {
		BaselineList<Thing> list = new BaselineList<>();
		for (int id = first; id <= last; id++)
			adder.accept(list, new Thing(id));
		return list;
	}

	// =====================================================
	// Tests

	public void test_construction(MethodTest mt) {
		mt.assertTrue(unit != null);
	}

	public void test_addFirst(MethodTest mt) {
		int start = this.defaultStart();
		int stop = this.defaultEnd();
		for (int id = start; id <= stop; id++)
			unit.addFirst(new Thing(id));
		BaselineList<Thing> expected;
		expected = newBaselineList(start, stop
				, (list, elem) -> list.addFirst(elem));
		mt.assertEquals(expected, unit, () -> unit.toString());
	}

	public void test_addLast(MethodTest mt) {
		for (int id=this.defaultStart(); id<=this.defaultEnd(); id++)
			unit.addLast(new Thing(id));
		BaselineList<Thing> expected;
		expected = newBaselineList(this.defaultStart(), this.defaultEnd()
					, (list, elem) -> list.addLast(elem));
		mt.assertEquals(expected, unit, () -> unit.toString());		
	}
	
	public void test_add(MethodTest mt) {
		for (int id=this.defaultStart(); id<=this.defaultEnd(); id++)
			unit.add(new Thing(id));
		BaselineList<Thing> expected;
		expected = newBaselineList(this.defaultStart(), this.defaultEnd()
					, (list, elem) -> list.add(elem));
		mt.assertEquals(expected, unit, () -> unit.toString());		
	}
	
	public void test_insert(MethodTest mt) {
		int firstId = defaultStart();
		int lastId = defaultEnd();
		unit.add(new Thing(firstId));		
		BaselineList<Thing> expected = new BaselineList<Thing>();
		expected.add(new Thing(firstId));		
		Random rand = new Random();
		for (int id = firstId + 1; id <= lastId; id++) {
			int randomIndex = rand.nextInt(expected.size() + 1);
			expected.insert(randomIndex, new Thing(id));
			unit.insert(randomIndex, new Thing(id));
		}
		//expected.insert(expected.size(), new Thing(lastId+1));
		//unit.insert(expected.size() - 1, new Thing(lastId+1));		
		mt.assertEquals(unit.size(), expected.size(), "size check");
		mt.worth(4);
		mt.assertEquals(expected, unit);
	}		

	//----------------------------------------------------
	//Test Bas	

	//----------------------------------------------------
	//Helper Methods	

	private int defaultStart() {
		return 1001;
	}

	private int defaultEnd() {
		return 1001;
	}
	
	//----------------------------------------------------
	//Main entry point

	public static void main(String[] args) {
		//TODO
		_UnitTestManager.main(args);
	}

}

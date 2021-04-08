
/*
    DynamicList_OneElement_Scorer.java.java
    02/14/21
    
    Unit: emty list (individual tests will modify)
*/
package tests_cases;

import java.util.Arrays;
import java.util.List;
import java.util.AbstractMap.SimpleEntry;
import java.util.function.BiConsumer;

import linearpub.DynamicList;
import scorer.MethodTest;
import testutil.BaselineList;
import testutil.Thing;

public class AddingInserting_Tests extends Abstract_DynamicList_TestCase {

	// ============================================
	// Constructors

	public AddingInserting_Tests(int maxPoints, String constructUnitSnippet) {
		super(maxPoints, "Methods That Add/Insert", constructUnitSnippet);
	}
	
	public AddingInserting_Tests() {
		this(100, null);
	}	

	// ============================================
	// Housekeeping / Test Admin

	protected String[] getTestNames() {
		return new String[] { 
				"test_construction", 
				"test_addFirst", 
				"test_addLast", 
				"test_add", 
				"test_insert_1",
				"test_insert_2",				
		};
	}
	
	@Override
	protected void gatherSpecialTestScores(List<SimpleEntry<String, Integer>> list) {
		super.gatherSpecialTestScores(list);
		list.add(newKV("test_insert_1", 50));
		list.add(newKV("test_insert_2", 50));		
	}		

	// =====================================================
	// Setup

	public void beforeEach() {
		this.unit = this.getListFactory().newList(); 
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
			unit().addFirst(new Thing(id));
		BaselineList<Thing> expected;
		expected = newBaselineList(start, stop
				, (list, elem) -> list.addFirst(elem));
		mt.assertEquals(expected, unit(), () -> unit().toString());
	}

	public void test_addLast(MethodTest mt) {
		for (int id=this.defaultStart(); id<=this.defaultEnd(); id++)
			unit().addLast(new Thing(id));
		BaselineList<Thing> expected;
		expected = newBaselineList(this.defaultStart(), this.defaultEnd()
					, (list, elem) -> list.addLast(elem));
		mt.assertEquals(expected, unit(), () -> unit().toString());		
	}
	
	public void test_add(MethodTest mt) {
		for (int id=this.defaultStart(); id<=this.defaultEnd(); id++)
			unit().add(new Thing(id));
		BaselineList<Thing> expected;
		expected = newBaselineList(this.defaultStart(), this.defaultEnd()
					, (list, elem) -> list.add(elem));
		mt.assertEquals(expected, unit(), () -> unit().toString());		
	}
	
	public void test_insert_1(MethodTest mt) {
		DynamicList<Integer> actual = this.getListFactory().newList();
		List<Integer> expected = Arrays.asList(20, 10);
		actual.add(10);	//10
		actual.insert(0, 20);	//20 10
		String msg = "original [10] -- inserted 20@0";
		mt.assertEquals(expected.size(), actual.size(), "inserted one into list of size one");
		mt.assertEquals(expected, actual.toJavaList(), msg);		
	}
	
	public void test_insert_2(MethodTest mt) {
		DynamicList<Integer> actual = this.getListFactory().newList();
		List<Integer> expected = Arrays.asList(20, 30, 40, 10);
		actual.add(10);	//10
		actual.insert(0, 20);	//20 10
		actual.insert(1, 30);	//20 30 10
		actual.insert(2, 40);	//20 30 40 10
		String msg = "original [10] -- inserted 20@0, 30@1, 40@2";
		mt.assertEquals(expected.size(), actual.size(), "inserted three into list of size one");
		mt.assertEquals(expected, actual.toJavaList(), msg);		
	}	

	//----------------------------------------------------
	//Helper Methods	

	private int defaultStart() {
		return 1001;
	}

	private int defaultEnd() {
		return 1004;
	}
	
	//----------------------------------------------------
	//Main entry point

	public static void main(String[] args) {
		//TODO
		_UnitTestManager.main(args);
	}

}

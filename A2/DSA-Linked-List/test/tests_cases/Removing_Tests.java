
/*
    DynamicList_Empty_Scorer.java
    02/14/21
*/
package tests_cases;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

import linearpub.DynamicList;
import scorer.MethodTest;
import testutil.Thing;

public class Removing_Tests extends Abstract_DynamicList_TestCase {

	// ============================================
	// Constructors

	public Removing_Tests(
			int maxPoints, 
			String constructUnitSnippet) {
		super(maxPoints, "Methods That Remove", constructUnitSnippet);
	}
	
	public Removing_Tests() {
		this(100, null);
	}	

	// ============================================
	// Housekeeping / Test Admin
	
	protected String[] getTestNames() {
		return new String[] {		
		"test_construction",
		"test_isEmpty",
		"test_removeFirst",
		"test_removeLast",
		"test_removeAll",
		"test_removeIndex_First",		
		"test_removeIndex_Last",
		"test_remove",
		"test_removeFirst_OnEmptyList",
		"test_removeLast_OnEmptyList",
		"test_removeIndex_OnEmptyList"
		};
	}
	
	// =====================================================
	// Setup

	public void beforeEach() {
		this.setUnit(this.getListFactory().newList());		
		//Add four elements
		BiConsumer<DynamicList<Thing>, Thing> bestAddFunction;
		bestAddFunction = getBestAddFunction(new Thing(1), new Thing(2));		
		for (int eachId: new Integer[] {10, 20, 30, 40})
			bestAddFunction.accept(this.unit(), new Thing(eachId));
	}
	
	// =====================================================
	// Tests

	public void test_construction(MethodTest mt) {
		mt.assertTrue(this.unit() != null);
	}

	public void test_isEmpty(MethodTest mt) {
		mt.assertFalse(this.unit().isEmpty());
	}
	
	public void test_removeFirst(MethodTest mt) {
		for (int i = 0; i <= 3; i++)
			this.unit().removeFirst();
		mt.assertTrue(this.unit().isEmpty(), "isEmpty should be true (removed all)");
	}

	public void test_removeLast(MethodTest mt) {
		for (int i = 0; i <= 3; i++)
			this.unit().removeLast();
		mt.assertTrue(this.unit().isEmpty(), "isEmpty should be true (removed all)");
	}

	public void test_removeAll(MethodTest mt) {
		this.unit().removeAll();
		mt.assertTrue(this.unit().isEmpty(), "isEmpty should be true (removed all)");
	}

	public void test_removeIndex_First(MethodTest mt) {
		for (int i = 0; i <= 3; i++)
			this.unit().removeIndex(0);
		mt.assertTrue(this.unit().isEmpty(), "isEmpty should be true (removed all)");
	}
	
	public void test_removeIndex_Last(MethodTest mt) {
		for (int i = 3; i >= 0; i--)
			this.unit().removeIndex(i);
		mt.assertTrue(this.unit().isEmpty(), "isEmpty should be true (removed all)");
	}	

	public void test_remove(MethodTest mt) {
		for (int eachId: new Integer[] {30, 20, 40, 10})
			this.unit().remove(thing -> thing.getId() == eachId);
		mt.assertTrue(this.unit().isEmpty(), "isEmpty should be true (removed all)");		
	}
	
	public void test_removeFirst_OnEmptyList(MethodTest mt) {
		DynamicList<Thing> u = this.getListFactory().newList();
		mt.assertExceptionIn(() -> u.removeFirst(), emptyListExceptionMsg());
	}

	public void test_removeLast_OnEmptyList(MethodTest mt) {
		DynamicList<Thing> u = this.getListFactory().newList();
		mt.assertExceptionIn(() -> u.removeLast(), emptyListExceptionMsg());		
	}

	public void test_removeIndex_OnEmptyList(MethodTest mt) {
		DynamicList<Thing> u = this.getListFactory().newList();		
		mt.assertExceptionIn(() -> u.removeIndex(0), emptyListExceptionMsg());		
	}	
	
	//----------------------------------------------------
	//Helpers	
	
	private Supplier<String> emptyListExceptionMsg() {

		return () -> "exception expected when removing from empty list";
	}	

	//----------------------------------------------------
	//Main entry point

	public static void main(String[] args) {
		//TODO
		_UnitTestManager.main(args);
	}

}

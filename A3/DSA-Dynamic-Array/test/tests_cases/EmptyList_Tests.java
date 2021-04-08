
/*
    DynamicList_Empty_Scorer.java
    02/14/21
    
    Note: We'll only run "test_methodSignatures" in this test case
*/
package tests_cases;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import scorer.MethodTest;
import testutil.Thing;

public class EmptyList_Tests extends Abstract_DynamicList_TestCase {

	// ============================================
	// Constructors

	public EmptyList_Tests(
			int maxPoints, 
			String constructUnitSnippet) {
		super(maxPoints, "Empty List", constructUnitSnippet);
	}
	
	public EmptyList_Tests() {
		this(100, null);
	}	

	// ============================================
	// Housekeeping / Test Admin
	
	protected String[] getTestNames() {
		return new String[] {		
		"test_construction",
		"test_size",
		"test_isEmpty",
		"test_subList",
		"test_first",
		"test_last",
		"test_find",
		"test_toJavaList"
		};
	}
	
	@Override
	protected void gatherSpecialTestScores(List<SimpleEntry<String, Integer>> list) {
		super.gatherSpecialTestScores(list);
		//list.add(newKV("test_methodSignatures", 100));		
	}	
	
	// =====================================================
	// Setup

	public void beforeEach() {
		this.setUnit(this.getListFactory().newList());		
	}
	
	// =====================================================
	// Tests

	public void test_construction(MethodTest mt) {
		mt.assertEquals(this.unit != null, true);
	}

	public void test_size(MethodTest mt) {
		mt.assertEquals(this.unit.size(), 0, () -> unit.toString());
	}

	public void test_isEmpty(MethodTest mt) {
		mt.assertTrue(this.unit.isEmpty(), () -> unit.toString());
	}
	
	//------------------
	
	public void test_subList(MethodTest mt) {
		mt.assertExceptionIn(() -> this.unit.subList(0, 1), "expecting exception for 'subList(0, 1)'");
	}

	public void test_first(MethodTest mt) {
		mt.assertExceptionIn(() -> this.unit.first(), "expecting exception for 'first()'");		
	}

	public void test_last(MethodTest mt) {
		mt.assertExceptionIn(() -> this.unit.last(), "expecting exception for 'last()'");		
	}

	public void test_find(MethodTest mt) {
		Function<Thing, Boolean> searchFct = each -> each.getId() == 10;
		mt.assertEquals(-1, this.unit().find(searchFct), "expecting no match for search in empty list");
	}

	public void test_toJavaList(MethodTest mt) {
		mt.assertEquals(new ArrayList<>(), this.unit.toJavaList());
	}

	//----------------------------------------------------
	//Main entry point

	public static void main(String[] args) {
		//TODO
		_UnitTestManager.main(args);
	}

}

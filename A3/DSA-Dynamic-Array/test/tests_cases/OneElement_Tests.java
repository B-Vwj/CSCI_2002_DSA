
/*
    DynamicList_OneElement_Scorer.java.java
    02/14/21
    
    Unit: one element (a Thing with id "getId" of 7)
*/
package tests_cases;

import java.util.function.Function;

import scorer.MethodTest;
import testutil.BaselineList;
import testutil.Thing;

public class OneElement_Tests extends Abstract_DynamicList_TestCase {

	// ============================================
	// Constructors

	public OneElement_Tests(int maxPoints, String constructUnitSnippet) {
		super(maxPoints, "List of Size One", constructUnitSnippet);
	}

	public OneElement_Tests() {
		this(100, null);
	}

	// ============================================
	// Housekeeping / Test Admin

	protected String[] getTestNames() {
		return new String[] { "test_construction", "test_size", "test_isEmpty", "test_get", "test_get_bad_index",
				"test_subList", "test_first", "test_last", "test_find", "test_find_noMatch",
				/*
				 * "test_addFirst", "test_addLast",
				 * "test_add", "test_insert",
				 * "test_removeFirst",
				 * "test_removeLast", "test_removeAll",
				 * "test_removeIndex", "test_remove",
				 */
				"test_toJavaList" };
	}

	// =====================================================
	// Setup

	public void beforeEach() {
		this.unit = this.getListFactory().newList();
		//And add one element
		getBestAddFunction(new Thing(1), new Thing(2)).accept(this.unit(), new Thing(7));
	}
	
	// =====================================================
	// Helpers	

	private int defaultElementId() {
		return 7;
	}

	private Thing defaultElement() {
		return new Thing(this.defaultElementId());
	}

	private BaselineList<Thing> defaultBaselineList() {
		BaselineList<Thing> list = new BaselineList<>();
		list.add(this.defaultElement());
		return list;
	}

	// =====================================================
	// Tests

	public void test_construction(MethodTest mt) {
		mt.assertTrue(unit != null);
	}

	public void test_size(MethodTest mt) {
		mt.assertEquals(1, unit.size(), 1);
	}

	public void test_isEmpty(MethodTest mt) {
		mt.assertFalse(unit.isEmpty());
	}

	public void test_get(MethodTest mt) {
		mt.assertEquals(this.defaultElement(), unit.get(0));
	}

	public void test_get_bad_index(MethodTest mt) {
		mt.assertExceptionIn(() -> unit.get(1000), () -> String.format("expecting exception for 'get(%d)'", 1000));
	}

	//------------------

	public void test_subList(MethodTest mt) {
		//exception
		mt.assertEquals(this.defaultBaselineList().subList(0, 1), this.unit.subList(0, 1));
	}

	public void test_first(MethodTest mt) {
		mt.assertEquals(this.defaultElement(), this.unit.first());
	}

	public void test_last(MethodTest mt) {
		mt.assertEquals(this.defaultElement(), this.unit.last());
	}

	public void test_find(MethodTest mt) {
		Function<Thing, Boolean> searchFct = eaThing -> eaThing.getId() == this.defaultElementId();
		mt.assertEquals(0, this.unit().find(searchFct));
	}

	public void test_find_noMatch(MethodTest mt) {
		Function<Thing, Boolean> searchFct = eaThing -> false;
		mt.assertEquals(-1, this.unit().find(searchFct));
	}

	public void test_toJavaList(MethodTest mt) {
		mt.assertEquals(this.defaultBaselineList().toJavaList(), this.unit.toJavaList());
	}

	//----------------------------------------------------
	//Main entry point

	public static void main(String[] args) {
		//TODO
		_UnitTestManager.main(args);
	}

}


/*
    DynamicList_OneElement_Scorer.java.java
    02/14/21
    
    Unit: one element (a Thing with id "getId" of 7)
*/
package tests_cases;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Supplier;

import linearpub.DynamicList;
import scorer.MethodTest;
import testutil.BaselineList;
import testutil.Thing;

public class ManyElements_Tests extends Abstract_DynamicList_TestCase {

	// ============================================
	// Constructors
	
	public ManyElements_Tests(
			int maxPoints, 
			String constructUnitSnippet) {			
		super(maxPoints, "List of Size Many", constructUnitSnippet);
	}	
	
	public ManyElements_Tests() {
		this(100, null);
	}	
	
	// ============================================
	// Housekeeping / Test Admin
	
	protected String[] getTestNames() {
		return new String[] {
		"test_methodSignatures",
		"test_construction",
		"test_size",
		"test_isEmpty",
		"test_get",
		"test_get_bad_index",
		//"test_subList_fullRange",
		"test_subList",
		"test_subListIndexOutOfBounds",		
		"test_first",
		"test_last",
		"test_find",
		"test_find_noMatch",
		"test_toJavaList"
		};
	}

	@Override
	protected void gatherSpecialTestScores(List<SimpleEntry<String, Integer>> list) {
		super.gatherSpecialTestScores(list);
		//list.add(newKV("test_subList_fullRange", 20));
		list.add(newKV("test_find_noMatch", 50));		
	}	
	
	// =====================================================
	// Setup
	
	public void beforeEach() {
		this.unit = this.getListFactory().newList();
		BiConsumer<DynamicList<Thing>, Thing> bestAddFunction;
		bestAddFunction = getBestAddFunction(new Thing(1), new Thing(2));
		for (int i = defaultStartId1(); i <= defaultLastId1(); i++)
			bestAddFunction.accept(this.unit(), new Thing(i));
	}
	
	// =====================================================
	// Tests
	
	/**
	 * This checks that each expected method (signature) exists
	 * with proper method parameters 
	 */
	public void test_methodSignatures(MethodTest mt) {
		if (checkSignature(mt, "size"))
			mt.record(true, true);
		if (checkSignature(mt, "isEmpty"))
			mt.record(true, true);
		if (checkSignature(mt, "get", int.class))
			mt.record(true, true);
		if (checkSignature(mt, "subList", int.class, int.class))
			mt.record(true, true);
		if (checkSignature(mt, "first"))
			mt.record(true, true);
		if (checkSignature(mt, "last"))
			mt.record(true, true);
		if (checkSignature(mt, "find", Function.class))
			mt.record(true, true);
		if (checkSignature(mt, "addFirst", Object.class))
			mt.record(true, true);
		if (checkSignature(mt, "addLast", Object.class))
			mt.record(true, true);
		if (checkSignature(mt, "add", Object.class))
			mt.record(true, true);
		if (checkSignature(mt, "insert", int.class, Object.class))
			mt.record(true, true);
		if (checkSignature(mt, "removeFirst"))
			mt.record(true, true);
		if (checkSignature(mt, "removeLast"))
			mt.record(true, true);
		if (checkSignature(mt, "removeAll"))
			mt.record(true, true);
		if (checkSignature(mt, "removeIndex", int.class))
			mt.record(true, true);
		if (checkSignature(mt, "remove", Function.class))
			mt.record(true, true);
		if (checkSignature(mt, "toJavaList"))
			mt.record(true, true);
		if (checkSignature(mt, "iterator"))
			mt.record(true, true);
	}	

	public void test_construction(MethodTest mt) {
		mt.assertTrue(unit != null);
	}

	public void test_size(MethodTest mt) {
		mt.assertEquals(unit.size(), defaultSize1());
	}

	public void test_isEmpty(MethodTest mt) {
		mt.assertFalse(unit.isEmpty());
	}
	
	public void test_get(MethodTest mt) {
		int i = 0;
		for (Thing eachExpected: this.defaultBaselineList1().toJavaList())
			mt.assertEquals(eachExpected, unit.get(i++), this.fmt("index %d",  i));
	}
	
	public void test_get_bad_index(MethodTest mt) {
		mt.assertExceptionIn(() -> unit.get(this.defaultSize1()+100),
				() -> String.format("expecting exception for 'get(%d)'",
						this.defaultSize1()+100));
	}	
	
	//------------------
	
//	public void test_subList_fullRange(MethodTest mt) {
//		DynamicList<Thing>
//			expected = this.defaultBaselineList1(),
//			unit = this.unit();
//		mt.assertEquals(
//			expected,
//			unit.subList(0, expected.size()), 
//			fmt("subList(%d, %d)", 0, expected.size())); 
//	}	
	
	public void test_subList(MethodTest mt) {
		DynamicList<Thing>
			base = this.defaultBaselineList1(),
			unit = this.unit();
		int sz = base.size();
		for (int i=0; i<sz; i++)
			for (int j=i+1; j<=sz; j++) {
				DynamicList<Thing> expected, actual;
				expected = base.subList(i, j);
				actual = unit.subList(i,  j);
				String msg = fmt("subList(%d, %d)", i, j);				
				mt.assertEquals(expected.size(), actual.size(), "size check for " + msg); 
				mt.assertEquals(expected, actual, msg);
			}
	}
	
	public void test_subListIndexOutOfBounds(MethodTest mt) {
		mt.assertExceptionIn(() -> unit.subList(0, unit.size() + 1),
				() -> String.format("expecting exception for 'subList(0, %d)'", unit.size() + 1));
		mt.assertExceptionIn(() -> unit.subList(-1, unit.size()),
				() -> String.format("expecting exception for 'subList(-1, %d)'", unit.size()));				
	}	

	public void test_first(MethodTest mt) {
		mt.assertEquals(this.defaultStartId1(), this.unit().first().getId());
	}

	public void test_last(MethodTest mt) {
		mt.assertEquals(this.defaultLastId1(), this.unit().last().getId());	
	}

	public void test_find(MethodTest mt) {
		int targetId = this.defaultStartId1() + (this.defaultSize1() / 2);
		int expectedIndex = targetId - this.defaultStartId1();
		Function<Thing, Boolean> searchFct = eaThing -> eaThing.getId() == targetId;
		mt.assertEquals(expectedIndex, this.unit().find(searchFct));
	}
	
	public void test_find_noMatch(MethodTest mt) {
		Function<Thing, Boolean> searchFct = eaThing -> eaThing.getId() == (this.defaultLastId1() + 1);
		mt.assertEquals(-1, this.unit().find(searchFct));
	}	

	public void test_toJavaList(MethodTest mt) {
		mt.assertEquals(this.defaultBaselineList1().toJavaList(), this.unit.toJavaList());
	}

	//----------------------------------------------------
	//Main entry point

	public static void main(String[] args) {
		//TODO
		_UnitTestManager.main(args);
	}
	
	// ============================================
	// Helpers	
	
	protected int defaultSize1() {
		return 3;
	}	
	
	protected int defaultStartId1() {
		return 1001;
	}
	
	protected int defaultLastId1() {
		return defaultStartId1() + defaultSize1() - 1;
	}	
	
	protected BaselineList<Thing> defaultBaselineList1() {
		//three elements to support a nice print
		BaselineList<Thing> list = new BaselineList<>();
		for (int i = 1001; i <= 1003; i++)
			list.add(new Thing(i));
		return list;
	}	
	
	protected BaselineList<Thing> defaultBaselineList2() {
		BaselineList<Thing> list = new BaselineList<>();
		//Add a bunch of elements (2002 - 1000 + 1) = 1003
		for (int i = 1000; i <= 2002; i++)
			list.add(new Thing(i));
		return list;
	}		

}

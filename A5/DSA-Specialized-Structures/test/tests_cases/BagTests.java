/**
    BagTests.java
    3/31/21
*/
package tests_cases;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.Supplier;

import pub.BagIdea;
import pub.SSFactory;
import pub.SpecializedStructureIdea;
import scorer.MethodTest;
import testutil.Thing;

public class BagTests extends SpecializedStructureTests {
	
	@Override
	protected BagIdea<Thing> unit() {
		return (BagIdea<Thing>)super.unit();
	}	

	@Override	
	@SuppressWarnings("unchecked")
	protected Supplier<BagIdea<Thing>> emptyStructureGenerator() {
		return (Supplier<BagIdea<Thing>>)super.emptyStructureGenerator();
	}	

	// ============================================
	// Constructors

	public BagTests(int maxPoints, String testCaseLabel,
			Supplier<BagIdea<Thing>> anEmptyStructureGenerator,
			String constructionSnippet) {
		super(maxPoints, testCaseLabel, anEmptyStructureGenerator, constructionSnippet);
	}
	
	// ============================================
	// Housekeeping / Test Admin
	
	protected String[] getTestNames() {
		List<String> result = new ArrayList<>();
		result.addAll(Arrays.asList(super.getTestNames()));
		String[] localTestNames =
				new String[] {
						"test_specific_methodSignatures",						
						"test_construction",
						"test_add_size_contains",
						"test_add_size_any",
						"test_remove_add_size_contains",
						"test_remove_add_no_match",
						"test_any_empty_exception"
				};
		result.addAll(Arrays.asList(localTestNames));
		return result.toArray(String[]::new);
	}
	
	@Override
	protected void gatherSpecialTestScores(List<SimpleEntry<String, Integer>> list) {
		super.gatherSpecialTestScores(list);
		//list.add(newKV("test_specific_methodSignatures", 50));		
		list.add(newKV("test_any_empty_exception", 75));		
	}	
		
	@Override
	public Object constructTestee() {
		return SSFactory.newLinkedBag();
	}
	
	// =====================================================
	// Setup

	public void beforeEach() {
		this.unit(this.emptyStructureGenerator().get());		
	}

	// =====================================================
	// Tests
	
	public void test_construction(MethodTest mt) {
		mt.assertEquals(this.unit() != null, true);
	}

	public void test_add_size_contains(MethodTest mt) {
		BagIdea<Thing> u = this.unit();		
		mt.assertEquals(0, u.size());
		int load = 3;
		for (int id = 1; id <= load; id++) {
			Thing newElem = new Thing(id);
			u.add(newElem);
			mt.assertEquals(id, u.size());
			final int anId = id;
			mt.assertTrue(u.contains(t -> t.getId() == anId));			
		}
	}
	
	public void test_add_size_any(MethodTest mt) {
		BagIdea<Thing> u = this.unit();		
		mt.assertEquals(0, u.size());
		int load = 3;
		List<Thing> elements = new ArrayList<>();
		for (int id = 1; id <= load; id++) {
			Thing newElem = new Thing(id);
			elements.add(newElem);
			u.add(newElem);
			mt.assertEquals(id, u.size());			
			mt.assertTrue(elements.contains(u.any()));			
		}
	}	
	
	public void test_remove_add_size_contains(MethodTest mt) {
		BagIdea<Thing> u = this.unit();		
		mt.assertEquals(0, u.size());
		int load = 3;
		for (int id = 1; id <= load; id++)
			u.add(new Thing(id));
		for (int id = 1; id <= load; id++) {
			Thing target = new Thing(id);
			final int anId = id;
			Thing removed = u.remove(thing -> thing.getId() == anId);
			mt.assertEquals(load - id, u.size());			
			mt.assertEquals(target, removed);
		}
		//no match
	}	
	
	public void test_remove_add_no_match(MethodTest mt) {
		BagIdea<Thing> u = this.unit();		
		mt.assertEquals(0, u.size());
		int load = 3;
		for (int id = 1; id <= load; id++)
			u.add(new Thing(id));
		Thing result = null;
		result = u.remove(thing -> thing.getId() == -99);
		mt.assertEquals(null, result, "Should not find id = -99");
		result = u.remove(thing -> thing.getId() == 0);
		mt.assertEquals(null, result, "Should not find id = 0");		
	}	
			
	public void test_any_empty_exception(MethodTest mt) {
		mt.assertExceptionIn(() -> this.unit().any(),
				() -> String.format("expecting exception (true) for \"any\" on empty structure"));
	}
	
	public void test_add_toJavaList(MethodTest mt) {
		//Overriding because order is indeterminate
		SpecializedStructureIdea<Thing> u = this.unit();
		List<Thing> expected = new ArrayList<>();
 		int load = 3;
		for (int i = 1; i <= load; i++) {
			expected.add(new Thing(i));
			u.add(new Thing(i));
		}
		Collections.sort(expected, (a, b) -> Integer.valueOf(a.getId()).compareTo(b.getId()));
		List<Thing> actual = u.toJavaList();		
		Collections.sort(actual, (a, b) -> Integer.valueOf(a.getId()).compareTo(b.getId()));		
		mt.assertEquals(expected, actual);
	}	
	
	/**
	 * This checks that each expected method (signature) exists
	 * with proper method parameters 
	 */
	public void test_specific_methodSignatures(MethodTest mt) {
		if (checkSignature(mt, "contains", Function.class))
			mt.record(true, true);		
		if (checkSignature(mt, "any"))
			mt.record(true, true);		
		if (checkSignature(mt, "remove", Function.class))
			mt.record(true, true);
	}		

	//----------------------------------------------------
	//Main entry point

	public static void main(String[] args) {
		//TODO
		_UnitTestManager.main(args);
	}

}
















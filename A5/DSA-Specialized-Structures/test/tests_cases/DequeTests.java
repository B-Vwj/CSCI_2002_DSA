/**
    DequeTests.java
    3/31/21
*/
package tests_cases;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import pub.DequeIdea;
import pub.SSFactory;
import scorer.MethodTest;
import testutil.Thing;

public class DequeTests extends SpecializedStructureTests {
	
	@Override
	protected DequeIdea<Thing> unit() {
		return (DequeIdea<Thing>)super.unit();
	}	

	@Override	
	@SuppressWarnings("unchecked")
	protected Supplier<DequeIdea<Thing>> emptyStructureGenerator() {
		return (Supplier<DequeIdea<Thing>>)super.emptyStructureGenerator();
	}	

	// ============================================
	// Constructors

	public DequeTests(int maxPoints, String testCaseLabel,
			Supplier<DequeIdea<Thing>> anEmptyStructureGenerator,
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
						"test_addLast_size_first",
						"test_addLast_size_last",
						"test_addFirst_size_first",
						"test_addLast_size_removeLast",
						"test_addFirst_size_removeFirst",
						"test_first_empty_exception",
						"test_last_empty_exception",
						"test_removeFirst_empty_exception",
						"test_removeLast_empty_exception"
				};
		result.addAll(Arrays.asList(localTestNames));
		return result.toArray(String[]::new);
	}
	
	@Override
	protected void gatherSpecialTestScores(List<SimpleEntry<String, Integer>> list) {
		super.gatherSpecialTestScores(list);
		//list.add(newKV("test_specific_methodSignatures", 10));		
		list.add(newKV("test_first_empty_exception", 75));		
		list.add(newKV("test_last_empty_exception", 75));
		list.add(newKV("test_removeFirst_empty_exception", 75));
		list.add(newKV("test_removeLast_empty_exception", 75));
	}	
	
	@Override
	public Object constructTestee() {
		return SSFactory.newLinkedDeque();
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

	public void test_addLast_size_first(MethodTest mt) {
		DequeIdea<Thing> u = this.unit();		
		mt.assertEquals(0, u.size());
		int load = 3;
		Thing expected = null;
		for (int id = 1; id <= load; id++) {
			Thing newElem = new Thing(id);
			u.addLast(newElem);
			if (id == 1) expected = newElem;
			mt.assertEquals(id, u.size());			
			mt.assertEquals(expected, u.first());			
		}
	}
	
	public void test_addLast_size_last(MethodTest mt) {
		DequeIdea<Thing> u = this.unit();		
		mt.assertEquals(0, u.size());
		int load = 3;
		for (int id = 1; id <= load; id++) {
			Thing newElem = new Thing(id);
			u.addLast(newElem);
			mt.assertEquals(id, u.size());			
			mt.assertEquals(newElem, u.last());			
		}
	}	

	public void test_addFirst_size_first(MethodTest mt) {
		DequeIdea<Thing> u = this.unit();		
		mt.assertEquals(0, u.size());
		int load = 3;
		for (int id = 1; id <= load; id++) {
			Thing newElem = new Thing(id);
			u.addFirst(newElem);
			mt.assertEquals(id, u.size());			
			mt.assertEquals(newElem, u.first());			
		}
	}	
	
	public void test_addLast_size_removeLast(MethodTest mt) {
		//addLast: 11, 12, 13
		//removeLast: 13, 12, 11 
		DequeIdea<Thing> u = this.unit();		
		mt.assertEquals(0, u.size());
		int load = 3, start = 11, stop = start + load - 1;
		for (int id = start; id <= stop; id++)
			u.addLast(new Thing(id));
		for (int id = stop; id >= start; id--) {
			Thing removed = u.removeLast();
			mt.assertEquals(id - start, u.size());			
			mt.assertEquals(removed, new Thing(id));			
		}
	}	
	
	public void test_addFirst_size_removeFirst(MethodTest mt) {
		//addFirst: 11, 12, 13 => resulting in 13, 12, 11 
		//removeFirst: 13, 12, 11 
		DequeIdea<Thing> u = this.unit();		
		mt.assertEquals(0, u.size());
		int load = 3, start = 11, stop = start + load - 1;
		for (int id = start; id <= stop; id++)
			u.addFirst(new Thing(id));
		for (int id = stop; id >= start; id--) {
			Thing removed = u.removeFirst();
			mt.assertEquals(id - start, u.size());			
			mt.assertEquals(removed, new Thing(id));			
		}
	}	
		
	public void test_first_empty_exception(MethodTest mt) {
		mt.assertExceptionIn(() -> this.unit().first(),
				() -> String.format("expecting exception (true) for first on empty structure"));
	}	
	
	public void test_last_empty_exception(MethodTest mt) {
		mt.assertExceptionIn(() -> this.unit().first(),
				() -> String.format("expecting exception (true) for last on empty structure"));
	}	
	
	public void test_removeFirst_empty_exception(MethodTest mt) {
		mt.assertExceptionIn(() -> this.unit().removeFirst(),
				() -> String.format("expecting exception (true) for first on empty structure"));
	}	
	
	public void test_removeLast_empty_exception(MethodTest mt) {
		mt.assertExceptionIn(() -> this.unit().removeLast(),
				() -> String.format("expecting exception (true) for last on empty structure"));
	}	
	
	/**
	 * This checks that each expected method (signature) exists
	 * with proper method parameters 
	 */
	public void test_specific_methodSignatures(MethodTest mt) {
		if (checkSignature(mt, "first"))
			mt.record(true, true);		
		if (checkSignature(mt, "last"))
			mt.record(true, true);		
		if (checkSignature(mt, "addFirst", Object.class))
			mt.record(true, true);
		if (checkSignature(mt, "addLast", Object.class))
			mt.record(true, true);		
		if (checkSignature(mt, "removeFirst"))
			mt.record(true, true);		
		if (checkSignature(mt, "removeLast"))
			mt.record(true, true);
	}		

	//----------------------------------------------------
	//Main entry point

	public static void main(String[] args) {
		//TODO
		_UnitTestManager.main(args);
	}

}
















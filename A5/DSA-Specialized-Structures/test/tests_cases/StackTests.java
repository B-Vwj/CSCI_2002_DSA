/**
    StackTests.java
    3/31/21
*/
package tests_cases;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import pub.SSFactory;
import pub.StackIdea;
import scorer.MethodTest;
import testutil.Thing;

public class StackTests extends SpecializedStructureTests {
	
	@Override
	protected StackIdea<Thing> unit() {
		return (StackIdea<Thing>)super.unit();
	}	

	@Override	
	@SuppressWarnings("unchecked")
	protected Supplier<StackIdea<Thing>> emptyStructureGenerator() {
		return (Supplier<StackIdea<Thing>>)super.emptyStructureGenerator();
	}	

	// ============================================
	// Constructors

	public StackTests(int maxPoints, String testCaseLabel,
			Supplier<StackIdea<Thing>> anEmptyStructureGenerator,
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
						"test_push_size_peek",
						"test_push_size_pop",
						"test_push_size_pop_larger_load",
						"test_pop_empty_exception",
						"test_peek_empty_exception"
				};
		result.addAll(Arrays.asList(localTestNames));
		return result.toArray(String[]::new);
	}
	
	@Override
	protected void gatherSpecialTestScores(List<SimpleEntry<String, Integer>> list) {
		super.gatherSpecialTestScores(list);
		//list.add(newKV("test_specific_methodSignatures", 10));		
		list.add(newKV("test_pop_empty_exception", 75));		
		list.add(newKV("test_peek_empty_exception", 75));		
	}	
	
	@Override
	public Object constructTestee() {
		return SSFactory.newLinkedStack();
	}
	
	protected boolean isToJavaListReversed() {
		return true;
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

	public void test_push_size_peek(MethodTest mt) {
		StackIdea<Thing> u = this.unit();		
		mt.assertEquals(0, u.size());
		for (int id=1; id<=3; id++) {
			u.push(new Thing(id));
			mt.assertEquals(id, u.size());			
			mt.assertEquals(new Thing(id), u.peek());			
		}
	}
	
	public void test_push_size_pop(MethodTest mt) {
		StackIdea<Thing> u = this.unit();		
		mt.assertEquals(0, u.size());
		for (int id = 1; id <= 3; id++)
			u.push(new Thing(id));
		//last-in-last-out (LIFO)
		for (int id = 3; id >= 1; id--) {
			mt.assertEquals(new Thing(id), u.pop());
			mt.assertEquals(id - 1, u.size());
		}
	}	
	
	public void test_push_size_pop_larger_load(MethodTest mt) {
		StackIdea<Thing> u = this.unit();		
		mt.assertEquals(0, u.size());
		for (int id = 1; id <= 1000; id++)
			u.push(new Thing(id));
		for (int id = 1000; id >= 1; id--) {
			mt.assertEquals(new Thing(id), u.pop());
			mt.assertEquals(id - 1, u.size());
		}
	}	
	
	public void test_pop_empty_exception(MethodTest mt) {
		mt.assertExceptionIn(() -> this.unit().pop(),
				() -> String.format("expecting exception (true) for pop on empty structure"));
	}	
	
	public void test_peek_empty_exception(MethodTest mt) {
		mt.assertExceptionIn(() -> this.unit().pop(),
				() -> String.format("expecting exception (true) for peek on empty structure"));
	}
	
	/**
	 * This checks that each expected method (signature) exists
	 * with proper method parameters 
	 */
	public void test_specific_methodSignatures(MethodTest mt) {
		if (checkSignature(mt, "push", Object.class))
			mt.record(true, true);
		if (checkSignature(mt, "pop"))
			mt.record(true, true);
		if (checkSignature(mt, "peek"))
			mt.record(true, true);
	}	

	//----------------------------------------------------
	//Main entry point

	public static void main(String[] args) {
		//TODO
		_UnitTestManager.main(args);
	}

}
















/**
    QueueTests.java
    3/31/21
*/
package tests_cases;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

import pub.QueueIdea;
import pub.SSFactory;
import scorer.MethodTest;
import testutil.Thing;

public class QueueTests extends SpecializedStructureTests {
	
	@Override
	protected QueueIdea<Thing> unit() {
		return (QueueIdea<Thing>)super.unit();
	}	

	@Override	
	@SuppressWarnings("unchecked")
	protected Supplier<QueueIdea<Thing>> emptyStructureGenerator() {
		return (Supplier<QueueIdea<Thing>>)super.emptyStructureGenerator();
	}	

	// ============================================
	// Constructors

	public QueueTests(int maxPoints, String testCaseLabel,
			Supplier<QueueIdea<Thing>> anEmptyStructureGenerator,
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
						"test_enqueue_size_peek",
						"test_enqueue_size_dequeue",
						"test_enqueue_size_dequeue_largerLoad",
						"test_dequeue_empty_exception",
						"test_peek_empty_exception"
				};
		result.addAll(Arrays.asList(localTestNames));
		return result.toArray(String[]::new);
	}
	
	@Override
	protected void gatherSpecialTestScores(List<SimpleEntry<String, Integer>> list) {
		super.gatherSpecialTestScores(list);
		//list.add(newKV("test_specific_methodSignatures", 10));		
		list.add(newKV("test_dequeue_empty_exception", 75));		
		list.add(newKV("test_peek_empty_exception", 75));		
	}	
	
	@Override
	public Object constructTestee() {
		return SSFactory.newLinkedQueue();
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

	public void test_enqueue_size_peek(MethodTest mt) {
		QueueIdea<Thing> u = this.unit();		
		mt.assertEquals(0, u.size());
		Thing firstElem = null;
		for (int id=1; id<=3; id++) {
			Thing newElem = new Thing(id);
			u.enqueue(newElem);
			if (id == 1) firstElem = newElem; 
			mt.assertEquals(id, u.size());			
			mt.assertEquals(firstElem, u.peek());			
		}
	}
	
	public void test_enqueue_size_dequeue(MethodTest mt) {
		QueueIdea<Thing> u = this.unit();		
		mt.assertEquals(0, u.size());
		int load = 3;
		for (int id = 1; id <= load; id++)
			u.enqueue(new Thing(id));
		//first-in-firt-out (FIFO)
		for (int id = 1; id <= load; id++) {
			mt.assertEquals(new Thing(id), u.dequeue(), "match");
			mt.assertEquals(load - id, u.size(), "size");
		}
	}	
	
	public void test_enqueue_size_dequeue_largerLoad(MethodTest mt) {
		QueueIdea<Thing> u = this.unit();
		int load = 3;		
		mt.assertEquals(0, u.size());
		for (int id = 1; id <= load; id++)
			u.enqueue(new Thing(id));
		//first-in-firt-out (FIFO)
		for (int id = 1; id <= load; id++) {
			mt.assertEquals(new Thing(id), u.dequeue(), "match");
			mt.assertEquals(load - id, u.size(), "size");
		}
	}	
	
	public void test_dequeue_empty_exception(MethodTest mt) {
		mt.assertExceptionIn(() -> this.unit().dequeue(),
				() -> String.format("expecting exception (true) for dequeue on empty structure"));
	}	
	
	public void test_peek_empty_exception(MethodTest mt) {
		mt.assertExceptionIn(() -> this.unit().dequeue(),
				() -> String.format("expecting exception (true) for peek on empty structure"));
	}	
	
	/**
	 * This checks that each expected method (signature) exists
	 * with proper method parameters 
	 */
	public void test_specific_methodSignatures(MethodTest mt) {
		if (checkSignature(mt, "enqueue", Object.class))
			mt.record(true, true);
		if (checkSignature(mt, "dequeue"))
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
















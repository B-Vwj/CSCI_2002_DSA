
/*
    DynamicList_Empty_Scorer.java
    02/14/21
    
    Note: We'll only run "test_methodSignatures" in this test case
*/
package tests_cases;

import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;

import pub.SpecializedStructureIdea;
import scorer.AbstractScorer;
import scorer.MethodTest;
import scorer.TestSpec;
import testutil.Thing;

/*
 * Specialized Structure Tests
 */
public abstract class SpecializedStructureTests extends AbstractScorer<TestSpec> {
	
	private SpecializedStructureIdea<Thing> unit;
	private Supplier<? extends SpecializedStructureIdea<Thing>> emptyStructureGenerator;
	
	// ============================================
	// Constructors
	public SpecializedStructureTests(int maxPoints, String testCaseLabel,
			Supplier<? extends SpecializedStructureIdea<Thing>> anEmptyStructureGenerator,
			String constructionSnippet) {
		super(maxPoints, testCaseLabel, constructionSnippet);
		this.emptyStructureGenerator = anEmptyStructureGenerator;		
	}
	
	// ============================================
	
	protected boolean isToJavaListReversed() {
		//virtual optional
		return false;
	}	
	
	protected SpecializedStructureIdea<Thing> unit() {
		return unit;
	}

	protected void unit(SpecializedStructureIdea<Thing> unit) {
		this.unit = unit;
	}	

	protected Supplier<? extends SpecializedStructureIdea<Thing>> emptyStructureGenerator() {
		return this.emptyStructureGenerator;
	}	
	
	protected void emptyStructureGenerator(Supplier<? extends SpecializedStructureIdea<Thing>> emptyStructureGenerator) {
		this.emptyStructureGenerator = emptyStructureGenerator;
	}	
		
	// ============================================
	// Housekeeping / Test Admin
	
	protected String[] getTestNames() {
		return new String[] {
		"test_common_methodSignatures",				
		"test_add_size",
		"test_add_isEmpty",
		"test_add_removeAll",
		"test_add_toJavaList"
		};
	}
	
	@Override
	protected void gatherSpecialTestScores(List<SimpleEntry<String, Integer>> list) {
		super.gatherSpecialTestScores(list);
		//test_methodSignatures is really to just provide info to the test case user
		list.add(newKV("test_common_methodSignatures", 10));		
	}	
	
	// =====================================================
	// Setup

	public void beforeEach() {
		this.unit = this.emptyStructureGenerator.get();		
	}

	// =====================================================
	// Tests
	
	/**
	 * This checks that each expected method (signature) exists
	 * with proper method parameters 
	 */
	public void test_common_methodSignatures(MethodTest mt) {
		if (checkSignature(mt, "size"))
			mt.record(true, true);
		if (checkSignature(mt, "isEmpty"))
			mt.record(true, true);
		if (checkSignature(mt, "removeAll"))
			mt.record(true, true);
	}	
	
	public void test_add_size(MethodTest mt) {
		SpecializedStructureIdea<Thing> u = this.unit();		
		mt.assertEquals(u.size(), 0);
		for (int id=1; id<=2; id++) {
			u.add(new Thing(id));
			mt.assertEquals(id, u.size());			
		}
	}
	
	public void test_add_isEmpty(MethodTest mt) {
		SpecializedStructureIdea<Thing> u = this.unit();		
		mt.assertEquals(u.isEmpty(), true);
		for (int id=1; id<=2; id++) {
			u.add(new Thing(id));
			mt.assertEquals(u.isEmpty(), false);			
		}
	}	
	
	public void test_add_removeAll(MethodTest mt) {
		SpecializedStructureIdea<Thing> u = this.unit();
		u.add(new Thing(1));		
		u.add(new Thing(2));		
		mt.assertFalse(u.isEmpty());
		u.removeAll();
		mt.assertTrue(u.isEmpty());		
	}	
	
	public void test_add_toJavaList(MethodTest mt) {
		SpecializedStructureIdea<Thing> u = this.unit();
		List<Thing> expected = new ArrayList<>();
 		int load = 3;
		for (int i = 1; i <= load; i++) {
			expected.add(new Thing(i));
			u.add(new Thing(i));
		}
		if (this.isToJavaListReversed())
			Collections.reverse(expected);
		mt.assertEquals(expected, u.toJavaList());
	}	
	
	//----------------------------------------------------
	//Main entry point

	public static void main(String[] args) {
		//TODO
		_UnitTestManager.main(args);
	}

}

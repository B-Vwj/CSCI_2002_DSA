
/*
    Abstract_DynamicList_Scorer.java.java
    02/14/21
    
    T: one element (a Thing with id "getId" of 7)
*/
package tests_cases;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

import pub.DynamicList;
import scorer.AbstractScorer;
import scorer.TestSpec;
import testutil.LinearTestTool;

public abstract class Abstract_DynamicList_TestCase<T> extends AbstractScorer<TestSpec> {

	protected DynamicList<T> unit;
	private Supplier<DynamicList<T>> emptyListGenerator;
	private String constructUnitSnippet;
	private BiConsumer<DynamicList<T>, T> bestAddFunction;
	
	public void setEmptyListGenerator(Supplier<DynamicList<T>> emptyListGenerator) {
		this.emptyListGenerator = emptyListGenerator;
	}

	public void setConstructUnitSnippet(String constructUnitSnippet) {
		this.constructUnitSnippet = constructUnitSnippet;
	}

	public Supplier<DynamicList<T>> getEmptyListGenerator() {
		return emptyListGenerator;
	}	

	// ============================================
	// Constructors
	
	public Abstract_DynamicList_TestCase(
			int maxPoints, 
			Supplier<DynamicList<T>> anEmptyListGenerator,
			String testCaseLabel,
			String constructUnitSnippet) {
		this(new TestSpec(maxPoints, testCaseLabel));
		this.emptyListGenerator = anEmptyListGenerator;
		this.constructUnitSnippet = constructUnitSnippet;
	}	

	private Abstract_DynamicList_TestCase(TestSpec aSpec) {
		super(aSpec);
		this.unit = null;
	}
	
	// ============================================
	// Overrides	
	
	@Override
	public Object constructTestee() {
		return this.getEmptyListGenerator().get(); 
	}
	
	@Override	
	protected int defaultTestScore() {
		return 100;
	}

	@Override
	protected void gatherSpecialTestScores(List<SimpleEntry<String, Integer>> list) {
		super.gatherSpecialTestScores(list);
	}

	@Override	
	protected int defaultMaxErrors() {
		return 4;
	}	
	
	@Override
	public String getConstructTesteeSnippet() {
		return this.constructUnitSnippet;
	}	
	
	// ============================================
	// Helpers	
	
	public BiConsumer<DynamicList<T>, T> getBestAddFunction(T data1, T data2) {
		//lazily init'd
		if (bestAddFunction != null)
			return bestAddFunction;
		bestAddFunction = LinearTestTool.bestAddFunction(this.emptyListGenerator, data1, data2);  
		return bestAddFunction;
	}	
	
	public Supplier<String> unitToString() {
		return () -> this.unit.toString();
	}
	
}

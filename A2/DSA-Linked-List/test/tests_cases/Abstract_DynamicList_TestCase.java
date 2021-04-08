
/*
    Abstract_DynamicList_Scorer.java.java
    02/14/21
    
    ?: one element (a Thing with id "getId" of 7)
*/
package tests_cases;

import java.util.AbstractMap.SimpleEntry;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

import linearpub.DynamicList;
import scorer.AbstractScorer;
import scorer.TestSpec;
import testutil.LinearTestTool;
import testutil.Thing;

public abstract class Abstract_DynamicList_TestCase extends AbstractScorer<TestSpec> {
	
	private TesteeFactory listFactory;
	
	public BiConsumer<DynamicList<?>, ?> getBestAddFunction() {
		return bestAddFunction;
	}

	public void setBestAddFunction(BiConsumer<DynamicList<?>, ?> bestAddFunction) {
		this.bestAddFunction = bestAddFunction;
	}

	protected DynamicList<?> unit;
	
	@SuppressWarnings("unchecked")
	protected DynamicList<Thing> unit() {
		return (DynamicList<Thing>)this.unit;
	}	
	
	protected void setUnit(DynamicList<Thing> aUnit) {
		this.unit = aUnit;
	}		
	
	private String constructUnitSnippet;
	private BiConsumer<DynamicList<? extends Object>, ? extends Object> bestAddFunction;
	
	public void setConstructUnitSnippet(String constructUnitSnippet) {
		this.constructUnitSnippet = constructUnitSnippet;
	}

	// ============================================
	// Constructors
	
	public Abstract_DynamicList_TestCase(
			int maxPoints, 
			String testCaseLabel,
			String constructUnitSnippet) {
		this(new TestSpec(maxPoints, testCaseLabel));
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
		return this.getListFactory().newList(); 
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
	
	public TesteeFactory getListFactory() {
		return listFactory;
	}

	public void setListFactory(TesteeFactory listFactory) {
		this.listFactory = listFactory;
	}	
	
	// ============================================
	// Helpers	
	
	public <U> BiConsumer<DynamicList<U>, U> getBestAddFunction(U data1, U data2) {
		//lazily init'd
		return LinearTestTool.bestAddFunction(
				() -> this.getListFactory().newList(), data1, data2);  
	}	
	
	public Supplier<String> unitToString() {
		return () -> this.unit.toString();
	}
	
}

package tests_cases;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import scorer.AbstractScorer;
import scorer.TestSpec;
import unit_test.unit_test_model.UnitTestManager;

public class DynamicListTestSuite extends UnitTestManager {
	
	private TesteeFactory fac;
	private String constructionSnippet;
	
	//--------------------------------------------------------
	
	public DynamicListTestSuite(String aConstructionSnippet, TesteeFactory aFac) {
		this(false);
		this.constructionSnippet = aConstructionSnippet;
		this.fac = aFac;
	}	
	
	public DynamicListTestSuite(boolean aShouldScore) {
		super(aShouldScore);
	}
	
	//---------------------------------------------------------------
	//Building Test Cases	

	@Override
	protected LinkedHashMap<String, AbstractScorer<TestSpec>> buildTestCases() {
		LinkedHashMap<String, AbstractScorer<TestSpec>> map = new LinkedHashMap<>();
		List<Supplier<Abstract_DynamicList_TestCase>> generators;
		generators = new ArrayList<>();
		generators.add(() -> new EmptyList_Tests());
		generators.add(() -> new OneElement_Tests());
		generators.add(() -> new ManyElements_Tests());
		generators.add(() -> new AddingInserting_Tests());
		generators.add(() -> new Removing_Tests());
		generators.add(() -> new LoadTests_Tests());
		for (Supplier<Abstract_DynamicList_TestCase> gen: generators) {
			Abstract_DynamicList_TestCase tc = gen.get();
			tc.setConstructUnitSnippet(this.constructionSnippet);
			tc.setListFactory(this.fac);
			map.put(tc.testCaseName(), tc);
		}
		return map;
	}
	
	//--------------------------------------------------------	

	@Override	
	public List<AbstractScorer<TestSpec>> testCases() {
		return new ArrayList<>(this.getTestCases().values());
	}	

	@Override	
	public List<String> testCaseNames() {
		return testCases().stream()
			.map(testCase -> testCase.testCaseName())
			.collect(Collectors.toList());
	}

	//---------------------------------------------------------------
	//Run All
	
	public void runAll() {
		run(false, this.testCaseNames(), new ArrayList<>());
	}
	
	public void runAll(boolean headFull, boolean shouldScore) {
		setHeadfull(headFull);
		setShouldScore(shouldScore);
		runAll();
	}	
	
	public static void runAllTestCases(boolean b) {
		DynamicListTestSuite mgr = new DynamicListTestSuite(b);
		mgr.setHeadfull(false);
		mgr.runAll();
	}	
	
	public static void main(String[] args) {
		String[] array = args;
		array = new String[]{"y"};
		DynamicListTestSuite.runAllTestCases(array.length > 0 ? array[0].toLowerCase().equals("y") : false);
	}
	
}

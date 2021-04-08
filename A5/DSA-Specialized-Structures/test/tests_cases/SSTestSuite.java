package tests_cases;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

import pub.SSFactory;
import scorer.AbstractScorer;
import scorer.TestSpec;
import unit_test.unit_test_model.UnitTestManager;

@SuppressWarnings("unused")
public class SSTestSuite<T> extends UnitTestManager {

	public SSTestSuite() {
		this(false);
	}	
	
	public SSTestSuite(boolean aShouldScore) {
		super(aShouldScore);
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
	//Building Test Cases	

	@Override
	protected LinkedHashMap<String, AbstractScorer<TestSpec>> buildTestCases() {
		LinkedHashMap<String, AbstractScorer<TestSpec>> map = new LinkedHashMap<>();
		AbstractScorer<TestSpec> tc;
		
		tc = new StackTests(13, "Stack Tests (Linked)", () -> SSFactory.newLinkedStack(), "SSFactory.newLinkedStack()");
		map.put(tc.testCaseName(), tc);
		tc = new StackTests(12, "Stack Tests (Arrayed)", () -> SSFactory.newArrayedStack(), "SSFactory.newArrayedStack()");
		map.put(tc.testCaseName(), tc);
		
		tc = new QueueTests(13, "Queue Tests (Linked)", () -> SSFactory.newLinkedQueue(), "SSFactory.newLinkedQueue()");
		map.put(tc.testCaseName(), tc);
		tc = new QueueTests(12, "Queue Tests (Arrayed)", () -> SSFactory.newArrayedQueue(), "SSFactory.newArrayedQueue()");
		map.put(tc.testCaseName(), tc);
		
		tc = new DequeTests(13, "Deque Tests (Linked)", () -> SSFactory.newLinkedDeque(), "SSFactory.newLinkedDeque()");
		map.put(tc.testCaseName(), tc);
		tc = new DequeTests(12, "Deque Tests (Arrayed)", () -> SSFactory.newArrayedDeque(), "SSFactory.newArrayedDeque()");
		map.put(tc.testCaseName(), tc);
		
		tc = new BagTests(13, "Bag Tests (Linked)", () -> SSFactory.newLinkedBag(), "SSFactory.newLinkedBag()");
		map.put(tc.testCaseName(), tc);
		tc = new BagTests(12, "Bag Tests (Arrayed)", () -> SSFactory.newArrayedBag(), "SSFactory.newArrayedBag()");
		map.put(tc.testCaseName(), tc);		
								
		return map;
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
	
	public static <U> void runAllTestCases(boolean b) {
		SSTestSuite<U> mgr = new SSTestSuite<>(b);
		mgr.setHeadfull(false);
		mgr.runAll();
	}	
	
	public static void main(String[] args) {
		String[] array = args;
		array = new String[]{"y"};
		SSTestSuite.runAllTestCases(array.length > 0 ? array[0].toLowerCase().equals("y") : false);
	}
	
}

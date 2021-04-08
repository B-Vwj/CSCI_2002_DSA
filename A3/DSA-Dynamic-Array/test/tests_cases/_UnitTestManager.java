package tests_cases;

public class _UnitTestManager {
	
	public static DynamicListTestSuite newTestSuiteWithScoring() {
		DynamicListTestSuite suite;
		suite = new DynamicListTestSuite(constructLLUnitSnippet(), new DynamicArrayTesteeFactory());
		suite.setShouldScore(true);
		return suite;
	}		

	public static DynamicListTestSuite newTestSuite() {
		DynamicListTestSuite suite;
		suite = new DynamicListTestSuite(constructLLUnitSnippet(), new DynamicArrayTesteeFactory());
		return suite;
	}
	
	//----------------------------

	public static void main(String[] args) {
		DynamicListTestSuite suite;
		suite = new DynamicListTestSuite(constructLLUnitSnippet(), new DynamicArrayTesteeFactory());
		//String[] array = args;
		String[] array = new String[] { "y" };
		boolean shouldScore = array.length > 0 ? array[0].toLowerCase().equals("y") : false;
		suite.runAll(false, shouldScore);
	}

	private static String constructLLUnitSnippet() {
		return "DynamicArrayFactory.newList()";
	}
}

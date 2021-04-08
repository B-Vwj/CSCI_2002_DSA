package tests_cases;

import testutil.Thing;

public class _UnitTestManager {
	
	public static <T> SSTestSuite<T> newTestSuiteWithScoring() {
		SSTestSuite<T> suite;
		suite = new SSTestSuite<>();
		suite.setShouldScore(true);
		return suite;
	}		

	public static <T> SSTestSuite<T> newTestSuite() {
		SSTestSuite<T> suite;
		suite = new SSTestSuite<>();
		return suite;
	}
	
	//----------------------------

	public static void main(String[] args) {
		SSTestSuite<Thing> suite;
		suite = new SSTestSuite<>();
		//String[] array = args;
		String[] array = new String[] { "y" };
		boolean shouldScore = array.length > 0 ? array[0].toLowerCase().equals("y") : false;
		suite.runAll(false, shouldScore);
	}

}

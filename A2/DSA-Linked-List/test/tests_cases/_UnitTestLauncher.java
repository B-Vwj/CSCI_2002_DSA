package tests_cases;

import unit_test.unit_test_ui.UnitTestConfiguration;
import unit_test.unit_test_ui.UnitTestUI;

public class _UnitTestLauncher {
	
	public static void main(String[] args) {
		UnitTestConfiguration.setTestManager(_UnitTestManager.newTestSuiteWithScoring());
		UnitTestUI.openView();
	}

}

package linkedlisttest;

/*
 * LLPrimSmokeTest.java
 * LL = Linked List
 * 
 *  A smoke test on LinkedList using primitive like values (Integers).
 *  
 *  Ivar "list" is the testee that we test.
 *  
 *  We just test on an empty list here
 *  
 */

import java.util.ArrayList;
import java.util.List;

import linearpub.DynamicList;
import linearpub.LinkedListFactory;
import testutil.SubTest;
import testutil.UnitTest;
import testutil.UnitTestManager;

public class LLPrimSmokeTest extends UnitTest {
	
	DynamicList<Integer> list;	//testee	
	
	//--------------------------------------------------------------
		
	public void beforeEach() {
		//Called before each test
		//Test setup
		super.beforeEach();
		this.list =	LinkedListFactory.newList(); 
	}
	
	public void afterEach() {
		//Called after each test
		//Test teardown / cleanup
		super.afterEach();
		this.list =	null; 
	}		

	//--------------------------------------------------------------
	//Tests

	private void testConstruct() {
		//Simply make sure an object was constructed (not a null)
		assertNotEquals(null, list);
	}

	private void testSize() {
		//We expect that ivar "list" is empty 
		assertEquals(0, list.size());
	}

	private void testIsEmpty() {
		//We expect that ivar "list" is empty 
		assertEquals(true, list.isEmpty());
	}	

	//--------------------------------------------------------------
	//Test Entry Point (Startup)

	public static void main(String[] args) {
		LLPrimSmokeTest unitTest = new LLPrimSmokeTest();
		UnitTestManager<LLPrimSmokeTest> mgr;
		mgr = new UnitTestManager<>("LinkedList", unitTest, unitTest.subTests()); 
		mgr.runAll();
	}	
	
	private List<SubTest> subTests() {
		//Build the sub-tests
		List<SubTest> tests = new ArrayList<>();
		tests.add(newSubTest("testConstruct1", () -> this.testConstruct()));
		tests.add(newSubTest("testConstruct2", () -> this.testSize()));
		tests.add(newSubTest("testAddGet", () -> this.testIsEmpty()));		
		return 	tests;
	}		

}

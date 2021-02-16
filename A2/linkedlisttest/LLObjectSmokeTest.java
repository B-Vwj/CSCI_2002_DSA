package linkedlisttest;

/*
 * LLObjectSmokeTest
 * LL = Linked List
 * 
 * The same test as LinkedListPrimSmokeTest except our
 * elements are objects rather than primitive-like objects.
 *   
 */

import java.util.ArrayList;
import java.util.List;

import linearpub.DynamicList;
import linearpub.LinkedListFactory;
import testutil.SubTest;
import testutil.Thing;
import testutil.UnitTest;
import testutil.UnitTestManager;

public class LLObjectSmokeTest extends UnitTest {
	
	DynamicList<Thing> list;	//testee	
	
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
		LLObjectSmokeTest unitTest = new LLObjectSmokeTest();
		UnitTestManager<LLObjectSmokeTest> mgr;
		mgr = new UnitTestManager<>("LinkedList", unitTest, unitTest.subTests()); 
		mgr.runAll();
	}	
	
	private List<SubTest> subTests() {
		//Build the sub-tests
		List<SubTest> tests = new ArrayList<>();
		tests.add(newSubTest("testConstruct", () -> this.testConstruct()));
		tests.add(newSubTest("testSize", () -> this.testSize()));
		tests.add(newSubTest("testIsEmpty", () -> this.testIsEmpty()));
		return 	tests;
	}		

}

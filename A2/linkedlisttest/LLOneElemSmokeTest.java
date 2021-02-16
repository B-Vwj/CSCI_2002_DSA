package linkedlisttest;

/*
 * LLOneElemSmokeTest
 * LL = Linked List
 * 
 *  A smoke test on LinkedList using primitive like values (Integers).
 *  
 *  Ivar "list" is the testee that we test.
 *  
 *  We test a list of size one here.
 *  
 */

import java.util.ArrayList;
import java.util.List;

import linearpub.DynamicList;
import linearpub.LinkedListFactory;
import testutil.SubTest;
import testutil.UnitTest;
import testutil.UnitTestManager;

public class LLOneElemSmokeTest extends UnitTest {
	
	DynamicList<Integer> list;	//testee	
	
	//--------------------------------------------------------------
	
	public int testElement() {
		return 101;
	}
		
	public void beforeEach() {
		//Called before each test
		//Test setup
		super.beforeEach();
		this.list = LinkedListFactory.newList();
		this.list.add(testElement());
	}
	
	public void afterEach() {
		//Called after each test
		//Test teardown / cleanup
		super.afterEach();
		this.list =	null; 
	}		

	//--------------------------------------------------------------
	//Tests

	private void testSize() {
		//We expect that ivar "list" is empty 
		assertEquals(1, list.size());
	}

	private void testIsEmpty() {
		//We expect that ivar "list" is empty 
		assertEquals(false, list.isEmpty());
	}
	
	private void testFirst() {
		//First (and only) element should be equal to the test element 
		assertEquals(testElement(), list.first());
	}		
	
	private void testLast() {
		//Last (and only) element should be equal to the test element 
		assertEquals(testElement(), list.last());
	}	

	//--------------------------------------------------------------
	//Test Entry Point (Startup)

	public static void main(String[] args) {
		LLOneElemSmokeTest unitTest = new LLOneElemSmokeTest();
		UnitTestManager<LLOneElemSmokeTest> mgr;
		mgr = new UnitTestManager<>("LinkedList", unitTest, unitTest.subTests()); 
		mgr.runAll();
	}	
	
	private List<SubTest> subTests() {
		//Build the sub-tests
		List<SubTest> tests = new ArrayList<>();
		tests.add(newSubTest("testSize", () -> this.testSize()));
		tests.add(newSubTest("testIsEmpty", () -> this.testIsEmpty()));
		tests.add(newSubTest("testFirst", () -> this.testFirst()));
		tests.add(newSubTest("testLast", () -> this.testLast()));		
		return 	tests;
	}		

}

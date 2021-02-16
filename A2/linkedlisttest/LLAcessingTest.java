package linkedlisttest;

/*
 * LLAcessingTest
 * LL = Linked List
 * 
 *  We test list accessing behaviors here.
 *  See "DynamicList.java" for the list
 *  labeled "Accessing".
 *  
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import linearpub.DynamicList;
import linearpub.LinkedListFactory;
import testutil.SubTest;
import testutil.Thing;
import testutil.UnitTest;
import testutil.UnitTestManager;
import static testutil.TestTool.map;

public class LLAcessingTest extends UnitTest {

	DynamicList<Thing> list; //testee	

	//--------------------------------------------------------------

	public List<Integer> listElementIds() {
		return Arrays.asList(100, 101, 102, 103, 104, 105, 106, 107, 108, 109);
	}

	public void beforeEach() {
		//Called before each test
		//Test setup
		//Construct our testee list ivar
		super.beforeEach();
		list = LinkedListFactory.newList();
		for (int eachId : listElementIds())
			list.add(new Thing(eachId));
	}

	public void afterEach() {
		//Called after each test
		//Test teardown / cleanup
		super.afterEach();
		list = null;
	}

	//--------------------------------------------------------------
	//Tests

	private void testSubListFromStart() {
		//subList between 0-3 (inclusive-exclusive) which
		//means elements at indexes 0, 1 and 2
		//Ids start at 1
		DynamicList<Thing> subList;
		List<Integer> expectedIds = Arrays.asList(100, 101, 102), actualIds;
		subList = list.subList(0, 3);
		actualIds = map(subList.toJavaList(), thing -> thing.getId());
		assertEquals(expectedIds, actualIds);
	}

	private void testToJavaList() {
		List<Integer> actualIds;
		actualIds = map(list.toJavaList(), thing -> thing.getId());
		assertEquals(listElementIds(), actualIds);
	}

	//--------------------------------------------------------------
	//Test Entry Point (Startup)

	public static void main(String[] args) {
		LLAcessingTest unitTest = new LLAcessingTest();
		UnitTestManager<LLAcessingTest> mgr;
		mgr = new UnitTestManager<>("LinkedList", unitTest, unitTest.subTests());
		mgr.runAll();
	}

	private List<SubTest> subTests() {
		//Build the sub-tests
		List<SubTest> tests = new ArrayList<>();
		tests.add(newSubTest("testSubListFromStart", () -> this.testSubListFromStart()));
		tests.add(newSubTest("testToJavaList", () -> this.testToJavaList()));
		return tests;
	}

}

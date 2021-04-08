package pub;

import ss.*;
import pub.*;

/*
	Class: SSFactory.java
	Description:
		Specialized structure factory.
*/

public class SSFactory {

	//---------------------------------------------------------
	//Generate Stacks (one linked, one arrayed)

	@SuppressWarnings("unchecked")
	public static <T> StackIdea<T> newLinkedStack() {
		//return linked stack
		DynamicList list = LinkedListFactory.newList();
		Stack<T> stack = new Stack(list);
		return stack;
	}

	@SuppressWarnings("unchecked")
	public static <T> StackIdea<T> newArrayedStack() {
		//return arrayed stack (replace "return null")
		DynamicList list = DynamicArrayFactory.newList();
		Stack<T> stack = new Stack(list);
		return stack;
	}
	
	//---------------------------------------------------------
	//Generate Queues (one linked, one arrayed)	

	@SuppressWarnings("unchecked")
	public static <T> QueueIdea<T> newLinkedQueue() {
		//return linked queue
		DynamicList list = LinkedListFactory.newList();
		Queue<T> q = new Queue(list);
		return q;
	}

	@SuppressWarnings("unchecked")
	public static <T> QueueIdea<T> newArrayedQueue() {
		//return arrayed queue (replace "return null")
		DynamicList list = DynamicArrayFactory.newList();
		Queue<T> q = new Queue(list);
		return q;
	}
	
	//---------------------------------------------------------
	//Generate Deques (one linked, one arrayed)	

	@SuppressWarnings("unchecked")
	public static <T> DequeIdea<T> newLinkedDeque() {
		//return linked deque (replace "return null")
		DynamicList list = LinkedListFactory.newList();
		Dequeue<T> dq = new Dequeue(list);
		return dq;
	}

	@SuppressWarnings("unchecked")
	public static <T> DequeIdea<T> newArrayedDeque() {
		//return arrayed deque (replace "return null")
		DynamicList list = DynamicArrayFactory.newList();
		Dequeue<T> dq = new Dequeue(list);
		return dq;
	}
	
	//---------------------------------------------------------
	//Generate Bags (one linked, one arrayed)	

	@SuppressWarnings("unchecked")
	public static <T> BagIdea<T> newLinkedBag() {
		//return linked bag (replace "return null")
		DynamicList list = LinkedListFactory.newList();
		Bag<T> bag = new Bag(list);
		return bag;
	}

	@SuppressWarnings("unchecked")
	public static <T> BagIdea<T> newArrayedBag() {
		//return arrayed bag (replace "return null")
		DynamicList list = DynamicArrayFactory.newList();
		Bag<T> bag = new Bag(list);
		return bag;
	}	
		
}

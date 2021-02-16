package linearpub;

import linkedlist.LinkedList;

/*
 * LinkedListFactory
 * 	Factory that generates and returns linked list
 */

public class LinkedListFactory {

	public static <T> DynamicList<T> newList() {
		return new LinkedList<T>();
	}

}

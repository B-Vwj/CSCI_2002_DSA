package pub;
/**
 * 	DynamicList.java
	Interface: DynamicList
	Description:
		Idea for structure that:
			- supports indexed access
			- dynamic size (add/remove supported -- in contrast to a fixed structure)
	Notes:
		1) Generally valid index is from 0 to (list size - 1). There may be (noted) exceptions 
			(like for "insert")
*/

import java.util.Iterator;
import java.util.List;
import java.util.function.Function;


public interface DynamicList<E> extends Iterable<E> {
	
	//-------------------- Basic Statistics ---------------------
	
	/**
	 * Returns number of elements in this list 
	 */
	int size();
	
	/**
	 * Returns true if this list contains no elements
	 */
	boolean isEmpty();

	//--------------------- Accessing ---------------------
	
	/**	
	 * Returns element at given index.
	 * Throws IndexOutOfBoundsException if passed index is invalid. 
	 */
	E get(int index);
	
	/**
	 * Returns a new list containing the elements of this list
	 * 		between the given index "start" (inclusive) and
	 * 		the given index "stop" (exclusive)
	 * Throws IndexOutOfBoundsException if either passed index is invalid.
	 */	
	DynamicList<E> subList(int start, int stop);
	
	/**
	 * Returns first element 
	 * Throws RuntimeException if list is empty
	 */	
	E first();
	
	/**
	 * Return last element 
	 * Throws RuntimeException if list is empty
	 */	
	E last();
	
	/**
	 * Returns index of first matching element (where searchFct outputs true) 
	 * Return -1 if no match
	 */	
	int find(Function<E, Boolean> searchFct);
 		
	//--------------------- Adding ---------------------
	
	/**
	 * Adds the passed element to start of list 
	 */	
	void addFirst(E newElem);
	
	/**
	 * Adds the passed element to end of list 
	 */	
	void addLast(E newElem);
	
	/**
	 * Alias for "addLast" (same functionality) 
	 */	
	void add(E newElem);
	
	/**
	 * Inserts passed element into list at the passed index
	 * Before insert, all elements from index to right are shifted right
	 * Valid index is from 0 to size
	 * If index = size, then does simple append (addLast)
 	 * Throws IndexOutOfBoundsException if passed index is invalid 
	 */		
	void insert(int index, E newElem);	
 		
	//--------------------- Removing ---------------------
	
	/**
	 * Removes first element 
	 * Returns removed element
	 * Throws RuntimeException if list is empty 
	 */	
	E removeFirst();
	
	/**
	 * Removes last element 
	 * Returns removed element
	 * Throws RuntimeException if list is empty 
	 */		
	E removeLast();
	
	/**
	 * Resets the list so it is empty
	 * If list is already empty, then does nothing
	 * No action is performed on the elements
	 *
	 */	
	void removeAll();
	
	/**
	 * Removes elem at index 
	 * Returns the removed element
 	 * Throws IndexOutOfBoundsException if passed index is invalid
	 */	
	public E removeIndex(int index);	
	
	/**
	 * Removes first matching element (where searchFct outputs true) 
	 * Returns the removed element
	 * If no match, return null
	 */	
	E remove(Function<E, Boolean> searchFct);	
 	
	//--------------------- Convenience ---------------------

	/**
	 * Returns a Java "List<E>" containing all elements in this list 
	 */	
	List<E> toJavaList();
	
	
	/**
	 * Returns one-line user-friendly message about this object 
	 * Helpful method especially for debugging
	 */	
	String toString();
	
	//---------------------------------------------------------------------
	//--------------------- Optional ---------------------

	/**
	 * Returns iterator on this list
	 * Optional operation 
	 */	
	default Iterator<E>	iterator() { throw notImplemented(); }		

	private static RuntimeException notImplemented() {
		return new RuntimeException("Not Implemented");
	}
	
}

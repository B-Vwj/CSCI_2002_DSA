package pub;

import java.util.Iterator;
import java.util.List;

/**
 * SpecializedStructure.java
 * Interface: SpecializedStructure
 * Description: The idea for a specialized structure
 * Notes:
 * 	1) The super-interface for specialized structure ideas
 * 	2) This interface will NOT be implemented
 * 	3) Sub-interfaces will be implemented   
 */

public interface SpecializedStructureIdea<E> extends Iterable<E> {
	
	//-------------------- Basic Statistics ---------------------

	/**
	 * Returns number of elements in this structure 
	 */
	int size();

	/**
	 * Returns true if this structure contains no elements
	 */
	boolean isEmpty();

	//--------------------- Adding ---------------------

	/**
	 * Convenience (familiar protocol) method "add"
	 * Each sub-interface should decides and documents what
	 * add does. E.g., for Stack it "add" would do a "push"
	 * Note that if an abstract class implements this interface,
	 * then "add" might be declared abstract (and let
	 * subclasses implement). 
	*/
	public void add(E newElem);

	//--------------------- Removing ---------------------

	/**
	 * Resets structure so it is empty
	 * If structure is already empty, then does nothing
	 * No action is performed on the elements
	 *
	 */
	void removeAll();

	//--------------------- Convenience ---------------------

	/**
	 * Returns a Java "List<E>" containing all elements in this structure
	 * in the proper order for the structure (sub-interface will document) 
	 */
	List<E> toJavaList();

	/**
	 * Returns one-line user-friendly message about this object 
	 * Helpful method especially for debugging
	 */
	String toString();

	//--------------------- Optional ---------------------

	/**
	 * Displays (prints) all the elements to the console
	 * Optional operation 
	 */
	default void display() {
		throw notImplemented();
	}

	/**
	 * Returns iterator on this structure
	 * Iterator should iterate in same order as used in "toJavaList"
	 * Optional operation
	 */
	default Iterator<E> iterator() {
		throw notImplemented();
	}

	private static RuntimeException notImplemented() {
		return new RuntimeException("Not Implemented");
	}

}

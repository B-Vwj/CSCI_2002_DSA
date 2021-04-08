package pub;

/**
 * DequeIdea.java
 * Interface: DequeIdea
 * Description: The idea for a Deque structure
 * Notes:
 * 	1) Also see super-interface
 * 	2) The (inherited) "add" method does an "addLast"
 * 	3) The (inherited) "toJavaList" returns list in first to last order    
 */

public interface DequeIdea<E> extends SpecializedStructureIdea<E> {
	
	//--------------------- Accessing ---------------------	

	/**
	 * Returns first element 
	 * Throws RuntimeException if list is empty
	 */	
	E first();
	
	/**
	 * Returns last element 
	 * Throws RuntimeException if list is empty
	 */	
	E last();		
	
	//--------------------- Adding ---------------------

	/**
	 * Adds the passed element to start of list 
	 */	
	void addFirst(E newElem);
	
	/**
	 * Adds the passed element to end of list 
	 */	
	void addLast(E newElem);
	
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
		
}

package pub;

/**
 * QueueIdea.java
 * Interface: QueueIdea
 * Description: The idea for a Queue structure
 * Notes:
 * 	1) Also see super-interface
 * 	2) The (inherited) "add" method does an "enqueue"
 * 	3) The (inherited) "toJavaList" returns a list of elements in first to 
 * 			last order (i.e., the order elements would be "dequeued")    
 */

public interface QueueIdea<E> extends SpecializedStructureIdea<E> {
	
	/**
	 * Adds newElem to rear (end) of queue (as new last element)
	*/
	public void enqueue(E newElem);
		
	/**
	 * Removes and returns front/first element
	 * Returns the removed element
	 * Throws RuntimeException if list is empty
	 */	
	E dequeue();
	
	/**
	 * Returns front/first element
	 * Does NOT remove element
	 * If structure is empty, return null
	 */	
	E peek();		
	
}

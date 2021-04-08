package pub;

/**
 * StackIdea.java
 * Interface: StackIdea
 * Description: The idea for a Stack structure
 * Notes:
 * 	1) Also see super-interface
 * 	2) The (inherited) "add" method does a "push"
 * 	3) The (inherited) "toJavaList" returns a list of elements in top to 
 * 			bottom order (i.e., the order elements would be "popped")   
 */

public interface StackIdea<E> extends SpecializedStructureIdea<E> {
	
	/**
	 * Pushes (adds) element onto top of stack
	*/
	public void push(E newElem);
	
	/**
	 * Removes element from top of stack
	 * Returns the removed element
	 * Throws RuntimeException if stack is empty
	 */	
	E pop();	
	
	/**
	 * Returns element from top of stack
	 * Does NOT remove element
	 * If structure is empty, return null
	 */	
	E peek();		
	
}

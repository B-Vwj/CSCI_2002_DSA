package pub;

import java.util.function.Function;

/**
 * BagIdea.java
 * Interface: BagIdea
 * Description: The idea for a Bag structure
 * Notes:
 * 	1) Also see super-interface
 * 	2) The (inherited) "toJavaList" returns list where order does
 * 		not matter (can be in ANY order)    
 */

public interface BagIdea<E> extends SpecializedStructureIdea<E> {
	
	/**
	 * Returns true if structure contains matching element (where searchFct outputs true) 
	 * Otherwise returns false
	 */	
	boolean contains(Function<E, Boolean> searchFct);	
	
	/**
	 * Returns any element from structure (implementor's choice as to which element) 
	 * Throws RuntimeException if list is empty
	 */	
	E any();

	/**
	 * Adds element into structure
	 * Element is added is to unspecified position -- may be anywhere -- implementor's choice 
	 */	
	void add(E newElem);
	
	/**
	 * Removes first matching element (where searchFct outputs true) 
	 * Returns the removed element
	 * If no match, return null
	 */	
	E remove(Function<E, Boolean> searchFct);
	
}

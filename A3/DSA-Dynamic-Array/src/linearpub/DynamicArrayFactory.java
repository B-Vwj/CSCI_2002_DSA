package linearpub;

import dynarray.*;

/*
 * DynamicArrayFactory
 * 	I am a factory that generates and returns a dynamic array
 */

@SuppressWarnings("unchecked")
public class DynamicArrayFactory {

	@SuppressWarnings("unchecked")
	public static <T> DynamicList<T> newList() {
		//return new empty dynamic array
		return new DynArr();
	}

	@SuppressWarnings("unchecked")
	public static <T> DynamicList<T> newList(int growthFactor) {
		//return new empty dynamic array
		return new DynArr(10, growthFactor);
	}	
	
	
}

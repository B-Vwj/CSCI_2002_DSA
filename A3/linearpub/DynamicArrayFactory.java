package linearpub;

import dynarray.*;

/*
 * DynamicArrayFactory
 * 	I am a factory that generates and returns a dynamic array
 */

public class DynamicArrayFactory {

	public static <T> DynamicList<T> newList() {
		//return new empty dynamic array
		return new DynArr();
	}

	public static <T> DynamicList<T> newList(int growthFactor) {
		//return new empty dynamic array
		return new DynArr(10, growthFactor);
	}	
	
	
}

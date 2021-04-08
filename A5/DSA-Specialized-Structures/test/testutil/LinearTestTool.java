package testutil;

import java.util.function.BiConsumer;
import java.util.function.Supplier;

import pub.DynamicList;
import scorer.BlockClosure;

public class LinearTestTool {
	
	public static <T> boolean checkAdd(T t1, T t2, 
										Supplier<DynamicList<T>> emptyListGenerator,
										BiConsumer<DynamicList<T>, T> addFct) {
		DynamicList<T> list = emptyListGenerator.get();
		addFct.accept(list,  t1);
		if (list.size() != 1) return false;
		addFct.accept(list,  t2);
		if (list.size() != 2) return false;
		return true;
	}
		
	public static <T> BiConsumer<DynamicList<T>, T> bestAddFunction(
			Supplier<DynamicList<T>> emptyListGenerator, T t1, T t2
			) {
		//preferred
		if (checkAdd(t1, t2, emptyListGenerator, (l, elem) -> l.addLast(elem)))
			return (l, elem) -> l.addLast(elem);
		if (checkAdd(t1, t2, emptyListGenerator, (l, elem) -> l.add(elem)))
			return (l, elem) -> l.add(elem);			
		if (checkAdd(t1, t2, emptyListGenerator, (l, elem) -> l.addFirst(elem)))
			return (l, elem) -> l.addFirst(elem);
		//Default is addLast
		return (l, elem) -> l.addLast(elem); 
	}
	
	public static <T> T handleException(Supplier<T> supplier, T defaultReturn) {
		//return object via supplier, or null on exception
		try { return supplier.get(); }
		catch(Exception ex) { return defaultReturn; }
	}
	
	public static <T> T handleException(Supplier<T> supplierFct) {
		return handleException(supplierFct, null);
	}	
	
	public static boolean generatesException(BlockClosure evaluable) {
		//return true if exception occurs
		try { evaluable.evaluate(); return false; }
		catch(Exception ex) { return true; }
	}	
	
}


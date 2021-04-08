package tests_cases;

import linearpub.DynamicArrayFactory;
import linearpub.DynamicList;

public interface TesteeFactory {
	<T> DynamicList<T> newList();
}

class LinkedListTesteeFactory implements TesteeFactory {

	@Override
	public <T> DynamicList<T> newList() {
		return null;
	}
}

class DynamicArrayTesteeFactory implements TesteeFactory {

	@Override
	public <T> DynamicList<T> newList() {
		return DynamicArrayFactory.newList();
	}
}
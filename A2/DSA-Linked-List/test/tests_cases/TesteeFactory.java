package tests_cases;

import linearpub.DynamicList;
import linearpub.LinkedListFactory;

public interface TesteeFactory {
	<T> DynamicList<T> newList();
}

class LinkedListTesteeFactory implements TesteeFactory {

	@Override
	public <T> DynamicList<T> newList() {
		return LinkedListFactory.newList();
	}
}

class DynamicArrayTesteeFactory implements TesteeFactory {

	@Override
	public <T> DynamicList<T> newList() {
		return null;
	}
}
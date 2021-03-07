package testutil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import linearpub.DynamicList;
import scorer.BaselineTestObject;

//BaselineList: For Scoring/Grading

public class BaselineList<E> extends BaselineTestObject implements DynamicList<E> {

	//------------------------------------------
	//Data	
	
	List<E> elements;
	
	//------------------------------------------
	//Constructors

	/*Note: Java has conservative warning when using a generic type with varargs
	After validating that our method is using varargs properly
	we supress warning*/
	@SafeVarargs
	public BaselineList(E... newArray) {
		this(Arrays.asList(newArray));
	}
	
	public BaselineList(List<E> list) {
		elements = new ArrayList<>();
		for (E each: list)
			elements.add(each);
	}	
	
	public BaselineList(DynamicList<E> t) {
		elements = new ArrayList<>();
		for (int i=0; i<t.size(); i++)
			elements.add(t.get(i));
	}	
	
	//------------------------------------------
	//Factory Methods
	
	public static BaselineList<Integer> fourInts() {
		return new BaselineList<Integer>(10, 20, 30, 40);
	}
	
	public static BaselineList<String> fiveStrings() {
		return new BaselineList<String>("Mary", "Sally", "Yaping", "Kofi", "Mo");
	}	
	
	//------------------------------------------
	//Accessors	
		
	public List<E> getElements() {
		return elements;
	}	
	
	public List<E> toJavaList() {
		return this.getElements();
	}
	
	//------------------------------------------
	//Public
	
	public void add(E e) {
		e().add(e);
	}
	
	public void addFirst(E e) {
		e().add(0, e);
	}	
	
	public void addLast(E e) {
		e().add(size(), e);
	}	
	
	public E get(int index) {
		return e().get(index);
	}
	
	public E first() {
		return get(0);
	}
	
	public E last() {
		return get(size() - 1);
	}	
	
	public E set(int index, E newElement) {
		E prev = get(index);
		e().set(index, newElement);
		return prev;
	}	
	
	public BaselineList<E> subList(int fromIndex, int toIndex) {
		List<E> newElems = e().subList(fromIndex, toIndex); 
		return new BaselineList<E>(newElems); 
	}
	
	public int size() {
		return e().size();
	}
	
	public boolean isEmpty() {
		return e().isEmpty();
	}
	
	public E removeFirst() {
		return e().remove(0);
	}
	
	public E removeLast() {
		return e().remove(size() - 1);
	}	
	
	public E remove(int index) {
		return e().remove(index);
	}	
	
	@Override
	public String toString() {
		List<E> list;
		int max = 8;
		String postfix = "";
		if (size() > max) {
			list = e().subList(0, max);
			postfix = "... (size=" + size() + ")";
		}
		else
			list = e();
		return Arrays.toString(list.toArray()) + postfix;
	}	
	
	//------------------------------------------
	//Equality	
	
	@Override	
	public int hashCode()  {
		int hashCode = 7;
		hashCode = 31 * hashCode + (getElements()==null ? 0 : getElements().hashCode());
		return hashCode;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })	
	@Override
	public boolean equals(Object o)  {
		if (o == this)
			return true;
		BaselineList<E> other = null;		
		if (o instanceof BaselineList)
			other = (BaselineList)o;
		else if (o instanceof DynamicList)
			other = new BaselineList<>((DynamicList)o);
		if (size() != other.size())
			return false;
		return safeEquals(this.getElements(), other.getElements());
	}

	private boolean safeEquals(Object a, Object b)  {
		//If only one is nil, then false, use XOR*/
		if (a==null ^ b==null)
			return false;
		//We now know both are null, or not null, check for condition #1 first*/
		//If either is null, they both are
		if (a==null)
			return true;
		//Finally a safe equals
		return a.equals(b);
	}

	//------------------------------------------
	//Helpers	
		
	public String findDifference(BaselineList<E> other) {
		if (other.size() != other.size())
			return String.format("Sizes different %d vs %d", other.size(), size());
		for (int i=0; i<other.size(); i++)
			if (!other.get(i).equals(get(i)))
				return String.format("Element mismatch at index %d (%s vs %s)"
										, i, "" + other.get(i), "" + get(i));
		return null;
	}
	
	private List<E> e() {
		return getElements();
	}
	
	//------------------------------------------
	//More Overrides	

	@Override
	public int find(Function<E, Boolean> searchFct) {
		List<E> coll = this.elements;
		for (int i = 0; i < coll.size(); i++)
			if (searchFct.apply(coll.get(i)))
				return i;
		return -1;
	}

	@Override
	public void insert(int index, E newElem) {
		this.elements.set(index, newElem);
	}

	@Override
	public void removeAll() {
		this.elements.clear();
	}

	@Override
	public E removeIndex(int index) {
		return this.elements.remove(index);
	}

	@Override
	public E remove(Function<E, Boolean> searchFct) {
		int matchIndex = this.find(searchFct);
		if (matchIndex >= 0)
			return this.elements.remove(matchIndex);
		return null;
	}
	
	
}


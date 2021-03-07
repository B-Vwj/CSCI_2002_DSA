package answers;

/*
LinkedListBigOAnswers.java

RULES:

	1. Replace all tags "YOURANSWER" below with your big-o guess for the given method

	2. The method name pattern in this class is:

		Method in this class: "size_BigO"
		Associated method in dynamic array: "size"

	3. Do Big-O analysis for the subject method (e.g. like "size" in previous step)

	4. Replace "YOURANSWER" with your best big-o analysis guess (either "1" or "n")

	5. Problems have been done for you to help you get started. See methods in this file:

		size_BigO
		isEmpty_BigO
		subList_BigO

	6. Assume worst-case for your analysis (e.g. for a linear search or find, that means
	the match would be in the last list element).

	7. You do NOT need to add comments to your methods. You only need to provide
	a big-o guess (in other words, replace "YOURANSWER" with either "1" or "n").

*/

public class LinkedListBigOAnswers {

	//-------------------- Basic Statistics ---------------------

	public String size_BigO() {
		/* We will assume (for Big-O) we have an optimization of keeping track
		of size as an ivar (do NOT worry if you did not do this optimization).
		So, given size is an ivar, then there is only one operation (getting 'this.size").
		We are NOT dependent on the size of linked list or "n".
		Thus we have O(1)*/
		return "1";
	}

	public String isEmpty_BigO() {
		/*"isEmpty" can be derived without being dependent on size of linked list or "n".
		Thus our guess for big-o is "1", so we return "1"*/
		return "1";
	}

	//--------------------- Accessing ---------------------

	public String get_BigO(int index) {
		return "n";
	}

	public String subList_BigO(int start, int stop) {
		/* We need to iterate first to start, and then from start to
		stop so we are dependent on "n" because, assuming worst case,
		start could be "0" and stop could be "n".
		So we return "n" as our big-o guess*/
		return "n";
	}

	public String first_BigO() {
		return "1";
	}

	public String last_BigO() {
		return "1";
	}

	public String find_BigO() {
		//Hint: this is a linear search
		return "n";
	}

	//--------------------- Adding ---------------------

	public String addFirst_BigO() {
		return "n";
	}

	public String addLast_BigO() {
		return "n";
	}

	public String add_BigO() {
		return "n";
	}

	public String insert_BigO() {
		return "n";
	}

	//--------------------- Removing ---------------------

	public String removeFirst_BigO() {
		return "n";
	}

	public String removeLast_BigO() {
		return "n";
	}

	public String removeAll_BigO() {
		return "n";
	}

	public String removeIndex_BigO() {
		return "n";
	}

	public String remove_BigO() {
		return "n";
	}

	//--------------------- Convenience ---------------------

	public String toJavaList_BigO() {
		return "n";
	}

}

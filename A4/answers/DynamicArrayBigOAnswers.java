package answers;

/*
DynamicArrayBigOAnswers.java

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

	6. You may IGNORE "grow" and "shrink". In other words, do NOT consider them
	in your big-o analysis.

	7. Assume worst-case (except for "grow" and "shrink" which we ignore).
	Worst case means e.g. for a linear search or find, that means
	the match would be in the last list element.

	8. You do NOT need to add comments to your methods. You only need to provide
	a big-o guess (in other words, replace "YOURANSWER" with either "1" or "n").

*/

public class DynamicArrayBigOAnswers {

	//-------------------- Basic Statistics ---------------------

	public String size_BigO() {
		/*"size" is an ivar -- so work is just getting 'this.size".
		which means performance is constant (not impacted by the size of list or "n")
		For constant we say big-o of "1", so we return "1" here*/
		return "1";
	}

	public String isEmpty_BigO() {
		/*"isEmpty" can be derived easily without being dependent on size of list or "n".
		Thus big-o is "1", so we return "1"*/
		return "1";
	}

	//--------------------- Accessing ---------------------

	public String get_BigO(int index) {
		return "n";
	}

	public String subList_BigO(int start, int stop) {
		/* We need to iterate from start to stop so we are dependent on the size
		of the list "n" because, assuming worst case, start could be "0" and stop
		could be "n" So we return "n" as our big-o guess*/
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
		return "1";
	}

	public String add_BigO() {
		return "1";
	}

	public String insert_BigO() {
		return "n";
	}

	//--------------------- Removing ---------------------

	public String removeFirst_BigO() {
		return "n";
	}

	public String removeLast_BigO() {
		return "1";
	}

	public String removeAll_BigO() {
		return "n";
	}

	public String removeIndex_BigO() {
		return "1";
	}

	public String remove_BigO() {
		return "n";
	}

	//--------------------- Convenience ---------------------

	public String toJavaList_BigO() {
		return "n";
	}

}

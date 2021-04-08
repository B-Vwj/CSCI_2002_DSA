#README.TXT

Here is a note to go along with the GitHub instructions/

Your JAVA files will go into the appropriate
"src" sub-directories:

	pub - public - SSFactory is done unless you different ss class names
			-- in that case, replace SSFactory.java with your factory

	ss - your specialized structures implementation (JAVA files)

NOTE WELL - 
	Use public gateway.
	In your "ss" code, construct your lists using these statements:
	LinkedListFactory.newList();
	DynamicArrayFactory.newList();
	
That way you can you are only going through the public gateway, 
and you can easily use the, e.g., the answer key code (see below).
	
ss_support.jar allows you to use the answer key linked list (LL) and dynamic array (DA).
If you'd rather use your own, you'll need to add the LL and DA factories into 'pub', and
of course your LL and DA code (packages).

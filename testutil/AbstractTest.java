package testutil;

/*xdoc-showAll
AbstractTest
xdlAction=stepsVertTrios

I am an abstract class. 

Subclasses:

`numbered`
Use my "assert*" methods to check results.
When done, run "printSummary".

See one of my subclasses for example usage.

My code is below.

Have Fun.

Your friend,
AbstractTest
*/

abstract public class AbstractTest {
	
	private int testCount;
	private int failureCount;
	
	public AbstractTest() {
		this.testCount = 0;
		this.failureCount = 0;
	}
		
	public void assertEquals(Object expected, Object actual) {
		++this.testCount;
		if (!assertEqualsSafely(expected, actual)) {
			++this.failureCount;
			prnf("FAILED (assertEquals) -- actual <%s> vs expected <%s>%n", actual, expected); 
		}
	}
	
	public void assertNotEquals(Object expected, Object actual) {
		++this.testCount;
		if (assertEqualsSafely(expected, actual)) {
			++this.failureCount;
			prnf("FAILED (assertNotEquals) -- actual <%s> vs expected <%s>%n", actual, expected); 
		}
	}	
	
	public void assertTrue(boolean condition) {
		assertEquals(true, condition);
	}
	
	public void fail(String msg) {
		//Record test as failed
		prnf("Failed -- " + msg);
		assertTrue(false);
	}	
	
	public static void header(String header) {
		prn("\nStarting test: " + header);
	}	

	public static void prn(Object o) {
		System.out.println(o);
	}
	
	public static void prnf(String format, Object... params) {
		System.out.printf(format, params);
	}	
	
	public static void separator() {
		System.out.println("--------------------------------------------");
	}	
	
	public static void minorSeparator() {
		System.out.println("-----------");
	}	
	
	public static void cr() {
		//carriage return new line
		System.out.println("");
	}	
	
	private boolean assertEqualsSafely(Object a, Object b)  {
		//If only one is nil, then false, use XOR*/
		if (a==null ^ b==null)
			return false;
		//We now know that if either is null, they both are
		if (a==null)
			return true;
		//Finally a safe equals
		return a.equals(b);
	}	
	
	public void printSummary() {
		cr();
		prnf("Test Results for test -- %s%n", this.getClass().getSimpleName()); 
		int n, f, p;
		n = this.testCount;
		f = this.failureCount;
		p = n - f;
		if (n == 0) return;
		double percent = 100.0 * p / n;
		prnf("Test Count: %d%n", n);
		prnf("Failure Count: %d%n", f);
		prnf("Passing Percent: %.1f%%%n", percent);
		separator();
	}

}

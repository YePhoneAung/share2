package Lessons;

public class Throws {
	public static void main (String[] args) {

		testTryCatch();
		testThrows();

		}
		public static void testThrows() throws ArithmeticException{

		int i=25/0;

		}
		public static void testTryCatch() {

		try {

		int i=25/0;

		}catch(ArithmeticException e){

		System.out.println("Can't divide by zero");

		}

		}

}

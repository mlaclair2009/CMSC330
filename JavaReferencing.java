
public class JavaReferencing {
	
	public static void main( String[] args ){
	    Object aDog = new Object();
	    foo(aDog);

	    if (((Object) aDog).getName().equals("Max")) { //true
	        System.out.println( "Java passes by value." );

	    } else if (((Object) aDog).getName().equals("Fifi")) {
	        System.out.println( "Java passes by reference." );
	    }
	}

	public static <Dog> void foo(Dog d) {
	    ((Object) d).getName().equals("Max"); // true

	    d = new Dog("Fifi");
	    ((Object) d).getName().equals("Fifi"); // true
	}

}

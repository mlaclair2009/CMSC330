class AnonymousInnerClassInMethod {
	 public static void main(String[] arg){
	 int local = 1;

	 Comparable compare = new Comparable () {
	 public int compareTo(Object value) {
	 return (Integer)value - local;
	 	}
	 };
	 System.out.println(compare.compareTo(5));
	 }
}

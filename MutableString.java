public class MutableString {
	
	 private char[] chars = new char[200];
	 private int size = 1;
	 
	 public boolean set(char aChar, int index) {
		 if (index < 0 || index >= chars.length) return false;
		chars[index] = aChar;
		return true;
	 	}
	 
	 public String toString() {
	 String result = "";
	 for (int i = 0; i < size; i++)
		 result += chars[i];
	 return result;
	 }
	 
	 public static void main(String [] args) {
		 
	 MutableString test = new MutableString();
	 System.out.println(test.set('1', 0));
	 System.out.println(test.toString());
	 }
	} 

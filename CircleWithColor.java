/*Matt LaClair
 * CMSC 330
 * Homework 6
 */
public class CircleWithColor extends CircleJava{
	
 String color;
 
 CircleWithColor(double radius, String color){
	 super(radius);
	 this.color = color;
 } 

 public final void put(){
	 super.put();
	 System.out.println("Circle Color = " + color);
  }
} 
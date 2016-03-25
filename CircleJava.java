/*Matt LaClair
 * CMSC 330
 * Homework 6
 */
public class CircleJava {
	
double radius;

 CircleJava (double radius){
 	this.radius = radius; 
 }
 
 public void put(){
	 System.out.println("Circle Radius = " + radius);
 }
 
 public static void main(String[] args){
	 CircleJava circle = new CircleWithColor(100, "blue");
	 circle.put();
	 CircleJava circle1 = new CircleJava (50);
	 circle1.put();
 }
}

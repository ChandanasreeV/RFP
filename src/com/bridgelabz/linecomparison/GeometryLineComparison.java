package com.bridgelabz.linecomparison;

//A Java program to compare two lines using the compareTo method

//Class representing a coordinate in the Cartesian system
class CartesianPoint {
 double x, y; // x and y coordinates

 // Constructor to initialize the x and y values
 CartesianPoint(double x, double y) {
     this.x = x;
     this.y = y;
 }
}

//Class representing a geometric line and implementing Comparable to compare lengths
class GeometricLine implements Comparable<GeometricLine> {
 CartesianPoint pointA; // Starting point of the line
 CartesianPoint pointB; // Ending point of the line

 // Constructor to initialize the two endpoints of the line
 GeometricLine(CartesianPoint pointA, CartesianPoint pointB) {
     this.pointA = pointA;
     this.pointB = pointB;
 }

 // Method to calculate the length of the line using the distance formula
 public double getLength() {
     // Length = sqrt((x2 - x1)^2 + (y2 - y1)^2)
     double deltaX = pointB.x - pointA.x; // Difference in x values
     double deltaY = pointB.y - pointA.y; // Difference in y values
     return Math.sqrt(deltaX * deltaX + deltaY * deltaY); // Pythagorean theorem
 }

 // compareTo method to compare this line with another based on their lengths
 @Override
 public int compareTo(GeometricLine otherLine) {
     double thisLength = this.getLength();      // Length of the current line
     double otherLength = otherLine.getLength(); // Length of the line to compare with

     // Use Double.compare to handle precision issues and return result
     return Double.compare(thisLength, otherLength); // Returns -1, 0, or 1
 }
}

//Main class to test the comparison of two lines
public class GeometryLineComparison {
 public static void main(String[] args) {
     // Create first line from point (1, 2) to (4, 6)
     GeometricLine line1 = new GeometricLine(new CartesianPoint(1, 2), new CartesianPoint(4, 6));

     // Create second line from point (2, 3) to (5, 7)
     GeometricLine line2 = new GeometricLine(new CartesianPoint(2, 3), new CartesianPoint(5, 7));

     // Compare the two lines using compareTo method
     int result = line1.compareTo(line2); // Stores comparison result

     // Print result based on comparison
     if (result == 0) {
         System.out.println("Both lines are equal in length.");
     } else if (result < 0) {
         System.out.println("Line 1 is shorter than Line 2.");
     } else {
         System.out.println("Line 1 is longer than Line 2.");
     }
 }
}

package com.bridgelabz.linecomparison;

//Class representing a point in 2D space using x and y coordinates
class GeoPoint {
 private double x; // x-coordinate (private = encapsulation)
 private double y; // y-coordinate

 // Constructor to initialize point coordinates
 public GeoPoint(double x, double y) {
     this.x = x;
     this.y = y;
 }

 // Getter for x-coordinate
 public double getX() {
     return x;
 }

 // Getter for y-coordinate
 public double getY() {
     return y;
 }

 // Overriding equals() method to compare two points
 @Override
 public boolean equals(Object obj) {
     if (this == obj) return true; // Check if both references point to same object
     if (obj == null || getClass() != obj.getClass()) return false; // Check class compatibility

     GeoPoint other = (GeoPoint) obj; // Type cast to GeoPoint
     return Double.compare(x, other.x) == 0 &&
            Double.compare(y, other.y) == 0; // Compare x and y values
 }
}

//Class representing a line made of two GeoPoints and implementing Comparable
class GeoLine implements Comparable<GeoLine> {
 private GeoPoint startPoint; // Start point of the line
 private GeoPoint endPoint;   // End point of the line

 // Constructor to initialize the line using two points
 public GeoLine(GeoPoint startPoint, GeoPoint endPoint) {
     this.startPoint = startPoint;
     this.endPoint = endPoint;
 }

 // Method to calculate the length of the line using the distance formula
 public double getLength() {
     double dx = endPoint.getX() - startPoint.getX(); // Difference in x
     double dy = endPoint.getY() - startPoint.getY(); // Difference in y
     return Math.sqrt(dx * dx + dy * dy); // Return Euclidean distance
 }

 // Overriding equals() to check if two lines are the same (by endpoints)
 @Override
 public boolean equals(Object obj) {
     if (this == obj) return true; // Same object
     if (obj == null || getClass() != obj.getClass()) return false; // Check class

     GeoLine other = (GeoLine) obj;

     // Check if start and end points match in either direction
     return (startPoint.equals(other.startPoint) && endPoint.equals(other.endPoint)) ||
            (startPoint.equals(other.endPoint) && endPoint.equals(other.startPoint));
 }

 // Implement compareTo to compare two lines based on their lengths
 @Override
 public int compareTo(GeoLine otherLine) {
     return Double.compare(this.getLength(), otherLine.getLength()); // Returns -1, 0, or 1
 }
}

//Main class to test the equals and compareTo methods
public class GeometryOOPDemo {
 public static void main(String[] args) {
     // Create 4 points
     GeoPoint p1 = new GeoPoint(0, 0);
     GeoPoint p2 = new GeoPoint(3, 4); // Line length = 5
     GeoPoint p3 = new GeoPoint(1, 1);
     GeoPoint p4 = new GeoPoint(4, 5); // Line length = 5

     // Create two lines using those points
     GeoLine line1 = new GeoLine(p1, p2);
     GeoLine line2 = new GeoLine(p3, p4);

     // Use equals() to check if the lines are the same
     if (line1.equals(line2)) {
         System.out.println("Lines are equal.");
     } else {
         System.out.println("Lines are not equal.");
     }

     // Use compareTo() to compare line lengths
     int comparison = line1.compareTo(line2);

     if (comparison == 0) {
         System.out.println("Both lines are of equal length.");
     } else if (comparison < 0) {
         System.out.println("Line 1 is shorter than Line 2.");
     } else {
         System.out.println("Line 1 is longer than Line 2.");
     }

     // Optionally print the actual lengths
     System.out.println("Length of Line 1: " + line1.getLength());
     System.out.println("Length of Line 2: " + line2.getLength());
 }
}


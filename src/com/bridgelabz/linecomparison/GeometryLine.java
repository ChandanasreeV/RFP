package com.bridgelabz.linecomparison;

//Import the Math class for mathematical operations
import java.lang.Math;

//Define a class to represent a point in 2D Cartesian coordinates
class Point {
 double x, y;

 // Constructor to initialize the point
 Point(double x, double y) {
     this.x = x;
     this.y = y;
 }
}

//Define a class to represent a line using two points
class Line {
 Point start, end;

 // Constructor to initialize the line with two points
 Line(Point start, Point end) {
     this.start = start;
     this.end = end;
 }

 // Method to calculate the length of the line using the distance formula
 double length() {
     // Length = sqrt((x2 - x1)^2 + (y2 - y1)^2)
     double dx = end.x - start.x;
     double dy = end.y - start.y;
     return Math.sqrt(dx * dx + dy * dy);
 }
}

//Main class to test the Line and Point classes
public class GeometryLine {
 public static void main(String[] args) {
     // Create two points (x1, y1) and (x2, y2)
     Point p1 = new Point(1, 2);
     Point p2 = new Point(4, 6);

     // Create a line using the two points
     Line line = new Line(p1, p2);

     // Calculate and print the length of the line
     System.out.println("Length of the line: " + line.length());
 }
}

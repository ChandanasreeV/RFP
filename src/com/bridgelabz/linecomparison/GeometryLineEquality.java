package com.bridgelabz.linecomparison;

//A Java program to compare two line segments based on their end points using equals()

class Coordinate {
 double x, y;

 // Constructor to initialize a coordinate
 Coordinate(double x, double y) {
     this.x = x;
     this.y = y;
 }

 // Override equals to compare two coordinates by x and y values
 @Override
 public boolean equals(Object obj) {
     if (this == obj) return true; // same object
     if (obj == null || getClass() != obj.getClass()) return false;

     Coordinate other = (Coordinate) obj;
     return Double.compare(x, other.x) == 0 &&
            Double.compare(y, other.y) == 0;
 }
}

class LineSegment {
 Coordinate start, end;

 // Constructor to initialize a line segment using two coordinates
 LineSegment(Coordinate start, Coordinate end) {
     this.start = start;
     this.end = end;
 }

 // Override equals to compare two line segments by their end points (in any order)
 @Override
 public boolean equals(Object obj) {
     if (this == obj) return true; // same object
     if (obj == null || getClass() != obj.getClass()) return false;

     LineSegment other = (LineSegment) obj;

     // A line segment is equal if both start and end match (or reversed)
     return (start.equals(other.start) && end.equals(other.end)) ||
            (start.equals(other.end) && end.equals(other.start));
 }
}

public class GeometryLineEquality {
 public static void main(String[] args) {
     // Create two line segments with same coordinates in different order
     LineSegment segment1 = new LineSegment(new Coordinate(1, 2), new Coordinate(4, 6));
     LineSegment segment2 = new LineSegment(new Coordinate(4, 6), new Coordinate(1, 2));

     // Check if the line segments are equal
     if (segment1.equals(segment2)) {
         System.out.println("The line segments are equal.");
     } else {
         System.out.println("The line segments are not equal.");
     }
 }
}

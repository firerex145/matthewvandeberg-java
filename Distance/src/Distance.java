/*
Matthew Vandeberg
AP CS A
Period 1
10-18-18
Unit 3 Project - Distance
 */
public class Distance {
    public static void main (String[] args){
        double a = distance(16, 10, 2, 8); //passes the coordinates of city 1 and city 2 to distance method and stores the return value in a
        System.out.println("Distance between city 1 and city 2 = " + a); //prints the distance between city 1 and city 2
        double b = a + distance(2, 8, 10, 3); //passes the coordinates of city 2 and city 3 to distance method and and stores the return value in b
        System.out.println("Distance between city 2 and city 3 = " + b); //prints the distance between city 1 and city 2
        double c = b + distance(10, 3, 16, 10); //passes the coordinates of city 3 and city 1 to distance method and stores the return value
        System.out.println("Distance between city 3 and city 1 = " + c); //prints the distance between city 1 and city 2
    }

    public static double distance (int x1, int y1, int x2, int y2){ //gets coordinates
        double dis = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2)); //calculates the distance between the two coordinates given by the parameters
        return dis; //returns the distance as a double to main
    }
}
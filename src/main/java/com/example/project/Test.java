package com.example.project;

public class Test {
    public static void main(String[] args) 
    {
        LinearCalculator c = new LinearCalculator("(10,5)","(6,-1)");

        String studentOutput = "The two points are: (" + c.getX1() + "," + c.getY1() + ")";
        studentOutput += " and " + "(" + c.getX2() + "," + c.getY2() + ")";
        studentOutput += "\nThe equation of the line between these points is: " + c.equation();
        studentOutput += "\nThe slope of this line is: " + c.slope();
        studentOutput += "\nThe y-intercept of the line is: " + c.yInt();
        studentOutput += "\nThe distance between the two points is: " + c.distance();
     
        System.out.println(studentOutput);
    }
}

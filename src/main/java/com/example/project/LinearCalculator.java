package com.example.project;
public class LinearCalculator

{
    //INSTANCE VARIABLES 
    //4 INTEGER variables (name them: x1,x2,y1,y2) 

    private int x1;
    private int x2;
    private int y1;
    private int y2;

    //CONSTRUCTOR
    //1 constructor with 2 String parameters. Each parameter represents a coordinate. 
    //For example, "(1,2)" and "(3,4)" would be two parameter values 
    //You will have to parse the string into 4 integers, representing the 2 points.
    public LinearCalculator(String coordinatePair1, String coordinatePair2)
    { // <--add 2 string parameters to this constructor
        String stringXOne = coordinatePair1.substring(1, coordinatePair1.indexOf(","));
        String stringYOne = coordinatePair1.substring(coordinatePair1.indexOf(",") + 1, coordinatePair1.length()-1);
        String stringXTwo = coordinatePair2.substring(1, coordinatePair2.indexOf(","));
        String stringYTwo = coordinatePair2.substring(coordinatePair2.indexOf(",") + 1, coordinatePair2.length()-1);

        x1 = Integer.parseInt(stringXOne);
        x2 = Integer.parseInt(stringXTwo);
        y1 = Integer.parseInt(stringYOne);
        y2 = Integer.parseInt(stringYTwo);

    }



    //METHODS
    //getters and setters for the 4 instance variables (8 methods total) 
    public int getX1(){return x1;}
    public int getY1(){return y1;}
    public int getX2(){return x2;}
    public int getY2(){return y2;}
    public void setX1(int newx1){x1 = newx1;}
    public void setY1(int newy1){y1 = newy1;}
    public void setX2(int newx2){x2 = newx2;}
    public void setY2(int newy2){y2 = newy2;}

    
    //returns x2 - x1
    public double xDistance()
    {
        return x2-x1;
    }

    //returns y2 - y1
    public double yDistance()
    {
        return y2-y1;
    }

    //distance() -> returns a double. 
    //calculates the distance between the two points to the nearest HUNDREDTH and returns the value.
    public double distance(){
        double addedNumbers = Math.pow(xDistance(), 2) + Math.pow(yDistance(), 2);
        double totalDistance = Math.sqrt(addedNumbers);
        totalDistance = roundedToHundredth(totalDistance);
        return totalDistance;
    }

    //yInt() -> returns a double.
    //calculates the y intercept of the equation and returns the value to the nearest HUNDREDTH
    //if y-int if undefined, should return -999.99
    public double yInt()
    {
        if (slope() == -999.99)
        {
            return -999.99;
        }
        double yIntercept = (y1 - (slope() * x1));
        yIntercept = roundedToHundredth(yIntercept);
        return yIntercept;
    }

    //slope() -> returns a double. 
    //calculates the slope of the equations and returns the value to the nearest HUNDREDTH
    //if slope is undefined, should return -999.99
    public double slope()
    {
        if (xDistance() == 0)
        {
            return -999.99;
        }
        return roundedToHundredth(yDistance()/xDistance());
    }

    //equations() -> returns a String.
    //calculates the final equation in y=mx+b form and returns the string
    //if the equation has no slope, the equation should return -> "undefined"
    //HINT: You may need other custom methods to decrease the amount of code in the equations() method
    public String equation(){
        if (slope() == -999.99)
        {
            return "undefined";
        }
        else if (yInt() == 0)
        {
           return "y=" + slope() + "x";
        }
        else if (slope() == 0)
        {
            return "y=" + yInt();
        }

        if (yInt() < 0)
        {
            return "y=" + slope() + "x" + yInt(); 
        }
        return "y=" + slope() + "x+" + yInt();
    }


    //roundedToHundredth(double x)-> returns double
    //calculates the input to the nearest hundredth and returns that value
    public double roundedToHundredth(double x){
        // source https://www.geeksforgeeks.org/java-program-to-round-a-number-to-n-decimal-places/ we luv geeksforgeeks
        return Math.round(x * 100.0)/100.0;
    }

    //printInfo() -> returns a string of information
    //this method is tested but you can also call it in your main method if gradle tests are 
    //not working. 
    public String printInfo(){
        String str = "The two points are: (" + x1 + "," + y1  + ")";
        str += " and " + "(" + x2 + "," + y2 + ")";
        str += "\nThe equation of the line between these points is: " + equation() ;
        str += "\nThe slope of this line is: " + slope();
        str += "\nThe y-intercept of the line is: " + yInt();
        str += "\nThe distance between the two points is: " + distance();
        return str;
    }

}
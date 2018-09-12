/*
Matthew Vandeberg
AP CS A
Period 1
9-12-18
Project #1 - SixDays of Xmas
 */
public class SixDays {
    public static void main(String[] args){
        dayOne();
        dayTwo();
        dayThree();
        dayFour();
        dayFive();
        daySix();
    }
    //prints first verse and calls giftOne method
    public static void dayOne(){
        System.out.println("On the 1st day of \"Xmas\", my true love gave to me");
        giftOne();
    }
    //prints second verse and calls giftTwo method
    public static void dayTwo(){
        System.out.println("On the 2nd day of \"Xmas\", my true love gave to me");
        giftTwo();
    }
    //prints third verse and calls giftThree method
    public static void dayThree(){
        System.out.println("On the 3rd day of \"Xmas\", my true love gave to me");
        giftThree();
    }
    //prints fourth verse and calls giftFour method
    public static void dayFour(){
        System.out.println("On the 4th day of \"Xmas\", my true love gave to me");
        giftFour();
    }
    //prints fifth verse and calls giftFive method
    public static void dayFive(){
        System.out.println("On the 5th day of \"Xmas\", my true love gave to me");
        giftFive();
    }
    //prints sixth verse and calls giftSix method
    public static void daySix(){
        System.out.println("On the 6th day of \"Xmas\", my true love gave to me");
        giftSix();
    }
    //prints the first gift and a blank line
    public static void giftOne(){
        System.out.println("a partridge in a pear tree.");
        System.out.println();
    }
    //prints the second gift and calls giftOne method
    public static void giftTwo(){
        System.out.println("two turtle doves, and");
        giftOne();
    }
    //prints the third gift and calls giftTwo method
    public static void giftThree(){
        System.out.println("three French hens,");
        giftTwo();
    }
    //prints the fourth gift and calls giftThree method
    public static void giftFour(){
        System.out.println("four calling birds,");
        giftThree();
    }
    //prints the fifth gift and calls giftFour method
    public static void giftFive(){
        System.out.println("five golden rings,");
        giftFour();
    }
    //prints the sixth gift and calls giftFive method
    public static void giftSix(){
        System.out.println("six geese a-laying,");
        giftFive();
    }
}
package objectandclass;

class Thing {

    // Constructor
    Thing() {
        secondString = "b" + firstString;
    }

    // Initializer
    {
        secondString = "d";
        firstString = "a" + this.secondString ;
    }

    // Static Initializer
    static {
//        System.out.println(thirdString);
        thirdString = "c";
    }
    String firstString;
    String secondString;
    // Initializer
    {
        secondString = "a" + firstString;
    }
    // Two instance variables


    // static variable
    static String thirdString;


    public String toString() {
        return firstString + secondString + thirdString;
    }
}

public class ForwardReference {
    public static void main(String[] args) {
        Thing one = new Thing();
        System.out.println(one);
    }
}
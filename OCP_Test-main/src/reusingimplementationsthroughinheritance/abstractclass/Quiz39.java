package reusingimplementationsthroughinheritance.abstractclass;


abstract class AbstractClass {
    protected static int counter;  // Line 1
//    protected static abstract int getCounter();     // Line 2
//    static abstract void printCounter();  // Line 3

}

public class Quiz39 extends AbstractClass {

    public static void main(String[] args) {
        AbstractClass.counter++;   // Line 4
        printCounter();
    }

    public static int getCounter() {  // Line 5
        return AbstractClass.counter; // Line 6
    }

    public static void printCounter() { // Line 7
        System.out.println("Counter = " + getCounter());
    }
}
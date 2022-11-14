package methods;

public class Quiz29 {
    public static void main(String[] args) {
        Quiz29 t = new Quiz29();
        char c = 'a';
        int i = 10;
        t.printMethod(i, c);
        t.printMethod(c, i);
    }

    public void printMethod(int a, long b) {   // Method 1 //change to Long ??
        System.out.println("Method (int, Long) called");
    }

    void printMethod(short a, char b) {  // Method 2 //change to Character ??
        System.out.println("Method (short, Character) called");
    }

    void printMethod(int... a) {   // Method 3
        System.out.println("Method (int...) called");
    }
}
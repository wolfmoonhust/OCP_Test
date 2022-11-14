/*
    concept of hiding:
        hide an instance of variable: by creating a variable of same name and type on the subclass
        hide a static variable: by creating a static variable of same name and type on the subclass
        hide a static method: by creating a static method with same name and parameter types on the subclass
        do not hide an instance method from a subclass -> override it
 */

package reusingimplementationsthroughinheritance.test;

public class Test {
    public static void main(String[] args) {
//        Super s = new Super();
//        Sub sub = new Sub();
        Super ss = new Sub();
        ss.notDeclaredInSubClass();
        ss.instanceMethod();
        ss.staticMethod();

        System.out.println(" " + ss.a + " " + ss.b);
    }
}

class Super {
    int a = 11; // instance field
    static int b = 11; // static field

    public void instanceMethod() { // instance method
        System.out.println("super instance method");
    }

    public static void staticMethod() { // static method
        System.out.println("super static method");
    }

    public void notDeclaredInSubClass() {
        System.out.println("not declared in subclass");
    }
}

class Sub extends Super {
    int a = 3; // instance field
    static int b = 3; // static field

    public void instanceMethod() { // instance method
        System.out.println("sub instance method " + b + " " + a);
    }

    public static void staticMethod() { // static method
        System.out.println("sub static method");
    }
}
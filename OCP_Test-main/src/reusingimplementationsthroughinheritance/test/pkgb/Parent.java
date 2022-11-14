package reusingimplementationsthroughinheritance.test.pkgb;

public class Parent {
    protected static String name = "ABC";

    protected void printName() {
        System.out.println(name);
    }
    protected static String getName() {
        return name;
    }
}
package reusingimplementationsthroughinheritance.polymorphism;

/*
Learn Programming Academy's Java 1Z0-815 Certification Exam Course
Section 9: Reusing Implementations Through Inheritance
Topic: Enable Polymorphism by overriding methods.
*/

import java.io.FileNotFoundException;
import java.io.IOException;

class BaseClass {
     void goodMethod() throws IOException {
        System.out.println("BaseClass executing good method");
    }

    protected void printInformation(CharSequence s) {
        System.out.println("BaseClass prints " + s);
    }

    public CharSequence getInformation() {
        return getClass().getName();
    }
}

class ExtendedClass extends BaseClass {

    public void goodMethod() throws FileNotFoundException {
//        super.goodMethod();
        System.out.println("AND ExtendedClass executing a better method");
    }

//    public void printInformation(CharSequence string) {
//        System.out.println("ExtendedClass prints " + string);
//    }

    public void printInformation(String s) {
        System.out.println("ExtendedClass prints " + s);
    }

        public String getInformation() {
        return getClass().getName();
    }
}

public class OverrideExample {
    public static void main(String[] args) {
        ExtendedClass e = new ExtendedClass();
        try {
            e.goodMethod();
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        e.printInformation(e.getInformation());
        e.printInformation((CharSequence) e.getInformation());
    }
}
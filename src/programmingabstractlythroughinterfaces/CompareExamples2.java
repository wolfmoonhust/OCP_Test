package programmingabstractlythroughinterfaces;

/*
Learn Programming Academy's Java 1Z0-815 Certification Exam Course
Section 10: Programming Abstractly Through Interfaces
Topic: Distinguish class inheritance from interface inheritance
Sub-Topic: Abstract Class and Interface Comparisons
*/
// We have a global class keeping track of instance counts
class GlobalInformation2 {
    public static int DogCount;
    public static int CatCount;
    public static int TreeCount;
}

// Create an interface to support the countMyInstances method
interface Countable {
    public abstract void countMyInstances();
}

// Animal implements Countable
abstract class Animal2 implements Countable {
    public Animal2(String name, String type) {
        this.name = name;
        this.type = type;
        countMyInstances();
    }

    private String name;
    private String type;
}

// We add a concrete Animal called Dog which must implement
// countMyInstances()
class Dog2 extends Animal2 {

    public Dog2(String name, String type) {
        super(name, type);
    }

    public void countMyInstances() {
        GlobalInformation2.DogCount++;
    }
}

// We add a concrete Animal called Cat which must implement
// countMyInstances()
class Cat2 extends Animal2 {

    public Cat2(String name, String type) {
        super(name, type);
    }

    public void countMyInstances() {
        GlobalInformation2.CatCount++;
    }
}

// We add a disparate class that will also implement
// countMyInstances()
class Tree2 implements Countable {
    public Tree2() {
        countMyInstances();
    }

    public void countMyInstances() {
        GlobalInformation2.TreeCount++;
    }
}

// Our main method will create some objects of disparate types
// and verify that our counters are being incremented.
public class CompareExamples2 {
    public static void main(String[] args) {
        Dog2 d;
        Cat2 c;
        Tree2 t;
        for (int i = 0; i < 5; i++) {
            d = new Dog2("DOG_" + (i + 1), "dog");
        }
        for (int i = 0; i < 7; i++) {
            c = new Cat2("CAT_" + (i + 1), "cat");
        }
        for (int i = 0; i < 3; i++) {
            t = new Tree2();
        }
        System.out.println("Number of Cat instances = "
                + GlobalInformation2.CatCount);
        System.out.println("Number of Dog instances = "
                + GlobalInformation2.DogCount);
        System.out.println("Number of Tree instances = "
                + GlobalInformation2.TreeCount);
    }
}

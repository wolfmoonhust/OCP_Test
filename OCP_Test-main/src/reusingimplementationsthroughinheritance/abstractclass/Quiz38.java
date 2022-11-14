package reusingimplementationsthroughinheritance.abstractclass;

abstract class AbstractClass1 {

    public AbstractClass1() {

    }

    final void myOwnMethod() {  // Line 1
        System.out.println("my own");
    }

    void familyMethod() {
        System.out.println("my family");
        printFamilyTree();  // Line 2
    }

    abstract void printFamilyTree();
}

public abstract class Quiz38 extends AbstractClass1 {  // Line 3
    public Quiz38(){

    }
    public static void main(String[] args) {
        printFamilyTrees();
    }

    protected static void printFamilyTrees() {   // Line 4
//        Quiz38 t = new Quiz38();   // Line 5
//        t.printFamilyTree();  // Line 6
    }
}
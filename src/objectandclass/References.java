package objectandclass;

// A simple test class with a few attributes, a constructor and
// a method.
class TestClass {

    private String a = "a";
    private String b = "b";

    // Constructor
    TestClass(String a, String b) {
        this.a = a;
        this.b = b;
    }

    public String toString() {
        return a + "-" + b;
    }
}

public class References {
    public static void main(String[] args) {

        // Declare and instantiate some objects

        // aref is a reference to the 'a-z object'
        TestClass aref = new TestClass("a", "z");

        // bref is a reference to the 'first-last object'
        TestClass bref = new TestClass("first", "last");

        // cref is a reference to the 'start-end object'
        TestClass cref = new TestClass("start", "end");

        // objectandclass.References not assigned to any objects.
        TestClass dref = null;
        TestClass eref = null;

        // any references to 'a-z object' no longer exist after statement
        aref = bref;
        System.out.println("aref has a reference to object : " + aref);

        //  aref, bref and dref variables reference the 'first-last object'
        dref = bref;
        System.out.println("dref has a reference to object : " + dref);

        // Assignments not in declarations occur right to left
        // eref, bref, cref variables all reference the 'start-end object'
        eref = bref = cref;
        System.out.println("eref has a reference to object : " + eref);

        System.out.println("---------before-------------");
        System.out.println("aref has a reference to object : " + aref);
        System.out.println("bref has a reference to object : " + bref);
        System.out.println("cref has a reference to object : " + cref);
        System.out.println("dref has a reference to object : " + dref);
        System.out.println("eref has a reference to object : " + eref);

        // all references to 'start-end object' are set to null,
        // making it eligible for garbage collection
        aref = dref = null;
        System.out.println("---------Finally-------------");
        System.out.println("aref has a reference to object : " + aref);
        System.out.println("bref has a reference to object : " + bref);
        System.out.println("cref has a reference to object : " + cref);
        System.out.println("dref has a reference to object : " + dref);
        System.out.println("eref has a reference to object : " + eref);

        System.out.println("---------Other objectandclass.Test-------------");
        Test t1 = new Test("1");
        Test t2 = new Test("2");
        Test t3 = new Test("3");
        Test t4 = new Test("4");
        t2 = t4;
        t4 = t1;
        t3 = t2;
        t1 = t3;
        t2 = new Test("5");
        t2 = null;

        System.out.println("t1 has a reference to object : " + t1);
        System.out.println("t2 has a reference to object : " + t2);
        System.out.println("t3 has a reference to object : " + t3);
        System.out.println("t4 has a reference to object : " + t4);

        Test t5 = new Test("5");
        Test t6 = t5;
        t5 = null;

        System.out.println("t5 has a reference to object : " + t5 + " t6=" + t6);

    }
}

class Test {
    private String id;

    public Test(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "objectandclass.Test{" +
                "id='" + id + '\'' +
                '}';
    }
}
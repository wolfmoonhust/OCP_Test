package objectandclass;

class ASuperClass {
    String name;


    // Constructor for Super Class
    ASuperClass() {
        System.out.println("Parent constructor executes");
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "My name is " + this.name;
    }
    {
        System.out.println("init superclass executes");
    }
}


class ASubClass extends ASuperClass {

    // Constructor for Sub Class
    ASubClass() {
        System.out.println("Child no args constructor executes");
        setName(name);
    }

    // Constructor for Sub Class
    ASubClass(String name) {
//        super();
        this();
        System.out.println("Child single argument constructor executes");
        setName(name);
    }

    // Initializer code
    {
        this.name = "Override";
        System.out.println("Child initializer executes");
        System.out.println(this);
    }


}

public class InitializerOddsAndEnds {
    static final int data;

   public InitializerOddsAndEnds(){
//       data = 100;
   }
    static {
        data =100;
    }
    public static void main(String[] args) {
//    this.data;
        ASubClass joe = new ASubClass("Joe");
        System.out.println(joe);
    }
}
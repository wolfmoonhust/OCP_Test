package methods;

class NoLoad {
    public void bestMethod(int i) {
        System.out.println("bestMethod for int");
    }

//    // Method with different access modifier
//    private void bestMethod(int i) {
//        System.out.println("private bestMethod for int");
//    }

//    // Method with a different name for the parameter
//    public void bestMethod(int myInteger) {
//        System.out.println("private bestMethod for myInteger int");
//    }

//    // Method with a different non-access modifier
//    public static void bestMethod(int i) {
//        System.out.println("static bestMethod for int");
//    }

    // An abstract method
//    public abstract void bestMethod(int i);

    // Method with a different return type
//    public int bestMethod(int i) {
//        System.out.println("bestMethod for int returns an int");
//        return i;
//    }
}
public class NotOverloaded {
    public static void main(String[] args) {
        NoLoad n = new NoLoad();
        n.bestMethod(1);
    }

}
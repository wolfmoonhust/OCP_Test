package operatoranddecisionconstructs;

public class SwitchExampleCaseExpression {

    public static void main(String[] args) {
        // Example of a switch statement with expression based on
        // compile time constants in the case label
        String str = "";
        String test = "12";
        switch (test + "1") {
            case ("1"):
                System.out.println("Output is 1");
                break;
            case ("1" + "2"):  // concatenation operator in expression.
                System.out.println("Output is 12");
                break;
            case ("2"):
                System.out.println("Output is 2");
                break;
            default:
                System.out.println("Output is default");
        }
    }
}
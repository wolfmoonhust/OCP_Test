package operatoranddecisionconstructs;

public class SwitchOddities {
    public static void main(String[] args) {
        byte[] bytes = {100, 103, 104, 107, 126};
        String caseAssignedValue = "";

        // Create a label to use in switch statement
        start_for:
        for (var i : bytes) {   // Using LVTI here
//            System.out.println("for loop " + i);
            switch (i) {
                case 100:
                case 103:
                case 104:
                    // This is case block break
                    break;
                case 107:
                    caseAssignedValue = "Less than 110";
                    // This is a for loop break with label
                    break start_for;
                case 126:
                    caseAssignedValue = "Equal to 126";
                    break;
            }
            System.out.println("Done processing " + i +
                    ", caseAssignedValue = " + caseAssignedValue);
        }

        var price = 100;
        var tax_rate = getTaxRate("NH");  // Line 4
        var tax = price * tax_rate;  // Line 5
//        switch (tax) {          // Line 6
//            case 5:
//                System.out.println("Taxed at 5%");
//                break;
//            case 6:
//                System.out.println("Taxed at 6%");
//                break;
//            case 7:
//                System.out.println("Taxed at 7%");
//                break;
//            default:            // Line 7
//        }
    }


    public static float getTaxRate(String state) {
        float tax;
        switch (state) {   // Line 1
            default:   // Line 2
                tax = 0.05f;
            case "PA":
                tax = 0.06f;
                break;
            case "NJ":
                tax = 0.07f;
                break;
        }
        return tax;    // Line 3
    }
}
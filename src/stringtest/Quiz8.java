package stringtest;

import java.util.Calendar;

public class Quiz8 {
    public static void main(String... args) {  //  Line 1

        String hello="hello";
        for (var arg: args) {  // Line 2
            String sb = new String(arg);; // Line 3
            System.out.print(arg.equals(sb) +" ");  // Line 4
            System.out.print( (hello.equals(arg)) +" ");  // Line 5
            System.out.println( (hello==arg.intern())); // Line 6

            Calendar.getInstance().getTimeInMillis();

        }

        String abc = "test";
        String def = abc;
        abc = "hello";
        System.out.println("abc =" + abc + " def=" + def);
    }
}

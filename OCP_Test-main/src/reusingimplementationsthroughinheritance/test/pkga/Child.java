package reusingimplementationsthroughinheritance.test.pkga;

import reusingimplementationsthroughinheritance.test.pkgb.Parent;

public class Child extends Parent {
    static String name = "DEF";

    //**   Insert code here **//

    protected static String getName() {
        return name;
    }


    public static void main(String[] args) {
        System.out.println(new Child().getName());
    }
}

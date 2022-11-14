package reusingimplementationsthroughinheritance.polymorphism;

/*
Correct Answer: Code fails on the line: tempcount = tt.getClassyName(s) == "abc" ? abcCount++ : defCount++;
The object variable s is passed to the getClassyName method overloaded with Object.
The code casts the object to a 'Quiz43' but the object is a 'SubClass' so the cast fails.
 */
class SubClass {
    public static String classyName = "abc";
    public static String getClassyName() { return classyName; }
}

public class Quiz43 extends SubClass {
    public static String classyName = "def";
    public static String getClassyName() { return classyName; }

    public static void main(String[] args) {
        Quiz43 tt = new Quiz43();
        Object t = tt;
        Object s = new SubClass();
        int abcCount = 0;
        int defCount = 0;

        int tempcount = ((Quiz43) t).classyName == "abc" ? abcCount++ : defCount++;
        tempcount = ((SubClass) s).classyName == "abc" ? abcCount++ : defCount++;

        tempcount = tt.getClassyName(t) == "abc" ? abcCount++ : defCount++;
        tempcount = tt.getClassyName(s) == "abc" ? abcCount++ : defCount++;

        tempcount = tt.getClassyName((Quiz43) t) == "abc" ? abcCount++ : defCount++;
        tempcount = tt.getClassyName((SubClass) s) == "abc" ? abcCount++ : defCount++;

        System.out.println("abcCount = " + abcCount);
    }

    public String getClassyName(Object t) {
        Quiz43 tt = (Quiz43) t;
        return tt.getClassyName();
    }

    public String getClassyName(SubClass sc) {
        return sc.getClassyName();
    }
}
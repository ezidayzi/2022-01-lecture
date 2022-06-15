package Exam_2018;
class ChildException extends Exception{}
class GrandChildException extends ChildException {}

public class ExceptionHandlingTest2 {
    static int count = 0;
    public static void main(String[] args) {
        try {
            throw new GrandChildException();
        } catch(GrandChildException g) {
            System.out.println("GrandChildException");
        }
        catch(ChildException c) {
            System.out.println("ChildException");
        }

        try {
            throw new GrandChildException();
        } catch(ChildException c) {
            System.out.println("ChildException");
        }

        System.out.println();

        while(true) {
            try {
                if(count++ == 0)
                    throw new ChildException();
                System.out.println("CatchMe");
            } catch(ChildException e) {
                System.out.println("ChildException");
            } finally {
                System.out.println("Finally");
                if(count == 2) break;
            }
        }
    }
}
/*
GrandChildException
ChildException
 */
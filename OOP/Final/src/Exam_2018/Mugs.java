package Exam_2018;

class Mug{
        Mug(int marker){
                System.out.println("Mug(" + marker + ")");
        }
        void f(int marker){
                System.out.println("f(" + marker + ")");
        }
}

public class Mugs {
        {
                mug1 = new Mug(1);
                mug2 = new Mug(2);
                System.out.println("mug1 & mug2 initialized");
        }
        Mug mug1 = new Mug(99);
        Mug mug2;

        Mugs(){
                System.out.println("Mugs()");
        }
        Mugs(int i){
                System.out.println("Mugs(int)");
        }

        public static void main(String args[]){
                System.out.println("inside main()");
                new Mugs();
                System.out.println("new Mugs() completed");
                new Mugs(1);
                System.out.println("new Mugs(1) completed");
        }
}

/*
inside main()
Mug(99)
Mug(1)
Mug(2)
mug1 & mug2 initialized
Mugs()
new Mugs() completed
Mug(99)
Mug(1)
Mug(2)
mug1 & mug2 initialized
Mugs(int)
new Mugs(1) completed
 */

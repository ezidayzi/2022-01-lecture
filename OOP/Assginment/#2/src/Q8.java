import java.util.Scanner;

public class Q8 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("정수 몇개?");
        int num = scan.nextInt();
        int[] randInts = new int[num];

        for (int i = 0 ; i< num; i++) {
            randInts[i] = (int)(Math.random()*100+1);
            for(int j=0; j < i; j++) {
                if (randInts[i] == randInts[j]) {
                    i--;
                }
            }
        }

        for (int i = 0 ; i< num; i++) {
            System.out.print(randInts[i]+" ");
            if ((i+1)%10 == 0) System.out.println();
        }


        scan.close();
    }
}
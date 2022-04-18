public class Q10 {
    public static void main(String[] args) {

        int size = 4;
        int [][] matrix = new int[size][size];

        for (int x = 0; x < size; x++) {
            for (int y = 0; y < size; y++){
                matrix[x][y] = (int)(Math.random()*10+1);
            }
        }

        int n = 6;
        while (n > 0) {
            int x = (int)(Math.random()*4);
            int y = (int)(Math.random()*4);

            if (matrix[x][y] != 0) {
                matrix[x][y] = 0;
                n--;
            }
        }

        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}

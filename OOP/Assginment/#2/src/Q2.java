public class Q2 {
    public static void main(String[] args) {
        int[][] n = {{1}, {1, 2, 3}, {1}, {1, 2, 3, 4}, { 1, 2}};

        for (int[] ints : n) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }
}

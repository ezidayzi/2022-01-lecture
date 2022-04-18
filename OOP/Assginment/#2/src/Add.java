public class Add {
    public static void main (String[] args) {
        int sum = 0;

        for (String arg : args) {
            try {
                int n = Integer.parseInt(arg);
                sum = sum + n;
            } catch (NumberFormatException e) {

            }
        }
        System.out.println(sum);
    }
}


public class DiamondPattern {
    public static void main(String[] args) {
        int num = 3;
        int n = num + num - 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (num * num <= i + j)
                    System.out.print("*");
                // else if (n != 0)
                // System.out.print("*");
                else
                    System.out.print(" ");
            }
            System.out.println();
        }
    }
}

import java.util.Arrays;

public class FirstMAXSecondMIN {
    public static void main(String[] args) {
        int[] num = { 1, 2, 3, 4, 5, 6, 7 };
        int length = num.length;
        Arrays.sort(num);

        for (int i = 0, max = length - 1, min = 0; i < num.length; i++) {
            if (i % 2 == 0) {
                System.out.print(num[max--] + ",");
            } else if (i % 2 == 1) {
                System.out.print(num[min++] + ",");
            }
        }

    }
}

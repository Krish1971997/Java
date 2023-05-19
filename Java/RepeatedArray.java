import java.util.Arrays;

public class RepeatedArray {
    public static void main(String[] args) {
        int arr[] = { 0, 2, 2, 2, 0, 6, 6, 0, 8 };
        int res[] = new int[arr.length];
        for (int i = 0, j = i + 1; j < arr.length; i++, j++) {
            if ((arr[i] == arr[j]) && (arr[i] != 0 || arr[j] != 0)) {
                arr[i] = arr[i] * 2;
                arr[j] = 0;
            }
        }
        int k = res.length - 1;
        for (int i = 0, j = 0; i < arr.length; i++) {
            if (arr[i] != 0) {
                res[j++] = arr[i];
            } else
                res[k--] = arr[i];
        }

        System.out.println(Arrays.toString(res));
    }
}

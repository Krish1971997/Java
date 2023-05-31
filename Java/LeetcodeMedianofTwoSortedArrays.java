import java.util.Arrays;
//https://leetcode.com/problems/median-of-two-sorted-arrays/description/
public class LeetcodeMedianofTwoSortedArrays {
    public static void main(String[] args) {
        int nums1[] = { 1, 2 }, nums2[] = { 3, 4 };
        int mergedArray[] = new int[nums1.length + nums2.length];
        double res = 0.00000;
        for (int i = 0, j = 0, k = 0; i < mergedArray.length; i++) {
            if (nums1.length > i)
                mergedArray[j++] = nums1[i];
            else
                mergedArray[j++] = nums2[k++];
        }
        Arrays.sort(mergedArray);
        if (mergedArray.length % 2 == 0) {
            int divide = mergedArray.length / 2;
            res = (double) (mergedArray[divide] + mergedArray[divide - 1]) / 2;
        } else {
            int divide = mergedArray.length / 2;
            res = mergedArray[divide];
        }
        System.out.println("Result ---> " + res);
    }
}

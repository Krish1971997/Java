//https://practice.geeksforgeeks.org/problems/find-duplicates-in-an-array/1?page=1&company[]=Zoho&sortBy=submissions

import java.util.*;

public class FindDuplicatesInAnArray {
    public static void main(String[] args) {
        int a[] = { 13, 9, 25, 1, 1, 0, 22, 13, 22, 20, 3, 8, 11, 25, 10, 3, 15, 11, 19, 20, 2, 4, 25, 14, 23, 14 };
        int n = a.length;
        Solution g = new Solution();
        ArrayList<Integer> ans = g.duplicates(a, n);
        for (Integer val : ans)
            System.out.print(val + " ");
        System.out.println();
    }
}

class Solution {
    public ArrayList<Integer> duplicates(int arr[], int n) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        for (int i : arr) {
            if (list.contains(i)) {
                if (!list1.contains(i)) {
                    list1.add(i);
                }
            } else
                list.add(i);
        }

        if (list1.size() == 0) {
            list1.add(-1);
        }
        Collections.sort(list1);
        return list1;
    }
}

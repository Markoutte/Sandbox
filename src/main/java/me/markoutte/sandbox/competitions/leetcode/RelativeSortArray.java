package me.markoutte.sandbox.competitions.leetcode;

import java.util.Arrays;

/**
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
 * <p>
 * Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2. Elements that do not appear in arr2 should be placed at the end of arr1 in ascending order.
 * <p>
 * Example 1:
 * <p>
 * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * Output: [2,2,2,1,4,3,3,9,6,7,19]
 * Example 2:
 * <p>
 * Input: arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
 * Output: [22,28,8,6,17,44]
 * <p>
 *
 * Constraints:
 * <p>
 * 1 <= arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * All the elements of arr2 are distinct.
 * Each arr2[i] is in arr1.
 * <p>
 * @see <a href="https://leetcode.com/problems/relative-sort-array">https://leetcode.com/problems/relative-sort-array</a>
 */
public class RelativeSortArray {

    public static void main(String[] args) {
        int[] array1 = new RelativeSortArray().relativeSortArray(
                new int[]{2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19},
                new int[]{2, 1, 4, 3, 9, 6}
        );
        System.out.println(Arrays.toString(array1));
        int[] array2 = new RelativeSortArray().relativeSortArray(
                new int[]{28,6,22,8,44,17},
                new int[]{22,28,8,6}
        );
        System.out.println(Arrays.toString(array2));
    }

    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        int curr = 0;
        for (int k : arr2) {
            for (int i = 0; i < arr1.length; i++) {
                if (arr1[i] == k) {
                    swap(arr1, curr++, i);
                }
            }
        }
        Arrays.sort(arr1, curr, arr1.length);
        return arr1;
    }

    void swap(int[] input, int i, int j) {
        if (input[i] != input[j]) {
            input[i] = input[i] ^ input[j];
            input[j] = input[i] ^ input[j];
            input[i] = input[i] ^ input[j];
        }
    }

}

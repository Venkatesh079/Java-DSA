package Arrays;

import java.util.Arrays;

public class ArraysQuestions {

    public static void main(String[] args) {

        int[] arr = new int[]{11,234,43,45,1234,2342,443122,443122};
       // System.out.println(maxElement(arr));
        System.out.println(Arrays.toString(rotateArrayByK(arr,1)));

    }

    /**
     * 1. Find the maximum element in an array:
     *  Technique: Iterate through the array while keeping track of the maximum
     * element found so far.
     */

    public static int maxElement(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int j : arr) {
            if (j > max) {
                max = j;
            }
        }
        return max;
    }

    public static int minElement(int[] arr) {
        int minValue = Integer.MAX_VALUE;
        for (int j : arr) {
            if (j < minValue) {
                minValue = j;
            }
        }
        return minValue;
    }

    /**
     * 3. Find the second largest element in an array:
     *  Technique: Iterate through the array, keeping track of both the maximum
     * and the second maximum elements found so far.
     */

    public static int secondMaxElement(int[] arr) {
        int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;
        for (int j : arr) {
            if (j > max) {
                secondMax = max;
                max = j;
            }
        }
        return secondMax;
    }

    /**
     * 4. Find if there are duplicate elements in an array:
     *  Technique: Use a HashSet or sort the array first and then check adjacent
     * elements for duplicates.
     */

    public static boolean isDuplicate(int[] arr) {
        if (arr == null) {
            return false;
        }
        Arrays.sort(arr);
//        Set<Integer> set = new HashSet<>();
//        for (int j : arr) {
//            if (set.contains(j)) {
//                return true;
//            }
//            set.add(j);
//        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == arr[i - 1]) {
                return true;
            }
        }
        return false;
    }

    /**
     * 5. Reverse an array:
     *  Technique: Use two pointers approach, one starting from the beginning and
     * the other from the end, and swap elements until they meet.
     */
    public static int[] reverseArray(int[] arr) {
       int start = 0, end = arr.length - 1;
       while (start<end)
       {
           int temp = arr[start];
           arr[start] = arr[end];
           arr[end] = temp;
           start++;
           end--;
       }
       return arr;
    }

    /**
     * 6. Rotate an array to the right by k steps:
     *  Technique: Use reversal technique: reverse the whole array, then reverse the
     * first k elements, and finally reverse the rest.
     */

    public static int[] rotateArrayByK(int[] arr, int k)
    {
        int n = arr.length;
        k = k % n; // Handle cases where k is greater than the array length

        // Reverse the entire array
        reverse(arr, 0, n - 1);
        // Reverse the first k elements
        reverse(arr, 0, k - 1);
        // Reverse the remaining elements
        return reverse(arr, k, n - 1);
    }

    private static int [] reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
        return nums;
    }
}

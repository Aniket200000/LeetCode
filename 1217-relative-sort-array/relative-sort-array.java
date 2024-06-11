class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
                        // Initialize an array to store the count of each element in arr1
        int[] count = new int[1001]; // Assuming elements are in the range [0, 1000]

        // Count the occurrences of each element in arr1
        for (int num : arr1) {
            count[num]++;
        }

        // Initialize the result array
        int[] result = new int[arr1.length];
        int index = 0;

        // Process elements from arr2
        for (int num : arr2) {
            while (count[num] > 0) {
                result[index++] = num;
                count[num]--;
            }
        }

        // Process remaining elements not in arr2
        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                result[index++] = i;
                count[i]--;
            }
        }

        return result;
    }
}

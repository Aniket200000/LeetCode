class Solution {
    public int sumSubarrayMins(int[] arr) {
        final int MOD = 1000000007;

        // Part 1: Calculate the next smaller element on the left for each element
        Stack<Integer> leftStack = new Stack<>();
        int[] left = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            while (!leftStack.isEmpty() && arr[i] < arr[leftStack.peek()]) {
                leftStack.pop();
            }
            left[i] = leftStack.isEmpty() ? -1 : leftStack.peek();
            leftStack.push(i);
        }
        Stack<Integer> rightStack = new Stack<>();
        int[] right = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            while (!rightStack.isEmpty() && arr[i] <= arr[rightStack.peek()]) {
                rightStack.pop();
            }
            right[i] = rightStack.isEmpty() ? arr.length : rightStack.peek();
            rightStack.push(i);
        }

        long result = 0;
        for (int i = 0; i < arr.length; i++) {
            result += (long) arr[i] * (i - left[i]) * (right[i] - i);
            result %= MOD;
        }

        return (int) result;
    }
}
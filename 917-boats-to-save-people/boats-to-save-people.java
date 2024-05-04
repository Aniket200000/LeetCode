class Solution {
    public int numRescueBoats(int[] people, int limit) {
         Arrays.sort(people); // Sort people by weight
        int left = 0; // Pointer to the lightest person
        int right = people.length - 1; // Pointer to the heaviest person
        int reqBoats = 0; // Counter for required boats

        while (left <= right) { // Loop until pointers meet or cross
            if (people[left] + people[right] <= limit) { // If lightest and heaviest fit in one boat
                left++; // Move to the next lightest person
            }
            right--; // Always move to the next heaviest person
            reqBoats++; // Each iteration uses one boat
        }

        return reqBoats; // Return the total number of boats required
    }
}

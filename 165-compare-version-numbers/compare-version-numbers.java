class Solution {
    public int compareVersion(String version1, String version2) {
        String[] revs1 = version1.split("\\.");
    String[] revs2 = version2.split("\\.");

    // Find the maximum length between the two sets of revisions
    int maxLen = Math.max(revs1.length, revs2.length);

    // Iterate over the indices from 0 to maxLen-1
    for (int i = 0; i < maxLen; i++) {
        // Get the revision as an integer, or 0 if it doesn't exist
        int rev1 = (i < revs1.length) ? Integer.parseInt(revs1[i]) : 0;
        int rev2 = (i < revs2.length) ? Integer.parseInt(revs2[i]) : 0;

        // Compare the revisions
        if (rev1 < rev2) {
            return -1; // version1 is less than version2
        } else if (rev1 > rev2) {
            return 1; // version1 is greater than version2
        }
    }

    // If all revisions are equal, return 0
    return 0;
    }
}
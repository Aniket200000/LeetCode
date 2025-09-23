class Solution {
    public int compareVersion(String version1, String version2) {
    String[] revs1 = version1.split("\\.");
    String[] revs2 = version2.split("\\.");

    int maxLen = Math.max(revs1.length, revs2.length);

    for (int i = 0; i < maxLen; i++) {
        int rev1 = (i < revs1.length) ? Integer.parseInt(revs1[i]) : 0;
        int rev2 = (i < revs2.length) ? Integer.parseInt(revs2[i]) : 0;

        if (rev1 < rev2) {
            return -1; 
        } else if (rev1 > rev2) {
            return 1; 
        }
    }

    return 0;
    }
}
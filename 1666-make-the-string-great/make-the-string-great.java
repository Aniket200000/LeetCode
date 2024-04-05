class Solution {
    public String makeGood(String s) {
        StringBuilder stringBuilder = new StringBuilder(s);
        int i = 0;

        while (i < stringBuilder.length() - 1) {
            if (Math.abs(stringBuilder.charAt(i) - stringBuilder.charAt(i + 1)) == 32) {
                stringBuilder.delete(i, i + 2);
                i = Math.max(i - 1, 0);
            } else {
                i++;
            }
        }
        return stringBuilder.toString();
    }
}

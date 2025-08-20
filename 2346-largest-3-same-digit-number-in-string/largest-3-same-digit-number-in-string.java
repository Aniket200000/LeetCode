class Solution {
    public String largestGoodInteger(String num) {
        String max = "";
        for (int i = 0; i < num.length() - 2; i++) {
            if (num.charAt(i) == num.charAt(i + 1) && num.charAt(i + 1) == num.charAt(i + 2)) {
                String curr = "" + num.charAt(i) + num.charAt(i) + num.charAt(i);
                if (max.compareTo(curr) < 0) {
                    max = curr;
                }
            }
        }
        return max;
    }
}

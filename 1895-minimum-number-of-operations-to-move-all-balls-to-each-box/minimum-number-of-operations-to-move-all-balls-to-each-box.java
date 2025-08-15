class Solution {
    public int[] minOperations(String boxes) {
        int n = boxes.length();
        int answer[] = new int[n];
        for(int i = 0 ; i < n ;i++){
            int result = 0;
           for(int j = 0 ; j < n ; j++){
            if(boxes.charAt(j) == '1'){
                result += Math.abs(i - j);
            }
            answer[i] = result;
           }
        }
        return answer;
    }
}
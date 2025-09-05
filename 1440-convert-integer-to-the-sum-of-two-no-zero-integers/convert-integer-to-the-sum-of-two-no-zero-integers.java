class Solution {
    public int[] getNoZeroIntegers(int n) {
        int[] arr = new int[2];
        
        for(int i = 1; i < n; i++){
            arr[0] = i;
            arr[1] = n - i;
            
            if(!containsZero(arr[0]) && !containsZero(arr[1])){
                return arr;
            }
        }
        
        return arr;
    }
    
    private boolean containsZero(int num) {
        while(num > 0) {
            if(num % 10 == 0) return true;
            num /= 10;
        }
        return false;
    }
}

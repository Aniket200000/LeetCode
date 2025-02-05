class Solution {
    public int search(int[] a, int target) {
        int low = 0 , high = a.length-1, mid=0;

        while(low <= high){
            mid = low + (high-low)/2; // Avoid overflow

           if(a[mid] == target){//Target found at mid
            return mid;
           }

           else if(a[low] <= a[mid]) { // Checks if left Half is sorted
            if(a[low] <= target && target <= a[mid]){ // target in left half
                high = mid -1 ;
            }
            else{ // target in right half
                low = mid + 1;
            }
           }
            else{ // Checks if right half is sorted
                if(a[mid] < target && target <= a[high]){ // target lies in right half
                    low = mid + 1;
                }
                else { // target lies in left half
                    high = mid -1;
                }
            }
           
        } 
        return -1;// target not found
    }
}
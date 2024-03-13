class Solution {
    public int pivotInteger(int n) {
     if(n == 1) return n ;
     int leftPointer = 1 ;
     int rightPointer = n ;
     int leftSum = leftPointer ;
     int rightSum = rightPointer;

     while ( leftPointer < rightPointer){
        if(leftSum < rightSum){
            leftPointer++;
            leftSum+=leftPointer;
        }
        else{
            rightPointer--;
            rightSum+=rightPointer;
        }
        if(leftSum == rightSum && leftPointer + 1 == rightPointer - 1){
            return leftPointer + 1 ;
        }
     }
     return -1;
    }
}
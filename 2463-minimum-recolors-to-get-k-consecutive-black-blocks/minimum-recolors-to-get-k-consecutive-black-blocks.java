class Solution {
    public int minimumRecolors(String blocks, int k) {
        char[] charArr = blocks.toCharArray();
        int n = charArr.length;

        int Wcount = 0 , change ;

        for(int i = 0 ; i < k ; i++){
            if(charArr[i] == 'W'){
                Wcount++;
            }
        }
        change = Wcount;

        for(int right = k ; right < n ; right++){
            if(charArr[right - k] == 'W'){
                Wcount--;
            }
            if(charArr[right] == 'W'){
                Wcount++;
            }

            change = Math.min(change , Wcount);

        }
        return change;
    }
}
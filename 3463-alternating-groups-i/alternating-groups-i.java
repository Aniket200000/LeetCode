class Solution {
    public int numberOfAlternatingGroups(int[] colors) {
        int groups = 0 ;
        int n = colors.length;
        

        for(int i = 0 ;  i < n ; i++ ){

            if(colors[i % n] != colors[(i - 1 + n)% n]){
                if(colors[i % n] != colors[(i + 1)% n]){
                    groups++;
                }
            }
        }
        return groups;
    }
}
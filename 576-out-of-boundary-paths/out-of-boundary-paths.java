class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
int mod=1000000007;
        int dp[][]=new int[m][n];
        int dp1[][]=new int[m][n];
        int count=0;
        int dir[][]=new int[][]{{1,0},{-1,0},{0,1},{0,-1}}; 
        dp[startRow][startColumn]=1;
        for(int mo=1;mo<=maxMove;mo++){ 
            for(int i=0;i<m;i++){
                for(int j=0;j<n;j++){
                    if(dp[i][j]!=0){  
                    for(int k=0;k<4;k++){ 
                        int x=i+dir[k][0];
                        int y=j+dir[k][1];
                        if(x<0 || x>=m || y<0 || y>=n){ 
                            count=(count+dp[i][j])%mod;
                        }
                        else{
                            dp1[x][y]=(dp1[x][y]+dp[i][j])%mod;
                        }
                    }
                  }
                }
            }
            dp=dp1; 
            dp1=new int[m][n];
        }
        return count;    
    }
}
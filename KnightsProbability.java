class Solution {
    public double knightProbability(int n, int k, int row, int column) {
        return solution(row, column, n, k);
    }
    
    public double solution(int r, int c, int n, int k) {
		//write your code here
		double[][][] dp = new double[n][n][k+1];

		for(int i=0;i<=k;i++){
			for(int j=0;j<n;j++){
				for(int l=0;l<n;l++){
					if(i==0){
						dp[j][l][i] = 1.0;
					}else{

						int nj = j;
						int nl = l;


						nj = j-1;
						nl = l-2;


						if(!(nj>=n || nj<0 || nl>=n || nl<0)){
							dp[j][l][i] = dp[j][l][i] + (dp[nj][nl][i-1])/8.0;

						}


						nj = j-2;
						nl = l-1;

						if(!(nj>=n || nj<0 || nl>=n || nl<0)){
							dp[j][l][i] = dp[j][l][i] + (dp[nj][nl][i-1])/8.0;

						}
						nj = j-1;
						nl = l+2;

						if(!(nj>=n || nj<0 || nl>=n || nl<0)){
							dp[j][l][i] = dp[j][l][i] + (dp[nj][nl][i-1])/8.0;

						}

						nj = j-2;
						nl = l+1;

						if(!(nj>=n || nj<0 || nl>=n || nl<0)){
							dp[j][l][i] = dp[j][l][i] + (dp[nj][nl][i-1])/8.0;

						}
						nj = j+1;
						nl= l-2;

						if(!(nj>=n || nj<0 || nl>=n || nl<0)){
							dp[j][l][i] = dp[j][l][i] + (dp[nj][nl][i-1])/8.0;

						}

						nj=j+2;
						nl=l-1;

						if(!(nj>=n || nj<0 || nl>=n || nl<0)){
							dp[j][l][i] = dp[j][l][i] + (dp[nj][nl][i-1])/8.0;

						}

						nj=j+1;
						nl=l+2;

						if(!(nj>=n || nj<0 || nl>=n || nl<0)){
							//System.out.println("nj"+ nj);
							//System.out.println(nl);

							//System.out.println(dp[nj][nl][i-1]);
							dp[j][l][i] = dp[j][l][i] + (dp[nj][nl][i-1])/8.0;

						}

						nj=j+2;
						nl=l+1;

						if(!(nj>=n || nj<0 || nl>=n || nl<0)){
							dp[j][l][i] = dp[j][l][i] + (dp[nj][nl][i-1])/8.0;

						}
						
						


					}

				}
			}
		}
		return dp[r][c][k];


		
	}
}

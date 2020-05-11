#include <bits/stdc++.h>
#include <iostream>
#include <cstdio>	

using namespace std;


// started16:26

/*int LCS (string s, string ss, int i, int j, auto dp){

	if (i==0 || j==0)
		return 0;
	if(dp[i][j]!=-1)
		return dp[i][j];
	
	if (s[i-1] == ss[j-1]){
		dp[i][j] = 1+LCS(s,ss,i-1,j-1,dp);;
		return dp[i][j];
		*//*return 1+LCS(s,ss,i-1,j-1,dp);*//*
	}
	else{
		dp[i][j] = max(LCS(s,ss,i-1,j,dp),LCS(s,ss,i,j-1,dp));
		return dp[i][j];
		*//*return max(LCS(s,ss,i-1,j,dp),LCS(s,ss,i,j-1,dp));*//*
	}

}
*/
int LCS2(string s,string ss){
	int dp[6103][6103];// = {0};
	memset(dp,0,sizeof dp);
	int i,j;
	for (i=1;i<=s.length();i++){
		for(j=1;j<=ss.length();j++){
			if(s[i-1]==ss[j-1])
				dp[i][j]=1+dp[i-1][j-1];
			else
				dp[i][j]=max(dp[i-1][j],dp[i][j-1]);
		}
	}
	return dp[i-1][j-1];
}	
int main(void){
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	int t;
	string s,ss;
	cin>>t;
	while(t--){
		cin>>s;
		ss = s;
		reverse(ss.begin(),ss.end());
        // cout<<s<<endl<<ss<<endl;
        cout<<s.length() - LCS2(s,ss)<<"\n";
	}
	return 0;
} 

// submitted 16:35
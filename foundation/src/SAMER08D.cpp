// TODO: skipping this
#include<bits/stdc++.h>

using namespace std;

int check(string a, string b, int i, int j){
	int cnt = 0;
	i--;j--;
	/*while(a[i--]==b[j--] && i>=0 && j>=0 && cout<<i<<" " && cout<<j<<endl) cnt++;*/
	while(i>=0 && j>=0){
		if (a[i]==b[j])
			cnt++;
		else
			break;
		i--;j--;
	}
	// cout<<i<<" "<<j<<" "<<cnt<<endl;
	return cnt;
}

int func(string a, string b, int i,int j,int k,auto dp){
	
	if(i==0 || j==0)
		return 0;
	if (dp[i][j]!=-1)
		return dp[i][j];
	/*check will give the length of equal substring */
	int c = check (a,b,i,j); 
	if(c >=k){
		dp[i][j] = c + func(a,b,i-c,j-c,k,dp);
		return dp[i][j];
		/*return c + func(a,b,i-c,j-c,k,dp);*/
	}
	else{
		dp[i][j] = max(func(a,b,i-1,j,k,dp),func(a,b,i,j-1,k,dp));
		return dp[i][j];
		/*return max(func(a,b,i-1,j,k,dp),func(a,b,i,j-1,k,dp));*/
	}
}

int func2(string a, string b, int i,int j,int k, int m, auto dp){
	
	if(i==0 || j==0)
		return 0;
	if (dp[i][j][k]!=-1)
		return dp[i][j][k];
	/*check will give the length of equal substring */
	int c = check (a,b,i,j); 
	if(c >=k && k>0){
		dp[i][j][k] = 1 + max(func2(a,b,i-1,j,k-1,m,dp),func2(a,b,i,j-1,k-1,m,dp));
		return dp[i][j][k];
		/*return c + func2(a,b,i-c,j-c,k,dp);*/
	}
	else{
		dp[i][j][k] = max(func2(a,b,i-1,j,m,m,dp),func2(a,b,i,j-1,m,m,dp));
		return dp[i][j][k];
		/*return max(func2(a,b,i-1,j,k,dp),func2(a,b,i,j-1,k,dp));*/
	}
}
int main(void){
	int m;
	string a,b;
	int p,q;
	int dp[100][100][101];// = {-1};
	while(cin>>m && m!=0){
		cin>>a;
		cin>>b;
		p = a.length();
		q = b.length();
		memset (dp,-1,sizeof dp);
		cout<<func2(a,b,p,q,m,m,dp)<<endl;
		/*int g = func(a,b,p,q,m,dp);
		reverse(a.begin(),a.end());
		reverse(b.begin(),b.end());
		int h = func(a,b,p,q,m,dp);
		cout<<max(g,h)<<endl;
		cout<<a<<endl<<b<<endl;*/
	}	
	return 0;
}
#include <bits/stdc++.h>

using namespace std;

// int mul()
// pair -> smoke,color
pair<int,int> func2(auto a,auto b){
	int _smoke = a.second*b.second;
	int _color = (a.second + b.second) % 100;
	return {_smoke,_color};
}
pair<int,int> func(auto v,int i, int j, auto dp){
	// cout<<"i="<<i<<" j="<<j<<endl;
	if(i==j)
		return {0,v[i]};
	if (dp[i][j].first!=-1 && dp[i][j].second!=-1)
		return dp[i][j];
	int min = INT_MAX;
	pair<int,int> minpair = {0,0};
	for (int k=i;k<j;k++){
		auto f1 = func(v,i,k,dp);
		auto f2 = func(v,k+1,j,dp);
		auto _pair = func2(f1,f2);
		int _smoke = _pair.first + f1.first + f2.first; 
		int _color = _pair.second;
		// cout<<_smoke<<" "<<_color<<endl;
		if (_smoke<min){
			min = _smoke;
			minpair = {_smoke,_color};
		}
	}
	dp[i][j] = minpair;
	return minpair;
}


int main(void){

	int t,m;
	vector<int> v;
	pair<int,int> dp[103][103] ;//= {-1,-1};
	// cin>>t;
	while(cin>>m){		v.resize(m);
		for (int i=0;i<m;i++){
			cin>>v[i];
		}
		// memset(dp,-1,sizeof dp);
		for (int i=0;i<=m;i++)
			for (int j=0;j<=m;j++)
				dp[i][j]={-1,-1};
		auto ans = func(v,0,m-1,dp);
		cout<<ans.first<<endl;
		// func(v,0,m);

	}
	return 0;
}





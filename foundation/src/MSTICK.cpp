#include <bits/stdc++.h>

using namespace std;
struct x{
	int w,h;
}arr[30001];
int main(void){

	int t;
	int m;
	cin>>t;
	while(t--){
		cin>>m;
		for (int i=0;i<m;i++){
			cin >> arr[i].w >> arr[i].h;
		}
		sort(arr,arr+m,[](x a,x b) {if (a.w==b.w) return a.h<b.h; else return a.w>b.w;});
		vector<x> vc;
		vc.push_back(arr[0]);
		
	}
}
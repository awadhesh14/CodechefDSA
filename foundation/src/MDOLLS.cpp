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
		/*for (int i=1;i<m;i++){
			auto pos = lower_bound(vc.begin(),vc.end(),arr[i],[](x a,x b) {if (a.w==b.w) return a.h<b.h; else return a.w>b.w;});
			int x =pos-vc.begin()-1;
			// cout<<vc[x].h<<endl;
			if (vc[x].w>arr[i].w && vc[x].h>arr[i].h){
				vc[x] = arr[i];
			}
			else{
				vc.push_back(arr[i]);
			}
		}*/
		bool _T;
		for (int i=1;i<m;i++){
			_T = false;
			for (int j=0;j<vc.size();j++){
				if (vc[j].w>arr[i].w && vc[j].h>arr[i].h){
					vc[j] = arr[i];
					_T = true;
					break;
				}
			}
			if (!_T){
				vc.push_back(arr[i]);
			}
		}
		cout<<vc.size()<<endl;
	}	

	return 0;
}
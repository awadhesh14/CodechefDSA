#include <bits/stdc++.h>

using namespace std;
struct x{
	int w,h;
	bool operator<(x other) const{
		if (w==other.w) return h>other.h; else return w>other.w;
		// if (w==other.w) return h<other.h; else return w>other.w;
	}
	bool operator==(x other) const{
		return  (w==other.w && h==other.h);// return h<other.h; else return w>other.w;
	}
};

int func(auto arr){
	vector<x> tail;
	tail.push_back(arr[0]);
	int length = 1;
	/*for (int i=1;i<arr.size();i++){
		auto it = lower_bound(tail.begin(),tail.end(),arr[i]);
		if(it == tail.begin()+length)
			tail[length++] = arr[i];
		else
			*it = arr[i];
	}*/
	bool _T;
	for(int i=1;i<arr.size();i++){
		_T=true;
		for (int j=0;j<tail.size();j++){
			if(tail[j].w<=arr[i].w && tail[j].h<=arr[i].h){
				tail[j]=arr[i];
				_T = false;
				break;
			}
		}
		if(_T){
			tail.push_back(arr[i]);
		}
	}
	return tail.size();
}
int main(void){
	int t,m;
	cin>>t;
	vector<x> arr;
	while(t--){
		cin>>m; arr.resize(m);
		for (int i=0;i<m;i++)
			cin >> arr[i].w >> arr[i].h;
		sort(arr.begin(),arr.end());//,[](x a,x b) {if (a.w==b.w) return a.h<b.h; else return a.w>b.w;});
		vector<x> vc;
		vc.push_back(arr[0]);
		/*for (int i=0;i<m;i++){
			cout<<arr[i].w<<" "<<arr[i].h<<endl;
		}*/
		reverse(arr.begin(),arr.end());
		cout<<func(arr)<<endl;
	}
}
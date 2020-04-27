"""
"""
"""
TODO: func2 gives TLE func1 gives runtime error but func2 accepted in java
"""
"""
"""

import sys 
sys.stdin = open('input.in', 'r')  
# sys.stdout = open('outputf.in', 'w') 
# started at 

MAXI = 999999999
def func2(h,K,i,dp):
	if h==0:
		return 0
	elif h<0:
		return MAXI
	elif i>=len(K) and h>0:
		return MAXI
	elif dp[h][i]!=-1:
		return dp[h][i]
	else:
		
		dp[h][i] = min(1+func2(h-K[i],K,i,dp) if dp[h-K[i]][i]==-1 else 1+dp[h-K[i]][i],func2(h,K,i+1,dp) if dp[h][i+1]==-1 else dp[h][i+1])
		# dp[h][i] = min(1+func2(h-K[i],K,i,dp),func2(h,K,i+1,dp))
		return  dp[h][i]
from copy import copy
for _ in range(int(input())):
	N =  int(input())
	# H =list(map(lambda x: 2*int(x),input().split()))
	H = list(map(int,input().split()))
	K = list(map(int,input().split()))
	_1 = [-1 for i in range(1008)]
	dp = [copy(_1) for j in range(1008)]
	print(sum([func2(2*h,K,0,dp) for h in H]))

def func1(n,ans,K):
	if ans[n]>0:return ans[n]
	x = [1+func1(n-k,ans,K) for k in K if k<=n]
	x = [_x for _x in x if _x>0 ]
	ans[n] = min(x) if len(x) else -1
	return ans[n]

from copy import copy
xy = [0 for i in range(1005*1005)]
for _ in range(int(input())):
	N =  int(input())
	H,K = list(map(int,input().split())),list(sorted(map(int,input().split())))
	ans = copy(xy)
	for k in K: ans[k]=1
	print(sum([func1(2*h,ans,K) for h in H]))
# submitted at
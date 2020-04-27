import sys 
sys.stdin = open('input.in', 'r')  
# sys.stdout = open('outputf.in', 'w') 

# started at 
# a = []
MAXI = 999999999
def func(h,K,i,dp):
	if h==0:
		return 0
	elif h<0:
		return MAXI
	elif i>=len(K) and h>0:
		return MAXI
	elif dp[h][i]!=-1:
		return dp[h][i]
	else:
		
		dp[h][i] = min(1+func(h-K[i],K,i,dp) if dp[h-K[i]][i]==-1 else 1+dp[h-K[i]][i],func(h,K,i+1,dp) if dp[h][i+1]==-1 else dp[h][i+1])
		# dp[h][i] = min(1+func(h-K[i],K,i,dp),func(h,K,i+1,dp))
		return  dp[h][i]


from copy import copy
for _ in range(int(input())):
	N =  int(input())
	# H =list(map(lambda x: 2*int(x),input().split()))
	H = list(map(int,input().split()))
	K = list(map(int,input().split()))
	_1 = [-1 for i in range(1008)]
	dp = [copy(_1) for j in range(1008)]
	print(sum([func(2*h,K,0,dp) for h in H]))
import sys 
sys.stdin = open('input.in', 'r')  
# sys.stdout = open('outputf.in', 'w') 


# started at 

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
		dp[h][i] = min(1+func(h-K[i],K,i,dp),func(h,K,i+1,dp))
		return  dp[h][i]



for _ in range(int(input())):
	N =  int(input())
	# H =list(map(lambda x: 2*int(x),input().split()))
	H = [2*int(x) for x in input().split()]
	K = list(map(int,input().split()))
	dp = [[-1 for i in range(1008)] for j in range(1008)]
	print(sum([func(h,K,0,dp) for h in H]))

# submitted at
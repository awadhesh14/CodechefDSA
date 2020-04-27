import sys 
sys.stdin = open('input.in', 'r')  
# sys.stdout = open('outputf.in', 'w') 

# started at 
# a = []


# started at 
# a = []
import sys
sys.setrecursionlimit(100000+5)
def func(h,K,i,coins):
	if(h<=0):
		# print("h<=0",h,i,coins)
		return coins
	if(i>=len(K)):
		# print("i>=len",h,i,coins)
		return coins
	# if(dp[h]!=0):
	# 	return dp[h]+coins
	if(dp[h][K[i]]!=0):
		# print("herre")
		return dp[h][K[i]] + coins
	if (K[i]>h):
		# return func(h,K,i+1,coins) if i<len(K)-1 else 250000
		dp[h][K[i]] = func(h,K,i+1,coins) if i<len(K)-1 else 250000
		return dp[h][K[i]]
	if(i==len(K)-1):
		x =  func(h-K[i],K,i,coins+1)
		y = func(h,K,i+1,coins) if i<len(K)-1 else 250000
		# return min(x,y)
		dp[h][K[i]] = min(x,y)
		return dp[h][K[i]]
	x =  func(h-K[i],K,i,coins+1)
	z = func(h-K[i],K,i+1,coins+1) if i<len(K)-1 else 250000
	y = func(h,K,i+1,coins) if i<len(K)-1 else 250000
	# print("returning",h,i,coins)
	dp[h][K[i]] = min(x,y,z)
	return dp[h][K[i]]
	# a.append((h,K[i],min(x,y,z)))#,ans,x,y,z))
	# return min(x,y,z)
dp = [[0 for i in range(1008)] for j in range(1008)] 
# dp = [0]*1008
for _ in range(int(input())):
	N =  int(input())
	ans,H,K = 0,list(map(lambda x: 2*int(x),input().split())),list(map(int,input().split()))
	mx = max(H)
	for h in H:
		ans += func(h,K,0,0)
		# ans+=dp[h]
		# print(dp[h])
		# print(x)
	print(ans)
# for i in sorted(a):
# 	print(i)
# print(len(a) - len(set(a)))
# submitted at
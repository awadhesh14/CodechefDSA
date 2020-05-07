import sys 
sys.stdin = open('input.in', 'r')  
# sys.stdout = open('outputf.in', 'w') 

# started 17:52
from math import gcd
def func(W,i,g,dp):
	if i>=len(W): return 0
	if dp[i][g]!=-1: return dp[i][g]
	_g = gcd(g,W[i])
	ans1 = 1+func(W,i+1,_g,dp) if _g==1 else func(W,i+1,_g,dp)
	dp[i][g]= ans1+func(W,i+1,g,dp)
	return dp[i][g]
result = ""
for _ in range(int(input())) :
	n = int(input())
	W,dp = [int(x) for x in input().split()],[[-1 for x in range(10000+3)] for y in range(70)]
	result += str(func(W,0,0,dp))+"\n"
print(result[:-1])
# submitted 03:05
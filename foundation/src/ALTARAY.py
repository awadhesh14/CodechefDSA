import sys 
sys.stdin = open('input.in', 'r')  
# sys.stdout = open('outputf.in', 'w') 

# started at 22:30
import sys
sys.setrecursionlimit(100000+5)

def sign(n):
	return n>0
def func(a,sgn,ans,A,N):
	if a>=N:
		return 0
	ans[a] = 1 + func(a+1,sign(A[a]),ans,A,N)
	if sign(A[a])!=sgn:
		return ans[a]
	else:
		return 0

result = []

for _ in range(int(input())):
	N = int(input())
	A = list(map(int,input().split()))
	ans = [-1]*N
	ans[0] = 1+func(1,sign(A[0]),ans,A,N)
	result.append(" ".join(map(str,ans)))
print("\n".join(result))
# submitted at 22:56
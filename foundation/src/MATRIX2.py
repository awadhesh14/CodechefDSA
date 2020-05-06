import sys 
sys.stdin = open('input.in', 'r')  
# sys.stdout = open('outputf.in', 'w') 


# started at 00:36

n,m = map(int,input().split())
W = []
for _ in range(n):
	W.append(input())
M = [[0 for x in range(m)] for y in range(n)]
for it,i in enumerate(W):
	t=0
	for jt,j in enumerate(i):
		t=t+1 if j=='1' else 0
		M[it][jt]=t
ans = 0
for i in range(m-1,-1,-1):
	t=0	
	for j in range(n-1,-1,-1):
		t=min(t+1,M[j][i]) if W[j][i]=='1' else 0
		# M[j][i]=(M[j][i][0],t)
		ans+=min(M[j][i],t)
print(ans)
"""
for i in M:
	for j in i:
		print(j,end=" ")
	print()
"""
# submitted at 00:53
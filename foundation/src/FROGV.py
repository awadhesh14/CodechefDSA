import sys 
sys.stdin = open('input.in', 'r')  
# sys.stdout = open('outputf.in', 'w') 


# started at 21:45

n,k,p = map(int,input().split())
W = [int(x) for x in input().split()]
M = list(sorted(zip(W,[x for x in range(1,n+1)])))
P = [x for x in range(n+2)]
res = ""
# print(M)
for i in range(1,n):
	# if P[M[i][1]]==-1:
	# 	P[M[i][1]]=1
	if M[i][0]-M[i-1][0]<=k:
		P[M[i][1]]=P[M[i-1][1]]
	# print(M[i][0],M[i-1][0])
# print(P)
for _ in range(p):
	a,b = map(int,input().split())
	if P[a]==P[b]:
		res+='Yes\n'# print('Yes')
	else:
		res+='No\n'# print('No')

print(res[:-1])
# submitted at 
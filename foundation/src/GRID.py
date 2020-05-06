import sys 
sys.stdin = open('input.in', 'r')  
# sys.stdout = open('outputf.in', 'w') 


# started at 

t = int(input())
for _ in range(t):
	n=int(input())
	W = []
	for i in range(n):
		W.append([x for x in input()])
	M = [[0 for i in range(n)] for j in range(n)]
	for i in range(n-1,-1,-1):
		p = 0
		for j in range(n-1,-1,-1):
			if(W[i][j]=='#'):
				p = 1
			M[i][j]=p
	ans=0
	for j in range(n):
		for i in range(n-1,-1,-1):
			if (W[i][j]=='#'):
				break
			elif(M[i][j]==1):
				continue
			else:
				ans+= 1
		# 	print(W[i][j],(n-j),end=" ")
		# print()
	print(ans)

# submitted at
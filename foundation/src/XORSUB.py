import sys 
sys.stdin = open('input.in', 'r')  
# sys.stdout = open('outputf.in', 'w') 


# started at 

t = int(input())
for _ in range(t):
	n,k = map(int,input().split())
	W = [int(x) for x in input().split()]
	S = {k}
	for i in W:
		_t = []
		for j in S:
			_t.append(i^j)
		for x in _t: S.add(x)
	print(max(S))



# submitted at
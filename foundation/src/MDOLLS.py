# NOTE: TLE on spoj
import sys 
sys.stdin = open('input.in', 'r')  
# sys.stdout = open('outputf.in', 'w') 

# started 11:13

from functools import cmp_to_key,total_ordering
from bisect import bisect_left
@total_ordering
class wh1:
	def __init__(self,w,h):
		self.w = w
		self.h = h
	def __lt__(self,other):
		return self.h<other.h if self.w==other.w else self.w>other.w
	def __eq__(self,other):
		return self.w==other.w and self.h==other.h
res = ""
for _ in range(int(input())):
	m = int(input())
	wh,hw = [],[int(x) for x in input().split()]
	for i in range(0,len(hw),2):
		wh.append(wh1(hw[i],hw[i+1]))
	wh.sort()
	# for i in wh:
	# 	print(i.w,i.h)
	pq = [wh[0]]
	for i in wh[1:]:
		x = bisect_left(pq,i)
		if(pq[x-1].w>i.w and pq[x-1].h>i.h):
			pq[x-1]= i
			# print('here x=',x)
		else:
			pq.append(i)
	res += str(len(pq)) + "\n"
print(res[:-1])

# submitted 13:11 the next day
# for _ in range(int(input())):
# 	m = int(input())
# 	wh,hw = [],[int(x) for x in input().split()]
# 	for i in range(0,len(hw),2):	
# 		wh.append((hw[i],hw[i+1]))
# 	wh = sorted(wh,key=cmp_to_key(lambda x,y: x[1]-y[1] if x[0]==y[0] else y[0]-x[0]))
# 	pq = [wh[0]]
# 	for i,j in wh[1:]:
# 		# for it,(p,q) in enumerate(pq):
# 		# 	if p>i and q>j:
# 		# 		pq[it]=(i,j)
# 		# 		break
# 		# else:
# 		# 	pq.append((i,j))
# 		x = bisect_left(pq,(i,j))
# 		if(x):
# 			pq[x-1] = (i,j)
# 		else:
# 			pq.append((i,j))

# 	# print(wh)
# 	print(len(pq))








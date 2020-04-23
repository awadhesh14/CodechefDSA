def primes_method5(n): #returns a list of all primes upto n
    out = list()
    sieve = [True] * (n+1)
    for p in range(2, n+1):
        if (sieve[p]):
            out.append(p)
            for i in range(p, n+1, p):
                sieve[i] = False
    return out

def is_prime(n):
    if n == 2:
        return True
    if n % 2 == 0 or n <= 1:
        return False
    sqr = int(math.sqrt(n)) + 1
    for divisor in range(3, sqr, 2):
        if n % divisor == 0:
            return False
    return True

def isprime(n):
	if (n <= 1): 
		return False; 
	if (n <= 3): 
		return True 
	if (n % 2 == 0 or n % 3 == 0):
		return False
	for i in range(5,n,6):#(int i = 5; i * i <= n; i = i + 6) 
		if i*i>n: break
		if n%i==0 or n%(i+2)==0:
			return False
	return True

def permute(a, l, r, permutes): 
	    if l==r: 
	        permutes.append(toString(a))
	    else: 
	        for i in range(l,r+1): 
	            a[l], a[i] = a[i], a[l] 
	            permute(a, l+1, r, permutes) 
	            a[l], a[i] = a[i], a[l]
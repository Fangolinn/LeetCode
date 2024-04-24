class Solution:
    def tribonacci(self, n: int) -> int:
        lista = [0, 1, 1]
        
        if n==0:
            return 0
        
        for _ in range(3,n+1):
            lista.append(lista[-1]+ lista[-2]+ lista[-3])
            lista.pop(0)
            
        return lista[-1]

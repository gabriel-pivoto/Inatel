def gauss_seidel(A, b, x0, tol, max_iter):
    n = len(b)
    x = x0.copy()
    
    for k in range(max_iter):
        x_old = x.copy()
        
        for i in range(n):
            sum_Ax = sum(A[i][j] * x[j] for j in range(n) if j != i)
            x[i] = (b[i] - sum_Ax) / A[i][i]
        
        error = max(abs(x[i] - x_old[i]) for i in range(n))
        if error < tol:
            break
            
    return x

A = [[2, -1, 2],
     [1, 2, 1],
     [-2, -1, -3]]

b = [-2, -1, 1]

x0 = [0, 0, 0]

tol = 0.001
max_iter = 1000

solucao = gauss_seidel(A, b, x0, tol, max_iter)

print("Solução aproximada:", solucao)
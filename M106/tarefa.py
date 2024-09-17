import numpy as np

def f(x):
    return -x**2 + 2*x + 1

def teu_method(a, b, step=0.01):
    x_values = np.arange(a, b, step)
    for x in x_values:
        if f(x) == 0:
            return x
        elif f(x) * f(x + step) < 0:
            return (x + (x + step)) / 2
    return None

root_teu = teu_method(-3, 3)
print(f"Raiz pelo método TEU: {root_teu}")

def bisection_method(a, b, tol=1e-6):
    if f(a) * f(b) >= 0:
        print("A função deve ter sinais opostos em a e b")
        return None

    while (b - a) / 2 > tol:
        c = (a + b) / 2
        if f(c) == 0:
            return c
        elif f(a) * f(c) < 0:
            b = c
        else:
            a = c
    return (a + b) / 2

root_bisection = bisection_method(-3, 3)
print(f"Raiz pelo método da bisseção: {root_bisection}")

def df(x):
    return -2*x + 2

def newton_raphson(x0, tol=1e-6, max_iter=100):
    x = x0
    for _ in range(max_iter):
        fx = f(x)
        dfx = df(x)
        if abs(fx) < tol:
            return x
        if dfx == 0:
            return None
        x = x - fx / dfx
    return None

root_newton = newton_raphson(0)
print(f"Raiz pelo método de Newton-Raphson: {root_newton}")


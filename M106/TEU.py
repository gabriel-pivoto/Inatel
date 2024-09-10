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

# Intervalo [-3, 3]
root_teu = teu_method(-3, 3)
print(f"Raiz pelo método TEU: {root_teu}")

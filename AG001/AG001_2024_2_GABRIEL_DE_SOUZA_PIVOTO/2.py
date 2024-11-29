from sympy import Derivative, Integral, Symbol, pi, cos

C = 260 % 10

def main(t):
    return 0.3 * 2 * pi * 9 * cos(2 * pi * 9 * t - C)
    
t = Symbol('t')
    
x = Integral(main(t), t).doit()
v = main(t)
a = Derivative(main(t), t).doit()

a_7 = a.subs({t: 7})

print('\n---------------  DESLOCAMENTO  ---------------')
print('\n x(t) =',x)

print('\n---------------  ACELERAÇÃO  ---------------')
print('\n a(t) =', a)

print('\n---------------  ACELERAÇÃO EM t=7  ---------------')
print('\n'f' a(7) = {a_7}')
print(f' a(7) = {round(float(a_7), 2)} m/s²')
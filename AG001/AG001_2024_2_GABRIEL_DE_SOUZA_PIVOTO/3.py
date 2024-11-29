from sympy import Symbol, diff, sqrt 

c = 260 % 10

def deslocamento(t):
    S = ((-2 * t**4) / 3) + (5 * sqrt(t)) - c
    return S

t = Symbol('t')

result = diff(deslocamento(t), t)

result2 = diff(result, t)

print('\n***  VELOCIDADE  ***')
print('\n v(t) =', result)
print('\n v(8) =', result.subs({t: 8}))
print('\n***  ACELERACAO  ***')
print('\n a(t) =', result2)
print('\n a(9) =', result2.subs({t: 9}))
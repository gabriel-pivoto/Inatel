from sympy import Symbol, solve

C = 260 % 10

V1 = 3+(4*C)
V2 = -1-(5*C)

R1 = 25
R2 = 20
R3 = 10

def malha_1(i1, i2):
    return V1 - (R1*i1) - R3*(i1 - i2)

def malha_2(i1, i2):
    return V2 - (R3 * (i2 - i1)) - (R2*i2)

x = Symbol('i1')
y = Symbol('i2')

i1, i2 = solve((malha_1(x, y), malha_2(x, y))).values()

i3 = i2 - i1

print(f'i1 = {i1}')
print(f'i2 = {i2}')
print(f'i3 = {i3}')

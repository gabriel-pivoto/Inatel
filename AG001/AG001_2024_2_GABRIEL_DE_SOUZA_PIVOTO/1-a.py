from sympy import Limit, Symbol

C = 260 % 10

def main(x):
  return(1 + (C - 15)/x**0.5)**x**0.5
  
print('\n' * 100)

x = Symbol('x')

result = Limit(main(x), x, 0).doit()

print('\n Limite da função para x -> 0.')
print(result)
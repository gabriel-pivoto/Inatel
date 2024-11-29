from sympy import Limit, Symbol, S

C = 260 % 10

def main(x):
  return(1 + (C - 15)/x**0.5)**x**0.5
  
print('\n' * 100)

x = Symbol('x')

result = Limit(main(x), x, S.Infinity).doit()

print('\n Limite da função para x -> 00.')
print(result)

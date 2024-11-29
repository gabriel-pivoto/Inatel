from sympy import Symbol, solve, cos

C = 260 % 10

def print_result(x, i):
    try:
        print(f'x{i} = {round(float(x), 3)}')
    except:
        comp = complex(x)
        real_part = round(comp.real, 3)
        imag_part = round(comp.imag, 3)
        if imag_part < 0:
         print(f'x{i} = {real_part} - {abs(imag_part)}j')
        else:
         print(f'x{i} = {real_part} + {imag_part}j')

def eq_1(x):
    return 2**x + 2**(4*x) - (C + 1)

def eq_2(x):
    return (C+2)*x**3-(C+1)*x**2-5*x+4*C

def eq_3(x):
    return (3*(1/(cos((C-3))))+2)**2

if __name__ == '__main__':
    x = Symbol('x')

    result_eq1 = solve(eq_1(x))
    result_eq2 = solve(eq_2(x))
    result_eq3 = solve(eq_3(x))

    print('\n2**x + 2**(4x) = C + 1')
    for i, x in enumerate(result_eq1):
        print_result(x, i)

    print('\n5*sqrt(x) - 4x**2 + x/2 = C')
    for i, x in enumerate(result_eq2):
        print_result(x, i)

    print('\n{3tan[(C - 3)x] + 2}**2 = 0')
    for i, x in enumerate(result_eq3):
        print(f'x{i} = {x}')
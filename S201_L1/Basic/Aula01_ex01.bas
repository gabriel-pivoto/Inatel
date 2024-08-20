10 INPUT "Insira o valor de a:"; a
20 INPUT "Insira o valor de b:"; b
30 INPUT "Insira o valor de c:"; c
40 delta = b*b - 4*a*c
50 IF delta < 0 THEN PRINT "Não há raízes reais"
60 x1 = (-b + SQR(delta)) / (2 * a)
70 x2 = (-b - SQR(delta)) / (2 * a)
80 PRINT x1
90 PRINT x2

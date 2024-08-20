a = {}
y = 0
for i = 1, 100 do
  a[i] = math.random(1, 10)
  if a[i] % 2 == 0 then
    print(a[i])
    y = y + a[i]
  end
end
print("a soma de todos os numeros pares é:"..y)
--Q1
lista :: [Int]
lista = map (*3) [30,29..1]

ultimoElemento :: Int
ultimoElemento = last (reverse lista)

--Q2
fatorial_Numero :: Int -> Int
fatorial_Numero n
    | n > 0     = factorial n
    | otherwise = n * 2
  where
    factorial 0 = 1
    factorial x = x * factorial (x - 1)


main :: IO ()
main = do
    putStrLn "Exercício 1:"
    print lista
    putStrLn $ "Último elemento invertido: " ++ show ultimoElemento
    putStrLn "Exercício 2:"
    let numero = 5 
    putStrLn $ "Resultado do processamento para " ++ show numero ++ ": " ++ show (fatorial_Numero numero)

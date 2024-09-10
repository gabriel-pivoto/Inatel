package main

import (
	"fmt"
	"math"
)

func main() {
	var a, b, c float64

	fmt.Print("Digite o valor de a: ")
	fmt.Scanln(&a)
	fmt.Print("Digite o valor de b: ")
	fmt.Scanln(&b)
	fmt.Print("Digite o valor de c: ")
	fmt.Scanln(&c)

	delta := b*b - 4*a*c

	if delta < 0 {
		fmt.Println("A equação não possui raízes reais.")
	} else if delta == 0 {
		x := -b / (2 * a)
		fmt.Printf("A equação possui uma raiz real: x = %.2f\n", x)
	} else {
		x1 := (-b + math.Sqrt(delta)) / (2 * a)
		x2 := (-b - math.Sqrt(delta)) / (2 * a)
		fmt.Printf("A equação possui duas raízes reais: x1 = %.2f e x2 = %.2f\n", x1, x2)
	}
}

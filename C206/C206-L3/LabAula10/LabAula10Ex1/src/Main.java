import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o primeiro número: ");
        double numero1 = scanner.nextDouble();

        System.out.print("Digite o segundo número: ");
        double numero2 = scanner.nextDouble();

        System.out.println("Escolha a operação: ");
        System.out.println("1. Soma");
        System.out.println("2. Subtração");
        System.out.println("3. Divisão");
        System.out.println("4. Multiplicação");
        System.out.print("Opção: ");
        int op = scanner.nextInt();

        double resultado = 0;

        try {
            switch (op) {
                case 1:
                    resultado = numero1 + numero2;
                    break;
                case 2:
                    resultado = numero1 - numero2;
                    break;
                case 3:
                    if (numero2 == 0) {
                        throw new ArithmeticException("Divisão por zero não é permitida.");
                    }
                    resultado = numero1 / numero2;
                    break;
                case 4:
                    resultado = numero1 * numero2;
                    break;
                default:
                    System.out.println("Opção inválida.");
                    return;
            }

            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}

import java.util.Scanner;

public class exercicio2
{
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        double n1, n2;
        double resultado = 1;
        double a = 0;
        char op;
        System.out.println("Entre com o primeiro valor da operação: ");
        n1 = sc.nextInt();
        System.out.println("Entre com o segundo valor da operação: ");
        n2 = sc.nextInt();
        System.out.println("Entre com a operação que deseja realizar: ");
        op = sc.next().charAt(0);

        switch(op){
            case '+':
                resultado = n1+n2;
                System.out.println("Resultado: "+ resultado);
                break;
            case '-':
                resultado = n1-n2;
                System.out.println("Resultado: "+ resultado);
                break;
            case '*':
                resultado = n1*n2;
                System.out.println("Resultado: "+ resultado);
                break;
            case '/':
                resultado = n1/n2;
                System.out.println("Resultado: "+ resultado);
                break;
            case '^':
                resultado = Math.pow(n1, n2);
                System.out.println("Resultado: "+ resultado);
                break;

        }
        sc.close();
    }
}
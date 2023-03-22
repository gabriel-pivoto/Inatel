import java.util.Scanner;

public class exercicio1
{
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        
        int op;
        System.out.println("Entrar com o valor: ");
        op = sc.nextInt();

        if(op < 18.5){
            System.out.println("abaixo do peso");
        }else if(op <= 24.9){
            System.out.println("Peso ideal (parabéns)");
        }else if(op <= 29.9){
            System.out.println("levemente acima do peso");
        }else if(op <= 34.9){
            System.out.println("Obesidade grau I");
        }else if(op <= 39.9){
            System.out.println("Obesidade grau II (severa)");
        }else{
            System.out.println("Obesidade III (mórbida)");
        }
    }
}
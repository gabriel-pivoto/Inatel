import java.util.Scanner;

public class exercicio3
{
    public static void main(String[] args) {

        Scanner sc = new Scanner (System.in);
        int senha;

        do{
            System.out.println("Entre com a senha: ");
            senha = sc.nextInt();
            if(senha != 2002){
                System.out.println("Senha invalida");
            }

        }while(senha != 2002);

        System.out.println("Acesso permitido");


        sc.close();
    }
}
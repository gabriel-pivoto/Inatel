import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Conta conta = new Conta();
        Scanner sc = new Scanner(System.in);


        System.out.println("Inserir nome do cliente: ");
        String nome = sc.nextLine();
        conta.client.setNome(nome);
        System.out.println("Inserir cpf do cliente: ");
        String cpf = sc.nextLine();
        conta.client.setCpf(cpf);

        System.out.println("Quanto deseja depositar na conta?");
        double valor = sc.nextDouble();
        conta.deposita(valor);
        System.out.println("Quanto deseja sacar na conta?");
        valor  = sc.nextDouble();
        conta.saca(valor);


        //informações

        System.out.println("Nome do cliente: " + conta.client.getNome());
        System.out.println("Cpf: " + conta.client.getCpf());
        conta.extrato();



    }
}
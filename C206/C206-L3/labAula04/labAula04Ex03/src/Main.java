import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        Restaurante fornecedor1 = new Restaurante();
        fornecedor1.fornecedores[0] = new Fornecedor("a", 2);
        fornecedor1.fornecedores[1] = new Fornecedor("b", 4);
        fornecedor1.fornecedores[2] = new Fornecedor("c", 6);


        fornecedor1.cnpj = "2384723";
        fornecedor1.endereco = "Rua antonio teles";
        fornecedor1.nome = "ABC";




        fornecedor1.exibirInfos();
        entrada.close();
    }
}
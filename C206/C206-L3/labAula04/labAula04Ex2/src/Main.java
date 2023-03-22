import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

       Empresa c = new Empresa();
       c.contatos[0] = new Contato("Joao", "joao@gmail.com", "8482903829", "1245-02-01");
       c.cpnj = "15468321.54";
       c.endereco = "Rua antonio teles";

       c.exibirInfos();

    }
}
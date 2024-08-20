
import exception.SaldoInsuficienteException;

public class Main {

    public static void main(String[] args) {

        Conta conta1 = new Conta("Gabriel", 11111, 20, 50);

        conta1.mostraInfo();

        conta1.sacar(1.0);

        conta1.mostraInfo();

    }

}
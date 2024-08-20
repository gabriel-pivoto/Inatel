
import exception.SaldoInsuficienteException;

public class Conta {

    private double saldo;
    private double limite;

    private int numero;
    private String nome;


    public Conta(String nome, int numero, double saldo, double limite) {
        this.nome = nome;
        this.numero = numero;
        this.saldo = saldo;
        this.limite = limite;
    }
    public String getNome() {
        return nome;
    }


    public void sacar(double quantia) throws SaldoInsuficienteException {

        if(quantia <= saldo) {
            this.saldo -= quantia;
        }else {
            throw new SaldoInsuficienteException("Saldo Insuficiente");
        }

    }





    public void mostraInfo() {
        System.out.println("Nome: " + nome);
        System.out.println("Número da conta: " + numero);
        System.out.println("Saldo: " + saldo);
        System.out.println("Limite: " + limite);
    }





}
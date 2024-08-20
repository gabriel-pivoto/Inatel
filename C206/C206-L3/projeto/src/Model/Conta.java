package Model;

import Controller.Arquivo;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Conta {
    private double saldo;
    private String nome;
    private String email;
    private int idade;
    private String cpf;
    Aposta ap = new Aposta();
    public static int quantGanho = 0;
    public static double valor1;




    public Conta(String nome, String email, int idade, String cpf) {
        this.nome = nome;
        this.email = email;
        this.idade = idade;
        this.cpf = cpf;
    }

    // setter
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // getter
    public double getSaldo() {
        return saldo;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public int getIdade() {
        return idade;
    }

    public String getCpf() {
        return cpf;
    }


    Arquivo arq = new Arquivo();


    public void aposta(Time time, double valor, Conta c1, int quant, int tipo) {

        if (valor < c1.getSaldo()) {
            valor1 = valor;
            c1.setSaldo(c1.getSaldo() - valor);
            arq.cartaoTime(quant, time, tipo);
            System.out.println("Aposta concluida");

        } else {
            throw new SaldoInsuficienteException("Saldo Insufidasdasdaciente");
        }
        quantGanho++;
    }

    public void ganho(Time time, double valor, Conta c1, int quant, int tipo) {
       ap.ganho(time,valor, c1, quant, tipo);
    }

    public void resultado(Conta conta) {
       ap.resultado(conta);
    }
}




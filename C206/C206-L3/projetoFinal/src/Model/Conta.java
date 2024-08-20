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
    public Aposta ap = new Aposta();
    public static int quantGanho = 0;

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


    public void fazerAposta(Jogo jogo, double valor, Conta c1, int quant, String aposta, String time) throws SaldoInsuficienteException {

        if (valor <= c1.getSaldo()) {
            c1.setSaldo(c1.getSaldo() - valor);
            ap.valorAposta = valor;
            arq.cartaoTime(quant, jogo, aposta, time, c1);
            System.out.println("Aposta concluida");
            quantGanho++;
            ap.ganho(jogo,c1,quant,aposta,time);

        } else {
            throw new SaldoInsuficienteException("Saldo Insuficiente");
        }

    }

    public void resultado(Conta conta) {
       ap.resultado(conta);
    }
}




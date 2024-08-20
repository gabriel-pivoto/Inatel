package Model;

import Controller.Arquivo;


import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Aposta {
    Arquivo arq = new Arquivo();
    int quantGanho = 0;
    double valorFinal = 0;
    public double valorAposta;

    ArrayList<Double> valorTotalAposta = new ArrayList<>();
    ArrayList<Double> ganhoTotal = new ArrayList<>();

    public void ganho(Jogo jogo, Conta c1, int quantAposta, String tipoAposta, String nomeTime) {

        boolean flagGanhou; // variavel para auxiliar se o usuario ganhou a aposta ou nao
        double res; // variavel aux para inserir o ganho no aqui caso ele ganha a aposta
        valorTotalAposta.add(c1.ap.valorAposta);
        if (jogo.getTimeCasa().getNome() == nomeTime) {
            switch (tipoAposta) {
                case "gol":
                    if (jogo.getTimeCasa().gol == quantAposta) {
                        ganhoTotal.add(c1.ap.valorAposta * jogo.getTimeCasa().getOdd());
                        res = c1.ap.valorAposta * jogo.getTimeCasa().getOdd();
                        flagGanhou = true;
                        arq.ganhoOuNao(jogo,c1,flagGanhou,tipoAposta,nomeTime,quantAposta,res);
                    } else {
                        ganhoTotal.add(-c1.ap.valorAposta);
                        flagGanhou =false;
                        arq.ganhoOuNao(jogo,c1,flagGanhou,tipoAposta,nomeTime,quantAposta,0);
                    }
                    break;
                case "finalizacao":
                    if (jogo.getTimeCasa().finalizacao == quantAposta) {
                        ganhoTotal.add(c1.ap.valorAposta * jogo.getTimeCasa().getOdd());
                        res = c1.ap.valorAposta * jogo.getTimeCasa().getOdd();
                        flagGanhou = true;
                        arq.ganhoOuNao(jogo,c1,flagGanhou,tipoAposta,nomeTime,quantAposta,res);
                    } else {
                        ganhoTotal.add(-c1.ap.valorAposta);
                        flagGanhou =false;
                        arq.ganhoOuNao(jogo,c1,flagGanhou,tipoAposta,nomeTime,quantAposta,0);
                    }
                    break;
                case "escanteio":
                    if (jogo.getTimeCasa().escanteio == quantAposta) {
                        ganhoTotal.add(c1.ap.valorAposta * jogo.getTimeCasa().getOdd());
                        res = c1.ap.valorAposta * jogo.getTimeCasa().getOdd();
                        flagGanhou = true;
                        arq.ganhoOuNao(jogo,c1,flagGanhou,tipoAposta,nomeTime,quantAposta,res);
                    } else {
                        flagGanhou =false;
                        arq.ganhoOuNao(jogo,c1,flagGanhou,tipoAposta,nomeTime,quantAposta,0);
                    }
                    break;
                case "falta":
                    if (jogo.getTimeCasa().falta == quantAposta) {
                        ganhoTotal.add(c1.ap.valorAposta * jogo.getTimeCasa().getOdd());
                        res = c1.ap.valorAposta * jogo.getTimeCasa().getOdd();
                        flagGanhou = true;
                        arq.ganhoOuNao(jogo,c1,flagGanhou,tipoAposta,nomeTime,quantAposta,res);
                    } else {
                        ganhoTotal.add(-c1.ap.valorAposta);
                        flagGanhou =false;
                        arq.ganhoOuNao(jogo,c1,flagGanhou,tipoAposta,nomeTime,quantAposta,0);
                    }
                    break;
                case "cartao":
                    if (jogo.getTimeCasa().cartao == quantAposta) {
                        ganhoTotal.add(c1.ap.valorAposta * jogo.getTimeCasa().getOdd());
                        res = c1.ap.valorAposta * jogo.getTimeCasa().getOdd();
                        flagGanhou = true;
                        arq.ganhoOuNao(jogo,c1,flagGanhou,tipoAposta,nomeTime,quantAposta,res);
                    } else {
                        ganhoTotal.add(-c1.ap.valorAposta);
                        flagGanhou =false;
                        arq.ganhoOuNao(jogo,c1,flagGanhou,tipoAposta,nomeTime,quantAposta,0);
                    }
                    break;
            }
        } else {
            switch (tipoAposta) {
                case "gol":
                    if (jogo.getTimeVisita().gol == quantAposta) {
                        ganhoTotal.add(c1.ap.valorAposta * jogo.getTimeVisita().getOdd());
                        res = c1.ap.valorAposta * jogo.getTimeVisita().getOdd();
                        flagGanhou = true;
                        arq.ganhoOuNao(jogo,c1,flagGanhou,tipoAposta,nomeTime,quantAposta,res);
                    } else {
                        ganhoTotal.add(-c1.ap.valorAposta);
                        flagGanhou =false;
                        arq.ganhoOuNao(jogo,c1,flagGanhou,tipoAposta,nomeTime,quantAposta,0);
                    }
                    break;
                case "finalizacao":
                    if (jogo.getTimeVisita().finalizacao == quantAposta) {
                        ganhoTotal.add(c1.ap.valorAposta * jogo.getTimeVisita().getOdd());
                        res = c1.ap.valorAposta * jogo.getTimeVisita().getOdd();
                        flagGanhou = true;
                        arq.ganhoOuNao(jogo,c1,flagGanhou,tipoAposta,nomeTime,quantAposta,res);
                    } else {
                        ganhoTotal.add(-c1.ap.valorAposta);
                        flagGanhou =false;
                        arq.ganhoOuNao(jogo,c1,flagGanhou,tipoAposta,nomeTime,quantAposta,0);
                    }
                    break;
                case "escanteio":
                    if (jogo.getTimeVisita().escanteio == quantAposta) {
                        ganhoTotal.add(c1.ap.valorAposta * jogo.getTimeVisita().getOdd());
                        res = c1.ap.valorAposta * jogo.getTimeCasa().getOdd();
                        flagGanhou = true;
                        arq.ganhoOuNao(jogo,c1,flagGanhou,tipoAposta,nomeTime,quantAposta,res);
                    } else {
                        ganhoTotal.add(-c1.ap.valorAposta);
                        flagGanhou =false;
                        arq.ganhoOuNao(jogo,c1,flagGanhou,tipoAposta,nomeTime,quantAposta,0);
                    }
                    break;
                case "falta":
                    if (jogo.getTimeVisita().falta == quantAposta) {
                        ganhoTotal.add(c1.ap.valorAposta * jogo.getTimeVisita().getOdd());
                        res = c1.ap.valorAposta * jogo.getTimeVisita().getOdd();
                        flagGanhou = true;
                        arq.ganhoOuNao(jogo,c1,flagGanhou,tipoAposta,nomeTime,quantAposta,res);
                    } else {
                        ganhoTotal.add(-c1.ap.valorAposta);
                        flagGanhou =false;
                        arq.ganhoOuNao(jogo,c1,flagGanhou,tipoAposta,nomeTime,quantAposta,0);
                    }
                    break;
                case "cartao":
                    if (jogo.getTimeVisita().cartao == quantAposta) {
                        ganhoTotal.add(c1.ap.valorAposta * jogo.getTimeVisita().getOdd());
                        res = c1.ap.valorAposta * jogo.getTimeVisita().getOdd();
                        flagGanhou = true;
                        arq.ganhoOuNao(jogo,c1,flagGanhou,tipoAposta,nomeTime,quantAposta,res);
                    } else {
                        ganhoTotal.add(-c1.ap.valorAposta);
                        flagGanhou =false;
                        arq.ganhoOuNao(jogo,c1,flagGanhou,tipoAposta,nomeTime,quantAposta,0);
                    }
                    break;
            }
        }

    }

    public void resultado(Conta conta) {
        double sum = 0;
        double valorTotal = 0;

        for (Double number : valorTotalAposta) {
            valorTotal += number;
        }

        for (Double number : ganhoTotal) {
            sum += number;
        }

        //     System.out.println(conta.getSaldo() + sum);
        if (sum > 0) {
            valorFinal = conta.getSaldo() + sum;
            conta.setSaldo(valorFinal);
        } else
            sum = 0;
        arq.resultado(conta, sum, quantGanho, valorTotal);
    }
}





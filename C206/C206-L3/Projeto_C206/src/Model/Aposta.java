package Model;

import Controller.Arquivo;


import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Aposta {
    Arquivo arq = new Arquivo();
    double valorFinal = 0;
    public double valorAposta;

    ArrayList<Double> valorTotalAposta = new ArrayList<>();
    ArrayList<Double> ganhoTotal = new ArrayList<>();

    public void ganho(Jogo jogo, Conta c1, int quantAposta, String tipoAposta, String nomeTime) {
        /*
        Metodo ganho verifica se o usuario ganho nas apostas.
        - As apostas finalização, escanteio, falta e cartão são apostas
        que não precisa necessariamente ganhar somente se acertar a quantidade,
        a aposta funciona da seguinte forma quantidade que foi apostada pode ser
        o minimo  que pode acontecer. Ex: foi apostado 5 faltas porém o time fez 7 faltas,
        ganhou na aposta, porque 5 foi o quant minimo que o usuario achou que podia acontecer.
        E a odd desses valores so da lucro caso o usuario aposte no valor quant alto.
        - E ja para aposta gol o usuario precisa acertar a quantidade de gol exata

        Esses ganhos e perdas das apostas são armazedas no ArrayList ganhoTotal ja no ArrayList valorTotalAposta
        é utilizado para pegar o valor da aposta sem contabilizar os ganhos e perdas das apostas.
         */

        boolean flagGanhou; // variavel para auxiliar se o usuario ganhou a aposta ou nao
        double res; // variavel aux para inserir o ganho no aqui caso ele ganha a apos
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
                    if (jogo.getTimeCasa().finalizacao >= quantAposta) {
                        ganhoTotal.add(c1.ap.valorAposta * ((jogo.getTimeCasa().getOdd()*0.8) * (quantAposta*1.0015)));
                        res = c1.ap.valorAposta * ((jogo.getTimeCasa().getOdd()*0.8) * (quantAposta*1.0015));
                        flagGanhou = true;
                        arq.ganhoOuNao(jogo,c1,flagGanhou,tipoAposta,nomeTime,quantAposta,res);
                    } else {
                        ganhoTotal.add(-c1.ap.valorAposta);
                        flagGanhou =false;
                        arq.ganhoOuNao(jogo,c1,flagGanhou,tipoAposta,nomeTime,quantAposta,0);
                    }
                    break;
                case "escanteio":
                    if (jogo.getTimeCasa().escanteio >= quantAposta) {
                        ganhoTotal.add(c1.ap.valorAposta * ((jogo.getTimeCasa().getOdd()*0.8) * (quantAposta*1.0035)));
                        res = c1.ap.valorAposta * ((jogo.getTimeCasa().getOdd()*0.8) * (quantAposta*1.0035));

                        flagGanhou = true;
                        arq.ganhoOuNao(jogo,c1,flagGanhou,tipoAposta,nomeTime,quantAposta,res);
                    } else {
                        flagGanhou =false;
                        arq.ganhoOuNao(jogo,c1,flagGanhou,tipoAposta,nomeTime,quantAposta,0);
                    }
                    break;
                case "falta":
                    if (jogo.getTimeCasa().falta >= quantAposta) {
                        ganhoTotal.add(c1.ap.valorAposta * ((jogo.getTimeCasa().getOdd()*0.8) * (quantAposta*1.0022)));
                        res = c1.ap.valorAposta * ((jogo.getTimeCasa().getOdd()*0.8) * (quantAposta*1.0022));
                        flagGanhou = true;
                        arq.ganhoOuNao(jogo,c1,flagGanhou,tipoAposta,nomeTime,quantAposta,res);
                    } else {
                        ganhoTotal.add(-c1.ap.valorAposta);
                        flagGanhou =false;
                        arq.ganhoOuNao(jogo,c1,flagGanhou,tipoAposta,nomeTime,quantAposta,0);
                    }
                    break;
                case "cartao":
                    if (jogo.getTimeCasa().cartao >= quantAposta) {
                        ganhoTotal.add(c1.ap.valorAposta * ((jogo.getTimeCasa().getOdd()*0.8) * (quantAposta*1.0026)));
                        res = c1.ap.valorAposta * ((jogo.getTimeCasa().getOdd()*0.8) * (quantAposta*1.0026));
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
                    if (jogo.getTimeVisita().finalizacao >= quantAposta) {
                        ganhoTotal.add(c1.ap.valorAposta * ((jogo.getTimeVisita().getOdd()*0.8) * (quantAposta*1.0013)));
                        res = c1.ap.valorAposta * ((jogo.getTimeVisita().getOdd()*0.8) * (quantAposta*1.0013));
                        flagGanhou = true;
                        arq.ganhoOuNao(jogo,c1,flagGanhou,tipoAposta,nomeTime,quantAposta,res);
                    } else {
                        ganhoTotal.add(-c1.ap.valorAposta);
                        flagGanhou =false;
                        arq.ganhoOuNao(jogo,c1,flagGanhou,tipoAposta,nomeTime,quantAposta,0);
                    }
                    break;
                case "escanteio":
                    if (jogo.getTimeVisita().escanteio >= quantAposta) {
                        ganhoTotal.add(c1.ap.valorAposta * ((jogo.getTimeVisita().getOdd()*0.8) * (quantAposta*1.0038)));
                        res = c1.ap.valorAposta * ((jogo.getTimeVisita().getOdd()*0.8) * (quantAposta*1.0038));
                        flagGanhou = true;
                        arq.ganhoOuNao(jogo,c1,flagGanhou,tipoAposta,nomeTime,quantAposta,res);
                    } else {
                        ganhoTotal.add(-c1.ap.valorAposta);
                        flagGanhou =false;
                        arq.ganhoOuNao(jogo,c1,flagGanhou,tipoAposta,nomeTime,quantAposta,0);
                    }
                    break;
                case "falta":
                    if (jogo.getTimeVisita().falta >= quantAposta) {
                        ganhoTotal.add(c1.ap.valorAposta * ((jogo.getTimeVisita().getOdd()*0.8) * (quantAposta*1.0028)));
                        res = c1.ap.valorAposta * ((jogo.getTimeVisita().getOdd()*0.8) * (quantAposta*1.0028));
                        flagGanhou = true;
                        arq.ganhoOuNao(jogo,c1,flagGanhou,tipoAposta,nomeTime,quantAposta,res);
                    } else {
                        ganhoTotal.add(-c1.ap.valorAposta);
                        flagGanhou =false;
                        arq.ganhoOuNao(jogo,c1,flagGanhou,tipoAposta,nomeTime,quantAposta,0);
                    }
                    break;
                case "cartao":
                    if (jogo.getTimeVisita().cartao >= quantAposta) {
                        ganhoTotal.add(c1.ap.valorAposta * ((jogo.getTimeVisita().getOdd()*0.8) * (quantAposta*1.0025)));
                        res = c1.ap.valorAposta * ((jogo.getTimeVisita().getOdd()*0.8) * (quantAposta*1.0025));
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
        /*
        A variavel ganhoTotal e sum foi utilizada para atualizar o valor
        Saldo do usuario depois que ele finalizar as apostas
        A variavel valorTotal e valorTotalAposta foi utilizadas para
        para pegar o valor da aposta sem contabilizar os ganhos e perdas das apostas
        que esse metodo foi chamado pela a classe Conta no metodo fimDasApostas
         */
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
        arq.resultado(conta, sum, valorTotal);
    }
}





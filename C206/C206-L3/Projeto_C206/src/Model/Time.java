package Model;

import Controller.*;

public class Time implements EstatisticaTime {

    private String nome;
    private double odd;
    public int gol, finalizacao, cartao, escanteio, falta;
    private String titulos, goleiro, defesa, meia, ataque;

    public Time(String nome, double odd) {
        this.nome = nome;
        this.odd = odd;
    }


    public void setGoleiro(String goleiro) {
        this.goleiro = goleiro;
    }

    public void setTitulos(String titulos) {
        this.titulos = titulos;
    }

    public void setDefesa(String defesa) {
        this.defesa = defesa;
    }

    public void setMeia(String meia) {
        this.meia = meia;
    }

    public void setAtaque(String ataque) {
        this.ataque = ataque;
    }

    public String getNome() {
        return nome;
    }

    public double getOdd() {
        return odd;
    }

    /*
       Metodo que esta na interface EstatisticaTime que mostra
       as informações de titulos e a escalaçao do time
    */
    @Override
    public void infoTime() {
        System.out.println("O " + nome + " tem esses titulos: " + titulos);
        System.out.println("Escalacao:");
        System.out.println(goleiro);
        System.out.println(defesa);
        System.out.println(meia);
        System.out.println(ataque);
    }


}

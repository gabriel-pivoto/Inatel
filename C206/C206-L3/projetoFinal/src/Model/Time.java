package Model;

import Controller.*;

public class Time implements EstatisticaTime {

    private  String nome;
    private double odd;
    public int  gol, finalizacao, cartao, escanteio, falta;


    public Time(String nome, double odd) {
        this.nome = nome;
        this.odd = odd;
    }



    public String getNome() {
        return nome;
    }

    public double getOdd() {
        return odd;
    }

    @Override
    public void infoTime() {

    }


}

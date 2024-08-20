package Model;
import Controller.*;

import java.util.ArrayList;
import java.util.Random;
public class Jogo implements InfoJogo {

    private String estadio, cidade, narrador, campeonato;
    private  Time timeCasa;
    private Time timeVisita;
    private Aposta ap = new Aposta();
    private Arquivo arq = new Arquivo();


    public Time getTimeCasa() {
        return timeCasa;
    }

    public Time getTimeVisita() {
        return timeVisita;
    }

    public String getCampeonato() {
        return campeonato;
    }

    public Jogo(String estadio, String cidade, String narrador, String campeonato, Time timeCasa, Time timeVisita) {
        this.estadio = estadio;
        this.cidade = cidade;
        this.narrador = narrador;
        this.timeCasa = timeCasa;
        this.timeVisita = timeVisita;
        this.campeonato = campeonato;
    }

    public void resultado(){
        /*
            Metodo que utiliza numeros random para definir
            a quantidade de gols,escanteios, finalizaçoes,
            faltas e cartoes para os timeCasa e timeVisita
         */
        Random random = new Random();
        int numeroAleatorio;
        //// TIME CASA \\\\
        // gols
        numeroAleatorio = random.nextInt(6)+1;
        timeCasa.gol = numeroAleatorio;
        // finalizacoes
        numeroAleatorio = random.nextInt(20)+ timeCasa.gol;
        timeCasa.finalizacao = numeroAleatorio;
        //escanteios
        numeroAleatorio = random.nextInt(16);
        timeCasa.escanteio = numeroAleatorio;
        //faltas
        numeroAleatorio = random.nextInt(16);
        timeCasa.falta = numeroAleatorio;
        //cartao
        numeroAleatorio = random.nextInt(7);
        timeCasa.cartao = numeroAleatorio;

        //// TIME VISITANDE \\\\
        // gols
        numeroAleatorio = random.nextInt(6);
        timeVisita.gol = numeroAleatorio;
        // finalizacoes
        numeroAleatorio = random.nextInt(20)+ timeVisita.gol;
       timeVisita.finalizacao = numeroAleatorio;
       //escanteios
       numeroAleatorio = random.nextInt(16);
       timeVisita.escanteio = numeroAleatorio;
       //faltas
       numeroAleatorio = random.nextInt(16);
       timeVisita.falta = numeroAleatorio;
       //cartao
       numeroAleatorio = random.nextInt(7);
       timeVisita.cartao = numeroAleatorio;

    }
    public void resultadoArquivo(Jogo jogo){
        /*
            Depois da definiçoes de gols esse metedo
            verifica qual time venceu o jogo e armezena no
            arquivo txt com todas as informações
         */
        boolean vitoriaCasa = false;
        boolean empate = false;
        if(timeCasa.gol > timeVisita.gol){
            vitoriaCasa = true;
        }
        if(timeVisita.gol > timeCasa.gol){
            vitoriaCasa = false;
        }
        if(timeVisita.gol == timeCasa.gol) {
            empate = true;
        }
        arq.resultadoPartida(jogo, vitoriaCasa, empate);
    }
    /*
        Metodo que esta na interface InfoJogo que mostra
        as informações do jogo cidade, estadio e narrador
     */
    @Override
    public void info() {
        System.out.println("Cidade em que vai acontecer o jogo: " + cidade);
        System.out.println("Nome do estadio: " + estadio);
        System.out.println("Narrador : " + narrador);
    }



}

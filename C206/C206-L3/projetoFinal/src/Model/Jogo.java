package Model;
import Controller.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;
public class Jogo {


Helper Helper;
    private String estadio, cidade, narrador, campeonato;
    private  Time timeCasa;
    private Time timeVisita;
    ArrayList<Double> ganhoTotal = new ArrayList<>();
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
    public void info(JLabel label) {
        String infoTexto = "Cidade em que vai acontecer o jogo: " + cidade + "<br>"
                + "Nome do estádio: " + estadio + "<br>"
                + "Narrador que vai narrar: " + narrador;

        label.setText(infoTexto);
    }
}







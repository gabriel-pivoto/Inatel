package Model;
import Controller.*;
public class Jogo implements InfoTime{

    String estadio, cidade, narrador;

    public Jogo(String estadio, String cidade, String narrador) {
        this.estadio = estadio;
        this.cidade = cidade;
        this.narrador = narrador;
    }

    @Override
    public void info() {
        System.out.println("Cidade em que vai acontecer o jogo: " + cidade);
        System.out.println("Nome do estadio: " + estadio);
        System.out.println("Narrador  que vai narrar: " + narrador);
    }

    void gols(int golsEsperados){

    }
}

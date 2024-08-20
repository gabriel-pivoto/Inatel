package Model;

public class Corinthians extends Time{

    public String nome = "Corinthians";
    public double odd = 1.25;
    @Override
    public void infoTime() {
        super.infoTime();
        System.out.println("Ultimo campeão brasileiro no Mundial de Clubes, indo para a busca taça do Mundial");
        System.out.println("Titulos: 2 - Mundias , 1 - Libertadores, 30 - Paulista, 7 - Brasileirao, 3 - Copa do Brasil");
        System.out.println("Escalacao:");
        System.out.println("GOL - 12 Cassio");
        System.out.println("D - Fabio Santos, D - 2 Rafael Ramos, D - 23 Fagner, D - 21 Matheus Bidu" );
        System.out.println("M - 5 Fausto Vera, M - 20 Giuliano, M - 7 Maycon");
        System.out.println("A - 10 Roger Guedes, A - 28 Adson, A - 9 Yuri Alberto");

    }

}

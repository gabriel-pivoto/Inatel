package Model;

public class ManschesterCity extends Time{
    public String nome = "Manschester City";
    public double odd = 5.08;
    @Override

        public void infoTime(){
            super.infoTime();
            System.out.println("Acabou de ganhar a UEFA Champions League, colocando o terceiro trofeu de titulos conseguido nesse ano de 2023");
            System.out.println("Titulos: 1 - UEFA Champions League , 9 - Campeonato Inglês, 7 - Copa da Inglaterra, 8 - Liga Inglesa");
            System.out.println("Escalacao:");
            System.out.println("GOL - 31 Ederson");
            System.out.println("D - 7 Joao Cancelo, D - 14 Laporte, D - 3 Ruben Dias, D - 2 Kyle Walker" );
            System.out.println("M - 20 Bernardo Silva, M - 16 Rodri, M - 17 Kevin De Bruyne");
            System.out.println("A - 47 Phil Foden, A - 9 Haaland, A - 26 Riyad Mahrez");
    }
}

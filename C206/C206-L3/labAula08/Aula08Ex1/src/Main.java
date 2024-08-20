public class Main {
    public static void main(String[] args) {

        System.out.println("------------------");
        Sedan sedan = new Sedan();
        sedan.setAno(2022);
        sedan.setCor("lilas");
        sedan.setValor(6000);
        sedan.setPortaMalas("10");
        sedan.taxa();
        sedan.mostraInfo();

        System.out.println("------------------");
        SUV suv = new SUV();
        suv.setAno(2014);
        suv.setCor("amarelo");
        suv.setValor(40000);
        suv.setTracao(11);
        suv.taxa();
        suv.mostraInfo();



        System.out.println("------------------");
        Hatch hatch = new Hatch();
        hatch.setAno(2003);
        hatch.setCor("verde");
        hatch.setValor(30000);
        hatch.setPortas(6);
        hatch.taxa();
        hatch.mostraInfo();
        System.out.println("------------------");


    }
}
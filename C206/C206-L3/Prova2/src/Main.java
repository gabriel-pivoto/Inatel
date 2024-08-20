public class Main {
    public static void main(String[] args) {
        Leao leao = new Leao();
        leao.setTamanhoJuba(23);
        leao.setNome("Jorge");
        leao.setPerigoso(true);
        leao.setIdade(12);
        leao.setQntAnimais(1);
        



        Coruja coruja = new Coruja();
        coruja.setCor("Rosa");
        coruja.setIdade(8);
        coruja.setPerigoso(false);
        coruja.setNome("Cleudivania");
        coruja.setQntAnimais(1);


        Gato gato = new Gato();
        gato.setPerigoso(false);
        gato.setNome("Lana");
        gato.setIdade(3);
        gato.setRaca("Desconhecida");
        gato.setQntAnimais(1);



        Zoo zoo = new Zoo();

        zoo.setNome("Zoológico esperança");
        zoo.setEndereco("Rua Antonio teles Numero: 213");
        zoo.setCnpj(152446121);



        zoo.animais[1] = gato;
        zoo.animais[2] = leao;
        zoo.animais[3] = coruja;

        zoo.mostraInfo();





    }
}
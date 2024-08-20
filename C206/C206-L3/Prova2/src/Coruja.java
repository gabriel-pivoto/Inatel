public class Coruja extends Animal implements Alimentacao{

    private String cor;

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    @Override
    public void mostrainfo() {
        super.mostrainfo();
        System.out.println("Nome da coruja: " + getNome());
        System.out.println("Idade: " + getIdade());
        System.out.println("É perigoso: " + isPerigoso());
        System.out.println("Cor: " + getCor());

    }
    public void voar(){
        System.out.println("A coruja voa");
    }

    @Override
    public String barulho() {
        return super.barulho()+ "faz muito barulho";
    }

    @Override
    public void comendo() {
        System.out.println("Ela está comendo");
    }
}

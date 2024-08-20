public class Gato extends Animal implements Alimentacao{

    private String raca;

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    @Override
    public void comendo() {
        System.out.println("O gato está comendo");
    }

    @Override
    public void  mostrainfo() {
        super.mostrainfo();


        System.out.println("Nome do gato: " + getNome());
        System.out.println("Idade: " + getIdade());
        System.out.println("É perigoso: " + isPerigoso());
        System.out.println("Raça: " + getRaca());

    }

    @Override
    public String barulho() {
        return super.barulho() +  "não barulho";
    }

    public void correr(){
        System.out.println("Corre muito");
    }
}

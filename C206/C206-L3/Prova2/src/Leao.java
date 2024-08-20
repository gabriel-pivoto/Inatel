public class Leao extends Animal{

    private float tamanhoJuba;

    public float getTamanhoJuba() {
        return tamanhoJuba;
    }

    public void setTamanhoJuba(float tamanhoJuba) {
        this.tamanhoJuba = tamanhoJuba;
    }

    @Override
    public void mostrainfo() {
        super.mostrainfo();
        System.out.println("Nome leao: " + getNome());
        System.out.println("Idade: " + getIdade());
        System.out.println("É perigoso: " + isPerigoso());
        System.out.println("Tamanho da Juba: " + getTamanhoJuba());
    }
    public void dormir(){
        System.out.println("O Leao está dormindo");
    }

    @Override
    public String barulho() {
        return super.barulho() + "faz barulho";
    }
}

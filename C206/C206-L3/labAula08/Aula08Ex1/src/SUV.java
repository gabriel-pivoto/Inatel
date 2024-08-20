public class SUV extends Carro {

    private int tracao;

    public int getTracao() {
        return tracao;
    }

    public void setTracao(int tracao) {
        this.tracao = tracao;
    }

    @Override
    public void taxa() {
        System.out.println("taxa: " + getValor());
    }
    @Override
    public void mostraInfo(){
        System.out.println("Tração: " + getTracao());
        System.out.println("Valor: " + getValor());
        System.out.println("Ano: "  + getAno());
        System.out.println("Cor: " + getCor());
    }
}

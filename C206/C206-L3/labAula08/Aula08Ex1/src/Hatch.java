public class Hatch extends Carro {
    private int portas;

    public int getPortas() {
        return portas;
    }

    public void setPortas(int portas) {
        this.portas = portas;
    }
    @Override
    public void taxa() {
        System.out.println("taxa: " + getValor());
    }
    @Override
    public void mostraInfo(){
        System.out.println("Portas: " + getPortas());
        System.out.println("Valor: " + getValor());
        System.out.println("Ano: "  + getAno());
        System.out.println("Cor: " + getCor());
    }
}

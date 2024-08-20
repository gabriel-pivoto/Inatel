public class Sedan extends Carro{

    private String portaMalas;

    public void setPortaMalas(String portaMalas) {
        this.portaMalas = portaMalas;
    }

    public String getPortaMalas() {
        return portaMalas;
    }

    @Override
    public void taxa() {
        System.out.println("taxa: " + getValor());
    }
    @Override
    public void mostraInfo(){
        System.out.println("Porta malas: " + getPortaMalas());
        System.out.println("Valor: " + getValor());
        System.out.println("Ano: "  + getAno());
        System.out.println("Cor: " + getCor());
    }

}

public class Conta {

    Client client = new Client();
    private int qtdClientes;
    private double saldo;

    public double getSaldo() {
        return saldo;
    }

    public void deposita(double valor){

        this.saldo += valor;
    }

    public void saca(double valor){
        if(this.saldo - valor >= 0){
            this.saldo -= valor;
        }else{
            System.out.println("saldo insuficiente");
        }
    }

    public void extrato(){
        System.out.println("Extrato: " + getSaldo());
    }
}

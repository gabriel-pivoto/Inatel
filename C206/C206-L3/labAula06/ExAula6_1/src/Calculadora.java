public class Calculadora {

    public double pi = 3.14;


    public double circunferencia(double raio){
        return 2 * this.pi * raio;
    }

    public double volume(double raio){
        return (4/3)*this.pi*(Math.pow(this.pi, 3));
    }

}

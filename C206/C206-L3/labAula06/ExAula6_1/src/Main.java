import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Calculadora calculadora = new Calculadora();

        System.out.println("Favor inserir o valor do raio: ");
        double raio = sc.nextDouble();
        double volume = calculadora.circunferencia(raio);
        double circunferencia = calculadora.circunferencia(raio);
        System.out.println("Aqui está o calculo da circunferencia para este raio: " + String.format("%.2f", circunferencia));
        System.out.println("Aqui está o calculo do volume para este raio: " + String.format("%.2f", raio));


        sc.close();
    }
}
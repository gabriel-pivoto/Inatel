package Model;

import Controller.Arquivo;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class Aposta {
    Arquivo arq = new Arquivo();
    int quantGanho = 0 ;
    double valorFinal = 0;
    public static double valor1;

    ArrayList<Double> ganhoTotal = new ArrayList<>();
    public void ganho(Time time, double valor, Conta c1, int quant, int tipo) {
        Random random = new Random();
        int numeroAleatorio;

        ////********** MANCHESTER CITY **********\\\\
        if (time instanceof ManschesterCity) {
            ManschesterCity manschester = (ManschesterCity) time;
            switch (tipo) {
                // aposta por quantidade de cartão
                case 0:
                    numeroAleatorio = random.nextInt(6);
                    if (numeroAleatorio == quant) {
                        ganhoTotal.add(valor * manschester.odd);
                        System.out.println("Parabens, voce ganhou.Valor do ganho: " + valor*manschester.odd);
                    } else {
                        ganhoTotal.add(-valor);
                        System.out.println("Manchester City fizeram " + numeroAleatorio + " cartao nessa partida");
                        System.out.println("Infelismente, perdeu.Valor do ganho: " + 0);
                    }

                    break;
                case 1:
                    numeroAleatorio = random.nextInt(3);
                    if (numeroAleatorio == quant) {
                        ganhoTotal.add(valor * manschester.odd);
                        System.out.println("Parabens, voce ganhou.Valor do ganho: " + valor*manschester.odd);
                    } else {
                        ganhoTotal.add(-valor);
                        System.out.println("Manchester City fizeram " + numeroAleatorio + " gol nessa partida");
                        System.out.println("Infelismente, perdeu.Valor do ganho: " + 0);
                    }

                    break;
                // escanteio a favor do Manchester City
                case 2:
                    numeroAleatorio = random.nextInt(6);
                    if (numeroAleatorio == quant) {
                        ganhoTotal.add(valor * manschester.odd);
                        System.out.println("Parabens, voce ganhou.Valor do ganho: " + valor*manschester.odd);
                    } else {
                        ganhoTotal.add(-valor);
                        System.out.println("Manchester City teve " + numeroAleatorio + " escanteio ao seu favor nessa partida");
                        System.out.println("Infelismente, perdeu.Valor do ganho: " + 0);
                    }

                    break;
                // finalizaçao a favor do Manchester City
                case 3:
                    numeroAleatorio = random.nextInt(8);
                    if (numeroAleatorio == quant) {
                        ganhoTotal.add(valor * manschester.odd);
                        System.out.println("Parabens, voce ganhou.Valor do ganho: " + valor*manschester.odd);
                    } else {
                        ganhoTotal.add(-valor);
                        System.out.println("Manchester City fez " + numeroAleatorio + " finalizacao nessa partida");
                        System.out.println("Infelismente, perdeu.Valor do ganho: " + 0);
                    }
                    break;
                ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

            }
        }
        ////********** REAL MADRID **********\\\\
        if (time instanceof RealMadrid) {
            RealMadrid realMadrid = (RealMadrid) time;
            switch (tipo) {
                // aposta por quantidade de cartão do real madrid
                case 0:
                    numeroAleatorio = random.nextInt(5)+1;
                    if (numeroAleatorio == quant) {
                        ganhoTotal.add(valor * realMadrid.odd);
                        System.out.println("Parabens, voce ganhou.Valor do ganho: " + valor*realMadrid.odd);
                    } else {
                        ganhoTotal.add(-valor);
                        System.out.println("Real Madrid tomaram " + numeroAleatorio + " cartao nessa partida");
                        System.out.println("Infelismente, perdeu.Valor do ganho: " + 0);
                    }

                    break;
                // aposta por quat de gol real madrid
                case 1:
                    numeroAleatorio = random.nextInt(6) +3;
                    if (numeroAleatorio == quant) {
                        ganhoTotal.add(valor * realMadrid.odd);
                        System.out.println("Parabens, voce ganhou.Valor do ganho: " + valor*realMadrid.odd);
                    } else {
                        ganhoTotal.add(-valor);
                        System.out.println("Real Madrid fizeram " + numeroAleatorio + " gol nessa partida");
                        System.out.println("Infelismente, perdeu.Valor do ganho: " + 0);
                    }

                    break;
                // escandeio a favor do real madrid
                case 2:
                    numeroAleatorio = random.nextInt(10);
                    if (numeroAleatorio == quant) {
                        ganhoTotal.add(valor * realMadrid.odd);
                    } else {
                        ganhoTotal.add(-valor);
                        System.out.println("Real Madrid teve " + numeroAleatorio + " escanteio ao seu favor nessa partida");
                        System.out.println("Infelismente, perdeu.Valor do ganho: " + 0);
                    }

                    break;
                // finalizaçao a favor do real madrid
                case 3:
                    numeroAleatorio = random.nextInt(18);
                    if (numeroAleatorio == quant) {
                        ganhoTotal.add(valor * realMadrid.odd);
                        System.out.println("Parabens, voce ganhou.Valor do ganho: " + valor*realMadrid.odd);
                    } else {
                        ganhoTotal.add(-valor);
                        System.out.println("Real Madrid fez " + numeroAleatorio + " finalizacao nessa partida");
                        System.out.println("Infelismente, perdeu.Valor do ganho: " + 0);
                    }

                    break;
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
            }
        }
        ////********** BARCELONA **********\\\\
        if (time instanceof Barcelona) {
            Barcelona barcelona = (Barcelona) time;
            switch (tipo) {
                // aposta por quantidade de cartão do barcelona
                case 0:
                    numeroAleatorio = random.nextInt(10);
                    if (numeroAleatorio == quant) {
                        ganhoTotal.add(valor * barcelona.odd);
                        System.out.println("Parabens, voce ganhou.Valor do ganho: " + valor*barcelona.odd);
                    } else {
                        ganhoTotal.add(-valor);
                        System.out.println("Barcelona tomaram " + numeroAleatorio + " cartao nessa partida");
                        System.out.println("Infelismente, perdeu.Valor do ganho: " + 0);
                    }

                    break;
                // aposta por quat de gol do barcelona
                case 1:
                    numeroAleatorio = random.nextInt(4) ;
                    if (numeroAleatorio == quant) {
                        ganhoTotal.add(valor * barcelona.odd);
                        System.out.println("Parabens, voce ganhou.Valor do ganho: " + valor*barcelona.odd);
                    } else {
                        ganhoTotal.add(-valor);
                        System.out.println("Barcelona fizeram " + numeroAleatorio + " gol nessa partida");
                        System.out.println("Infelismente, perdeu.Valor do ganho: " + 0);
                    }

                    break;
                // escandeio a favor do barcelona
                case 2:
                    numeroAleatorio = random.nextInt(10);
                    if (numeroAleatorio == quant) {
                        ganhoTotal.add(valor * barcelona.odd);
                    } else {
                        ganhoTotal.add(-valor);
                        System.out.println("Barcelona teve " + numeroAleatorio + " escanteio ao seu favor nessa partida");
                        System.out.println("Infelismente, perdeu.Valor do ganho: " + 0);
                    }

                    break;
                // finalizaçao a favor do barcelona
                case 3:
                    numeroAleatorio = random.nextInt(18);
                    if (numeroAleatorio == quant) {
                        ganhoTotal.add(valor * barcelona.odd);
                        System.out.println("Parabens, voce ganhou.Valor do ganho: " + valor*barcelona.odd);
                    } else {
                        ganhoTotal.add(-valor);
                        System.out.println("Barcelona fez " + numeroAleatorio + " finalizacao nessa partida");
                        System.out.println("Infelismente, perdeu.Valor do ganho: " + 0);
                    }
                    break;
            }
        }
        /////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
        ////********** CORINTHIANS **********\\\\
        if (time instanceof Corinthians) {
            Corinthians corinthians = (Corinthians) time;
            switch (tipo) {
                // aposta por quantidade de cartão do Corinthians
                case 0:
                    numeroAleatorio = random.nextInt(4);
                    if (numeroAleatorio == quant) {
                        ganhoTotal.add(valor * corinthians.odd);
                        System.out.println("Parabens, voce ganhou.Valor do ganho: " + valor*corinthians.odd);
                    } else {
                        ganhoTotal.add(-valor);
                        System.out.println("Barcelona tomaram " + numeroAleatorio + " cartao nessa partida");
                        System.out.println("Infelismente, perdeu.Valor do ganho: " + 0);
                    }

                    break;
                // aposta por quat de gol do Corinthians
                case 1:
                    numeroAleatorio = random.nextInt(6) +3;
                    if (numeroAleatorio == quant) {
                        ganhoTotal.add(valor * corinthians.odd);
                        System.out.println("Parabens, voce ganhou.Valor do ganho: " + valor*corinthians.odd);
                    } else {
                        ganhoTotal.add(-valor);
                        System.out.println("Barcelona fizeram " + numeroAleatorio + " gol nessa partida");
                        System.out.println("Infelismente, perdeu.Valor do ganho: " + 0);
                    }

                    break;
                // escandeio a favor do Corinthians
                case 2:
                    numeroAleatorio = random.nextInt(6);
                    if (numeroAleatorio == quant) {
                        ganhoTotal.add(valor * corinthians.odd);
                    } else {
                        ganhoTotal.add(-valor);
                        System.out.println("Barcelona teve " + numeroAleatorio + " escanteio ao seu favor nessa partida");
                        System.out.println("Infelismente, perdeu.Valor do ganho: " + 0);
                    }

                    break;
                // finalizaçao a favor do Corinthians
                case 3:
                    numeroAleatorio = random.nextInt(8);
                    if (numeroAleatorio == quant) {
                        ganhoTotal.add(valor * corinthians.odd);
                        System.out.println("Parabens, voce ganhou.Valor do ganho: " + valor*corinthians.odd);
                    } else {
                        ganhoTotal.add(-valor);
                        System.out.println("Barcelona fez " + numeroAleatorio + " finalizacao nessa partida");
                        System.out.println("Infelismente, perdeu.Valor do ganho: " + 0);
                    }
                    break;
            }
        }
    }

    public void resultado(Conta conta) {
        double sum = 0;

        for (Double number : ganhoTotal){
            sum += number;
        }

        //     System.out.println(conta.getSaldo() + sum);
        if(sum >0 ) {
            valorFinal = conta.getSaldo() + sum;
        }
        else
            valorFinal = 0;
        arq.resultado(conta, valorFinal, quantGanho, sum);
    }
}





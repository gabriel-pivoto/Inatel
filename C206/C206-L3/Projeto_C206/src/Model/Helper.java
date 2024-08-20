package Model;


import java.util.Scanner;

public class Helper {

    public static void fazerJogo(Jogo jogo, Conta c) {

        // variaveis aux para fazer a entrada de dados
        Scanner sc = new Scanner(System.in);
        int tipo;
        int flag1;
        int quant;
        double valor;
        String aposta;

        System.out.println();
        System.out.println("Antes de fazer a aposta gostaria de saber informacoes do jogo? SIM ou NAO - 1 ou 0 ");
        flag1 = sc.nextInt();
        // Informaçoes do jogo - ESTADIO - CIDADE - NARRADOR
        if (flag1 == 1) {
            jogo.info();
        }
        System.out.println();
        System.out.println("1 - aposta em cima do " + jogo.getTimeCasa().getNome());
        System.out.println("2 - aposta em cima do " + jogo.getTimeVisita().getNome());
        tipo = sc.nextInt();
        // Fazendo aposta encima do Time Casa
        if (tipo == 1) {
            System.out.println();
            System.out.println("Antes de fazer a aposta gostaria de saber informacoes do " + jogo.getTimeCasa().getNome() + "? SIM ou NAO - 1 ou 0 ");
            // Informaçoes do Time Casa - TITULOS - ESCALACAO
            flag1 = sc.nextInt();
            if (flag1 == 1) {
                jogo.getTimeCasa().infoTime();
            }
            System.out.println();
            System.out.println("Temos varias opcoes de aposta em cima do " + jogo.getTimeCasa().getNome() + " . A ODD do time é de: " + jogo.getTimeCasa().getOdd());
            System.out.println("Antes de fazer a aposta gostaria de saber");
            System.out.println("cartao - aposta em quantos cartoes o " + jogo.getTimeCasa().getNome() + " pode ter nesse jogo");
            System.out.println("gol - aposta em quantos gols o " + jogo.getTimeCasa().getNome() + "  pode fazer nesse jogo");
            System.out.println("escanteio - aposta em quantos escanteios o " + jogo.getTimeCasa().getNome() + " pode ter a favor dele nesse jogo");
            System.out.println("finalizacao - aposta em quantas finalizacoes o " + jogo.getTimeCasa().getNome() + " pode fazer nesse jogo");
            System.out.println("falta - aposta em quantas falta o " + jogo.getTimeCasa().getNome() + " pode fazer nesse jogo");
            sc.nextLine();
            aposta = sc.nextLine();


            System.out.println();
            System.out.println("Favor insira o valor da aposta e quantidade possivel de" + aposta);
            System.out.println("Favor insira valor:");
            valor = sc.nextDouble();
            System.out.println("Favor insira a quantidade de " + aposta + "que o " + jogo.getTimeCasa().getNome() + " pode ter:");
            quant = sc.nextInt();
            c.fazerAposta(jogo, valor, c, quant, aposta, jogo.getTimeCasa().getNome());

        }

        // Fazendo aposta encima no Time Visita
        if (tipo == 2) {
            System.out.println();
            System.out.println("Antes de fazer a aposta gostaria de saber informacoes do "  + jogo.getTimeVisita().getNome() + "? SIM ou NAO - 1 ou 0 ");
            // Informaçoes do Time Visita - TITULOS - ESCALACAO
            flag1 = sc.nextInt();
            if (flag1 == 1) {
                jogo.getTimeVisita().infoTime();
            }
            System.out.println();
            System.out.println("Temos varias opcoes de aposta em cima do " + jogo.getTimeVisita().getNome() + " . A ODD do time é de: " + jogo.getTimeVisita().getOdd());
            System.out.println("Antes de fazer a aposta gostaria de saber");
            System.out.println("cartao - aposta em quantos cartoes o " + jogo.getTimeVisita().getNome() + " pode ter nesse jogo");
            System.out.println("gol - aposta em quantos gols o " + jogo.getTimeVisita().getNome() + "  pode fazer nesse jogo");
            System.out.println("escanteio - aposta em quantos escanteios o " + jogo.getTimeVisita().getNome() + " pode ter a favor dele nesse jogo");
            System.out.println("finalizacao - aposta em quantas finalizacoes o " + jogo.getTimeVisita().getNome() + " pode fazer nesse jogo");
            System.out.println("falta - aposta em quantas falta o " + jogo.getTimeVisita().getNome() + " pode fazer nesse jogo");
            sc.nextLine();
            aposta = sc.nextLine();


            System.out.println();
            System.out.println("Favor insira o valor da aposta e quantidade possivel de" + aposta);
            System.out.println("Favor insira valor:");
            valor = sc.nextDouble();
            System.out.println("Favor insira a quantidade de "+aposta+" que o " + jogo.getTimeVisita().getNome() + " pode ter:");
            quant = sc.nextInt();
            c.fazerAposta(jogo, valor, c, quant, aposta, jogo.getTimeVisita().getNome());

        }

    }
}


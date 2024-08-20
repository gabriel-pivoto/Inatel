import Controller.Arquivo;
import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public Main(){


    }

    public static void main(String[] args) {

        JFrame frame = new JFrame();
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel();
        JPanel bottomPanel = new JPanel();
        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel titleLabel = new JLabel("Davi.bet");
        titleLabel.setForeground(Color.BLUE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setVerticalAlignment(SwingConstants.NORTH);
        topPanel.add(titleLabel);

        JLabel nameLabel = new JLabel("Insira seu nome: ");
        JTextField inputNome = new JTextField(10);
        JButton submitButton = new JButton("Submit");

        inputPanel.add(nameLabel);
        inputPanel.add(inputNome);
        inputPanel.add(submitButton);

        bottomPanel.add(inputPanel);

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(bottomPanel, BorderLayout.WEST);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = inputNome.getText();
                nameLabel.setText("Seu nome: " + inputText);
            }
        });

        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Davi.bet");
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);



        //---------------------------------------------------------------------------------------------------------------------------------------------------------
        // VARIAVEIS
        Scanner sc = new Scanner(System.in);
        Arquivo arq1 = new Arquivo();

        // informaçoes dos times
        Time corinthians = new Corinthians();
        Time manchester = new ManschesterCity();
        Time realMadrid = new RealMadrid();
        Time barcelona = new Barcelona();
        Time time = new Time();
        time.jogos[0] = new Jogo("Arena Corinthians", "Itaquera", "Andre Henning");
        time.jogos[1] = new Jogo("Estadio Santiago Bernabeu", "Madrid", "Cleber Machado");
        // variaveis aux para fazer a entrada de dados
        boolean flag = true;
        boolean flag2 = true;
        int flag1 = 0;

        int tipo;
        int jogo;
        int aposta;
        double valor;
        int quant;

        /*informaçoes da conta:
         - regex no email permitindo apenas
        string que tem '@' e '.com' e se tiver um '.br'
         - Somedente pessoa apartir de 18 anos pode fazer a aposta
         - Tem que entrar obrigatoriamente com um cpf valido de verdade
        */
        System.out.println("Menu de aposta, muito bem vindo!");
        System.out.println("Favor insira o nome do usuario");
        String nomeConta = sc.nextLine();
        System.out.println("Favor insira o email para entrar na casa de apostas");
        String emailConta = sc.nextLine();
        String regex = "^[A-Za-z0-9+_.-]+@(hotmail|gmail|gec|get|gea|ges|gel|gep)(.inatel)?.com(.br)?$";
        while(!Pattern.matches(regex, emailConta)){
            System.out.println("Favor insira o email valido para entrar na casa de apostas");
            emailConta = sc.nextLine();
        }
        System.out.println("Favor insira a sua idade");
        int idadeConta = sc.nextInt();
        while(idadeConta < 18){
            System.out.println("Favor insira uma idade com 18 anos ou mais");
            idadeConta = sc.nextInt();
        }

        sc.nextLine();
        System.out.println("Por favor, insira o CPF que corresponde ao nome informado anteriormente:");
        String cpfConta = sc.nextLine();
        boolean isValid = isValidCPF(cpfConta);
        while (!isValid){
            System.out.println("Por favor, insira um CPF válido:");
            cpfConta = sc.nextLine();
            isValid = isValidCPF(cpfConta);
        }
        System.out.println("Parabens, agora voce ja esta cadastrado para começar a fazer as apostas esportivas, mas primeiro");
        System.out.println("favor insira um primeiro deposito para começar fazer as aposta");
        double saldo = sc.nextDouble();


        Conta c = new Conta(nomeConta, emailConta, idadeConta, cpfConta);
        c.setSaldo(saldo);
        arq1.perfil(c);


        while (flag) {
            System.out.println("Muito bem, aqui estão as opçoes de jogo que vao acontecer");
            System.out.println("Gostaria de apostar em qual jogo?");
            System.out.println("Jogo 0 - Resultado das apostas e finalizando");
            System.out.println("Jogo 1 - Corinthians X Marchester City na final do Mudial de Clubes 2024");
            System.out.println("Jogo 2 - Real Madrid X Barcelona na 10° rodada da LaLiga");
            jogo = sc.nextInt();

            // Resultado dos ganhos
            if (jogo == 0) {
                flag = false;
                c.resultado(c);
            }
            ////********** JOGO 1 **********\\\\
            if (jogo == 1) {
                System.out.println("Antes de fazer a aposta gostaria de saber informacoes do jogo? SIM ou NAO - 1 ou 0 ");
                flag1 = sc.nextInt();
                // Informaçoes do jogo - ESTADIO - CIDADE - NARRADOR
                if (flag1 == 1) {
                    time.jogos[0].info();
                }
                System.out.println("1 - aposta em cima do Corinthians");
                System.out.println("2 - aposta em cima do Manschester City");
                tipo = sc.nextInt();
                ////********** CORINTHIANS **********\\\\
                if (tipo == 1) {
                    System.out.println("Antes de fazer a aposta gostaria de saber informacoes do Corinthias? SIM ou NAO - 1 ou 0 ");
                    // Informaçoes do Corinthians - TITULOS - ESCALACAO
                    flag1 = sc.nextInt();
                    if (flag1 == 1) {
                        corinthians.infoTime();
                    }
                    System.out.println("Temos varias opcoes de aposta em cima do Corinthians. A ODD do time é de 0.2");
                    System.out.println("Antes de fazer a aposta gostaria de saber");
                    System.out.println("0 - aposta em quantos cartoes o Corinthians pode ter nesse jogo");
                    System.out.println("1 - aposta em quantos gols o Corinthians pode fazer nesse jogo");
                    System.out.println("2 - aposta em quantos escanteios o Corinthians pode ter a favor dele nesse jogo");
                    System.out.println("3 - aposta em quantas finalizacoes o Corinthians pode fazer nesse jogo");
                    aposta = sc.nextInt();
                    switch (aposta) {
                        case 0:
                            System.out.println("Favor insira o valor da aposta e quantidade possivel de cartoes");
                            System.out.println("Favor insira valor:");
                            valor = sc.nextDouble();
                            System.out.println("Favor insira a quantidade de cartoes que o Corinthians pode ter:");
                            quant = sc.nextInt();
                            c.aposta(corinthians, valor, c, quant, 0);
                            c.ganho(corinthians, valor, c, quant, 0);
                            break;
                        case 1:
                            System.out.println("Favor insira o valor da aposta e quantidade possivel de gols");
                            System.out.println("Favor insira valor:");
                            valor = sc.nextDouble();
                            System.out.println("Favor insira a quantidade de gols que o Corinthians pode fazer:");
                            quant = sc.nextInt();
                            c.aposta(corinthians, valor, c, quant, 1);
                            c.ganho(corinthians, valor, c, quant, 1);
                            break;
                        case 2:
                            System.out.println("Favor insira o valor da aposta e quantidade possivel de escanteios");
                            System.out.println("Favor insira valor:");
                            valor = sc.nextDouble();
                            System.out.println("Favor insira a quantidade de escanteios que o Corinthians pode fazer:");
                            quant = sc.nextInt();
                            c.aposta(corinthians, valor, c, quant, 2);
                            c.ganho(corinthians, valor, c, quant, 2);
                            break;
                        case 3:
                            System.out.println("Favor insira o valor da aposta e quantidade possivel de finalizacoes");
                            System.out.println("Favor insira valor:");
                            valor = sc.nextDouble();
                            System.out.println("Favor insira a quantidade de finalizacoes que o Corinthians pode fazer:");
                            quant = sc.nextInt();
                            c.aposta(corinthians, valor, c, quant, 3);
                            c.ganho(corinthians, valor, c, quant, 3);
                            break;
                    }
                }
                ////********** MANCHESTER CITY **********\\\\
                if (tipo == 2) {
                    System.out.println("Antes de fazer a aposta gostaria de saber informacoes do Manchester City ? SIM ou NAO - 1 ou 0 ");
                    // Informaçoes do Manchester City - TITULOS - ESCALACAO
                    flag1 = sc.nextInt();
                    if (flag1 == 1) {
                        manchester.infoTime();
                    }
                    System.out.println("Temos varias opcoes de aposta em cima do Manchester City. A ODD do time é de 5.08");
                    System.out.println("Antes de fazer a aposta gostaria de saber");
                    System.out.println("0 - aposta em quantos cartoes o Manchester City pode ter nesse jogo");
                    System.out.println("1 - aposta em quantos gols o Manchester City pode fazer nesse jogo");
                    System.out.println("2 - aposta em quantos escanteios o Manchester City pode ter a favor dele nesse jogo");
                    System.out.println("3 - aposta em quantas finalizacoes o Manchester City pode fazer nesse jogo");

                    aposta = sc.nextInt();
                    switch (aposta) {
                        case 0:
                            System.out.println("Favor insira o valor da aposta e quantidade possivel de cartoes");
                            System.out.println("Favor insira valor:");
                            valor = sc.nextDouble();
                            System.out.println("Favor insira a quantidade de gols que o Manchester City pode fazer:");
                            quant = sc.nextInt();
                            c.aposta(manchester, valor, c, quant, 0);
                            c.ganho(manchester, valor, c, quant, 0);
                            break;
                        case 1:
                            System.out.println("Favor insira o valor da aposta e quantidade possivel de gols");
                            System.out.println("Favor insira valor:");
                            valor = sc.nextDouble();
                            System.out.println("Favor insira a quantidade de gols que o Manchester City pode fazer:");
                            quant = sc.nextInt();
                            c.aposta(manchester, valor, c, quant, 1);
                            c.ganho(manchester, valor, c, quant, 1);
                            break;
                        case 2:
                            System.out.println("Favor insira o valor da aposta e quantidade possivel de escanteios");
                            System.out.println("Favor insira valor:");
                            valor = sc.nextDouble();
                            System.out.println("Favor insira a quantidade de escanteios que o Manchester City pode fazer:");
                            quant = sc.nextInt();
                            c.aposta(manchester, valor, c, quant, 2);
                            c.ganho(manchester, valor, c, quant, 2);
                            break;
                        case 3:
                            System.out.println("Favor insira o valor da aposta e quantidade possivel de finalizacoes");
                            System.out.println("Favor insira valor:");
                            valor = sc.nextDouble();
                            System.out.println("Favor insira a quantidade de d que o Manchester City pode fazer:");
                            quant = sc.nextInt();
                            c.aposta(manchester, valor, c, quant, 3);
                            c.ganho(manchester, valor, c, quant, 3);
                            break;

                    }
                }

            }

            ////********** JOGO 2 **********\\\\
            if( jogo == 2){
                System.out.println("Antes de fazer a aposta gostaria de saber informacoes do jogo? SIM ou NAO - 1 ou 0 ");
                flag1 = sc.nextInt();
                // Informaçoes do jogo - ESTADIO - CIDADE - NARRADOR
                if (flag1 == 1) {
                    time.jogos[1].info();
                }
                System.out.println("1 - aposta em cima do Real Madrid");
                System.out.println("2 - aposta em cima do Barcelona");
                tipo = sc.nextInt();
                ////********** REAL MADRID **********\\\\
                if (tipo == 1) {
                    System.out.println("Antes de fazer a aposta gostaria de saber informacoes do Real Madrid? SIM ou NAO - 1 ou 0 ");
                    // Informaçoes do Corinthians - TITULOS - ESCALACAO
                    flag1 = sc.nextInt();
                    if (flag1 == 1) {
                        corinthians.infoTime();
                    }
                    System.out.println("Temos varias opcoes de aposta em cima do Real Madrid. A ODD do time é de 1.59");
                    System.out.println("Antes de fazer a aposta gostaria de saber");
                    System.out.println("0 - aposta em quantos cartoes o Real Madrid pode ter nesse jogo");
                    System.out.println("1 - aposta em quantos gols o Real Madrid pode fazer nesse jogo");
                    System.out.println("2 - aposta em quantos escanteios o Real Madrid pode ter a favor dele nesse jogo");
                    System.out.println("3 - aposta em quantas finalizacoes o Real Madrid pode fazer nesse jogo");
                    aposta = sc.nextInt();
                    switch (aposta) {
                        case 0:
                            System.out.println("Favor insira o valor da aposta e quantidade possivel de cartoes");
                            System.out.println("Favor insira valor:");
                            valor = sc.nextDouble();
                            System.out.println("Favor insira a quantidade de cartoes que o Real Madrid pode ter:");
                            quant = sc.nextInt();
                            c.aposta(realMadrid, valor, c, quant, 0);
                            c.ganho(realMadrid, valor, c, quant, 0);
                            break;
                        case 1:
                            System.out.println("Favor insira o valor da aposta e quantidade possivel de gols");
                            System.out.println("Favor insira valor:");
                            valor = sc.nextDouble();
                            System.out.println("Favor insira a quantidade de gols que o Real Madrid pode fazer:");
                            quant = sc.nextInt();
                            c.aposta(realMadrid, valor, c, quant, 1);
                            c.ganho(realMadrid, valor, c, quant, 1);
                            break;
                        case 2:
                            System.out.println("Favor insira o valor da aposta e quantidade possivel de escanteios");
                            System.out.println("Favor insira valor:");
                            valor = sc.nextDouble();
                            System.out.println("Favor insira a quantidade de escanteios que o Real Madrid pode fazer:");
                            quant = sc.nextInt();
                            c.aposta(realMadrid, valor, c, quant, 2);
                            c.ganho(realMadrid, valor, c, quant, 2);
                            break;
                        case 3:
                            System.out.println("Favor insira o valor da aposta e quantidade possivel de finalizacoes");
                            System.out.println("Favor insira valor:");
                            valor = sc.nextDouble();
                            System.out.println("Favor insira a quantidade de finalizacoes que o Real Madrid pode fazer:");
                            quant = sc.nextInt();
                            c.aposta(realMadrid, valor, c, quant, 3);
                            c.ganho(realMadrid, valor, c, quant, 3);
                            break;
                    }
                }
                ////********** BARCELONA **********\\\\
                if (tipo == 2) {
                    System.out.println("Antes de fazer a aposta gostaria de saber informacoes do Barcelona? SIM ou NAO - 1 ou 0 ");
                    // Informaçoes do Manchester City - TITULOS - ESCALACAO
                    flag1 = sc.nextInt();
                    if (flag1 == 1) {
                        manchester.infoTime();
                    }
                    System.out.println("Temos varias opcoes de aposta em cima do Barcelona. A ODD do time é de 3.75");
                    System.out.println("Antes de fazer a aposta gostaria de saber");
                    System.out.println("0 - aposta em quantos cartoes o Barcelona pode ter nesse jogo");
                    System.out.println("1 - aposta em quantos gols o Barcelonapode fazer nesse jogo");
                    System.out.println("2 - aposta em quantos escanteios o Barcelona pode ter a favor dele nesse jogo");
                    System.out.println("3 - aposta em quantas finalizacoes o Barcelona pode fazer nesse jogo");

                    aposta = sc.nextInt();
                    switch (aposta) {
                        case 0:
                            System.out.println("Favor insira o valor da aposta e quantidade possivel de cartoes");
                            System.out.println("Favor insira valor:");
                            valor = sc.nextDouble();
                            System.out.println("Favor insira a quantidade de gols que o Manchester City pode fazer:");
                            quant = sc.nextInt();
                            c.aposta(barcelona, valor, c, quant, 0);
                            c.ganho(barcelona, valor, c, quant, 0);
                            break;
                        case 1:
                            System.out.println("Favor insira o valor da aposta e quantidade possivel de gols");
                            System.out.println("Favor insira valor:");
                            valor = sc.nextDouble();
                            System.out.println("Favor insira a quantidade de gols que o Barcelona pode fazer:");
                            quant = sc.nextInt();
                            c.aposta(barcelona, valor, c, quant, 1);
                            c.ganho(barcelona, valor, c, quant, 1);
                            break;
                        case 2:
                            System.out.println("Favor insira o valor da aposta e quantidade possivel de escanteios");
                            System.out.println("Favor insira valor:");
                            valor = sc.nextDouble();
                            System.out.println("Favor insira a quantidade de escanteios que o Barcelona pode fazer:");
                            quant = sc.nextInt();
                            c.aposta(barcelona, valor, c, quant, 2);
                            c.ganho(barcelona, valor, c, quant, 2);
                            break;
                        case 3:
                            System.out.println("Favor insira o valor da aposta e quantidade possivel de finalizacoes");
                            System.out.println("Favor insira valor:");
                            valor = sc.nextDouble();
                            System.out.println("Favor insira a quantidade de d que o Barcelona pode fazer:");
                            quant = sc.nextInt();
                            c.aposta(barcelona, valor, c, quant, 3);
                            c.ganho(barcelona, valor, c, quant, 3);
                            break;

                    }
                }

            }
        }
    }
    /* parte do codigo que
        verifica a validação do CPF
        */
    public static boolean isValidCPF(String cpf) {
        // Remover caracteres não numéricos do CPF
        cpf = cpf.replaceAll("[^0-9]", "");

        // Verificar se o CPF possui 11 dígitos
        if (cpf.length() != 11) {
            return false;
        }

        // Verificar se todos os dígitos são iguais
        if (cpf.matches("(\\d)\\1{10}")) {
            return false;
        }

        // Calcular os dígitos verificadores
        int digito1 = calcularDigitoVerificador(cpf.substring(0, 9), 10);
        int digito2 = calcularDigitoVerificador(cpf.substring(0, 9) + digito1, 11);

        // Verificar se os dígitos verificadores calculados são iguais aos dígitos informados
        return cpf.equals(cpf.substring(0, 9) + digito1 + digito2);
    }

    private static int calcularDigitoVerificador(String cpf, int peso) {
        int soma = 0;
        for (int i = 0; i < cpf.length(); i++) {
            soma += Character.getNumericValue(cpf.charAt(i)) * peso--;
        }
        int resto = soma % 11;
        return (resto < 2) ? 0 : (11 - resto);
    }



}

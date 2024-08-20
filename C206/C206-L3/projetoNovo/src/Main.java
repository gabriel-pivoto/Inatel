import Controller.Arquivo;
import Model.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Arquivo arq2 = new Arquivo();
        JFrame frame = new JFrame();
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel();
        JPanel bottomContainer = new JPanel();

        final String[] nomeConta1 = new String[1];
        final String[] cpfConta1 = new String[1];
        final String[] emailConta1 = new String[1];
        final int[] idadeConta1 = new int[1];
        final int[] saldoConta1 = new int[1];


        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // para o nome
        JPanel inputPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));// para o idade
        JPanel inputPanel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));// para o para o email
        JPanel inputPanel4 = new JPanel(new FlowLayout(FlowLayout.CENTER));// para o para o cpf
        JPanel inputPanel5 = new JPanel(new FlowLayout(FlowLayout.CENTER));// para o para o saldo
        JPanel inputPanel6 = new JPanel(new FlowLayout(FlowLayout.CENTER));// para o para confirmar as informações


        JLabel titleLabel = new JLabel("Davi.bet");
        titleLabel.setForeground(Color.BLUE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setVerticalAlignment(SwingConstants.NORTH);
        topPanel.add(titleLabel);

        JLabel nameLabel = new JLabel("Insira seu nome: ");
        JTextField inputNome = new JTextField(10);
        JButton submitButtonName = new JButton("Submit");

        JLabel idadeLabel = new JLabel("Insira sua idade: ");
        JTextField inputIdade = new JTextField(10);
        JButton submitButtonIdade = new JButton("Submit");

        JLabel emailLabel = new JLabel("Insira sua email: ");
        JTextField inputemail = new JTextField(10);
        JButton submitButtonemail= new JButton("Submit");

        JLabel CPFLabel = new JLabel("Insira sua CPF: ");
        JTextField inputCPF = new JTextField(10);
        JButton submitButtonCPF = new JButton("Submit");

        JLabel SaldoLabel = new JLabel("Insira seu depósito: ");
        JTextField inputsaldo = new JTextField(10);
        JButton submitButtonsaldo = new JButton("Submit");

        JButton submitButtonConfirmed = new JButton("Começar!");

        inputPanel.add(nameLabel);
        inputPanel.add(inputNome);
        inputPanel.add(submitButtonName);

        inputPanel2.add(idadeLabel);
        inputPanel2.add(inputIdade);
        inputPanel2.add(submitButtonIdade);

        inputPanel3.add(emailLabel);
        inputPanel3.add(inputemail);
        inputPanel3.add(submitButtonemail);

        inputPanel4.add(CPFLabel);
        inputPanel4.add(inputCPF);
        inputPanel4.add(submitButtonCPF);

        inputPanel5.add(SaldoLabel);
        inputPanel5.add(inputsaldo);
        inputPanel5.add(submitButtonsaldo);

        inputPanel6.add(submitButtonConfirmed);

        bottomContainer.setLayout(new BoxLayout(bottomContainer, BoxLayout.Y_AXIS));
        bottomContainer.add(inputPanel);
        bottomContainer.add(inputPanel2);
        bottomContainer.add(inputPanel3);
        bottomContainer.add(inputPanel4);
        bottomContainer.add(inputPanel5);
        bottomContainer.add(inputPanel6);


        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(bottomContainer, BorderLayout.CENTER);


        submitButtonName.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = inputNome.getText();
                nomeConta1[0] = inputText;
                nameLabel.setText("Seu nome: " + inputText);
            }
        });
        submitButtonIdade.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String inputIdadetext = inputIdade.getText();
                try {
                    int age = Integer.parseInt(inputIdadetext);
                    idadeConta1[0] = Integer.parseInt(inputIdadetext);
                    if (age >= 18 && age <100) {
                        idadeLabel.setText("Sua idade: " + inputIdadetext);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Você tem menos que 18 anos ou mais de 100!");
                        inputIdade.setText("");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Entrada inválida!");
                    inputIdade.setText("");
                }
            }
        });

        submitButtonemail.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputemailtext = inputemail.getText();
                emailConta1[0] = inputemailtext;
                try {
                    String regex = "^[A-Za-z0-9+_.-]+@(hotmail|gmail|gec|get|gea|ges|gel|gep)(.inatel)?.com(.br)?$";
                    if (Pattern.matches(regex, inputemailtext)) {
                        emailLabel.setText("Seu email: " + inputemailtext);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Email inválido");
                        inputIdade.setText("");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Entrada inválida!");
                    inputIdade.setText("");
                }
            }
        });


        submitButtonCPF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputcpftext = inputCPF.getText();
                cpfConta1[0] = inputcpftext;
                try {

                    if (isValidCPF(inputcpftext)) {
                        CPFLabel.setText("Seu cpf: " + inputcpftext);
                    } else {
                        JOptionPane.showMessageDialog(frame, "CPF inválido");
                        inputCPF.setText("");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Entrada inválida!");
                    inputIdade.setText("");
                }
            }
        });


        submitButtonsaldo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputSaldotext = inputsaldo.getText();
                try {
                    int age = Integer.parseInt(inputSaldotext);
                    saldoConta1[0] = Integer.parseInt(inputSaldotext);
                    if (age > 0) {
                        SaldoLabel.setText("Seu saldo: " + inputSaldotext);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Foi depositado!");
                        inputsaldo.setText("");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Entrada inválida!");
                    inputsaldo.setText("");
                }
            }
        });




        Time flamengo = new Time("Flamengo", 1.01);
        Time manchesterUnited = new Time("Manchester United", 5.08);
        Time psg = new Time("Paris Saint-Germain", 1.59);
        Time vasco = new Time("Vasco", 1000.00);

        Jogo jogo3 = new Jogo("Maracana", "Rio de Janeiro", "Galvão Bueno", "Mundial de Clubes 2024", flamengo, manchesterUnited);
        Jogo jogo4 = new Jogo("Princes Park", "Paris", "Andre Henning", "Amistoso", psg, vasco);
        jogo3.resultado();
        jogo4.resultado();




        submitButtonConfirmed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                if (nomeConta1[0] != null && cpfConta1[0] != null && emailConta1[0] != null && idadeConta1[0] > 0 && saldoConta1[0] > 0) {

                    Conta usuario1 = new Conta(nomeConta1[0], emailConta1[0], idadeConta1[0], cpfConta1[0]);
                    System.out.println(nomeConta1[0] + emailConta1[0] + idadeConta1[0] + cpfConta1[0]);
                    usuario1.setSaldo(saldoConta1[0]);
                    arq2.perfil(usuario1);
                    // Oculta as labels, inputs e botões
                    nameLabel.setVisible(false);
                    inputNome.setVisible(false);
                    submitButtonName.setVisible(false);

                    idadeLabel.setVisible(false);
                    inputIdade.setVisible(false);
                    submitButtonIdade.setVisible(false);

                    emailLabel.setVisible(false);
                    inputemail.setVisible(false);
                    submitButtonemail.setVisible(false);

                    CPFLabel.setVisible(false);
                    inputCPF.setVisible(false);
                    submitButtonCPF.setVisible(false);

                    SaldoLabel.setVisible(false);
                    inputsaldo.setVisible(false);
                    submitButtonsaldo.setVisible(false);


                }
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(frame, "Não foi possivel continuar, confirme as informações");
                }
            }
        });


        // Creating the interface itself
        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Davi.bet");
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);


//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
        // VARIAVEIS
        Scanner sc = new Scanner(System.in);
        Arquivo arq1 = new Arquivo();
        // informaçoes dos times
        Time corinthians = new Time("Corinthians", 1.25);
        Time manchester = new Time("Manchester City", 5.08);
        Time realMadrid = new Time("Real Madrid", 1.59);
        Time barcelona = new Time("Barcelona", 3.75);

        Jogo jogo1 = new Jogo("Arena Corinthians", "Itaquera", "Andre Henning", "Mundial de Clubes", corinthians, manchester);
        Jogo jogo2 = new Jogo("Estadio Santiago Bernabeu", "Madrid", "Cleber Machado", "10° rodada da LaLiga", realMadrid, barcelona);
        jogo1.resultado();
        jogo2.resultado();

        // variaveis aux para fazer a entrada de dados
        boolean flag = true;
        int flag1 ;

        int tipo;
        int jogo;
        String aposta;
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
        while (!Pattern.matches(regex, emailConta)) {
            System.out.println("Favor insira o email valido para entrar na casa de apostas");
            emailConta = sc.nextLine();
        }
        System.out.println("Favor insira a sua idade");
        int idadeConta = sc.nextInt();
        while (idadeConta < 18 && idadeConta <100) {
            System.out.println("Favor insira uma idade com 18 anos ou mais");
            idadeConta = sc.nextInt();
        }

        sc.nextLine();
        System.out.println("Por favor, insira o CPF que corresponde ao nome informado anteriormente:");
        String cpfConta = sc.nextLine();
        boolean isValid = isValidCPF(cpfConta);
        while (!isValid) {
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
            System.out.println("Jogo 1 - " + jogo1.getTimeCasa().getNome() + " X " + jogo1.getTimeVisita().getNome() +  " na/no " +  jogo1.getCampeonato() );
            //System.out.println("Jogo 2 - Real Madrid X Barcelona na 10° rodada da LaLiga");
            jogo = sc.nextInt();

            // Resultado dos ganhos
            if (jogo == 0) {
                flag = false;
                jogo1.resultadoArquivo(jogo1);
                jogo2.resultadoArquivo(jogo2);
                c.resultado(c);
            }
            ////********** JOGO 1 **********\\\\
            if (jogo == 1) {
                System.out.println("Antes de fazer a aposta gostaria de saber informacoes do jogo? SIM ou NAO - 1 ou 0 ");
                flag1 = sc.nextInt();
                // Informaçoes do jogo - ESTADIO - CIDADE - NARRADOR
                if (flag1 == 1) {
                    jogo1.info();
                }
                System.out.println("1 - aposta em cima do " + jogo1.getTimeCasa().getNome());
                System.out.println("2 - aposta em cima do " + jogo1.getTimeVisita().getNome());
                tipo = sc.nextInt();
                ////********** CORINTHIANS **********\\\\
                if (tipo == 1) {
                    System.out.println("Antes de fazer a aposta gostaria de saber informacoes do" + jogo1.getTimeCasa().getNome()+  "? SIM ou NAO - 1 ou 0 ");
                    // Informaçoes do Corinthians - TITULOS - ESCALACAO
                    flag1 = sc.nextInt();
                    if (flag1 == 1) {
                        jogo1.getTimeCasa().infoTime();
                    }
                    System.out.println("Temos varias opcoes de aposta em cima do" + jogo1.getTimeCasa().getNome() + " . A ODD do time é de: " + jogo1.getTimeCasa().getOdd());
                    System.out.println("Antes de fazer a aposta gostaria de saber");
                    System.out.println("0 - aposta em quantos cartoes o " + jogo1.getTimeCasa().getNome() + " pode ter nesse jogo");
                    System.out.println("1 - aposta em quantos gols o " + jogo1.getTimeCasa().getNome() + "  pode fazer nesse jogo");
                    System.out.println("2 - aposta em quantos escanteios o " + jogo1.getTimeCasa().getNome() + " pode ter a favor dele nesse jogo");
                    System.out.println("3 - aposta em quantas finalizacoes o " + jogo1.getTimeCasa().getNome() + " pode fazer nesse jogo");
                    sc.nextLine();
                    aposta = sc.nextLine();


                    System.out.println("Favor insira o valor da aposta e quantidade possivel de" + aposta);
                    System.out.println("Favor insira valor:");
                    valor = sc.nextDouble();
                    System.out.println("Favor insira a quantidade de " + aposta + "que o " +jogo1.getTimeCasa().getNome()+" pode ter:");
                    quant = sc.nextInt();
                    c.fazerAposta(jogo1, valor, c, quant, aposta, jogo1.getTimeCasa().getNome());

                }

                if (tipo == 2) {
                    System.out.println("Antes de fazer a aposta gostaria de saber informacoes do" +jogo1.getTimeVisita().getNome()+"? SIM ou NAO - 1 ou 0 ");
                    // Informaçoes do Corinthians - TITULOS - ESCALACAO
                    flag1 = sc.nextInt();
                    if (flag1 == 1) {
                        jogo1.getTimeVisita().infoTime();
                    }
                    System.out.println("Temos varias opcoes de aposta em cima do" + jogo1.getTimeVisita().getNome() + " . A ODD do time é de: " + jogo1.getTimeVisita().getOdd());
                    System.out.println("Antes de fazer a aposta gostaria de saber");
                    System.out.println("0 - aposta em quantos cartoes o " + jogo1.getTimeVisita().getNome() + " pode ter nesse jogo");
                    System.out.println("1 - aposta em quantos gols o " + jogo1.getTimeVisita().getNome() + "  pode fazer nesse jogo");
                    System.out.println("2 - aposta em quantos escanteios o " + jogo1.getTimeVisita().getNome() + " pode ter a favor dele nesse jogo");
                    System.out.println("3 - aposta em quantas finalizacoes o " + jogo1.getTimeVisita().getNome() + " pode fazer nesse jogo");
                    sc.nextLine();
                    aposta = sc.nextLine();


                    System.out.println("Favor insira o valor da aposta e quantidade possivel de" + aposta);
                    System.out.println("Favor insira valor:");
                    valor = sc.nextDouble();
                    System.out.println("Favor insira a quantidade de  que o Corinthians pode ter:");
                    quant = sc.nextInt();
                    c.fazerAposta(jogo1, valor, c, quant, aposta, jogo1.getTimeVisita().getNome());

                }
            }

            //jogo 2
            if(jogo == 2) {
                System.out.println("Antes de fazer a aposta gostaria de saber informacoes do jogo? SIM ou NAO - 1 ou 0 ");
                flag1 = sc.nextInt();
                // Informaçoes do jogo - ESTADIO - CIDADE - NARRADOR
                if (flag1 == 1) {
                    jogo1.info();
                }
                System.out.println("1 - aposta em cima do Corinthians");
                System.out.println("2 - aposta em cima do Manschester City");
                tipo = sc.nextInt();

                if (tipo == 1) {
                    System.out.println("Antes de fazer a aposta gostaria de saber informacoes do Corinthias? SIM ou NAO - 1 ou 0 ");
                    // Informaçoes do Corinthians - TITULOS - ESCALACAO
                    flag1 = sc.nextInt();
                    if (flag1 == 1) {
                        corinthians.infoTime();
                    }
                    System.out.println("Temos varias opcoes de aposta em cima do" + jogo1.getTimeCasa().getNome() + " . A ODD do time é de: " + jogo1.getTimeCasa().getOdd());
                    System.out.println("Antes de fazer a aposta gostaria de saber");
                    System.out.println("0 - aposta em quantos cartoes o " + jogo1.getTimeCasa().getNome() + " pode ter nesse jogo");
                    System.out.println("1 - aposta em quantos gols o " + jogo1.getTimeCasa().getNome() + "  pode fazer nesse jogo");
                    System.out.println("2 - aposta em quantos escanteios o " + jogo1.getTimeCasa().getNome() + " pode ter a favor dele nesse jogo");
                    System.out.println("3 - aposta em quantas finalizacoes o " + jogo1.getTimeCasa().getNome() + " pode fazer nesse jogo");
                    sc.nextLine();
                    aposta = sc.nextLine();



                    System.out.println("Favor insira o valor da aposta e quantidade possivel de" + aposta);
                    System.out.println("Favor insira valor:");
                    valor = sc.nextDouble();
                    System.out.println("Favor insira a quantidade de cartoes que o Corinthians pode ter:");
                    quant = sc.nextInt();
                    c.fazerAposta(jogo1, valor, c, quant, aposta, jogo1.getTimeCasa().getNome());
                    c.resultado(c);
                }


                if (tipo == 2) {
                    System.out.println("Antes de fazer a aposta gostaria de saber informacoes do Corinthias? SIM ou NAO - 1 ou 0 ");
                    // Informaçoes do Corinthians - TITULOS - ESCALACAO
                    flag1 = sc.nextInt();
                    if (flag1 == 1) {
                        corinthians.infoTime();
                    }
                    System.out.println("Temos varias opcoes de aposta em cima do" + jogo1.getTimeCasa().getNome() + " . A ODD do time é de: " + jogo1.getTimeCasa().getOdd());
                    System.out.println("Antes de fazer a aposta gostaria de saber");
                    System.out.println("0 - aposta em quantos cartoes o " + jogo1.getTimeCasa().getNome() + " pode ter nesse jogo");
                    System.out.println("1 - aposta em quantos gols o " + jogo1.getTimeCasa().getNome() + "  pode fazer nesse jogo");
                    System.out.println("2 - aposta em quantos escanteios o " + jogo1.getTimeCasa().getNome() + " pode ter a favor dele nesse jogo");
                    System.out.println("3 - aposta em quantas finalizacoes o " + jogo1.getTimeCasa().getNome() + " pode fazer nesse jogo");
                    sc.nextLine();
                    aposta = sc.nextLine();


                    System.out.println("Favor insira o valor da aposta e quantidade possivel de" + aposta);
                    System.out.println("Favor insira valor:");
                    valor = sc.nextDouble();
                    System.out.println("Favor insira a quantidade de cartoes que o Corinthians pode ter:");
                    quant = sc.nextInt();
                    c.fazerAposta(jogo1, valor, c, quant, aposta, jogo1.getTimeCasa().getNome());
                    c.resultado(c);
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

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
        final int[] escolha = new int[1];
        final Conta[] usuario1 = new Conta[1];
        escolha[0] = -1;

        Time flamengo = new Time("Flamengo", 1.01);
        Time manchesterUnited = new Time("Manchester United", 5.08);
        Time psg = new Time("Paris Saint-Germain", 1.59);
        Time vasco = new Time ("Vasco",6.0);
        Time corinthians = new Time("Corinthians", 1.25);
        Time manchester = new Time("Manchester City", 5.08);
        Time realMadrid = new Time("Real Madrid", 1.59);
        Time barcelona = new Time("Barcelona", 3.75);
        Time botafogo = new  Time("Botafogo", 1.22);

        Jogo jogo1 = new Jogo("Arena Corinthians", "Itaquera", "Andre Henning", "Mundial de Clubes", corinthians, manchester);
        Jogo jogo2 = new Jogo("Estadio Santiago Bernabeu", "Madrid", "Cleber Machado", "10° rodada da LaLiga", realMadrid, barcelona);
        Jogo jogo3 = new Jogo("Estadio Engenhao", "Rio de Janeiro", "Luiz Felipe Freitas", "Fina do campeonato carioca",botafogo,vasco);
        Jogo jogo5 = new Jogo("Maracana", "Rio de Janeiro", "Galvão Bueno", "Mundial de Clubes 2024", flamengo, manchesterUnited);
        Jogo jogo4 = new Jogo("Princes Park", "Paris", "Andre Henning", "Amistoso", psg, vasco);

        jogo1.resultado();
        jogo2.resultado();
        jogo3.resultado();
        jogo5.resultado();
        jogo4.resultado();





        JPanel inputPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // para o nome
        JPanel inputPanel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));// para o idade
        JPanel inputPanel3 = new JPanel(new FlowLayout(FlowLayout.CENTER));// para o para o email
        JPanel inputPanel4 = new JPanel(new FlowLayout(FlowLayout.CENTER));// para o para o cpf
        JPanel inputPanel5 = new JPanel(new FlowLayout(FlowLayout.CENTER));// para o para o saldo
        JPanel inputPanel6 = new JPanel(new FlowLayout(FlowLayout.CENTER));// para o para confirmar as informações
        JPanel LabelAposta1 = new JPanel(new FlowLayout(FlowLayout.CENTER));// para o primeira labels do menu de apostas
        JPanel Inputaposta1 = new JPanel(new FlowLayout(FlowLayout.CENTER));// para o input do menu de apostas




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

        JTextField InputAposta1_ = new JTextField(10);
        JButton submitButtonAposta1 = new JButton("Submit");

        JLabel Lable1Apostas = new JLabel("Muito bem, aqui estão as opçoes de jogo que vao acontecer: ");
        JLabel Lable2Apostas = new JLabel("Gostaria de apostar em qual jogo? ");
        JLabel Lable3Apostas = new JLabel("Jogo 0 - Resultado das apostas e finalizando ");
        JLabel Lable4Apostas = new JLabel("Jogo 1 - " + jogo1.getTimeCasa().getNome() + " X " + jogo1.getTimeVisita().getNome() + " na/no " + jogo1.getCampeonato() );
        JLabel Lable5Apostas = new JLabel("Jogo 2 - " + jogo2.getTimeCasa().getNome() + " X  "+ jogo2.getTimeVisita().getNome() + " na/no " + jogo2.getCampeonato());
        JLabel Lable6Apostas = new JLabel("Jogo 3 - " + jogo3.getTimeCasa().getNome() + " X " + jogo3.getTimeVisita().getNome() +" na/no " + jogo3.getCampeonato());


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

        LabelAposta1.add(Lable1Apostas);
        LabelAposta1.add(Lable2Apostas);
        LabelAposta1.add(Lable3Apostas);
        Inputaposta1.add(InputAposta1_);
        Inputaposta1.add(submitButtonAposta1);



        bottomContainer.setLayout(new BoxLayout(bottomContainer, BoxLayout.Y_AXIS));
        bottomContainer.add(LabelAposta1);
        bottomContainer.add(Lable2Apostas);
        bottomContainer.add(Lable3Apostas);
        bottomContainer.add(Lable4Apostas);
        bottomContainer.add(Lable5Apostas);
        bottomContainer.add(Lable6Apostas);
        bottomContainer.add(Inputaposta1);

        bottomContainer.add(inputPanel);
        bottomContainer.add(inputPanel2);
        bottomContainer.add(inputPanel3);
        bottomContainer.add(inputPanel4);
        bottomContainer.add(inputPanel5);
        bottomContainer.add(inputPanel6);

        LabelAposta1.setVisible(false);
        Lable2Apostas.setVisible(false);
        Lable3Apostas.setVisible(false);
        Lable4Apostas.setVisible(false);
        Lable5Apostas.setVisible(false);
        Lable6Apostas.setVisible(false);
        Inputaposta1.setVisible(false);


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








        submitButtonConfirmed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if (nomeConta1[0] != null && cpfConta1[0] != null && emailConta1[0] != null && idadeConta1[0] > 0 && saldoConta1[0] > 0) {

//                        Conta usuario1 = new Conta(nomeConta1[0], emailConta1[0], idadeConta1[0], cpfConta1[0]);
//                        System.out.println(nomeConta1[0] + emailConta1[0] + idadeConta1[0] + cpfConta1[0]);
//                        usuario1.setSaldo(saldoConta1[0]);
//                        arq2.perfil(usuario1);

                        usuario1[0] = new Conta(nomeConta1[0], emailConta1[0], idadeConta1[0], cpfConta1[0]);
                        System.out.println(nomeConta1[0] + emailConta1[0] + idadeConta1[0] + cpfConta1[0]);
                        usuario1[0].setSaldo(saldoConta1[0]);
                        arq2.perfil(usuario1[0]);


//                        // Oculta as labels, inputs e botões
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


                        LabelAposta1.setVisible(true);
                        Lable2Apostas.setVisible(true);
                        Lable3Apostas.setVisible(true);
                        Lable4Apostas.setVisible(true);
                        Lable5Apostas.setVisible(true);
                        Lable6Apostas.setVisible(true);
                        Inputaposta1.setVisible(true);
                        submitButtonConfirmed.setVisible(false);




                    }
                }catch (NumberFormatException ex){
                    JOptionPane.showMessageDialog(frame, "Não foi possivel continuar, confirme as informações");
                }
            }
        });

        submitButtonAposta1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    if(Inputaposta1.isVisible() == true){
                        String Inputaposta1__ = InputAposta1_.getText();

                        escolha[0] = Integer.parseInt(Inputaposta1__);
                        System.out.println(escolha[0]);

                        boolean flag2 = true;
                        while (flag2) {
                            if (usuario1[0] != null && escolha[0] == 0){
                                flag2 = false;
                                jogo1.resultadoArquivo(jogo1);
                                jogo2.resultadoArquivo(jogo2);
                                jogo3.resultadoArquivo(jogo3);
                                usuario1[0].resultado(usuario1[0]);
                            }
                        }

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


        //interface
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
        //cmd



        // VARIAVEIS
        Scanner sc = new Scanner(System.in);
        Arquivo arq1 = new Arquivo();
        // informaçoes dos times


        // variaveis aux para fazer a entrada de dados
        boolean flag = true;
        int flag1;

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
        while (idadeConta < 18) {
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
            System.out.println("Jogo 1 - " + jogo1.getTimeCasa().getNome() + " X " + jogo1.getTimeVisita().getNome() + " na/no " + jogo1.getCampeonato());
            System.out.println("Jogo 2 - " + jogo2.getTimeCasa().getNome() + " X " + jogo2.getTimeVisita().getNome() +" na/no " + jogo2.getCampeonato() );
            System.out.println("Jogo 3 - " + jogo3.getTimeCasa().getNome() + " X " + jogo3.getTimeVisita().getNome() +" na/no " + jogo3.getCampeonato() );

            jogo = sc.nextInt();

            // Resultado dos ganhos
            if (jogo == 0) {
                flag = false;
                jogo1.resultadoArquivo(jogo1);
                jogo2.resultadoArquivo(jogo2);
                jogo3.resultadoArquivo(jogo3);
                c.resultado(c);
            }
            if(jogo == 1){
                Helper.fazerJogo(jogo1,c);
            }
            if(jogo == 2){
                Helper.fazerJogo(jogo2,c);
            }
            if(jogo == 3){
                Helper.fazerJogo(jogo3,c);
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

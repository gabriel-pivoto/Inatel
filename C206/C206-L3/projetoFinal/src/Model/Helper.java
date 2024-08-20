package Model;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

public class Helper {
    private static JLabel InfojogoLable;
    public static void fazerJogo(Jogo jogo, Conta c) {



        JFrame frame = new JFrame();
        JPanel mainPanel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel();
        JPanel bottomContainer = new JPanel();
        final int[] escolha = new int[1];

        JLabel titleLabel = new JLabel("Davi.bet");
        titleLabel.setForeground(Color.BLUE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setVerticalAlignment(SwingConstants.NORTH);
        topPanel.add(titleLabel);

        JPanel inputPanelInfo = new JPanel(new FlowLayout(FlowLayout.CENTER));

        JPanel LabelInfojogo = new JPanel(new FlowLayout(FlowLayout.CENTER)); // para o pergunta das info do time

        JLabel InfotimeLable = new JLabel("Antes de fazer a aposta gostaria de saber informacoes do jogo? SIM ou NAO - 1 ou 0 ");
        JTextField inputinfotime = new JTextField(10);
        JButton submitButtontime = new JButton("Submit");

        InfojogoLable = new JLabel("info jogo");// vai substituir esse texto < ==

        inputPanelInfo.add(InfotimeLable);
        inputPanelInfo.add(inputinfotime);
        inputPanelInfo.add(submitButtontime);

        LabelInfojogo.add(InfojogoLable);

        bottomContainer.setLayout(new BoxLayout(bottomContainer, BoxLayout.Y_AXIS));
        bottomContainer.add(inputPanelInfo);
        bottomContainer.add(LabelInfojogo);

        mainPanel.add(topPanel, BorderLayout.NORTH);
        mainPanel.add(bottomContainer, BorderLayout.CENTER);


        frame.add(mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Davi.bet");
        frame.pack();
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);

        submitButtontime.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String inputinfotime_ = inputinfotime.getText();
                    escolha[0] = Integer.parseInt(inputinfotime_);
                    System.out.println(escolha[0]);

                    if (escolha[0] == 1) {
                        jogo.info(InfojogoLable);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Entrada inválida!");
                    inputinfotime.setText("");
                }
            }
        });




        Scanner sc = new Scanner(System.in);

        int tipo;
        int flag1;
        int quant;
        double valor;
        String aposta;


        System.out.println("Antes de fazer a aposta gostaria de saber informacoes do jogo? SIM ou NAO - 1 ou 0 ");
        flag1 = sc.nextInt();
        // Informaçoes do jogo - ESTADIO - CIDADE - NARRADOR
//        if (flag1 == 1) {
//            jogo.info();
//        }
        System.out.println("1 - aposta em cima do " + jogo.getTimeCasa().getNome());
        System.out.println("2 - aposta em cima do " + jogo.getTimeVisita().getNome());
        tipo = sc.nextInt();
        ////********** CORINTHIANS **********\\\\
        if (tipo == 1) {
            System.out.println("Antes de fazer a aposta gostaria de saber informacoes do" + jogo.getTimeCasa().getNome() + "? SIM ou NAO - 1 ou 0 ");
            // Informaçoes do Corinthians - TITULOS - ESCALACAO
            flag1 = sc.nextInt();
            if (flag1 == 1) {
                jogo.getTimeCasa().infoTime();
            }
            System.out.println("Temos varias opcoes de aposta em cima do" + jogo.getTimeCasa().getNome() + " . A ODD do time é de: " + jogo.getTimeCasa().getOdd());
            System.out.println("Antes de fazer a aposta gostaria de saber");
            System.out.println("cartao - aposta em quantos cartoes o " + jogo.getTimeCasa().getNome() + " pode ter nesse jogo");
            System.out.println("gol - aposta em quantos gols o " + jogo.getTimeCasa().getNome() + "  pode fazer nesse jogo");
            System.out.println("escanteio - aposta em quantos escanteios o " + jogo.getTimeCasa().getNome() + " pode ter a favor dele nesse jogo");
            System.out.println("finalizacao - aposta em quantas finalizacoes o " + jogo.getTimeCasa().getNome() + " pode fazer nesse jogo");
            System.out.println("falta - aposta em quantas falta o " + jogo.getTimeVisita().getNome() + " pode fazer nesse jogo");
            sc.nextLine();
            aposta = sc.nextLine();


            System.out.println("Favor insira o valor da aposta e quantidade possivel de" + aposta);
            System.out.println("Favor insira valor:");
            valor = sc.nextDouble();
            System.out.println("Favor insira a quantidade de " + aposta + "que o " + jogo.getTimeCasa().getNome() + " pode ter:");
            quant = sc.nextInt();
            c.fazerAposta(jogo, valor, c, quant, aposta, jogo.getTimeCasa().getNome());

        }

        if (tipo == 2) {
            System.out.println("Antes de fazer a aposta gostaria de saber informacoes do" + jogo.getTimeVisita().getNome() + "? SIM ou NAO - 1 ou 0 ");
            // Informaçoes do Corinthians - TITULOS - ESCALACAO
            flag1 = sc.nextInt();
            if (flag1 == 1) {
                jogo.getTimeVisita().infoTime();
            }
            System.out.println("Temos varias opcoes de aposta em cima do" + jogo.getTimeVisita().getNome() + " . A ODD do time é de: " + jogo.getTimeVisita().getOdd());
            System.out.println("Antes de fazer a aposta gostaria de saber");
            System.out.println("cartao - aposta em quantos cartoes o " + jogo.getTimeVisita().getNome() + " pode ter nesse jogo");
            System.out.println("gol - aposta em quantos gols o " + jogo.getTimeVisita().getNome() + "  pode fazer nesse jogo");
            System.out.println("escanteio - aposta em quantos escanteios o " + jogo.getTimeVisita().getNome() + " pode ter a favor dele nesse jogo");
            System.out.println("finalizacao - aposta em quantas finalizacoes o " + jogo.getTimeVisita().getNome() + " pode fazer nesse jogo");
            System.out.println("falta - aposta em quantas falta o " + jogo.getTimeVisita().getNome() + " pode fazer nesse jogo");
            sc.nextLine();
            aposta = sc.nextLine();


            System.out.println("Favor insira o valor da aposta e quantidade possivel de" + aposta);
            System.out.println("Favor insira valor:");
            valor = sc.nextDouble();
            System.out.println("Favor insira a quantidade de  que o " + jogo.getTimeVisita().getNome() + " pode ter:");
            quant = sc.nextInt();
            c.fazerAposta(jogo, valor, c, quant, aposta, jogo.getTimeVisita().getNome());

        }

    }
}


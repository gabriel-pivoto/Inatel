package Controller;

import Model.*;

import java.io.*;
import java.util.ArrayList;

public class Arquivo {
    // Metodo que inseri a aposta
    public void escrevendoAposta(int quant, Jogo jogo, String aposta, String nomeTime, Conta c) {
        OutputStream os = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            os = new FileOutputStream("C:\\Users\\gabri\\OneDrive\\Área de Trabalho/aposta.txt", true);
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);


            bw.write("Aposta do jogo " + jogo.getTimeCasa().getNome() + " contra " + jogo.getTimeVisita().getNome() + " no " + jogo.getCampeonato());
            bw.newLine();
            if (jogo.getTimeCasa().getNome() == nomeTime) {
                switch (aposta) {
                    case "gol":
                        // Escrevendo os valores usando bw:
                        bw.write("Aposta pela quantidade de gol do " + jogo.getTimeCasa().getNome());
                        bw.newLine();
                        bw.write("Odd do " + jogo.getTimeCasa().getNome() + " é de: " + jogo.getTimeCasa().getOdd());
                        bw.newLine();
                        bw.write("Apostou " + c.ap.valorAposta + " R$ pela quantidade de " + aposta + ": " + quant + "\n");
                        break;
                    case "finalizacao":
                        bw.write("Aposta pela quantidade de gols do " + jogo.getTimeCasa().getNome());
                        bw.newLine();
                        bw.write("Odd do " + jogo.getTimeCasa().getNome() + " é de: " + jogo.getTimeCasa().getOdd());
                        bw.newLine();
                        bw.write("Apostou " + c.ap.valorAposta + " R$ pela quantidade de " + aposta + ": " + quant + "\n");
                        break;

                    case "escanteio":
                        bw.write("Aposta pela quantidade de escanteio do " + jogo.getTimeCasa().getNome());
                        bw.newLine();
                        bw.write("Odd do " + jogo.getTimeCasa().getNome() + " é de: " + jogo.getTimeCasa().getOdd());
                        bw.newLine();
                        bw.write("Apostou " + c.ap.valorAposta + " R$ pela quantidade de " + aposta + ": " + quant + "\n");
                        break;

                    case "falta":
                        bw.write("Aposta pela quantidade de falta do " + jogo.getTimeCasa().getNome());
                        bw.newLine();
                        bw.write("Odd do " + jogo.getTimeCasa().getNome() + " é de: " + jogo.getTimeCasa().getOdd());
                        bw.newLine();
                        bw.write("Apostou " + c.ap.valorAposta + " R$ pela quantidade de " + aposta + ": " + quant + "\n");
                        break;
                    case "cartao":
                        bw.write("Aposta pela quantidade de cartao do " + jogo.getTimeCasa().getNome());
                        bw.newLine();
                        bw.write("Odd do " + jogo.getTimeCasa().getNome() + " é de: " + jogo.getTimeCasa().getOdd());
                        bw.newLine();
                        bw.write("Apostou " + c.ap.valorAposta + " R$ pela quantidade de " + aposta + ": " + quant + "\n");
                        break;
                }
            } else {
                switch (aposta) {
                    case "gol":
                        // Escrevendo os valores usando bw:
                        bw.write("Aposta pela quantidade de gol do " + jogo.getTimeVisita().getNome());
                        bw.newLine();
                        bw.write("Odd do " + jogo.getTimeVisita().getNome() + " é de: " + jogo.getTimeVisita().getOdd());
                        bw.newLine();
                        bw.write("Apostou " + c.ap.valorAposta + " R$ pela quantidade de " + aposta + ": " + quant + "\n");
                        break;
                    case "finalizacao":
                        bw.write("Aposta pela quantidade de gols do " + jogo.getTimeVisita().getNome());
                        bw.newLine();
                        bw.write("Odd do " + jogo.getTimeVisita().getNome() + " é de: " + jogo.getTimeVisita().getOdd());
                        bw.newLine();
                        bw.write("Apostou " + c.ap.valorAposta + " R$ pela quantidade de " + aposta + ": " + quant + "\n");
                        break;

                    case "escanteio":
                        bw.write("Aposta pela quantidade de escanteio do " + jogo.getTimeVisita().getNome());
                        bw.newLine();
                        bw.write("Odd do " + jogo.getTimeVisita().getNome() + " é de: " + jogo.getTimeVisita().getOdd());
                        bw.newLine();
                        bw.write("Apostou " + c.ap.valorAposta + " R$ pela quantidade de " + aposta + ": " + quant + "\n");
                        break;

                    case "falta":
                        bw.write("Aposta pela quantidade de falta do " + jogo.getTimeVisita().getNome());
                        bw.newLine();
                        bw.write("Odd do " + jogo.getTimeVisita().getNome() + " é de: " + jogo.getTimeVisita().getOdd());
                        bw.newLine();
                        bw.write("Apostou " + c.ap.valorAposta + " R$ pela quantidade de " + aposta + ": " + quant + "\n");
                        break;
                    case "cartao":
                        bw.write("Aposta pela quantidade de cartao do " + jogo.getTimeVisita().getNome());
                        bw.newLine();
                        bw.write("Odd do " + jogo.getTimeVisita().getNome() + " é de: " + jogo.getTimeVisita().getOdd());
                        bw.newLine();
                        bw.write("Apostou " + c.ap.valorAposta + " R$ pela quantidade de " + aposta + ": " + quant + "\n");
                        break;
                }
            }


        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (bw != null)
                    bw.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    // metodo que inseri no arquivo as informações do usuario
    public void perfil(Conta c) {
        OutputStream os = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            os = new FileOutputStream("C:\\Users\\gabri\\OneDrive\\Área de Trabalho/aposta.txt", true);
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);

            bw.write("Perfil do usuario");
            bw.newLine();
            bw.write("Nome do usuario: " + c.getNome());
            bw.newLine();
            bw.write("Idade do usuario: " + c.getIdade());
            bw.newLine();
            bw.write("CPF do usuario: " + c.getCpf());
            bw.newLine();
            bw.write("Email do usuario: " + c.getEmail());
            bw.newLine();
            bw.write("Saldo do usuario: " + c.getSaldo() + "R$");
            bw.newLine();
            bw.write("  ");
            bw.newLine();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (bw != null)
                    bw.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    //// Metodo que mostra saldo final do usuario
    public void resultado(Conta c, double valorFinal, double valorAposta) {
        OutputStream os = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            os = new FileOutputStream("C:\\Users\\gabri\\OneDrive\\Área de Trabalho/aposta.txt", true);
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);

            bw.write("Valor total das " + Conta.quantGanho + " apostas que foram feitas: " + valorAposta + "R$");
            bw.newLine();
            bw.write("Valor total dos ganhos das apostas que foram feitas " + String.format("%." + 2 + "f", valorFinal) + "R$");
            bw.newLine();
            bw.write("Saldo da conta depois dos ganhos e perdas das apostas: " + String.format("%." + 2 + "f", c.getSaldo()) + "R$");
            bw.newLine();

        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (bw != null)
                    bw.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    // Metodo que mostra o resultado do Jogo
    public void resultadoPartida(Jogo jogo, boolean vitoriaCasa, boolean empate) {
        OutputStream os = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            os = new FileOutputStream("C:\\Users\\gabri\\OneDrive\\Área de Trabalho/aposta.txt", true);
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);
            bw.write("  ");
            bw.newLine();
            bw.write("Resutaldo da partida: " + jogo.getTimeCasa().getNome() + "   X   " + jogo.getTimeVisita().getNome() + " no/na " + jogo.getCampeonato());
            bw.newLine();
            if (vitoriaCasa == true && empate == false) {
                bw.write("Nesse jogo " + jogo.getTimeCasa().getNome() + " venceu o " + jogo.getTimeVisita().getNome() + " de " + jogo.getTimeCasa().gol + "X" + jogo.getTimeVisita().gol);
                bw.newLine();
            }
            if (vitoriaCasa == false && empate == true) {
                bw.write("Nesse jogo " + jogo.getTimeCasa().getNome() + " empatou com o " + jogo.getTimeVisita().getNome() + " de " + jogo.getTimeCasa().gol + "X" + jogo.getTimeVisita().gol);
                bw.newLine();
            }
            if (vitoriaCasa == false && empate == false) {
                bw.write("Nesse jogo " + jogo.getTimeCasa().getNome() + " perdeu para o " + jogo.getTimeVisita().getNome() + " de " + jogo.getTimeCasa().gol + "X" + jogo.getTimeVisita().gol);
                bw.newLine();
            }
            String aux = jogo.getTimeCasa().getNome();
            String espaco = " ".repeat(23 - aux.length());
            bw.write(aux + espaco + "X          " + jogo.getTimeVisita().getNome());
            bw.newLine();
            aux = "Gols : " + jogo.getTimeCasa().gol;
            espaco = " ".repeat(23 - aux.length());
            bw.write(aux + espaco + "X          Gols :" + jogo.getTimeVisita().gol);
            bw.newLine();

            aux = "Finalizacao : " + jogo.getTimeCasa().finalizacao;
            espaco = " ".repeat(23 - aux.length());
            bw.write(aux + espaco + "X          Finalizacao : " + jogo.getTimeVisita().finalizacao);
            bw.newLine();

            aux = "Escanteios : " + jogo.getTimeCasa().escanteio;
            espaco = " ".repeat(23 - aux.length());
            bw.write(aux + espaco + "X          Escanteios : " + jogo.getTimeVisita().escanteio);
            bw.newLine();

            aux = "Faltas : " + jogo.getTimeCasa().falta;
            espaco = " ".repeat(23 - aux.length());
            bw.write(aux + espaco + "X          Faltas : " + jogo.getTimeVisita().falta);
            bw.newLine();
            aux = "Cartoes : " + jogo.getTimeCasa().cartao;
            espaco = " ".repeat(23 - aux.length());
            bw.write(aux + espaco + "X          Cartoes : " + jogo.getTimeVisita().cartao);
            bw.newLine();
            bw.write("  ");
            bw.newLine();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (bw != null)
                    bw.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    //// Metodo que inseri no arquivo ganhos e perdas
    public void ganhoOuNao(Jogo jogo, Conta c, boolean flag, String aposta, String nomeTime, int quant, double ganho) {
        OutputStream os = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            os = new FileOutputStream("C:\\Users\\gabri\\OneDrive\\Área de Trabalho/aposta.txt", true);
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);
            if (jogo.getTimeCasa().getNome() == nomeTime) {
                if (flag) {
                    bw.write("Ganhou a aposta de " + aposta + " do time " + jogo.getTimeCasa().getNome());
                    bw.newLine();
                    bw.write("Apostou " + quant + " de " + aposta + ". Lucro dessa aposta foi de:" + String.format("%." + 2 + "f", ganho) + "R$");
                    bw.newLine();
                    //String.format("%." + 2 + "f", ganho)
                } else {
                    switch (aposta) {
                        case "gol":
                            bw.write("Perdeu a aposta de " + aposta + " do time " + jogo.getTimeCasa().getNome());
                            bw.newLine();
                            bw.write("Apostou " + quant + " de " + aposta + ". Porem o time fez " + jogo.getTimeCasa().gol + " gol no jogo");
                            bw.newLine();
                            bw.write("Ganho  dessa aposta foi de: 0.00R$");
                            bw.newLine();
                            break;
                        case "finalizacao":
                            bw.write("Perdeu a aposta de " + aposta + " do time " + jogo.getTimeCasa().getNome());
                            bw.newLine();
                            bw.write("Apostou " + quant + " de " + aposta + ". Porem o time fez " + jogo.getTimeCasa().finalizacao + " finalizacao no jogo");
                            bw.newLine();
                            bw.write("Ganho  dessa aposta foi de: 0.00R$");
                            bw.newLine();
                            break;
                        case "escanteio":
                            bw.write("Perdeu a aposta de " + aposta + " do time " + jogo.getTimeCasa().getNome());
                            bw.newLine();
                            bw.write("Apostou " + quant + " de " + aposta + ". Porem o time teve " + jogo.getTimeCasa().escanteio + " escanteio no jogo");
                            bw.newLine();
                            bw.write("Ganho  dessa aposta foi de: 0.00R$");
                            bw.newLine();
                            break;
                        case "falta":
                            bw.write("Perdeu a aposta de " + aposta + " do time " + jogo.getTimeCasa().getNome());
                            bw.newLine();
                            bw.write("Apostou " + quant + " de " + aposta + ". Porem o time fez " + jogo.getTimeCasa().falta + " falta no jogo");
                            bw.newLine();
                            bw.write("Ganho  dessa aposta foi de: 0.00R$");
                            bw.newLine();
                            break;
                        case "cartao":
                            bw.write("Perdeu a aposta de " + aposta + " do time " + jogo.getTimeCasa().getNome());
                            bw.newLine();
                            bw.write("Apostou " + quant + " de " + aposta + ". Porem o time tomou " + jogo.getTimeCasa().cartao + " cartao no jogo");
                            bw.newLine();
                            bw.write("Ganho  dessa aposta foi de: 0.00R$");
                            bw.newLine();
                            break;
                    }
                }
            } else {
                if (flag) {
                    bw.write("Ganhou a aposta de " + aposta + " do time " + jogo.getTimeVisita().getNome());
                    bw.newLine();
                    bw.write("Apostou " + quant + " de " + aposta + ". Lucro dessa aposta foi de:" + String.format("%." + 2 + "f", ganho) + "R$");
                    bw.newLine();
                } else {
                    switch (aposta) {
                        case "gol":
                            bw.write("Perdeu a aposta de " + aposta + " do time " + jogo.getTimeVisita().getNome());
                            bw.newLine();
                            bw.write("Apostou " + quant + " de " + aposta + ". Porem o time fez " + jogo.getTimeVisita().gol + " gol no jogo");
                            bw.newLine();
                            bw.write("Ganho  dessa aposta foi de: 0.00R$");
                            bw.newLine();
                            break;
                        case "finalizacao":
                            bw.write("Perdeu a aposta de " + aposta + " do time " + jogo.getTimeVisita().getNome());
                            bw.newLine();
                            bw.write("Apostou " + quant + " de " + aposta + ". Porem o time fez " + jogo.getTimeVisita().finalizacao + " finalizacao no jogo");
                            bw.newLine();
                            bw.write("Ganho  dessa aposta foi de: 0.00R$");
                            bw.newLine();
                            break;
                        case "escanteio":
                            bw.write("Perdeu a aposta de " + aposta + " do time " + jogo.getTimeVisita().getNome());
                            bw.newLine();
                            bw.write("Apostou " + quant + " de " + aposta + ". Porem o time teve " + jogo.getTimeVisita().escanteio + " escanteio no jogo");
                            bw.newLine();
                            bw.write("Ganho  dessa aposta foi de: 0.00R$");
                            bw.newLine();
                            break;
                        case "falta":
                            bw.write("Perdeu a aposta de " + aposta + " do time " + jogo.getTimeVisita().getNome());
                            bw.newLine();
                            bw.write("Apostou " + quant + " de " + aposta + ". Porem o time fez " + jogo.getTimeVisita().falta + " falta no jogo");
                            bw.newLine();
                            bw.write("Ganho  dessa aposta foi de: 0.00R$");
                            bw.newLine();
                            break;
                        case "cartao":
                            bw.write("Perdeu a aposta de " + aposta + " do time " + jogo.getTimeVisita().getNome());
                            bw.newLine();
                            bw.write("Apostou " + quant + " de " + aposta + ". Porem o time tomou " + jogo.getTimeVisita().cartao + " tomou no jogo");
                            bw.newLine();
                            bw.write("Ganho  dessa aposta foi de: 0.00R$");
                            bw.newLine();
                            break;
                    }
                }
            }
            bw.write("  ");
            bw.newLine();
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                if (bw != null)
                    bw.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }

    }

}
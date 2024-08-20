package Controller;

import Model.*;

import java.io.*;
import java.util.ArrayList;

public class Arquivo {
    public void cartaoTime(int quant, Jogo jogo, String aposta, String nomeTime, Conta usuario1) {
        OutputStream os = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            os = new FileOutputStream("C:\\Users\\Davi  Gay\\Desktop\\teste/aposta.txt", true);
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
                        bw.write("Apostou " + usuario1.ap.valorAposta + " R$ pela quantidade de " + aposta+": " + quant + "\n");
                        break;
                    case "finalizacao":
                        bw.write("Aposta pela quantidade de gols do " + jogo.getTimeCasa().getNome());
                        bw.newLine();
                        bw.write("Odd do " + jogo.getTimeCasa().getNome() + " é de: " + jogo.getTimeCasa().getOdd());
                        bw.newLine();
                        bw.write("Apostou " + usuario1.ap.valorAposta + " R$ pela quantidade de " +aposta+ ": " + quant + "\n");
                        break;

                    case "escanteio":
                        bw.write("Aposta pela quantidade de escanteio do " + jogo.getTimeCasa().getNome());
                        bw.newLine();
                        bw.write("Odd do " + jogo.getTimeCasa().getNome() + " é de: " + jogo.getTimeCasa().getOdd());
                        bw.newLine();
                        bw.write("Apostou " + usuario1.ap.valorAposta + " R$ pela quantidade de " +aposta+ ": " + quant + "\n");
                        break;

                    case "falta":
                        bw.write("Aposta pela quantidade de falta do " + jogo.getTimeCasa().getNome());
                        bw.newLine();
                        bw.write("Odd do " + jogo.getTimeCasa().getNome() + " é de: " + jogo.getTimeCasa().getOdd());
                        bw.newLine();
                        bw.write("Apostou " + usuario1.ap.valorAposta + " R$ pela quantidade de " +aposta+ ": " + quant + "\n");
                        break;
                    case "cartao":
                        bw.write("Aposta pela quantidade de cartao do " + jogo.getTimeCasa().getNome());
                        bw.newLine();
                        bw.write("Odd do " + jogo.getTimeCasa().getNome() + " é de: " + jogo.getTimeCasa().getOdd());
                        bw.newLine();
                        bw.write("Apostou " + usuario1.ap.valorAposta + " R$ pela quantidade de " +aposta+ ": "  + quant + "\n");
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
                        bw.write("Apostou " + usuario1.ap.valorAposta + " R$ pela quantidade de " +aposta+ ": " + quant + "\n");
                        break;
                    case "finalizacao":
                        bw.write("Aposta pela quantidade de gols do " + jogo.getTimeVisita().getNome());
                        bw.newLine();
                        bw.write("Odd do " + jogo.getTimeVisita().getNome() + " é de: " + jogo.getTimeVisita().getOdd());
                        bw.newLine();
                        bw.write("Apostou " + usuario1.ap.valorAposta + " R$ pela quantidade de " +aposta+ ": "  + quant + "\n");
                        break;

                    case "escanteio":
                        bw.write("Aposta pela quantidade de escanteio do " + jogo.getTimeVisita().getNome());
                        bw.newLine();
                        bw.write("Odd do " + jogo.getTimeVisita().getNome() + " é de: " + jogo.getTimeVisita().getOdd());
                        bw.newLine();
                        bw.write("Apostou " + usuario1.ap.valorAposta + " R$ pela quantidade de " +aposta+ ": " + quant + "\n");
                        break;

                    case "falta":
                        bw.write("Aposta pela quantidade de falta do " + jogo.getTimeVisita().getNome());
                        bw.newLine();
                        bw.write("Odd do " + jogo.getTimeVisita().getNome() + " é de: " + jogo.getTimeVisita().getOdd());
                        bw.newLine();
                        bw.write("Apostou " + usuario1.ap.valorAposta + " R$ pela quantidade de " +aposta+ ": " + quant + "\n");
                        break;
                    case "cartao":
                        bw.write("Aposta pela quantidade de cartao do " + jogo.getTimeVisita().getNome());
                        bw.newLine();
                        bw.write("Odd do " + jogo.getTimeVisita().getNome() + " é de: " + jogo.getTimeVisita().getOdd());
                        bw.newLine();
                        bw.write("Apostou " + usuario1.ap.valorAposta + " R$ pela quantidade de " +aposta+ ": "  + quant + "\n");
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

    public void perfil(Conta usuario1) {
        OutputStream os = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            os = new FileOutputStream("C:\\Users\\gabri\\OneDrive\\Área de Trabalho/ApostasDavibet.txt", true);
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);

            bw.write("Perfil do usuario");
            bw.newLine();
            bw.write("Nome do usuario: " + usuario1.getNome());
            bw.newLine();
            bw.write("Idade do usuario: " + usuario1.getIdade());
            bw.newLine();
            bw.write("CPF do usuario: " + usuario1.getCpf());
            bw.newLine();
            bw.write("Email do usuario: " + usuario1.getEmail());
            bw.newLine();
            bw.write("Saldo do usuario: " + usuario1.getSaldo() + "R$");
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
    public void resultado(Conta usuario1, double valorFinal, int quantGanho, double valorAposta) {
        OutputStream os = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            os = new FileOutputStream("C:\\Users\\gabri\\OneDrive\\Área de Trabalho/ApostasDavibet.txt", true);
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);

            bw.write("Valor total das " + Conta.quantGanho + " apostas que foram feitas: " + valorAposta + "R$");
            bw.newLine();
            bw.write("Valor total dos ganhos das apostas que foram feitas "  + valorFinal + "R$");
            bw.newLine();
            bw.write("Saldo da conta depois dos ganhos e perdas das apostas: " + usuario1.getSaldo() + "R$");
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

    public void resultadoPartida(Jogo jogo, boolean vitoriaCasa, boolean empate) {
        OutputStream os = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            os = new FileOutputStream("C:\\Users\\gabri\\OneDrive\\Área de Trabalho/ApostasDavibet.txt", true);
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);
            bw.write("  ");
            bw.newLine();
            bw.write("Resutaldo da partida: " + jogo.getTimeCasa().getNome() + "   X   " + jogo.getTimeVisita().getNome() + " no/na " + jogo.getCampeonato());
            bw.newLine();
            if(vitoriaCasa == true && empate == false){
                bw.write("Nesse jogo " + jogo.getTimeCasa().getNome() + " venceu o " + jogo.getTimeVisita().getNome() + " de "  +jogo.getTimeCasa().gol +"X" + jogo.getTimeVisita().gol);
                bw.newLine();
            }
            if(vitoriaCasa == false && empate == true){
                bw.write("Nesse jogo " + jogo.getTimeCasa().getNome() + " empatou com o " + jogo.getTimeVisita().getNome() + " de "  +jogo.getTimeCasa().gol +"X" + jogo.getTimeVisita().gol);
                bw.newLine();
            }
            if(vitoriaCasa == false && empate == false) {
                bw.write("Nesse jogo " + jogo.getTimeCasa().getNome() + " perdeu para o " + jogo.getTimeVisita().getNome() + " de "  +jogo.getTimeCasa().gol +"X" + jogo.getTimeVisita().gol);
                bw.newLine();
            }

            bw.write( jogo.getTimeCasa().getNome() + "            X          " + jogo.getTimeVisita().getNome());
            bw.newLine();
            bw.write("Gols : " + jogo.getTimeCasa().gol + "               X          Gols :" +jogo.getTimeVisita().gol);
            bw.newLine();

            bw.write("Finalizacao : " + jogo.getTimeCasa().finalizacao + "       X          Finalizacao : " +jogo.getTimeVisita().finalizacao);
            bw.newLine();

            bw.write("Escanteios : " + jogo.getTimeCasa().escanteio + "         X          Escanteios : " +jogo.getTimeVisita().escanteio);
            bw.newLine();

            bw.write("Faltas : " + jogo.getTimeCasa().falta + "             X          Faltas : " +jogo.getTimeVisita().falta);
            bw.newLine();

            bw.write("Cartoes : " + jogo.getTimeCasa().cartao + "            X          Cartoes : " +jogo.getTimeVisita().cartao);
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
    public void ganhoOuNao(Jogo jogo, Conta usuario1, boolean flag, String aposta, String nomeTime, int quant, double ganho) {
        OutputStream os = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            os = new FileOutputStream("C:\\Users\\gabri\\OneDrive\\Área de Trabalho/ApostasDavibet.txt", true);
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);
            if (jogo.getTimeCasa().getNome() == nomeTime) {
                if (flag) {
                    bw.write("Ganhou a aposta de " + aposta + " do time " + jogo.getTimeCasa().getNome());
                    bw.newLine();
                    bw.write("Apostou " + quant + " de " + aposta + ". Lucro dessa aposta foi de:" + ganho + "R$");
                    bw.newLine();
                } else {
                    switch (aposta) {
                        case "gol":
                            bw.write("Perdeu a aposta de " + aposta + " do time " + jogo.getTimeCasa().getNome());
                            bw.newLine();
                            bw.write("Apostou " + quant + " de " + aposta + ". Porem o time fez " + jogo.getTimeCasa().gol + " no jogo");
                            bw.newLine();
                            bw.write("Ganho  dessa aposta foi de: 0.00R$");
                            bw.newLine();
                            break;
                        case "finalizacao":
                            bw.write("Perdeu a aposta de " + aposta + " do time " + jogo.getTimeCasa().getNome());
                            bw.newLine();
                            bw.write("Apostou " + quant + " de " + aposta + ". Porem o time fez " + jogo.getTimeCasa().finalizacao + " no jogo");
                            bw.newLine();
                            bw.write("Ganho  dessa aposta foi de: 0.00R$");
                            bw.newLine();
                            break;
                        case "escanteio":
                            bw.write("Perdeu a aposta de " + aposta + " do time " + jogo.getTimeCasa().getNome());
                            bw.newLine();
                            bw.write("Apostou " + quant + " de " + aposta + ". Porem o time fez " + jogo.getTimeCasa().escanteio + " no jogo");
                            bw.newLine();
                            bw.write("Ganho  dessa aposta foi de: 0.00R$");
                            bw.newLine();
                            break;
                        case "falta":
                            bw.write("Perdeu a aposta de " + aposta + " do time " + jogo.getTimeCasa().getNome());
                            bw.newLine();
                            bw.write("Apostou " + quant + " de " + aposta + ". Porem o time fez " + jogo.getTimeCasa().falta + " no jogo");
                            bw.newLine();
                            bw.write("Ganho  dessa aposta foi de: 0.00R$");
                            bw.newLine();
                            break;
                        case "cartao":
                            bw.write("Perdeu a aposta de " + aposta + " do time " + jogo.getTimeCasa().getNome());
                            bw.newLine();
                            bw.write("Apostou " + quant + " de " + aposta + ". Porem o time fez " + jogo.getTimeCasa().cartao + " no jogo");
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
                    bw.write("Apostou " + quant + " de " + aposta + ". Lucro dessa aposta foi de:" + ganho + "R$");
                    bw.newLine();
                } else {
                    switch (aposta) {
                        case "gol":
                            bw.write("Perdeu a aposta de " + aposta + " do time " + jogo.getTimeVisita().getNome());
                            bw.newLine();
                            bw.write("Apostou " + quant + " de " + aposta + ". Porem o time fez " + jogo.getTimeVisita().gol + " no jogo");
                            bw.newLine();
                            bw.write("Ganho  dessa aposta foi de: 0.00R$");
                            bw.newLine();
                            break;
                        case "finalizacao":
                            bw.write("Perdeu a aposta de " + aposta + " do time " + jogo.getTimeVisita().getNome());
                            bw.newLine();
                            bw.write("Apostou " + quant + " de " + aposta + ". Porem o time fez " + jogo.getTimeVisita().finalizacao + " no jogo");
                            bw.newLine();
                            bw.write("Ganho  dessa aposta foi de: 0.00R$");
                            bw.newLine();
                            break;
                        case "escanteio":
                            bw.write("Perdeu a aposta de " + aposta + " do time " + jogo.getTimeVisita().getNome());
                            bw.newLine();
                            bw.write("Apostou " + quant + " de " + aposta + ". Porem o time fez " + jogo.getTimeVisita().escanteio + " no jogo");
                            bw.newLine();
                            bw.write("Ganho  dessa aposta foi de: 0.00R$");
                            bw.newLine();
                            break;
                        case "falta":
                            bw.write("Perdeu a aposta de " + aposta + " do time " + jogo.getTimeVisita().getNome());
                            bw.newLine();
                            bw.write("Apostou " + quant + " de " + aposta + ". Porem o time fez " + jogo.getTimeVisita().falta + " no jogo");
                            bw.newLine();
                            bw.write("Ganho  dessa aposta foi de: 0.00R$");
                            bw.newLine();
                            break;
                        case "cartao":
                            bw.write("Perdeu a aposta de " + aposta + " do time " + jogo.getTimeVisita().getNome());
                            bw.newLine();
                            bw.write("Apostou " + quant + " de " + aposta + ". Porem o time fez " + jogo.getTimeVisita().cartao + " no jogo");
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
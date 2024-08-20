package Controller;

import Model.*;

import java.io.*;
import java.util.ArrayList;

public class Arquivo {
    public void cartaoTime(int quant, Time time, int tipo) {
        OutputStream os = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            os = new FileOutputStream("C:\\Users\\Davi  Gay\\Desktop\\DaviRosaGomes_HenriqueRodriguesMendonça 1/aposta.txt", true);
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);

            if (time instanceof Corinthians || time instanceof ManschesterCity) {
                bw.write("Aposta do jogo Corinthians contra Manschester city no mudial de Clubes na Arabia Saudita");
                bw.newLine();
                // Caso o time é o Corinthians
                if (time instanceof Corinthians) {
                    Corinthians corinthians = (Corinthians) time;
                    switch (tipo) {
                        case 0:
                            // Escrevendo os valores usando bw:
                            bw.write("Aposta pela quantidade de cartão do " + corinthians.nome);
                            bw.newLine();
                            bw.write("Odd do time: " + corinthians.odd);
                            bw.newLine();
                            bw.write("Apostou " + Conta.valor1 + " R$ pela quantidade de cartão: " + quant + "\n");
                            break;
                        case 1:
                            bw.write("Aposta pela quantidade de gols do " + corinthians.nome);
                            bw.newLine();
                            bw.write("Odd do time: " + corinthians.odd);
                            bw.newLine();
                            bw.write("Apostou " + Conta.valor1 + " R$ pela quantidade de gols: " + quant + "\n");
                            break;

                        case 2:
                            bw.write("Aposta pela quantidade de escandeio do " + corinthians.nome);
                            bw.newLine();
                            bw.write("Odd do time: " + corinthians.odd);
                            bw.newLine();
                            bw.write("Apostou " + Conta.valor1 + " R$ pela quantidade de escandeio: " + quant + "\n");
                            break;

                        case 3:
                            bw.write("Aposta pela quantidade de finalizacoes do " + corinthians.nome);
                            bw.newLine();
                            bw.write("Odd do time: " + corinthians.odd);
                            bw.newLine();
                            bw.write("Apostou " + Conta.valor1 + " R$ pela quantidade de finalizacoes: " + quant + "\n");
                            break;


                    }
                }
                // Caso o time é o Manchester City
                if (time instanceof ManschesterCity) {
                    ManschesterCity manschester = (ManschesterCity) time;
                    switch (tipo) {
                        case 0:
                            // Escrevendo os valores usando bw:
                            bw.write("Aposta pela quantidade de cartão do " + manschester.nome);
                            bw.newLine();
                            bw.write("Odd do time: " + manschester.odd);
                            bw.newLine();
                            bw.write("Apostou " + Conta.valor1 + " R$ pela quantidade de cartão: " + quant + "\n");
                            break;
                        case 1:
                            bw.write("Aposta pela quantidade de gols do " + manschester.nome);
                            bw.newLine();
                            bw.write("Odd do time: " + manschester.odd);
                            bw.newLine();
                            bw.write("Apostou " + Conta.valor1 + " R$ pela quantidade de gols: " + quant + "\n");
                            break;
                        case 2:
                            bw.write("Aposta pela quantidade de escandeio do " + manschester.nome);
                            bw.newLine();
                            bw.write("Odd do time: " + manschester.odd);
                            bw.newLine();
                            bw.write("Apostou " + Conta.valor1 + " R$ pela quantidade de escandeio: " + quant + "\n");
                            break;

                        case 3:
                            bw.write("Aposta pela quantidade de finalizacoes do " + manschester.nome);
                            bw.newLine();
                            bw.write("Odd do time: " + manschester.odd);
                            bw.newLine();
                            bw.write("Apostou " + Conta.valor1 + " R$ pela quantidade de finalizacoes: " + quant + "\n");
                            break;

                    }
                }
            }

                if (time instanceof Barcelona || time instanceof RealMadrid) {
                    bw.write("Aposta do jogo Real Madrid contra Barcelona na 10° rodada da LaLiga");
                    bw.newLine();
                    // Caso o time é o Corinthians
                    if (time instanceof Barcelona) {
                        Barcelona barcelona = (Barcelona) time;
                        switch (tipo) {
                            case 0:
                                // Escrevendo os valores usando bw:
                                bw.write("Aposta pela quantidade de cartão do " + barcelona.nome);
                                bw.newLine();
                                bw.write("Odd do time: " + barcelona.odd);
                                bw.newLine();
                                bw.write("Apostou " + Conta.valor1 + " R$ pela quantidade de cartão: " + quant + "\n");
                                break;
                            case 1:
                                bw.write("Aposta pela quantidade de gols do " + barcelona.nome);
                                bw.newLine();
                                bw.write("Odd do time: " + barcelona.odd);
                                bw.newLine();
                                bw.write("Apostou " + Conta.valor1 + " R$ pela quantidade de gols: " + quant + "\n");
                                break;

                            case 2:
                                bw.write("Aposta pela quantidade de escandeio do " + barcelona.nome);
                                bw.newLine();
                                bw.write("Odd do time: " + barcelona.odd);
                                bw.newLine();
                                bw.write("Apostou " + Conta.valor1 + " R$ pela quantidade de escandeio: " + quant + "\n");
                                break;

                            case 3:
                                bw.write("Aposta pela quantidade de finalizacoes do " + barcelona.nome);
                                bw.newLine();
                                bw.write("Odd do time: " + barcelona.odd);
                                bw.newLine();
                                bw.write("Apostou " + Conta.valor1 + " R$ pela quantidade de finalizacoes: " + quant + "\n");
                                break;


                        }
                    }
                    // Caso o time é o Manchester City
                    if (time instanceof RealMadrid) {
                        RealMadrid realMadrid = (RealMadrid) time;
                        switch (tipo) {
                            case 0:
                                // Escrevendo os valores usando bw:
                                bw.write("Aposta pela quantidade de cartão do " + realMadrid.nome);
                                bw.newLine();
                                bw.write("Odd do time: " + realMadrid.odd);
                                bw.newLine();
                                bw.write("Apostou " + Conta.valor1 + " R$ pela quantidade de cartão: " + quant + "\n");
                                break;
                            case 1:
                                bw.write("Aposta pela quantidade de gols do " + realMadrid.nome);
                                bw.newLine();
                                bw.write("Odd do time: " + realMadrid.odd);
                                bw.newLine();
                                bw.write("Apostou " + Conta.valor1 + " R$ pela quantidade de gols: " + quant + "\n");
                                break;
                            case 2:
                                bw.write("Aposta pela quantidade de escandeio do " + realMadrid.nome);
                                bw.newLine();
                                bw.write("Odd do time: " + realMadrid.odd);
                                bw.newLine();
                                bw.write("Apostou " + Conta.valor1 + " R$ pela quantidade de escandeio: " + quant + "\n");
                                break;

                            case 3:
                                bw.write("Aposta pela quantidade de finalizacoes do " + realMadrid.nome);
                                bw.newLine();
                                bw.write("Odd do time: " + realMadrid.odd);
                                bw.newLine();
                                bw.write("Apostou " + Conta.valor1 + " R$ pela quantidade de finalizacoes: " + quant + "\n");
                                break;

                        }
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

    public void perfil(Conta c) {
        OutputStream os = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            os = new FileOutputStream("C:\\Users\\Davi  Gay\\Desktop\\DaviRosaGomes_HenriqueRodriguesMendonça 1/aposta.txt", true);
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);


            bw.write("Nome do usuario: " + c.getNome());
            bw.newLine();
            bw.write("Idade do usuario: " + c.getIdade());
            bw.newLine();
            bw.write("CPF do usuario: " + c.getCpf());
            bw.newLine();
            bw.write("Email do usuario: " + c.getEmail());
            bw.newLine();
            bw.write("Saldo do usuario: " + c.getSaldo());
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
    public void resultado(Conta c, double valorFinal, int quantGanho, double valorAposta) {
        OutputStream os = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;
        try {
            os = new FileOutputStream("C:\\Users\\Davi  Gay\\Desktop\\DaviRosaGomes_HenriqueRodriguesMendonça 1/aposta.txt", true);
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);

            bw.write("Valor total das " + Conta.quantGanho + " apostas que foram feitas: " + valorAposta  + "R$" );
            bw.newLine();
            bw.write("Total de ganhos das " + Conta.quantGanho  + " apostas que foram feitas: " + valorFinal  + "R$" );
            bw.newLine();
            bw.write("Saldo da conta depois dos ganhos e perdas das apostas: " + c.getSaldo() + "R$");
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
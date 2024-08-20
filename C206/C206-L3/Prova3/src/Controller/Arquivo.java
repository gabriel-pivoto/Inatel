package Controller;

import Model.Professores;

import java.io.*;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;


public class Arquivo {

    public void escrever(Professores func){

        OutputStream os = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;

        // bloco try catch para caso tenha algo de errado na escrita do professores no arquivo.txt
        try{

            /* le o fluxo de bytes do arquivo com o nome que foi passado
            se o arquivo com esse nome nao existir, ele cria um com esse nome dentro
            das dependencias do projeto.
            Ja o append serve para: se for true, iremos apenas inserir os novos dados
            recebidos no final do arquivo, se for false, ele sobescreve o arquivo.
             */

            //os = new FileOutputStream("C:/Users/User/OneDrive/Área de Trabalho/Arquivo.txt", true);
            os = new FileOutputStream("Professores.txt", true);

            /*
            O outputStreamWrites recebe os caracteres digitados pelo usuário e os transforma em bytes
            para serem enviados.
             */
            osw = new OutputStreamWriter(os);

            /*
            o BufferedWriter recebe caracteres como entrada, armazena temporariamente
            esses caracteres em um buffer e, quando o buffer estiver cheio ou quando for solicitado
            escreve esses caracteres no fluxo de saída (osw).
            O fluxo de saída (osw) é responsável por converter esses caracteres em bytes
            usando uma codificação de caracteres específica e escrevê-los em um arquivo.
            Ou seja, o bw recebe os caracteres, os envia para o osw que os converte em bytes
            e os envia para o os, que é responsável por escrever bytes em um arquivo.
             */

            bw = new BufferedWriter(osw);

            // escrevendo os valores usando bw:
            bw.write("Professores");
            bw.newLine();
            bw.write(func.nome + "\n");
            bw.write(func.materia + "\n");
            bw.write(func.cpf + "\n");

        }catch(Exception e){
            System.out.println(e);

        }finally {
            // bloco try catch para tentar fechar a entrada de dados
            try {
                bw.close();
            }catch (Exception e){
                System.out.println(e);
            }

        }

    }


    public ArrayList<Professores> ler(){

        ArrayList<Professores> profs = new ArrayList<>();

        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;
        String linhaLer;

        // bloco try catch para tentar ler um arquivo
        try{

            /*
            o FileInputStream é responsável por ler os bytes de um arquivo
            cujo nome foi passado como parametro
             */

            // is = new FileInputStream("C:/Users/User/OneDrive/Área de Trabalho/Arquivo.txt");
            is = new FileInputStream("Professores.txt");

            /*
            O InputStreamReader é responsável por converter
            os bytes em caracteres
             */
            isr = new InputStreamReader(is);

            /*
            O BufferedReader que é responsável por ler os caracteres
            a partir do fluxo de entrada e armazená-los em um buffer temporário,
            a fim de melhorar a eficiência da leitura dos dados.
             */
            br = new BufferedReader(isr);


            linhaLer = br.readLine(); //le a primeira linha do arquivo para ver se tem professores cadastrados
            while(linhaLer != null){

                if(linhaLer.contains("Professores")){ // se conter professores, iremos ler as informações
                    Professores f = new Professores();
                    f.nome = br.readLine(); // le o nome que é uma string
                    f.materia = br.readLine(); // le a idade que é um int
                    f.cpf = br.readLine(); // le um cpf que é uma string
                    profs.add(f); // armazena as informações de funcionário em uma lista
                }
                linhaLer = br.readLine(); // pula pra proxima linha
            }

        }catch (Exception e){
            System.out.println(e);
        }finally {

            // bloco try catch para tentar fechar a leitura de dados
            try{
                br.close();
            }catch (Exception e){
                System.out.println(e);
            }
        }


        return profs;
    }


    public void remover(Professores func) {
        ArrayList<Professores> professores = ler(); // Lê todos os funcionários do arquivo

        /*
        O Iterator é uma interface em Java que permite percorrer uma coleção
         de elementos e realizar operações como remoção de elementos durante a iteração.
         Ele fornece métodos para percorrer os elementos da coleção de forma sequencial.
         */

        // Percorre a lista de funcionários e remove o funcionário desejado
        Iterator<Professores> iterator = professores.iterator();
        while (iterator.hasNext()) {
            Professores f = iterator.next();
            if (f.cpf.equals(func.cpf)) { // Verifica se o CPF corresponde ao funcionário a ser removido
                iterator.remove(); // Remove o funcionário da lista
                System.out.println("Professor removido!");
                break; // Sai do loop após remover o funcionário
            }
        }

        // Reescreve a lista atualizada no arquivo
        OutputStream os = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;

        try {
            os = new FileOutputStream("Professores.txt", false); // Sobrescreve o arquivo
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);

            for (Professores f : professores) {
                bw.write("Professores");
                bw.newLine();
                bw.write(f.nome + "\n");
                bw.write(f.materia + "\n");
                bw.write(f.cpf + "\n");
            }
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            try {
                bw.close();
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }




}

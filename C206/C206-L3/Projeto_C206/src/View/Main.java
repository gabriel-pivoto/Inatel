package View;

import Controller.Arquivo;
import Model.*;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        // VARIAVEIS
        Scanner sc = new Scanner(System.in);
        Arquivo arq1 = new Arquivo();

        // informaçoes dos times

        ////INFORMAÇOES DO TIME CORINTHIANS\\\\
        Time corinthians = new Time("Corinthians", 1.25);
        corinthians.setTitulos("2 - Mundias , 1 - Libertadores, 30 - Paulista, 7 - Brasileirao, 3 - Copa do Brasil");
        corinthians.setGoleiro("GOL - 12 Cassio");
        corinthians.setDefesa("D - Fabio Santos, D - 2 Rafael Ramos, D - 23 Fagner, D - 21 Matheus Bidu");
        corinthians.setMeia("M - 5 Fausto Vera, M - 20 Giuliano, M - 7 Maycon");
        corinthians.setAtaque("A - 10 Roger Guedes, A - 28 Adson, A - 9 Yuri Alberto");


        ////INFORMAÇOES DO TIME PALMEIRAS\\\\
        Time palmeiras = new Time("Palmeiras", 2.54);
        palmeiras.setTitulos("2 - Mundiais, 1 - Libertadores, 23 - Paulista, 10 - Brasileirão, 4 - Copa do Brasil");
        palmeiras.setGoleiro("GOL - 1 Weverton");
        palmeiras.setDefesa("D - 26 Marcos Rocha, D - 15 Gustavo Gómez, D - 3 Luan, D - 6 Victor Luis");
        palmeiras.setMeia("M - 28 Raphael Veiga, M - 5 Danilo, M - 18 Gustavo Scarpa");
        palmeiras.setAtaque("A - 7 Rony, A - 27 Luiz Adriano, A - 9 Deyverson");


        ////INFORMAÇOES DO TIME REAL MADRID\\\\
        Time realMadrid = new Time("Real Madrid", 1.59);
        realMadrid.setTitulos("27 - La Liga, 13 - Liga dos Campeões, 19 - Copa del Rey, 4 - Mundiais");
        realMadrid.setGoleiro("GOL - 1 Thibaut Courtois");
        realMadrid.setDefesa("D - 2 Dani Carvajal, D - 5 Raphael Varane, D - 6 Nacho, D - 12 Marcelo");
        realMadrid.setMeia("M - 8 Toni Kroos, M - 14 Casemiro, M - 22 Isco");
        realMadrid.setAtaque("A - 9 Karim Benzema, A - 11 Gareth Bale, A - 20 Vinicius Junior");


        ////INFORMAÇOES DO TIME BARCELONA\\\\
        Time barcelona = new Time("Barcelona", 3.75);
        barcelona.setTitulos("26 - La Liga, 5 - Liga dos Campeões, 31 - Copa del Rey, 3 - Mundiais");
        barcelona.setGoleiro("GOL - 1 Marc-André ter Stegen");
        barcelona.setDefesa("D - 20 Sergi Roberto, D - 3 Gerard Piqué, D - 15 Clément Lenglet, D - 18 Jordi Alba");
        barcelona.setMeia("M - 5 Sergio Busquets, M - 8 Frenkie de Jong, M - 21 Pedri");
        barcelona.setAtaque("A - 10 Lionel Messi, A - 7 Antoine Griezmann, A - 11 Ousmane Dembélé");


        ////INFORMAÇOES DO TIME VASCO\\\\
        Time vasco = new Time("Vasco", 3.0);
        vasco.setTitulos("1 - Mundial, 1 - Libertadores, 24 - Carioca, 4 - Brasileirão, 3 - Copa do Brasil");
        vasco.setGoleiro("GOL - 1 Vanderlei");
        vasco.setDefesa("D - 22 Léo Matos, D - 3 Ernando, D - 4 Leandro Castan, D - 6 Zeca");
        vasco.setMeia("M - 5 Andrey, M - 8 Marquinhos Gabriel, M - 10 Nenê");
        vasco.setAtaque("A - 9 Germán Cano, A - 11 Morato, A - 17 Léo Jabá");


        ////INFORMAÇOES DO TIME BOTAFOGO\\\\
        Time botafogo = new Time("Botafogo", 1.22);
        botafogo.setTitulos("1 - Mundial, 1 - Libertadores, 21 - Carioca, 6 - Brasileirão, 2 - Copa do Brasil");
        botafogo.setGoleiro("GOL - 12 Diego Loureiro");
        botafogo.setDefesa("D - 2 Daniel Borges, D - 3 Kanu, D - 4 Gilvan, D - 6 Paulo Victor");
        botafogo.setMeia("M - 5 Pedro Castro, M - 10 Chay, M - 8 Ricardinho");
        botafogo.setAtaque("A - 9 Rafael Navarro, A - 11 Diego Gonçalves, A - 7 Ronald");

        ////INFORMAÇOES DOS TRES JOGOS\\\\
        Jogo jogo1 = new Jogo("Arena Corinthians", "Itaquera", "Andre Henning", "Campeonato Paulista", corinthians, palmeiras);
        Jogo jogo2 = new Jogo("Estadio Santiago Bernabeu", "Madrid", "Cleber Machado", "10° rodada da LaLiga", realMadrid, barcelona);
        Jogo jogo3 = new Jogo("Estadio Engenhao", "Rio de Janeiro", "Luiz Felipe Freitas", "Fina do campeonato carioca",botafogo,vasco);
        jogo1.resultado();
        jogo2.resultado();
        jogo3.resultado();

        // variaveis aux para fazer a entrada de dados
        boolean flag = true;
        int jogo;


        /*informaçoes da conta:
         - regex no email permitindo apenas string que tem '@'
           e '.com' e se tiver um '.br'
         - Somente pessoa apartir de 18 anos pode fazer a aposta
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
        while (idadeConta < 18 && idadeConta <=100) {
            System.out.println("Favor insira uma idade com 18 anos ou mais e que não ultrapasse 100 anos de idade");
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
            System.out.println( );
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
                c.fimDasApostas(c);
            }
            /*
            É chamada a classe helper para facilitar na logica do codigo caso tive mais time e
            em seguida tive mais jogos evitando a repetição. Foi feito apenas tres jogos, porém,
            é possivel criar mais jogos dessa forma.
             */
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

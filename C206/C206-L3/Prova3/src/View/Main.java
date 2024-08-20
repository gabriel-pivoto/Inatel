package View;

import java.util.ArrayList;
import java.util.Scanner;
import Controller.Arquivo;
import Model.Professores;

public class Main
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        Arquivo arq = new Arquivo();
        Professores p = new Professores();
        boolean flag =  true;

        while (flag)
        {
            System.out.println("Digite sua opção: ");
            System.out.println("1 - Adicionar professor");
            System.out.println("2 - Ler Arquivo");
            System.out.println("3 - Para remover um professor");
            System.out.println("4 - Sair");
            int op = sc.nextInt();
            sc.nextLine();

            switch (op)
            {
                case 1:
                    System.out.println("Digite o nome do Professor");
                    p.nome = sc.nextLine();
                    System.out.println("Digite a materia do Professor: ");
                    p.materia = sc.nextLine();
                    System.out.println("Digite seu CPF: ");
                    p.cpf = sc.nextLine();
                    arq.escrever(p);
                    System.out.println("model.Professor adicionado!");
                    break;

                case 2:
                    ArrayList<Professores> profs = arq.ler();
                    for (Professores prof : profs) {
                        System.out.println("Nome: " + prof.nome);
                        System.out.println("Materia: " + prof.materia);
                        System.out.println("CPF: " + prof.cpf);
                    }
                    break;

                case 3:
                    System.out.println("Digite o nome do professor que deseja remover");

                    p.nome = sc.nextLine();
                    System.out.println("Digite a materia do professor que deseja remover: ");
                    p.materia = sc.nextLine();
                    System.out.println("Digite o CPF do professor que deseja remover: ");
                    p.cpf = sc.nextLine();
                    arq.remover(p);
                    break;

                case 4:
                    flag = false;
                    System.out.println("Você saiu!");
                    break;


                default:
                    System.out.println("opção inválida!");
                    break;
            }
        }


    }

}



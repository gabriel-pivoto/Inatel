public class Empresa {

    String cpnj;
    String endereco;

    Contato[] contatos = new Contato[4];

    void exibirInfos(){
        System.out.println("-----------------------------");
        for (int i = 0; i < contatos.length; i++) {
            if (contatos[i] != null){
                System.out.println("Data de Nascimento: "+contatos[i].dataNascimento);
                System.out.println("Nome: " + contatos[i].nome);
                System.out.println("Telefone: " + contatos[i].telefone);
                System.out.println("Email: " +contatos[i].email);
                System.out.println("-----------------------------");
            }

        }
        System.out.println("Endereço da empresa: " + endereco);
        System.out.println("CNPJ da empresa: "  + cpnj);
        System.out.println("-----------------------------");

    }

}

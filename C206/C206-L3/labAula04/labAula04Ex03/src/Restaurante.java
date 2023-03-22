public class Restaurante {
    String cnpj;
    String endereco;
    String nome;
    Fornecedor[] fornecedores = new Fornecedor[3];


    void exibirInfos(){
        System.out.println("---------------------------------------");
        System.out.println("Restaurante:" + nome);
        System.out.println("CNPJ: " + cnpj);
        System.out.println("Endereço: " + endereco);

        System.out.println("---------------------------------------");
        System.out.println("Fornecedores: ");


        for (int i = 0; i < fornecedores.length; i++) {
            if (fornecedores[i] != null){
                System.out.println("Tipo: " + fornecedores[i].tipo);
                System.out.println("Quantidade: " + fornecedores[i].quantidade);
                System.out.println("---------------------------------------");
            }

        }
    }

}

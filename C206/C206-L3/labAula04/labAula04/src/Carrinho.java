import javax.sound.midi.Soundbank;

public class Carrinho {
    double total;
    Produto[] produtos = new Produto[4];


    void exibirInfos(){
        System.out.println("-----------------------------");
        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i] != null){
                System.out.println("Nome: " + produtos[i].nome);
                System.out.println("Descrição: " + produtos[i].descricao);
                System.out.println("Fabricante: " + produtos[i].fabricante);
                System.out.println("Preço: " + produtos[i].preco);
                System.out.println("-----------------------------");

            }
        }
    }
    void calculaTotal(){
        total = 0;
        for (int i = 0; i < produtos.length; i++) {
            if (produtos[i] != null){
                total += produtos[i].preco;
            }
        }
        System.out.println("Preço total: " + total);
    }

}

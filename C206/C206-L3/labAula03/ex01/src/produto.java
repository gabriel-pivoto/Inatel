public class produto {

    produto(int codigoSerie1, String codigoProduto1, String nome1, String categoria1, int quantidade1) {
        this.codigoSerie = codigoSerie1;
        this.codigoProduto = codigoProduto1;
        this.nome = nome1;
        this.categoria = categoria1;
        this.quantidade = quantidade1;
    }



    int codigoSerie;
    String codigoProduto;
    String nome;
    String categoria;
    int quantidade;

    void mostraInfo(){
        System.out.println("Código Série: " + codigoSerie);
        System.out.println("Código do Produto: " + codigoProduto);
        System.out.println("Nome do produto: " + nome);
        System.out.println("Categoria: " + categoria);
        System.out.println("Quantidade: " + quantidade);
    }
}

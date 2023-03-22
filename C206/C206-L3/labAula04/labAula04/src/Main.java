public class Main {
    public static void main(String[] args) {

        Carrinho carrinho = new Carrinho();

        carrinho.produtos[0] = new Produto("Macarrao", "alimento", "A", 12);
        carrinho.produtos[1] = new Produto("Camisa" , "roupa", "B", 90);
        carrinho.produtos[2] = new Produto("bola", "esporte", "C", 40);

        carrinho.exibirInfos();
        carrinho.calculaTotal();


    }
}
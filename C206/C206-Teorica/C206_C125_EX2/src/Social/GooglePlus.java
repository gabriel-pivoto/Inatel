package Social;
import Control.VideoConferencia;
import Control.Compartilhamento;
import Control.RedeSocial;

public class GooglePlus extends RedeSocial implements VideoConferencia, Compartilhamento {

    public GooglePlus(String senha, int numAmigos) {
        super(senha, numAmigos);
    }
    public String getSenha() {
        return super.senha;
    }
    public int getnumAmigos() {
        return super.numAmigos;
    }
    @Override
    public void postarFoto(){
        System.out.println("Postando foto no GooglePlus!");
    }
    @Override
    public void postarVideo(){
        System.out.println("Postando video no GooglePlus!");
    }
    @Override

    public void postarComentario(){
        System.out.println("Postando comentário no GooglePlus!");
    }
    @Override
    public void fazStreaming(){
        System.out.println("Fazendo Streaming no GooglePlus!");
    }

    @Override
    public  void compartilhar(){
        System.out.println("Compartilhando no GooglePlus!");
    }
}

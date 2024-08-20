package Social;
import Control.VideoConferencia;
import Control.Compartilhamento;
import Control.RedeSocial;

public class Facebook extends RedeSocial implements VideoConferencia, Compartilhamento {


    public Facebook(String senha, int numAmigos) {
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
        System.out.println("Postando foto no Facebook!");
    }
    @Override
    public void postarVideo(){
        System.out.println("Postando video no Facebook!");
    }
    @Override

    public void postarComentario(){
        System.out.println("Postando comentário no Facebook!");
    }
    @Override
    public void fazStreaming(){
        System.out.println("Fazendo Streaming no Facebook!");
    }

    @Override
    public  void compartilhar(){
        System.out.println("Compartilhando no Facebook!");
    }

}

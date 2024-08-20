package Social;

import Control.Compartilhamento;
import Control.RedeSocial;


public class Twitter extends RedeSocial implements  Compartilhamento {

    public Twitter(String senha, int numAmigos) {
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
        System.out.println("Postando foto no Twitter!");
    }
    @Override
    public void postarVideo(){
        System.out.println("Postando video no Twitter!");
    }
    @Override

    public void postarComentario(){
        System.out.println("Postando comentário no Twitter!");
    }

    @Override
    public  void compartilhar(){
        System.out.println("Compartilhando no Twitter!");
    }


}

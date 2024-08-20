package Social;

import Control.RedeSocial;

public class Instagram extends RedeSocial {

    public Instagram(String senha, int numAmigos) {
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
        System.out.println("Postando foto no Instagram!");
    }
    @Override
    public void postarVideo(){
        System.out.println("Postando video no Instagram!");
    }
    @Override

    public void postarComentario(){
        System.out.println("Postando comentário no Instagram!");
    }



}

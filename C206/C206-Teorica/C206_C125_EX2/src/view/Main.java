package view;
import Control.*;
import Social.*;
public class Main {
    public static void main(String[] args) {

        RedeSocial[] redesSociais = new RedeSocial[4];
        redesSociais[0] = new Twitter("senha_twitter", 123);
        redesSociais[1] = new Facebook("senha_facebook", 9999);
        redesSociais[2] = new Instagram("senha_instagram", 4000);
        redesSociais[3] = new GooglePlus("senha_GooglePlus", 0);

        Usuario usuario = new Usuario("João", "jucelino@xnm.ug", redesSociais);
        System.out.println("------------------------------------");
        System.out.println("Nome do usario:" + usuario.getNome());
        System.out.println("Nome do email:" + usuario.getEmail());

        System.out.println("------------------------------------");
        // Acessar o compartilhamento do Facebook
        if (redesSociais[0] instanceof Twitter) {
            Twitter twitter = (Twitter) redesSociais[0];
            twitter.compartilhar();
            twitter.postarComentario();
            twitter.postarFoto();
            twitter.postarVideo();
            twitter.curtirPublicacao();
            System.out.println("Senha do Twitter: " + twitter.getSenha());
            System.out.println("Número de amigos do Twitter: " + twitter.getnumAmigos());

        }


        System.out.println("------------------------------------");
        // Acessar o compartilhamento do Facebook
        if (redesSociais[1] instanceof Facebook) {
            Facebook facebook = (Facebook) redesSociais[1];

            facebook.compartilhar();
            facebook.postarComentario();
            facebook.postarFoto();
            facebook.postarVideo();
            facebook.fazStreaming();
            System.out.println("Senha do Facebook: " + facebook.getSenha());
            System.out.println("Número de amigos do Facebook: " + facebook.getnumAmigos());


        }

        System.out.println("------------------------------------");
        if (redesSociais[2] instanceof Instagram) {
            Instagram instagram = (Instagram) redesSociais[2];

            instagram.postarComentario();
            instagram.postarFoto();
            instagram.postarVideo();
            instagram.curtirPublicacao();
            System.out.println("Senha do Instagram: " + instagram.getSenha());
            System.out.println("Número de amigos do Instagram: " + instagram.getnumAmigos());

        }

        System.out.println("------------------------------------");
        if (redesSociais[3] instanceof GooglePlus) {
            GooglePlus googlePlus = (GooglePlus) redesSociais[3];
            googlePlus.compartilhar();
            googlePlus.postarComentario();
            googlePlus.postarFoto();
            googlePlus.postarVideo();
            googlePlus.curtirPublicacao();
            googlePlus.fazStreaming();
            System.out.println("Senha do GooglePlus: " + googlePlus.getSenha());
            System.out.println("Número de amigos do GooglePlus: " + googlePlus.getnumAmigos());

        }
        System.out.println("------------------------------------");

    }
}

package Control;


import Social.Facebook;
import Social.GooglePlus;
import Social.Instagram;
import Social.Twitter;

public class Usuario {
    private String nome;
    private String email;

    private RedeSocial[] redesSociais;


    public Usuario(String nome, String email, RedeSocial[] redesSociais) {
        this.nome = nome;
        this.email = email;
        this.redesSociais = redesSociais;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}

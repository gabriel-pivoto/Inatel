public abstract class Animal {

    public int qntAnimais;

    private String nome;
    private int idade;

    private boolean perigoso;
    public int getQntAnimais() {
        return qntAnimais;
    }

    public void setQntAnimais(int qntAnimais) {
        this.qntAnimais = qntAnimais;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setPerigoso(boolean perigoso) {
        this.perigoso = perigoso;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public boolean isPerigoso() {
        return perigoso;
    }



    public void mostrainfo(){


    }
    public String barulho(){
        return null;
    }








}

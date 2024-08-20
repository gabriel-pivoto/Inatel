public class Zoo {
    private String nome;
    private String endereco;
    private long cnpj;

    public String getNome() {
        return nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public long getCnpj() {
        return cnpj;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setCnpj(long cnpj) {
        this.cnpj = cnpj;
    }

    Animal[] animais = new Animal[4];




    void mostraInfo(){
        System.out.println("Nome do Zoo: " + nome);
        System.out.println("Endereco: " + endereco);
        System.out.println("Cnpj: " + cnpj);

        System.out.println();
        for (int i = 0; i < animais.length; i++) {
            if(animais[i] != null){
                if(animais[i] instanceof Animal){
                    System.out.println("--------------------");
                    animais[i].mostrainfo();
                    animais[i].getQntAnimais();
                    animais[i].barulho();


                }
            }

        }

        /*
        System.out.println("----------------------");
        animais[1].mostrainfo();
        System.out.println("----------------------");
        animais[2].mostrainfo();
        System.out.println("----------------------");
        animais[3].mostrainfo();
        System.out.println("----------------------");
        */





















    }





}

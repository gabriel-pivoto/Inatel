using System;

class Cachorro
{
    public string Nome { get; set; }
    public int Idade { get; set; }

    public Cachorro(string nome, int idade)
    {
        Nome = nome;
        Idade = idade;
    }

    // Métodos
    public void ShowNome()
    {
        Console.WriteLine($"O nome do cachorro é: {Nome}");
    }

    public virtual void ShowIdade()
    {
        Console.WriteLine($"A idade do cachorro é: {Idade}");
    }
}

class CachorroGrande : Cachorro
{
    private string Tamanho;

    public CachorroGrande(string nome, int idade, string tamanho) : base(nome, idade)
    {
        Tamanho = tamanho;
    }

    public void ShowTamanho()
    {
        Console.WriteLine($"O tamanho do cachorro é: {Tamanho}");
    }

    public override void ShowIdade()
    {
        Console.WriteLine($"A idade do cachorro grande é: {Idade}");
    }
}

class CachorroPequeno : Cachorro
{
    public CachorroPequeno(string nome, int idade) : base(nome, idade)
    {
    }

    public override void ShowIdade()
    {
        Console.WriteLine($"A idade do cachorro pequeno é: {Idade}");
    }
}

class Program
{
    static void Main()
    {
        Cachorro cachorro = new Cachorro("Meg", 2);
        CachorroPequeno cachorroPequeno = new CachorroPequeno("Mel", 12);
        CachorroGrande cachorroGrande = new CachorroGrande("Toddt", 7, "Grande");

        cachorro.ShowNome();
        cachorro.ShowIdade();

        cachorroPequeno.ShowNome();
        cachorroPequeno.ShowIdade();

        cachorroGrande.ShowNome();
        cachorroGrande.ShowIdade();
        cachorroGrande.ShowTamanho();
    }
}

#include <iostream>
#include <string>

using namespace std;

class Pessoa {
protected:
    string nome;
    int idade;
public:
    Pessoa(string nome, int idade) : nome(nome), idade(idade) {}

    void imprimeNome() {
        cout << "O nome é: " << nome << endl;
    }

    int getIdade() const {  
        return idade;
    }
};

class Aluno : public Pessoa {
private:
    int matricula;
public:
    Aluno(string nome, int idade, int matricula) : Pessoa(nome, idade), matricula(matricula) {}

    void imprimeIdade() {
        cout << "O aluno tem " << getIdade() << " anos." << endl;
    }
};

class Professor : public Pessoa {
public:
    Professor(string nome, int idade) : Pessoa(nome, idade) {}

    void imprimeIdade() {
        cout << "O professor tem " << getIdade() << " anos." << endl;
    }
};

int main() {
    Pessoa pessoa("João", 40);
    Aluno aluno("Maria", 20, 12345);
    Professor professor("Carlos", 35);

    pessoa.imprimeNome();
    cout << "A idade da pessoa é: " << pessoa.getIdade() << endl;

    aluno.imprimeNome();
    aluno.imprimeIdade();

    professor.imprimeNome();
    professor.imprimeIdade();

    return 0;
}

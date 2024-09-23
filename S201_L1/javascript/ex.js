class Animal {
    constructor(nome, idade, especie) {
        this.nome = nome;
        this.idade = idade;
        this.especie = especie;
    }

    printInfo() {
        console.log(`Nome: ${this.nome}, Idade: ${this.idade}, Espécie: ${this.especie}`);
    }
}

class Cachorro extends Animal {
    #raca;

    constructor(nome, idade, especie, raca) {
        super(nome, idade, especie);
        this.#raca = raca;
    }

    printInfo() {
        super.printInfo();
        console.log(`Raça: ${this.#raca}`);
    }
}

class Gato extends Animal {
    constructor(nome, idade, especie, cores) {
        super(nome, idade, especie);
        this.cores = cores;
    }

    printInfo() {
        super.printInfo();
        console.log(`Cores: ${this.cores.join(', ')}`);
    }
}

const animal = new Animal("Toddy", 4, "Cachorro");
const cachorro = new Cachorro("Toddy", 4, "Cachorro", "Labrador");
const gato = new Gato("China", 9, "Mamífero", ["Branco", "Preto"]);
console.log('animal info:')
animal.printInfo();
console.log('---');
console.log('Cachorro info:');
cachorro.printInfo();
console.log('---');
console.log('Gato info:');
gato.printInfo();

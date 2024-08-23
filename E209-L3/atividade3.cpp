#include <iostream>
using namespace std;

void analisarNumeros(int numeros[5]) {
    int par = 0, impar = 0, positivo = 0, negativo = 0;

    for (int i = 0; i < 5; i++) {
        if (numeros[i] % 2 == 0) {
            par++;
        } else {
            impar++;
        }

        if (numeros[i] > 0) {
            positivo++;
        } else if (numeros[i] < 0) {
            negativo++;
        }
    }

    cout << "Quantidade de numeros pares: " << par << endl;
    cout << "Quantidade de numeros impares: " << impar << endl;
    cout << "Quantidade de numeros positivos: " << positivo << endl;
    cout << "Quantidade de numeros negativos: " << negativo << endl;
}

int main() {
    int n;
    cout << "Entre com o numero de testes: ";
    cin >> n;

    for (int i = 0; i < n; i++) {
        int numeros[5];
        cout << "Entre com os 5 numeros para o teste " << i + 1 << ": ";
        for (int j = 0; j < 5; j++) {
            cin >> numeros[j];
        }
        analisarNumeros(numeros);
        cout << endl;
    }

    return 0;
}

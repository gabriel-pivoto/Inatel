#include <iostream>
using namespace std;

int main() {
    int i;
    int x;
    cout << "Entre com o valor:";
    do {
        cin >> x;
    } while (x < 0 || x > 50);

    if (x == 0) {
        cout << "Nao existe divisao por 0" << endl;
    } else {
        for (i = x; i >0 ; i--) {
            int y = x % i;
            cout << "Resto da divisao de " << x << " por " << i << ": " << y << endl;
        }
    }

    return 0;
}

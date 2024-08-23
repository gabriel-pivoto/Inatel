#include <iostream>
#include <iomanip>
using namespace std;

int main()
{
    float x;
    cout<<"quantas laranjas deseja comprar?";
    cin>> x;
    if(x<12){
        cout<<"Preco da unidade: R$0.80";
        cout<< fixed << setprecision(2);
        x = x*0.8;
        cout<<"Preço total: R$" << x;
    }else{
        cout<<"Preco da unidade: R$0.65";
        cout<< fixed << setprecision(2);
        x = x * 0.65;
        cout<<"Preço total: R$" << x;
    }
    return 0;
}
#define botao_on PINB0 
#define botao_off PINB1
#define motor PORTB2 
#define s1 PINB3 
#define alarme PORTB4 

int main(void) {
    DDRB |= (1 << motor) | (1 << alarme);
    DDRB &= ~((1 << botao_on) | (1 << botao_off) | (1 << s1)); 
    
    PORTB |= (1 << botao_on) | (1 << botao_off) | (1 << s1); 
    while(1) {
         if (!(PINB & (1 << botao_on))) {
        PORTB |= (1 << motor); 
    }
    if (!(PINB & (1 << botao_off))) {
        PORTB &= ~(1 << motor); 
    }

    if (PINB & (1 << s1)) {
        PORTB |= (1 << alarme); 
    } else {
        if (!(PINB & (1 << botao_on))) {
            PORTB &= ~(1 << alarme); 
        }
    }
    }
    return 0;
}

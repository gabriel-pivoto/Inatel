#define vemelho PORTB0
#define amarelo PORTB1
#define azul PORTB2
#define botao PINB3

int main(void) {
    DDRB |= (1 << vemelho) | (1 << amarelo) | (1 << azul);

    DDRB &= ~(1 << botao);
    
    PORTB |= (1 << botao); 
    while(1) {
        if (!(PINB & (1 << botao))) {

        for (int i = 0; i < 6; i++) {
            PORTB |= (1 << amarelo);
            _delay_ms(500);
            PORTB &= ~(1 << amarelo);
            _delay_ms(500);
        }

        PORTB |= (1 << azul);
        while (PINB & (1 << botao)); 

        PORTB &= ~(1 << azul);
    } else {
        PORTB |= (1 << vemelho);
        PORTB &= ~(1 << amarelo);
        PORTB &= ~(1 << azul);
    }
    }
    return 0;
}

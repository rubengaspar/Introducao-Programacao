class Calculator {
	
	int value;
	
	Calculator() {
		value=0;
	}
	
	void plus(int n) {
		value += n;
	}
	
	void clean() {
		value = 0;
	}
	
	void subtraction(int a) {
		value -= a;
	}
	
	void multiply(int a, int b) {
		for (int i = 1; i <= a; i++) {
			value += b;
		}
	}
	
	void pow(int base, int pow) {
		for (int i = 1; i <= pow; i++) {
			value += base;
		}
	}
	
	void division (int num, int den) {
		int i = 0;
		while (num >= den) {
			num -= den;
			i++;
		}
		value += i;
	}

	void remainder (int num, int den) {
		// fazer ciclo
		// criar nova variavel para nao dar display na calculadora os valores a alterar
		// enquanto estão a ser calculados
		
		while (num > den) {
			if (num > den && num > 0 && den > 0)
				num -= den;
			else if (den > num && num > 0 && den > 0)
				den -= num;
			else if (num == den && num > 0 && den > 0)
				value += num;
			else
				value += 0;	
		}
	}
}

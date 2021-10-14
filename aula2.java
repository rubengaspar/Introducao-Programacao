class aula2 {

// Obter o máximo entre dois números
	static int max (int x, int y) {
		if (x>y)
			return x;	
		else
			return y;
		}

// Verificar se um número é múltiplo de um outro número, sem recurso ao operador de resto da divisão (%)
	static boolean isMultiple (int a, int b) {
		while (a>=b) {
			if (a==b)
				return true;
			a = a-b;
		}
		return false;
	}

// Obter o valor absoluto de um número
	static int abs (int a) {
		if (a<0) {
			a = a*-1;
		}
		return a;		
		}
	
	static int abs2 (int a) {
		if (a>=0) 
			return a;
		else
			return -a;		
		}

// Obter o quociente da divisão inteira, sem recorrer ao operador de divisão (/)
	static int divide (int a, int b) {
		int c = 0;
		while (a>=b) {
			a = a-b;
			c = c+1;
		}
		return c;
		}
	
//Obter uma potência de 2, i.e. 2n, dado o expoente num argumento que se assume ser um número natural n (diferente de zero)

	static int powerOfTwo (int a) {
		int s = 1;
		while (a>0){
			s = s*2;
			a = a -1;
		}
		return s;
	}
	

//Obter o somatório dos números naturais até um dado n
	
	static int somatorio (int a) {
		int s = 0;
		while (a > 0) {
		s = s + a;
		a = a -1;
		}
		return s;
	}
	
//Obter o somatório dos números naturais pares compreendidos num dado intervalo fechado
	static int sumEven (int a, int b) {
		int s = 0;
		while (b >= a) {
			if (b%2 == 0)
				s = s + b;
			b = b - 1;
		}
		return s;	
	}

//Obter o primeiro algarismo da representação decimal de um número inteiro
	static int firstDigit (int x) {
		int z;
		
		do {
			z = x;
			x= x/10;
		} while (x!=0);
		return z;
	}

//Obter o n-ésimo número da sequência de Fibonacci, considerando que o primeiro número da sequência tem número de ordem zero
	static long fibonacci (long n) {
		long f, x=0, y=1, contador = 1;
		
		if (n==0 || n==1)
			return n;
		do {
			f=x+y;
			x=y;
			y=f;
			contador = contador +1;
		} while (contador < n);
		return f;
	}
	
// Defina uma função que recebe como argumento dois números naturais m e n e que calcula o máximo divisor comum desses dois números, usando o algoritmo de Euclides
	static int gcd (int a, int b) {
	while (a!=b) {
		if (a>b)
			a = a - b;
		else if (a<b)
			b = b - a;
	}
		return a;
	}
}
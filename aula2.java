class aula2 {

// Obter o m�ximo entre dois n�meros
	static int max (int x, int y) {
		if (x>y)
			return x;	
		else
			return y;
		}

// Verificar se um n�mero � m�ltiplo de um outro n�mero, sem recurso ao operador de resto da divis�o (%)
	static boolean isMultiple (int a, int b) {
		while (a>=b) {
			if (a==b)
				return true;
			a = a-b;
		}
		return false;
	}

// Obter o valor absoluto de um n�mero
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

// Obter o quociente da divis�o inteira, sem recorrer ao operador de divis�o (/)
	static int divide (int a, int b) {
		int c = 0;
		while (a>=b) {
			a = a-b;
			c = c+1;
		}
		return c;
		}
	
//Obter uma pot�ncia de 2, i.e. 2n, dado o expoente num argumento que se assume ser um n�mero natural n (diferente de zero)

	static int powerOfTwo (int a) {
		int s = 1;
		while (a>0){
			s = s*2;
			a = a -1;
		}
		return s;
	}
	

//Obter o somat�rio dos n�meros naturais at� um dado n
	
	static int somatorio (int a) {
		int s = 0;
		while (a > 0) {
		s = s + a;
		a = a -1;
		}
		return s;
	}
	
//Obter o somat�rio dos n�meros naturais pares compreendidos num dado intervalo fechado
	static int sumEven (int a, int b) {
		int s = 0;
		while (b >= a) {
			if (b%2 == 0)
				s = s + b;
			b = b - 1;
		}
		return s;	
	}

//Obter o primeiro algarismo da representa��o decimal de um n�mero inteiro
	static int firstDigit (int x) {
		int z;
		
		do {
			z = x;
			x= x/10;
		} while (x!=0);
		return z;
	}

//Obter o n-�simo n�mero da sequ�ncia de Fibonacci, considerando que o primeiro n�mero da sequ�ncia tem n�mero de ordem zero
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
	
// Defina uma fun��o que recebe como argumento dois n�meros naturais m e n e que calcula o m�ximo divisor comum desses dois n�meros, usando o algoritmo de Euclides
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
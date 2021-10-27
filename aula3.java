class aula3 {

//Functions

	// numero de divisores de um numero inteiro
	static int numOfDiv (int a) {
		
		int count = 0, b=a;
		
		while (b > 0) {
			if (a%b==0) 
				count = count + 1;
			b = b - 1;
		}
		return count;	
	}

	// soma dos divisores de um numero inteiro
	static int sumOfDiv (int a) {
		
		int b = a - 1, sum = 0;
		
		while (b > 0) {
			if (a%b==0) {
				sum = sum + b;
			}
			b = b - 1;
		}
		return sum;
	}
	
// A. Defina uma fun��o que recebe como argumento um n�mero natural n e devolve verdadeiro caso n seja primo, ou falso caso contr�rio.
	static boolean isPrime (int a) {
		
		return numOfDiv(a) == 2;
	}
		
// B. Defina uma fun��o que recebe como argumento um n�mero natural n e devolve o somat�rio dos n�meros primos menores que n.
	static int sumOfPrimesSmallerThan (int n) {
		
		int sum = 0;
		
		while (n>1) {
		if (isPrime(n) == true) {
			sum = sum + n;
			}
		n = n - 1;
		}
		return sum;
	}
	

// C. Defina uma fun��o que recebe como argumento um n�mero natural n e devolve o n�mero de primos at� n (inclusive).
	static int numberOfPrimesUpTo(int a) {
		
		int count = 0;
		
		while (a > 1) {
			if (isPrime(a) == true)
				count = count +1;
		a = a - 1;
		}
		return count;
	}
	
// D. Analogamente � al�nea A, defina uma fun��o que permita saber se um n�mero � perfeito.
	static boolean isPerfect (int a) {
		return sumOfDiv(a) == a;
	}
	
// E. Fazendo uso da al�nea anterior, defina uma fun��o que recebe como argumento um n�mero natural n e que devolve o n�mero de n�meros perfeitos at� n (inclusive)
	static int numOfPerfect (int a) {
		
		int count = 0;
		
		while (a > 1) {
			if(isPerfect(a) == true)
				count  = count + 1;
		a = a - 1;
		}
		return count;
	}


// F. Defina uma fun��o que permite saber se existe algum n�mero primo num dado intervalo (aberto).
	static int existsPrimeBetween (int a, int b) {
		int count = 0;
		
		a += 1;
		
		while (a<b) {
			if (isPrime(a) == true)
				count = count + 1;
			a += 1;
		}
		return count;
	}
	
	
//Defina fun��es recursivas para calcular:
//	a) o n-�simo n�mero de Fibonacci
	static int fibonacci (int a) {
		if(a <= 1)
			return a;
		else
			return fibonacci(a - 1) + fibonacci(a - 2);
	}
	
//Defina fun��es recursivas para calcular:
//	b) o fatorial de um n�mero	
	static int factorial (int a) {
		if (a == 1)
			return a;
		else
			return factorial(a-1)*a;
	}

//Defina fun��es recursivas para calcular:
//	c) o m�ximo divisor comum entre dois n�meros. Pode ser �til relembrar o Algoritmo de Euclides
	static int gcd (int a, int b) {
		
		if (a>b)
			a = a - b;
		else if (b > a)
			b = b - a;
		else if (a == b)
			return a;
		else
			return 1;
		
		return gcd(a, b);
	}
	
	
//Defina uma fun��o que recebe como argumento um n�mero natural n e devolve a maior diferen�a entre dois n�meros primos consecutivos at� n.
	static int largerDifferenceBetweenPrimes (int n) {
		int i = 2, dif = 0, a = 2;
		
		while (i < a) {
			if(isPrime(i)) {
				if (dif < i - a)
					dif = i - a;
				a = i;
			}
			i = i + 1;
		}
	return dif;
	}
}
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
	
// A. Defina uma função que recebe como argumento um número natural n e devolve verdadeiro caso n seja primo, ou falso caso contrário.
	static boolean isPrime (int a) {
		
		return numOfDiv(a) == 2;
	}
		
// B. Defina uma função que recebe como argumento um número natural n e devolve o somatório dos números primos menores que n.
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
	

// C. Defina uma função que recebe como argumento um número natural n e devolve o número de primos até n (inclusive).
	static int numberOfPrimesUpTo(int a) {
		
		int count = 0;
		
		while (a > 1) {
			if (isPrime(a) == true)
				count = count +1;
		a = a - 1;
		}
		return count;
	}
	
// D. Analogamente à alínea A, defina uma função que permita saber se um número é perfeito.
	static boolean isPerfect (int a) {
		return sumOfDiv(a) == a;
	}
	
// E. Fazendo uso da alínea anterior, defina uma função que recebe como argumento um número natural n e que devolve o número de números perfeitos até n (inclusive)
	static int numOfPerfect (int a) {
		
		int count = 0;
		
		while (a > 1) {
			if(isPerfect(a) == true)
				count  = count + 1;
		a = a - 1;
		}
		return count;
	}


// F. Defina uma função que permite saber se existe algum número primo num dado intervalo (aberto).
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
	
	
//Defina funções recursivas para calcular:
//	a) o n-ésimo número de Fibonacci
	static int fibonacci (int a) {
		if(a <= 1)
			return a;
		else
			return fibonacci(a - 1) + fibonacci(a - 2);
	}
	
//Defina funções recursivas para calcular:
//	b) o fatorial de um número	
	static int factorial (int a) {
		if (a == 1)
			return a;
		else
			return factorial(a-1)*a;
	}

//Defina funções recursivas para calcular:
//	c) o máximo divisor comum entre dois números. Pode ser útil relembrar o Algoritmo de Euclides
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
	
	
//Defina uma função que recebe como argumento um número natural n e devolve a maior diferença entre dois números primos consecutivos até n.
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
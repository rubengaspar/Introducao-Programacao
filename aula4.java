package aula4;

/**
 * @author rsgra
 *
 */
public class aula4 {

// Trabalho Pr�vio
	
// Construir um vetor com os n�meros naturais at� um dado numero n.
	static int[] naturals (int n) {
		
		int v[] = new int [n];
		
		while (n>0) {
			v[n-1] = n;
			n--; // n = n - 1;
		}
		return v;
	}
	
// Calcular o somat�rio dos valores de um vetor
	static int sum (int[] v) {
		int i=0, sum = 0;
		while (i < v.length) {
			sum = sum + v[i];
			i++;
		}
	return sum;
}

// Construir um vetor com d�gitos aleat�rios (n�meros de 0 a 9), dado o comprimento.
	static int[] randomDigits (int n) {
		
		int i;
		int v[] = new int [n];
		
		while (n != 0) {
			
			i = (int) ( Math.random() *10);
			v[n-1] = i;
			n--;
		}
		return v;
	}

// A. Calcular a m�dia dos valores de um vetor. Na al�nea B do Trabalho Pr�vio � pedida
//	   uma fun��o para calcular o somat�rio de um vetor de inteiros que � �til neste contexto.
	static double mean (int[] v) {
		
		return (double) sum(v)/v.length;
	}

	
// B. Copiar (replicar) um vetor de inteiros, tendo o novo vetor um tamanho dado como argumento.
	
	static int[] copy (int[] v, int a) {
		
		int i = 0, b;
		int newV[] = new int [a];
		
		b = Math.min(v.length, newV.length);
				
		while (i != b) {
			newV[i] = v[i];
			i++;
		}
		
		return newV;
	}
	
	
	
	
// C. Copiar (replicar) um vetor de inteiros, tendo o novo vetor o mesmo tamanho que o original. 
// Esta fun��o � uma especializa��o da anterior, dado que o que se pretende pode ser obtido 
// invocando-a com o segundo argumento igual ao tamanho do vetor passado no primeiro argumento 
//	(copy({1, 2, 3}, 3) -> {1, 2, 3} ). Desta forma, esta fun��o pode ser definida � custa da anterior.
	
	static int[] copy2 (int[] v) {
		
		return copy(v,v.length);
	}

	
	
// D. Verificar se existe determinado n�mero n num vetor.
	
	static boolean exists(int a, int[] v) {
	
		int i = 0;
		
		while (i != v.length) {
			if (a == v[i])
				return true;
		}
		return false;
		
	}
	
// E. Contar o n�mero de ocorr�ncias de um determinado n�mero num vetor.
	static int count(int a, int[] v) {
		int i = 0, cont = 0;
			while (i != v.length) {
				if (v[i] == a)
					cont++;
			i++;
			}
		return cont;
	}
	
// F. Defina uma fun��o que devolva o valor m�ximo de um vetor.
	static int max(int[]v) {
		
		int i = 1, max = v[0];
		
		while (i != v.length) {
			if (v[i] > max)
				max = v[i];
		i++;
		}
		return max;
	}
	
// G. Construir um sub-vetor de outro vetor, dados o �ndice do primeiro elemento e o �ndice do �ltimo elemento a incluir.
	static int[] subArray (int a, int b, int[]v) {
		
		int[] newV = new int[b-a+1];
		int i = 0;
		
		while (i != newV.length) {
			newV[i] = v[a];
			a++; 
			i++;			
		}
		
		return newV;
	}
	
// H. Obter a primeira metade de um vetor v, incluindo um par�metro booleano para permitir indicar se o elemento do meio � para incluir 
//	(caso o comprimento do vetor seja �mpar). Se o comprimento do vetor for par, este par�metro n�o ter� efeito.
	static int half (int b, boolean a) {
		int half;
		
		if (a == true)
			half = b/2+1;
		else
			half = b/2;
		
		return half;
	}
	
	
	static int[] firstHalf (int[]v, boolean a) {
		
		int i = 0;
		
		int[] newV = new int[half(v.length,a)];
		
		while (i != newV.length) {
			newV[i] = v[i];
			i++;
		}
		return newV;
	}
	
// I. Obter a segunda metade de um vetor, analogamente � al�nea anterior.
	static int[] secondHalf (int[]v, boolean a) {
		
		
		int i = 0;
		int n = half(v.length,a);
		
		int[] newV = new int[n];
		
		while (i != newV.length) {
			if (a== true)
				newV[i] = v[i+n-1];
			else if (a == false)
				newV[i] = v[i+n+1];
			i++;
		}
		
		return newV;
	}
	
// J. Construir um vetor juntando outros dois vetores (parte esquerda e direita).
	static int[] merge (int[]v1, int[]v2) {
		
		int i = 0;
		int a = v1.length + v2.length;
		int[] merge = new int[a];
		
		while (i < v1.length) {
			merge[i] = v1[i];
			i++;
		}
		
		while (i < v1.length + v2.length) {
			merge[i] = v2[i-v1.length];
			i++;
		}
		
		
		return merge;
	}
	
	
// K. Construa um vetor invertido com base noutro. Ou seja, o novo vetor ser� composto pelos elementos do vetor dado pela ordem inversa.
	static int[] invert (int[]v) {
		
		int i = 0, j = v.length-1;
		int[] invert = new int [v.length];
		
		while (i != v.length) {
			invert[i] = v[j];
			i++;
			j--;			
		}
		return invert;
	}

// L. Sortear um n�mero de um vetor, com igual probabilidade para todos os elementos. A solu��o passa por sortear um �ndice v�lido do vetor.
	static int random(int[]v) {

		int num = v[(int) (Math.random()*v.length)];
		return num;
	}
	
// Exercicios Extra
// A. Construir um vetor com base noutro, de modo a ter o dobro do tamanho e cada elemento duplicado.
	static int[] duplicate(int[]v) {
		
		int[] newV = new int [v.length*2];
		int i = 0, j= 0;
		
		while (i != v.length) {
			newV[j] = v[i];
			j++;
			newV[j] = v[i];
			j++;
			i++;
		}
		return newV;
	}
	
// B. Construir um vetor com base noutro, sendo a primeira metade uma c�pia e a segunda metade os mesmos elementos pela ordem inversa.
	static int[] duplicateInvert (int[]v) {
		
		int i = 0, j = 0;
		int[] newV = new int [v.length*2];
		int[] invert = invert(v);
		
		while (i != newV.length) {
			if (i < v.length) {
				newV[i] = invert[i];
				i++;
			} else {
				newV[i] = v[j];
				i++;
				j++;
			}
		}
		return newV;
	}
		
// C. Construir um vetor com base noutro, representando uma c�pia sem o elemento do meio (caso o tamanho seja �mpar).
	static int[] noMid (int[] v) {
	
		int comp;
		
		if (v.length%2!=0)
			comp = v.length-1;
		else {
			comp = v.length;
			return v; }
		
		int[] newV = new int [comp];
		
		newV = merge(firstHalf(v, false),secondHalf(v, false));
		return newV;
	}
	
// D. Construir um vetor com n n�meros da sequ�ncia de Fibonacci.
	static int fibonacci (int a) {
		if(a <= 1)
			return a;
		else
			return fibonacci(a - 1) + fibonacci(a - 2);
	}
	
	
	static int[] fibVector (int n) {
		
		int i = 0;
		int[]v = new int[n];
		
		while (i!= n) {
			v[i] = fibonacci(i);
			i++;
		}
		return v;
	}
}
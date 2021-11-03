class aula5 {

// TRABALHO PREVIO
// A. Defina uma função para criar um vetor de tamanho n preenchido com determinado caráter.
// charVector('c', 3)
	
	static char[] charVector (char b, int a){
		char v[] = new char[a];
		for (int i = 0; i != a; i++)
			v[i] = b;
		return v;
	}
	
// B. Defina um procedimento para preencher todo o vetor com determinado caráter.
// static void fill(char c, char[] v) {  }
	
	static void fill (char a, char[] v) {
		for (int i = 0; i != v.length; i++)
			v[i] = a;
	}
	
// C. Defina um procedimento para substituir todas as ocorrências de determinado caráter por outro.
	
	static void replace (char a, char b, char[] v) {
		for (int i = 0; i!= v.length; i++) {
			if (v[i] == a)
				v[i] = b;
		}
	}
	
// TRABALHO AULA
// A. Defina uma função para criar um vetor com os carateres consecutivos 
// a partir de um caráter dado como argumento, de comprimento n.
	static char[] sequence (char a, int n) {
		char v[] = new char[n];
			
			int b = (int)a;
		for (int i = 0; i != n; i++) {
			v[i] = (char)b;
			b++;
		}
	return v;
	}
	
// B. Defina procedimentos sobre vetores que permitam:
// 	Substituir a primeira ocorrência de determinado caráter por outro.
	static void replaceFirst (char a, char b, char[] v) {
	
		int n = 0, i = 0;
		while ( n == 0 && i!= v.length) {
			if (v[i] == a) {
				v[i] = b;
				n++;
			} else
				i++;
		}
	}
	
//	Substituir a última ocorrência de determinado caráter por outro.
	static void replaceLast (char a, char b, char[] v) {
		
		int max = 0;
		for (int i = 0; i!=v.length; i++) {
			if (v[i] == a)
				max = i;
		}
	v[max] = b;
	}
	
//	Rodar os seus elementos para a esquerda (o primeiro elemento passa a último).
	static void shiftLeft (char[] v) {
		int i = 0;
		char shift = v[i];
		for (i = 0; i!=v.length; i++) {
			if (i==v.length-1)
				v[i] = shift;
			else
				v[i] = v[i+1];
		}
	}
	
	
// Rodar os seus elementos para a direita (o último elemento passa a primeiro).
	static void shiftRight (char[] v) {
		
		char save = v[0];	
		for (int i = 0; i!=v.length-1;i++) {
			save = v[i+1];
			v[i] = v[i+1];
			i++;
		}
		v[v.length-1] = save;
	}
	
// Trocar os valores de duas posições do vetor.
	static void swap (int a, int b, char[] v) {
		char save = v[a];
		v[a] = v[b];
		v[b] = save;
	}

// Inverter a ordem dos seus elementos.
	static void invert (char[]v) {
		int n = 0, m = v.length-1;
		for (int i = 0; i!=v.length;i++) {
			}
	}
	
}

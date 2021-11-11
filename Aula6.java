class Aula6 {

//	TRABALHO PREVIO
//	
//	A. Criar uma matriz retangular com números inteiros de 0 a 9 aleatórios, dado o 
//	   número de linhas e número de colunas.
//
//	   static int[][] randomMatrix(int lines, int columns) { }
	
	static int[][] randomMatrix(int lines, int columns) { 
		int [][] m = new int [lines][columns]; //@matrix
		
		for (int i=0 ; i < lines ; i++) {
			for (int j=0 ; j < columns ; j++) {
				m[i][j]=(int) (10*Math.random());
				System.out.printf("%d ", m[i][j]);
			}
			System.out.println();
		}
		return m;
	}
	
	static void testeRandomMatrix() {
		randomMatrix(2,3);
		
	}
	
//	B .Criar uma matriz quadrada com números inteiros de 0 a 9 aleatórios, dado 
//	   apenas um inteiro correspondente ao número de linhas/colunas.
	
	static int[][] randomSquareMatrix(int lines) { 
		return randomMatrix (lines, lines);
	}
	
	static void testeRandomSquareMatrix() {
		@SuppressWarnings("unused")
		int[][] mat;
		mat=randomSquareMatrix(3);
	}		
	
//	C. Obter o somatório de todos os elementos de uma matriz dada como argumento.
	
	static int somaMatrix(int [][] m) {
		int soma=0;
		
		for (int i=0 ; i < m.length ; i++)
			for (int j=0 ; j < m[i].length ; j++)
				soma+=m[i][j];
		return soma;
	}
	
	static void testeSomaMatrix() {
		System.out.print(somaMatrix(randomMatrix(2,3)));
	}
	
//	D .Saber o número de elementos de uma matriz dada como argumento. 
//	   Recorde que as linhas de uma matriz (vetores) não têm necessariamente o 
//	   mesmo comprimento.
		
	static int LengthMatrix(int [][] m) {
		int contador = 0;
		
		for (int i=0 ; i < m.length ; i++)
			contador+=m[i].length;
		return contador;
	}
	static void testeLengthMatrix() {
		int [][] m= { {1,2,3} , {4,5} };
		System.out.println(LengthMatrix(m));
		System.out.println(LengthMatrix(randomMatrix(3,4)));
	}
	
//	EXERCICIOS:
	
//	A. Obter todos os elementos da matriz num vetor.
//
//	   static int[] unroll(int[][] m) { }
	
	static int[] unroll(int[][] m) {
		int comp=LengthMatrix(m);
		int[] v= new int [comp];
		int k=0;
		
		for (int i=0 ; i < m.length ; i++)
			for (int j=0 ; j < m[i].length ; j++) {
				v[k]=m[i][j];
				k++;
			}
		return v;
		
	}
	static void testeUnroll() {
		int[] w=unroll(randomMatrix(2,3));
		
		for (int k=0 ; k < w.length ; k++)
			System.out.println(w[k]+" ");
	}
	
//	B. Criar uma matriz, dados um vetor com valores, um número de linhas, e 
//	   um número de colunas.
//
//	   static int[][] matrixFrom(int[] v, int lines, int columns) { }
	
	static int[][] matrixFrom(int[] v, int lines, int columns) {
		int [][] m = new int [lines][columns];
		int k=0;
		
		for (int i=0 ; i < lines ; i++)
			for (int j=0 ; j < columns ; j++) {
				m[i][j]=v[k];
				k++;
			}
		return m;
	}
	static void testeMatrixFrom() {
		int[] v={1,2,3,4,5,6};
		int linhas=2, colunas=3;
		int[][] mat=matrixFrom(v,2,3);
		
		for (int i=0 ; i < linhas ; i++) {
			for (int j=0 ; j < colunas ; j++)
				System.out.print(mat[i][j]+" ");
			System.out.println();
		}
	}
		
//	C. Verificar se uma matriz em Java (int[][]) é uma matriz de 
//	   Álgebra válida (i.e. se todas as linhas têm o mesmo comprimento).
	
	static boolean validaMatrix(int [][] m) {
		int colunas=m[0].length;
		
		for (int i=0 ; i < m.length ; i++)
			if (m[i].length!=colunas)
				return false;
		return true;
	}
	static void testeValidaMatrix() {
		int [][] m= {{1,2,3,},{4,5,6}}; //se tirar o 6 devolve false
		
		System.out.println(validaMatrix(m));
	}
	
//	D. Verificar se uma matriz em Java (int[][]) é uma matriz de Álgebra quadrada 
//	   válida (i.e. se todas as linhas têm o mesmo comprimento e se o número de linhas 
//	   corresponde ao número de colunas).
	
	static boolean validaMatrixQuadrada(int [][] m) {
		int colunas=m[0].length;
		
		if (m.length*colunas!=Math.pow(colunas,2))
			return false;
		
		for (int i=0 ; i < m.length ; i++)
			if (m[i].length!=colunas)
				return false;
		return true;
	}
	static void testeValidaMatrixQuadrada() {
		int [][] m= {{1,2},{4,5,6}}; 
		
		System.out.println(validaMatrix(m));
	}
	
//	E. Verificar se duas matrizes são iguais.
//	   Desenvolva uma classe estática contendo funções e procedimentos sobre matrizes algébricas, 
//	   assumindo que as matrizes são válidas no contexto da Álgebra (i.e. todas as linhas têm o 
//	   mesmo comprimento), permitindo:

//	m1[i][j] = m2[i][j]  VER VIDEOS NA NET DAS AULAS PASSADAS... ELE NAO FEZ
//			if =! false
	
//	F. Criar uma matriz identidade de tamanho n.
//
//	   static int[][] identity(int n) { }
	
	static int[][] identity(int n) {
		int [][] m= new int [n][n];
		
		for (int i=0 ; i < n ; i++)
			m[i][i]=1;
		return m;
	}
	
	static void testeIdentity() {
		int dim=3;
		
		int[][] mat=identity(dim);
		
		for (int i=0 ; i < dim ; i++) {
			for (int j=0 ; j < dim ; j++) {
				System.out.print(mat[i][j]+" ");
			}
			System.out.println();
		}
	}
	
				
//	 G. Multiplicar uma matriz por um escalar (modificando-a).
//
//	    static void multiplyByScalar(int[][] m, int s) { }
		
		static void multiplyByScalar(int[][] m, int s) {
			for (int i=0 ; i < m.length ; i++)
				for (int j=0 ; j < m[i].length ; j++)
					m[i][j]=s*m[i][j];
		}
		static void testeMultiplyByScalar() {
			int escalar=2;
			int[][] m = {{1,2,3},{4,5,6}};
			
			multiplyByScalar(m, escalar);
			
			for (int i=0 ; i < m.length ; i++) {
				for (int j=0 ; j < m[i].length ; j++) {
					System.out.print(m[i][j]+" ");
				}
				System.out.println();
			}
	    }
		
				
				
				
//	 H. Efetuar a adição de duas matrizes, sendo que a primeira é modificada ficando com o resultado da adição.
//
//	    static void accumulate(int[][] m1, int[][] m2) { }

		static void accumulate(int[][] m1, int[][] m2) {
			for (int i=0 ; i < m1.length ; i++) 
				for (int j=0 ; j < m1[i].length ; j++)
					m1[i][j]+=m2[i][j];
		}
			static void testeAccumulate() {
				int[][] mat1 ={{1,2,3},{4,5}};
				int[][] mat2 ={{10,20,30},{40,50}};
				
				accumulate(mat1, mat2);
				
				for (int i=0 ; i < mat1.length ; i++) {
					for (int j=0 ; j < mat1[i].length ; j++)
						System.out.print(mat1[i][j]+" ");
				}
				System.out.println();
		    }
		
		
		
//		I .Verificar se uma matriz é uma matriz identidade.
		
		static boolean checkIdentity(int[][] m) {
			for (int i=0 ; i < m.length ; i++)
				for (int j=0 ; j < m[i].length ; j++)
					if((i==j && m[i][j]!=1) || (i!=j && m[i][j]!=0))
						return false;
			return true;
		}
		static void testeCheckIdentity() {
			int [][] m1= {{1,2,3},{4,5,6}};
			int [][] m2= {{1,0,0},{0,1,0},{0,0,1}};
			
			System.out.println(checkIdentity(m1));
			System.out.println(checkIdentity(m2));		
        }		
	    
//		J. Obter uma coluna da matriz como um vetor, dado o índice da coluna.

		static int[] getColumn(int[][] m, int coluna) {
			int [] v= new int [m.length];
			
			for (int i=0 ; i < v.length ; i++)
				v[i]=m[i][coluna];
			return v;
		}
		static void testeGetColumn() {
			int [][] m= {{1,2,3},{4,5,6}};
			int coluna=0;
			
			int[] w;
			
			w=getColumn(m,coluna);
			
			for (int i=0 ; i < w.length ; i++)
				System.out.print(w[i]+" ");
		}
		
		
		
//		K. Obter a matriz transposta de uma matriz.
		
		static int[][] transposta(int[][] m1) {
			int [][] m2= new int [m1[0].length][m1.length];
			
			for (int i=0 ; i < m1.length ; i++)
				for (int j=0 ; j < m1[i].length ; j++)
					m2[j][i]=m1[i][j];
			return m2;
		}
		static void testeTransposta() {
			int[][] mat1 = {{1,2,3},{4,5,6}};
			@SuppressWarnings("unused")
			int[][] mat2 = {{1,2,3},{4,5,6},{7,8,9}};
			int[][] mat;
			
			mat=transposta(mat1);
			
			for (int i=0 ; i < mat.length ; i++)
				for (int j=0 ; j < mat[i].length ; j++)
					System.out.print(mat[i][j]+" ");
			
		System.out.println();
		}

					
		
		
//		L. Verificar se uma matriz é simétrica.
		
			static boolean CheckSimetry(int[][] m) {
				for (int i=0 ; i < m.length ; i++)
					for (int j=0 ; j < m[i].length ; j++)
						if(m[i][j] != m[j][i])
							return false;
				return true;
			}
			static void testeCheckSimetry() {
				int [][] m1= {{1,2,3},{3,4,5},{6,7,8}};
				int [][] m2= {{1,2,3},{2,5,6},{3,6,8}};
				
				System.out.println(CheckSimetry(m1));
				System.out.println(CheckSimetry(m2));
			}
		
		
		
//		ADICIONAIS:
//			A.Defina uma função para multiplicar duas matrizes, 
//			assumindo que as mesmas têm dimensões válidas para tal operação.
		
			static int[][] multiplica(int[][] m1, int[][] m2) {
				int [][] m= new int [m1.length][m2[0].length];
		
					for (int i=0 ; i < m1.length ; i++)
						for (int j=0 ; j < m2[0].length ; j++) 
							for (int k=0 ; k < m2.length ; k++) {
				m[i][j]+=m1[i][k]*m2[k][j];
				//System.out.print(i+" "+k+" "+m[i][j]+" ");
							}
					return m;
	
			}

			static void testeMultiplica() {
				int [][] mat1= {{1,2},{4,5}};
				int [][] mat2= {{1,2,3},{4,5,6}};
				int [][] mat;
	
				mat=multiplica(mat1,mat2);
					for (int i=0 ; i < mat.length ; i++) {
						for (int j=0 ; j < mat[i].length ; j++) {
							System.out.print(mat[i][j]+" ");
						}
							System.out.println();
					}
			}
	}



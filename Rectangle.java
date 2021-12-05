class Rectangle {

	final int width;
	final int height;
	
	Rectangle (int width, int height) {
		this.width = width;
		this.height = height;
	}
	
	// 1. Defina um método construtor adicional que cria um quadrado, dado apenas um parâmetro para a dimensão do lado. 
	// Aqui pode ser utilizada a primitiva this para que a execução deste construtor corresponda a uma invocação do outro.
	
	Rectangle (int side) {
		this(side,side); // chama o construtor de cima
	}
	
	int getWidth() {
		return this.width;
	}
	
	int getHeight() {
		return this.height;
	}
	
	// A2. Defina funções que permitam obter a seguinte informação sobre o retângulo:
	// a. área
	// b. perímetro
	// c. comprimento da diagonal
	// d. se o retângulo é um quadrado
	
	double getArea() {
		return width * height;
	}
	
	int getPerimiter() {
		return (width*2 + height*2);
	}
	
	double getDiagonal() {
		return (Math.sqrt(Math.pow(width,2) + Math.pow(height,2)));
	}
	
	boolean isSquare() {
		return width==height;
	}
	
	// A3.a) Defina funções que permitam obter um novo objeto retângulo:
	// escalando o retângulo dado um fator, por exemplo, escalar um retângulo 4x5 por 2 daria origem a um novo retângulo 8x10.  
	// Caso o fator seja igual a 1, deverá ser devolvido o próprio retângulo (this).

	Rectangle scale(int scale) {
		if (scale == 1) {
			return this; // IMPORTANTE
		} else {
			Rectangle newR = new Rectangle(width*scale,height*scale);
			return newR;
		}
	}
	
	// 3.b) somando outro retangulo, por exemplo, o retângulo 3x4 somado com os valores 4 e 5 daria origem a um retângulo 7x9.
	Rectangle sumRectangle (int width, int height) {
		Rectangle r = new Rectangle(this.width + width,this.height + height);
		return r;
	}
	
	// 4. Defina uma função que dado um retângulo r, 
	// indica se o retângulo que invoca a função é maior em termos de área que r.
	boolean bigger(Rectangle r1) {
		if (this.getArea() > r1.getArea())
			return true;
		else
			return false;
	}
	
	// 5. Defina uma função estática (static) que dados dois retângulos, devolve o retângulo que tem a área maior. 
	// Caso os retângulos tenham áreas iguais deverá ser devolvido o primeiro.	
	static Rectangle max(Rectangle r1, Rectangle r2) {
		if (r1.getArea() >= r2.getArea())
			return r1;
		else
			return r2;
	}
}

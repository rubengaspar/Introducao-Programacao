// Exercicios Color

class Aula7 {
 	
  // a) Construir uma cor aleatória
  static Color randomColor() {
				
		int r = (int) (Math.random() * 255);
		int g = (int) (Math.random() * 255);
		int b = (int) (Math.random() * 255);
		
		Color c = new Color(r,g,b);	
		return c;
	} 
  
 	// b) Construir um vetor de cores aleatórias dado um comprimento
	
	static Color[] randomColorArray(int length) {     
		
		Color[] colors = new Color[length];
		
		for (int i = 0; i != colors.length; i++)
			colors[i] = randomColor();
			
		return colors;
	}
  
  	// c) Dada uma cor, obter a cor inversa (255 - R, 255 - G, 255 - B)
	
	static Color inverted(Color color) {    
		
		Color invColor = new Color(255 - color.getR(), 255 - color.getG(), 255 - color.getB());
		
		return invColor;
	}
	
	static void cor (int r, int g, int b) {
		
		Color cor = new Color(r,g,b);
		Color invColor = inverted(cor);
		
		System.out.println(r + " became " + invColor.getR());
		System.out.println(g + " became " + invColor.getG());
		System.out.println(b + " became " + invColor.getB());
		
	}
  
  	// d)  Dada uma cor, obter uma cor mais clara/escura, dependendo de um acréscimo (delta) 
	// (positivo - mais clara; negativo - mais escura). Deve ter-se atenção para os valores se manterem válidos.
	
	static Color changeBrightness (Color color, int delta) {    
		
		int min = 0;
		int max = 255;
				
		if ( ((color.getR() + delta) < min) || ((color.getG() + delta) < min) || ((color.getB() + delta) < min) ||
			((color.getR() + delta) > max) || ((color.getG() + delta) > max) || ((color.getB() + delta) > max))  {
			
			System.out.println("Luminance Change too high");
			return color;
		
		} else {
			Color newColor = new Color(color.getR() + delta, color.getG() + delta, color.getB() + delta);
			return newColor;
		}		
	}
	
	static void testChangeBrightness (int delta) {
		
		Color c = new Color (0,0,0);
		
		System.out.println("Luminosidade Inicial: " + c.getLuminance());			
		System.out.println("Nova Luminosidade: " + changeBrightness(c, delta).getLuminance());
	}
  
  	// Imagens Binárias
	
	// a) Criar uma imagem aleatória dada uma dimensão. 
	// A probabilidade de um píxel ser branco ou preto deverá ser equivalente
	
	static BinaryImage randomImage (int x, int y) {
		
		BinaryImage randomImage = new BinaryImage(x,y);
		
		for (int w = 0; w != randomImage.getWidth(); w++) {
			for (int h = 0; h != randomImage.getHeight(); h++) {
				if (Math.random()*10 < 5)
				randomImage.setBlack(w, h);
				else
				randomImage.setWhite(w, h);
			}
		}
	
		return randomImage;
	}
	
	static void testImage (int x, int y) {
		int countW = 0;
		int countB = 0;
		
		BinaryImage randomImage = randomImage(x,y);
				
		for (int w = 0; w != randomImage.getWidth(); w++) 
			for (int h = 0; h != randomImage.getHeight(); h++)
				if (randomImage.isBlack(w, h) == true)
					countB += 1;
				else
					countW += 1;
				
		System.out.println("White: " + countW + "\nBlack: " + countB);
		paintSquare(randomImage, 20, 20, 20);
	}
	
	// b) Preencher um quadrado branco fornecendo o ponto do canto superior esquerdo (x, y) e o comprimento de lado (side) do quadrado.
	
	static void paintSquare (BinaryImage img, int x, int y, int side) {
		
		for (int w = x; w <= (x+side); w++)
			for (int h = y; h <= (y+side); h++)
				img.setWhite(w, h);
		
	}
	

	// c) Desenhar um contorno a preto nos píxeis limite da imagem
	static void paintSquareWithBorder (BinaryImage img, int x, int y, int side) {
		
		for (int w = x; w <= (x+side); w++) {
			for (int h = y; h <= (x+side); h++) {
				if (w == x || w == (x+side) || h == y || h == (y+side))
					img.setBlack(w, h);
				else
					img.setWhite(w, h);
			}
		}
	}

	static void testPaintSquare () {
		BinaryImage img = randomImage(200, 400);
		paintSquare(img, 60 , 60, 40);
		return;
	}
	
	// d) Criar uma imagem binária que forme um tabuleiro de xadrez, indicando o número de pixels de cada posição. 
	//Note que há uma linha de um píxel em torno do tabuleiro. Pode utilizar a função paintSquare(...) desenvolvida anteriormente.
	// BinaryImage board = createChessBoard(15);
	static BinaryImage createChessBoard(int a) {
		
		BinaryImage chess = new BinaryImage(a*8, a*8);
		

		for (int x = 0; x < 8; x++) {
			for (int y = 0; y < 8; y++) {
				if ((y % 2 == 0) == (x % 2 == 0)) 
					paintSquare(chess, (a*x), (a*y), a-1);
			}
		}
		return chess;
	}
			
	// e) Inverter uma imagem binária, de forma a que cada pixel branco passe a preto, e vice-versa. 
	// Desenvolva duas versões, um procedimento (que transforma a imagem) e uma função 
	// (que cria uma imagem nova e deixa a existente inalterada).
	static void invertImage (BinaryImage img) {
		
		for (int w = 0; w != img.getWidth(); w++) 
			for (int h = 0; h != img.getHeight(); h++)
				if (img.isBlack(w,h))
					img.setWhite(w,h);
				else
					img.setBlack(w,h);		
		
	}
	
	static void testInvert () {
		BinaryImage img = createChessBoard(20);
		
		System.out.println("Is the first square Black? " + img.isBlack(0,0));
		
		invertImage(img);
		
		System.out.println("Image Inverted");
		System.out.println("Is the first square White? " + !img.isBlack(0,0));
	}
	
	
	// f) Criar uma imagem escalada por um fator (p.e., fator 2 duplica o tamanho da imagem).
	// BinaryImage chess = createChessBoard(15);
	// BinaryImage chessBig = scale(chess, 2);
	
	static BinaryImage scale (BinaryImage img, int a) {
		
		BinaryImage scale = new BinaryImage(img.getWidth()*a,img.getHeight()*a);
		
		for (int x = 0; x < img.getHeight(); x++) {
			for (int y = 0; y < img.getWidth(); y++) {
				if (img.isBlack(x,y)) {
					scale.setBlack(x,y);
					
				} else {
					scale.setWhite(x,y);
					
				}
			}
		}
		return scale;
	}
	
	static void testScale () {
	}
	
	//	g) Criar uma imagem binária através da sobreposição de duas imagens binárias, sendo que: 
	//		se um pixel é branco em ambas as imagens, será branco na nova imagem; 
	//		se um pixel é preto numa das imagens, será preto na nova imagem.
	//		BinaryImage merge = merge(chess, chessBig);
	
	static BinaryImage merge(BinaryImage img1, BinaryImage img2) {
		
		int w, h;
		///////////////////////////////////////////
		//mudar para colar o a imagem mais pequena a ser colada na maior
		//////////////////////////////////////////
		w = Math.min(img1.getWidth(),img2.getWidth());
		h = Math.min(img1.getHeight(),img2.getHeight());
		
		
		BinaryImage merge = new BinaryImage(w,h);
		
		for (int x = 0; x < w; x++) {
			for (int y = 0; y < h; y++) {
				if ((img1.isBlack(x,y) == false) && (img2.isBlack(x,y)) == false) {
					merge.setWhite(x,y);
				} else {
					merge.setBlack(x,y);
				}
			}
		}
		return merge;
	}
	
	static void testMerge() {
		BinaryImage img1 = randomImage(200, 100);
		BinaryImage img2 = randomImage(200, 200);
		
		System.out.println("Images Created, Merging");
		merge(img1, img2);
		System.out.println("Images Merged");
	}
	
	//	h) Pintar um círculo de pontos aleatórios numa imagem dada, dados o centro do círculo e o raio.
	//	Neste exemplo, foi pintado um círculo com centro no ponto (50, 100) e raio 20 numa imagem preta de dimensões 100x200.
	
	static BinaryImage circle(int x, int y, int raio) {
		
		BinaryImage circle = new BinaryImage(400,400);
		
		for (int w = 0; w < circle.getWidth(); w++)
			for (int h = 0; h < circle.getHeight(); h++)
				if (Math.sqrt( (x-w)*(x-w)+(y-h)*(y-h)) < raio) // (x-x0)^2 + (y-y0)^2 = r
					if (Math.random() < 0.5)
						circle.setWhite(w,h);
		
		return circle;
	}
}

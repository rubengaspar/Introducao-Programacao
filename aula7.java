// Exercicios Color

class aula7 {
 	
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
  
  
}

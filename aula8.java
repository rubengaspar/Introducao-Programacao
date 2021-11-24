class aula8 {

	// 1. Inverter cores
	static ColorImage testInvert() {
		
		ColorImage img = new ColorImage("C:\\Users\\ruben\\eclipse-workspace\\aula4\\src\\objc1.png");
		
		img = img.invertColor(img);
		
		return img;
	}
	
	
	// 2. Mais escuro/claro
	static ColorImage testChangeBrightness() {
		
		ColorImage img = new ColorImage("C:\\Users\\ruben\\eclipse-workspace\\aula4\\src\\objc1.png");
		
		img = img.changeBrightness(img, -50);
		
		return img;
	}
	
	// 3. Espelhar a imagem horizontalmente.
	static ColorImage testHorizontal() {
		
		ColorImage img = new ColorImage("C:\\Users\\ruben\\eclipse-workspace\\aula4\\src\\objc1.png");
		
		img = img.horizontal(img);
		
		return img;
	}
	
	// 4. Modificar uma imagem, colando-lhe outra imagem (paste) em determinado ponto.
	static ColorImage testPaste() {
		ColorImage salazar = new ColorImage("C:\\Users\\ruben\\eclipse-workspace\\aula4\\src\\objc1.png");
		ColorImage superMario = new ColorImage("C:\\Users\\ruben\\eclipse-workspace\\aula4\\src\\supermario.png");
		
		salazar.paste(salazar, superMario, 50, 80);
		
		return salazar;
	}
	
	
	// 5. Devolver uma versão da imagem a preto e branco (obtendo uma nova imagem). 
	// Para tal, obtenha o valor da luminância da cor de cada píxel. 
	// Se a luminância for menor que 128, o píxel nessa posição na imagem a preto e branco deve ser preto, caso contrário deve ser branco.
	static ColorImage testBW() {
		ColorImage salazar = new ColorImage("C:\\Users\\ruben\\eclipse-workspace\\aula4\\src\\objc1.png");
		ColorImage superMario = new ColorImage("C:\\Users\\ruben\\eclipse-workspace\\aula4\\src\\supermario.png");
		
		salazar = salazar.bw(salazar);
		superMario = superMario.bw(superMario);
		
		return salazar;
	}
	
	// 6. Devolver uma copia de uma imgem
	static ColorImage testCopia() {
		
		ColorImage salazar = new ColorImage("C:\\Users\\ruben\\eclipse-workspace\\aula4\\src\\objc1.png");
		ColorImage copy = salazar.copy(salazar);
		
		return copy;
	}
	
	// 7. Devolver uma seleção rectangular da imagem, dados o canto superior esquerdo e o canto inferior direito.
	static ColorImage testSelection() {
		ColorImage salazar = new ColorImage("C:\\Users\\ruben\\eclipse-workspace\\aula4\\src\\objc1.png");
		
		ColorImage selection = salazar.selection(salazar, 30, 30, 70, 150);
	
		return selection;
	}
	
	
}

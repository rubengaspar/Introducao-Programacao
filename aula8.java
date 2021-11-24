class aula8 {
	
	// 1. Inverter cores
	static ColorImage testInvert() {
		
		ColorImage img = new ColorImage(".\\src\\objc1.png");
		
		img = img.invertColor(img);
		
		return img;
	}
	
	
	// 2. Mais escuro/claro
	static ColorImage testChangeBrightness() {
		
		ColorImage img = new ColorImage(".\\src\\objc1.png");
		
		img = img.changeBrightness(img, 100);
		
		return img;
	}
	
	// 3. Espelhar a imagem horizontalmente.
	static ColorImage testMirrorH() {
		
		ColorImage img = new ColorImage(".\\src\\objc1.png");
		
		img = img.mirrorH(img);
		
		return img;
	}
	
	// 4. Modificar uma imagem, colando-lhe outra imagem (paste) em determinado ponto.
	static ColorImage testPaste() {
		ColorImage salazar = new ColorImage(".\\src\\objc1.png");
		ColorImage superMario = new ColorImage(".\\src\\ISCTE.png");
		
		salazar.paste(salazar, superMario, 50, 80);
		
		return salazar;
	}
	
	
	// 5. Devolver uma versão da imagem a preto e branco (obtendo uma nova imagem). 
	// Para tal, obtenha o valor da luminância da cor de cada píxel. 
	// Se a luminância for menor que 128, o píxel nessa posição na imagem a preto e branco deve ser preto, caso contrário deve ser branco.
	static ColorImage testBW() {
		ColorImage salazar = new ColorImage(".\\src\\objc1.png");
		ColorImage superMario = new ColorImage(".\\src\\iscte.png");
		
		salazar = salazar.bw(salazar);
		superMario = superMario.bw(superMario);
		
		return salazar;
	}
	
	// 6. Devolver uma copia de uma imgem
	static ColorImage testCopia() {
		
		ColorImage salazar = new ColorImage(".\\src\\objc1.png");
		ColorImage copy = salazar.copy(salazar);
		
		return copy;
	}
	
	// 7. Devolver uma seleção rectangular da imagem, dados o canto superior esquerdo e o canto inferior direito.
	static ColorImage testSelection() {
		ColorImage salazar = new ColorImage(".\\src\\objc1.png");
		
		ColorImage selection = salazar.selection(salazar, 30, 30, 70, 150);
	
	return selection;
	}
	
	// B1. Aplicar um efeito de posterize, indicando uma cor para os píxeis escuros e uma cor para os pixels claros.
	static ColorImage testPosterize() {
		ColorImage salazar = new ColorImage(".\\src\\objc1.png");
		
		ColorImage posterize = Images.posterize(salazar, Color.Blue, Color.White);
		
	return posterize;
	}
	
	// B2. Test popArt
	static ColorImage testPopArt() {
		ColorImage salazar = new ColorImage(".\\src\\objc1.png");
		
		ColorImage popArt = Images.popArt(salazar);
		
	return popArt;
	}
	
	// C1. Criar um vector com quatro imagens, uma para cada quarto de uma imagem.
	static ColorImage[] testVector() {
		
		ColorImage salazar = new ColorImage(".\\src\\objc1.png");
		ColorImage[] imgVector = Images.imgVector(salazar);
		
		return imgVector;
	}
	
	// C2. Construir uma imagem nova, juntando duas imagens horizontalmente.
	static ColorImage testMerge() {
		ColorImage salazar = new ColorImage(".\\src\\objc1.png");

		ColorImage trim1 = salazar.selection(salazar,0,0,100,150); //100x150
		ColorImage trim2 = salazar.selection(salazar,100,0,150,150); //50x150

		ColorImage hMerge = Images.hMerge(trim1,trim2); //150x150
		
		return hMerge;		
	}
}

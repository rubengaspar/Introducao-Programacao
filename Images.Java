class Images {

	
	
	
	// B) Desenvolva uma classe estática Images, contendo funções e procedimentos para manipulação de imagens a cores, permitindo
	// B1. Aplicar um efeito de posterize, indicando uma cor para os píxeis escuros e uma cor para os pixels claros.
	static ColorImage posterize(ColorImage img, Color c1, Color c2) {
		
		ColorImage newImg = new ColorImage(img.getWidth(),img.getHeight());
		
		for (int x = 0; x != img.getWidth(); x++) {
			for (int y = 0; y != img.getHeight(); y++) {
				if (img.getColor(x, y).getLuminance() < 128)
					newImg.setColor(x, y, c1);
				else
					newImg.setColor(x, y, c2);
			}
		}
			
		return newImg;
	}	
	
	
	
	
	// B2. A partir de uma imagem, produzir outra imagem estilo "pop art" (ao jeito do exemplo dado).
	static ColorImage popArt(ColorImage img) {
		
		ColorImage popArt = new ColorImage(img.getWidth()*2, img.getHeight()*2);
		
		for (int x = 0; x < 2 ;x++) {
			for (int y = 0; y < 2 ;y++) {
				if (y<=0)
					popArt.paste(posterize(popArt,Color.Blue,Color.White), img, x*img.getWidth(), y*img.getHeight());				
				else
					popArt.paste(popArt.mirrorH(posterize(popArt,Color.Blue,Color.White)), img, x*img.getWidth(), y*img.getHeight());	
			}
		}
		
		return popArt;
	}

	// C) Acrescente à classe estática Images, funções e procedimentos para
	// C1. Criar um vector com quatro imagens, uma para cada quarto de uma imagem.
	
	
	
	
	
	// C2. Construir uma imagem nova, juntando duas imagens horizontalmente.
	
	
	
	
	
}

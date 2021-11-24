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
	
	// testing random colors
	static ColorImage post2(ColorImage img) {
		
		ColorImage newImg = new ColorImage(img.getWidth(),img.getHeight());
		
		Color c1 = new Color(	(int)Math.random()*255,
								(int)Math.random()*255,
								(int)Math.random()*255);

		Color c2 = new Color(	(int)Math.random()*255,
								(int)Math.random()*255,
								(int)Math.random()*255);
		
		
		for (int x = 0; x != img.getWidth(); x++) {
			for (int y = 0; y != img.getHeight(); y++) {
				if (img.getColor(x, y).getLuminance() < 128) {
					newImg.setColor(x, y, c1);
					c1.brighter(c1,50);
				} else {
					newImg.setColor(x, y, c2);
					c2.brighter(c2,50);
				}
			}
		}
		return newImg;
	}	
	
	
	
	// B2. A partir de uma imagem, produzir outra imagem estilo "pop art" (ao jeito do exemplo dado).
	static ColorImage popArt(ColorImage img) {
		
		ColorImage popArt = new ColorImage(img.getWidth()*2, img.getHeight()*2);
		
		for (int x = 0; x < 2 ;x++) {
			for (int y = 0; y < 2 ;y++) {
				if (x<=0)
					popArt.paste(popArt, post2(img), x*img.getWidth(), y*img.getHeight());				
				else
					popArt.paste(popArt, img.mirrorH(post2(img)), x*img.getWidth(), y*img.getHeight());	
			}
		}
		return popArt;
	}

	// C) Acrescente à classe estática Images, funções e procedimentos para
	// C1. Criar um vector com quatro imagens, uma para cada quarto de uma imagem.
	static ColorImage[] imgVector (ColorImage img1) {
		
		ColorImage img = img1;
		ColorImage[] imgVector = new ColorImage[4];
		
		for (int i = 0; i != imgVector.length; i++) {
			imgVector[i] = img.selection(img,20,20,100,70);
		}
		return imgVector;
	}
	
	// C2. Construir uma imagem nova, juntando duas imagens horizontalmente.
	static ColorImage hMerge(ColorImage img1, ColorImage img2) {
		
		ColorImage hMerge = new ColorImage(	img1.getWidth() + img2.getWidth(), 
											img1.getHeight());
		
		for (int x = 0; x != hMerge.getWidth(); x++) {
			for (int y = 0; y != hMerge.getHeight(); y++) {
				if (x < img1.getWidth())
					hMerge.setColor(x,y,img1.getColor(x,y));
				else
					hMerge.setColor(x,y,img2.getColor(x-img1.getWidth(),y));
			}
		}
		return hMerge;
	}
}

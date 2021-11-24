/**
 * Represents color images.
 * Image data is represented as a matrix:
 * - the number of lines corresponds to the image height (data.length)
 * - the length of the lines corresponds to the image width (data[*].length)
 * - pixel color is encoded as integers (ARGB)
 */
class ColorImage {

	private int[][] data; // @colorimage

	ColorImage(String file) {
		this.data = ImageUtil.readColorImage(file);
	}

	ColorImage(int width, int height) {
		data = new int[height][width];
	}

	int getWidth() {
		return data[0].length;
	}

	int getHeight() {
		return data.length;
	}

	void setColor(int x, int y, Color c) {
		data[y][x] = ImageUtil.encodeRgb(c.getR(), c.getG(), c.getB());
	}

	Color getColor(int x, int y) {
		int[] rgb = ImageUtil.decodeRgb(data[y][x]);
		return new Color(rgb[0], rgb[1], rgb[2]);
	}
	
	// 1. Inverter as cores de uma imagem. Deverá ser utilizada a função desenvolvida 
	// nos exercícios sobre cores
	
	ColorImage invertColor(ColorImage img) {    
		
		ColorImage newImg = new ColorImage(img.getWidth(),img.getHeight());
		
		for (int x = 0; x != img.getWidth(); x++) {
			for (int y = 0; y != img.getHeight(); y++) {
				Color invColor = new Color( 255 - img.getColor(x, y).getR(), 
											255 - img.getColor(x,y).getG(), 
											255 - img.getColor(x,y).getB());
				newImg.setColor(x,y,invColor);
			}
		}
		
	return newImg;
	}
	
	// 2. Transformar a imagem, tornando-a mais clara de acordo com um valor dado. 
	// Um valor positivo torna a imagem mais clara, um valor negativo torna a 
	// imagem mais escura. Deverá ser utilizada a função desenvolvida nos exercícios sobre cores.
	
	ColorImage changeBrightness (ColorImage img, int delta) {    
		
		ColorImage newImg = new ColorImage(img.getWidth(), img.getHeight());
	
		for (int x = 0; x != img.getWidth(); x++) {
			for (int y = 0; y != img.getHeight(); y++) {
				if ( ((img.getColor(x,y).getR() + delta) < 0) || 
					 ((img.getColor(x,y).getG() + delta) < 0) || 
					 ((img.getColor(x,y).getB() + delta) < 0) ||
					 ((img.getColor(x,y).getR() + delta) > 255) || 
					 ((img.getColor(x,y).getG() + delta) > 255) || 
					 ((img.getColor(x,y).getB() + delta) > 255)) {
					
					Color newColor1 = img.getColor(x, y);
					newImg.setColor(x, y, newColor1);
				
				} else {
					Color newColor2 = new Color( delta + img.getColor(x,y).getR(), 
												delta + img.getColor(x,y).getG(), 
												delta + img.getColor(x,y).getB());
					newImg.setColor(x, y, newColor2);
					
				}		
			}	
		}
		return newImg;
	}
	
	// 3. Espelhar a imagem horizontalmente.
	ColorImage horizontal(ColorImage img) {
		
		ColorImage newImg = new ColorImage(img.getWidth(),img.getHeight());
		
		for (int x = 0; x != img.getWidth(); x++) {
			for (int y = 0; y != img.getHeight(); y++) {
				newImg.setColor(x, y, img.getColor(img.getWidth()-1-x, y));
			}
		}
		return newImg;
		
	}
	
	// 4. Modificar uma imagem, colando-lhe outra imagem (paste) em determinado ponto.
	
	ColorImage paste(ColorImage img1, ColorImage img2, int w, int h) {
		
		ColorImage newImg = new ColorImage(img1.getWidth(), img1.getHeight());
		
		for (int x = 0; x != img2.getWidth(); x++) {
			for (int y = 0; y != img2.getHeight();y++) {
				img1.setColor(x+w, y+h, img2.getColor(x, y));
			}
		}
		
		return newImg;
	}
	
	// 5. Devolver uma versão da imagem a preto e branco (obtendo uma nova imagem). 
	// Para tal, obtenha o valor da luminância da cor de cada píxel. 
	// Se a luminância for menor que 128, o píxel nessa posição na imagem a preto e branco deve ser preto, caso contrário deve ser branco.

	ColorImage bw(ColorImage img) {
		
		ColorImage newImg = new ColorImage(img.getWidth(),img.getHeight());
		
		for (int x = 0; x != img.getWidth(); x++) {
			for (int y = 0; y != img.getHeight(); y++) {
				if (img.getColor(x, y).getLuminance() < 128)
					newImg.setColor(x, y, Color.Black);
				else
					newImg.setColor(x, y, Color.White);
			}
		}
			
		return newImg;
	}
	
	// 6. Devolver uma copia de uma imgem
	ColorImage copy(ColorImage img) {
		
		ColorImage copy = new ColorImage(img.getWidth(),img.getHeight());
		
		for (int x = 0; x != img.getWidth(); x++) {
			for (int y = 0; y != img.getHeight(); y++) {
				copy.setColor(x, y, img.getColor(x, y));
			}
		}
		return copy;
	}
	
	// 7. Devolver uma seleção rectangular da imagem, dados o canto superior esquerdo e o canto inferior direito.
	ColorImage selection(ColorImage img, int startx, int starty, int endx, int endy) {
		
		ColorImage selection = new ColorImage(endx-startx,endy-starty);
		
		for (int x = startx; x != endx; x++) {
			for (int y = starty; y != endy; y++) {
				selection.setColor(x-startx, y-starty, img.getColor(x, y));
			}
		}
		return selection;
	}
	
	
}

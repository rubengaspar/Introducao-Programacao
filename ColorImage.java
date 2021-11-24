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
	
	Color inverted(Color c) {    
		Color invColor = new Color(255 - c.getR(), 255 - c.getG(), 255 - c.getB());
	return invColor;
	}
	
	// 2. Transformar a imagem, tornando-a mais clara de acordo com um valor dado. 
	// Um valor positivo torna a imagem mais clara, um valor negativo torna a 
	// imagem mais escura. Deverá ser utilizada a função desenvolvida nos exercícios sobre cores.
	
	Color changeBrightness (Color c, int delta) {    
		
		int min = 0;
		int max = 255;
				
		if ( ((c.getR() + delta) < min) || 
			((c.getG() + delta) < min) || 
			((c.getB() + delta) < min) ||
			((c.getR() + delta) > max) || 
			((c.getG() + delta) > max) || 
			((c.getB() + delta) > max))  {
			
			System.out.println("Luminance Change too high");
			return c;
		
		} else {
			Color newColor = new Color(c.getR() + delta, c.getG() + delta, c.getB() + delta);
			return newColor;
		}		
	}
}

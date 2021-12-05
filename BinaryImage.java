class BinaryImage {
	
	private boolean[][] data; // @binaryimage
	
	/**
	 * Creates a binary image from the given image file (GIF, JPG, PNG).
	 * The pixels of the original image will be converted to
	 * black/white according to their luminance value.
	 */
	BinaryImage(String path) {
		this.data = ImageUtil.readBinaryImage(path);
	}
	
	/**
	 * Creates a black binary image with the given dimension in pixels.
	 */
	BinaryImage(int width, int height) {
		data = new boolean[height][width];
	}
	
	// C1. Um construtor que permita criar uma imagem com dimensão dada por um retângulo.
	BinaryImage(Rectangle r) {
		data = new boolean[r.getHeight()][r.getWidth()];
		// podia usar: this(r.getHeight(), r.getWidth());
	}

	/**
	 * Image width in pixels,
	 */
	int getWidth() {
		return data[0].length;
	}
	
	/**
	 * Image height in pixels,
	 */
	int getHeight() {
		return data.length;
	}
	
	/**
	 * Is pixel at (x, y) black?
	 */
	boolean isBlack(int x, int y) {
		validatePosition(x, y);
		return !data[y][x];
	}
	
	/**
	 * Sets the pixel at (x, y) to white.
	 */
	void setWhite(int x, int y) {
		validatePosition(x, y);
		data[y][x] = true;
	}
	
	/**
	 * Sets the pixel at (x, y) to black.
	 */
	void setBlack(int x, int y) {
		validatePosition(x, y);
		data[y][x] = false;
	}
	
	/**
	 * Is (x, y) a valid pixel position in this image?
	 */
	boolean validPosition(int x, int y) {
		return 
			x >= 0 && x < getWidth() &&
			y >= 0 && y < getHeight();
	}
	
	void validatePosition(int x, int y) {
		if(!validPosition(x, y))
			throw new IllegalArgumentException(
					"invalid point " + x + ", " + y + 
					": matrix dimension is " + getWidth() + " x " + getHeight());
	}
	
	// C2. Uma função para obter a dimensão da imagem num objeto Rectangle.
	Rectangle dimensao(BinaryImage img) {
		Rectangle r = new Rectangle(img.getWidth(), img.getHeight());
		return r;
	}
	
	// C3. Uma função que dado um ponto (Point) permite saber se o píxel nessa coordenada é branco.
	boolean isWhite(Point p) {
		return !isBlack(p.getX(),p.getY());
	}
	
	// C4. Um procedimento para pintar um píxel no ponto dado a branco ou preto
	
	void paint(Point p, boolean cor) {
		if (cor)
			this.setWhite(p.getX(),p.getY());
		else
			this.setBlack(p.getX(),p.getY());
	}
	
	// C5. Uma função para saber quantos píxeis brancos ou pretos existem na imagem.
	int getCount(boolean white) {
		int whites = 0, blacks = 0;
		
		for  (int x = 0; x < this.getHeight(); x++)
			for (int y = 0; y < this.getWidth(); y++)
				if (this.isBlack(y, x))
					blacks++;
				else
					whites++;
		if(white)
			return whites;
		else
			return blacks;
	}
	
	
	
	// C6. Uma função para obter todos os pontos da imagem com a cor branca ou preta.
	Point[] getPoints(boolean cor) {
		
		int wb = getCount(cor), k = 0;
		Point[] p = new Point[wb];
		
		for (int i = 0; i < this.getHeight(); i++)
			for (int j = 0; j < this.getWidth(); j++) {
				if (cor && !isBlack(j,i))
						p[k++] = new Point(j,i);
				if (!cor && isBlack(j,i))
					p[k++] = new Point(j,i);
			}				
		return p;
	}
	
	
	// C7. Um procedimento para inverter a cor de todos os píxeis da imagem.
	void invert() {
		for (int i = 0; i < this.getHeight(); i++)
			for (int j = 0; j < this.getWidth(); j++) {
				if (this.isBlack(j,i))
					this.setWhite(j,i);
				else
					this.setBlack(j,i);
			}
	}
	
	// C8.  Um procedimento para preencher um retângulo a branco, 
	//		dado um ponto para o canto superior esquerdo e uma dimensão.
	void fillRectangle(Point p, Rectangle r) {
		for (int i=p.getY(); i < p.getY()+r.getHeight(); i++)
			for (int j=p.getX(); j < p.getX()+r.getWidth(); j++)
				this.setWhite(j,i);
	}
	
	// C9. Um procedimento similar ao anterior, mas onde apenas o contorno do retângulo é pintado.
	void contorno(Point p, Rectangle r) {
		int i, j;
		
		i = p.getY();
		for (j = p.getX(); j < p.getX()+r.getWidth(); j++)
			this.setWhite(j,i);
		
		i= p.getY()+r.getHeight();
		for (i = p.getX(); j < p.getX()+r.getWidth(); j++)
			this.setWhite(j,i);
		
		j = p.getX();
		for (i = p.getY(); i < p.getY()+r.getHeight(); i++)
			this.setWhite(j,i);
		
		j = p.getX()+getWidth();
		for (i = p.getY(); i < p.getY()+r.getHeight(); i++)
			this.setWhite(j,i);	
	
	// nao gosto da forma como o prof fez - refazer com um ciclo apenas
	
	}
		
	// C10. Um procedimento que reduz/expande a imagem para uma nova dimensão dada num retângulo. 
	// 		As reduções/expansões serão ancoradas no canto superior esquerdo, 
	//		e no caso das expansões os novos píxeis deverão ficar com a cor preta.
	
	
}

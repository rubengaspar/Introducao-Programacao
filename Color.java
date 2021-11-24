/**
 * Represents RGB colors.
 * RGB values are stored in a 3-position array, with values in the interval [0, 255].
 * rgb[0] - Red
 * rgb[1] - Green
 * rgb[2] - Blue
 */
class Color {

	private final int[] rgb; // @color

	/**
	 * Creates an RGB color. Provided values have to 
	 * be in the interval [0, 255]
	 */
	Color(int r, int g, int b) {
		if(!valid(r) || !valid(g) || !valid(b))
			throw new IllegalArgumentException("invalid RGB values: " + r + ", " + g + ", " + b);
		
		this.rgb = new int[] {r, g, b};
	}

	/**
	 * Red value [0, 255]
	 */
	int getR() {
		return rgb[0];
	}

	/**
	 * Green value [0, 255]
	 */
	int getG() {
		return rgb[1];
	}

	/**
	 * Blue value [0, 255]
	 */
	int getB() {
		return rgb[2];
	}

	/**
	 * Obtains the luminance in the interval [0, 255].
	 */
	int getLuminance() {
		return (int) Math.round(rgb[0]*.21 + rgb[1]*.71 + rgb[2]*.08);
	}

	static boolean valid(int value) {
		return value >= 0 && value <= 255;
	}
	
	// Acrescente à classe Color constantes que representem as cores mais comuns 
	// (branco, preto, vermelho, verde, azul, etc.).
	static final Color Red = new Color(255,0,0);
	static final Color Green = new Color(0,255,0);
	static final Color Blue = new Color(0,0,255);
	static final Color White = new Color(255,255,255);
	static final Color Black = new Color(0,0,0);
	
	// Devolver a cor inversa (255 - R, 255 - G, 255 - B).
	Color getInv(Color c){
		Color newC = new Color(255 - c.getR(), 255 - c.getG(), 255 - c.getB());		
		return newC;
	}
	
	// Devolver uma cor mais clara/escura, dependendo de um valor 
	// (positivo - mais clara; negativo - mais escura).
	Color brighter(Color c, int value) {
		Color newC = new Color(c.getR() + value, c.getG() + value, c.getB() + value);
		return newC;
	}
	// Dada uma cor, devolver verdadeiro se os valores RGB forem 
	// iguais ao da cor que invoca a operação ou falso, caso contrário.
	Boolean sameColor(Color c) {
		return (c.getR() == c.getG() && c.getR() == c.getB());
	}
	
}

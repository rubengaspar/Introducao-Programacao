class ColorUtil {

	static final int MAX = 255;
	static final int MIN = 0;
	
	static boolean contains(Color[] colors, Color c) {
		
		for (int i = 0; i != colors.length; i++)
			if (compareColors(colors[i], c))
				return true;
		return false;
	}
	
	static boolean compareColors(Color c1, Color c2) {
		return 	c1.getR() == c2.getR() &&
				c1.getG() == c2.getG() &&
				c1.getB() == c2.getB();
	}
}

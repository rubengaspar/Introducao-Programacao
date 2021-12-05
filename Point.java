class Point {
	
	//B. Considere o conceito de ponto numa imagem. Defina uma classe Point 
	// para representar um ponto (imutável) numa imagem em termos de (x, y).
	
	private final int posX;
	private final int posY;
	
	Point(int x, int y) {
		posX = x;
		posY = y;
	}
	
	int getX() {
		return posX;
	}
	
	int getY() {
		return posY;
	}
}

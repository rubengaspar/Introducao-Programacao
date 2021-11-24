class PhotoOrganizer {
	
	
	// Atributos
	static final int INITIAL_SIZE = 100;
	
	ColorImage[] images;
	int next;
	
	
	// Metodo Construtor
	PhotoOrganizer() {
		images = new ColorImage[INITIAL_SIZE];
		next = 0;
	}
	
	// Metodos
	void add(ColorImage img) {
		if (next == images.length) {
			ColorImage[] v = new ColorImage[2*images.length];
			for (int i = 0; i != images.length; i++) {
				v[i] = images[i];
			}
			images = v;
		}
		images[next] = img;
		next++;
	}
	
	int numberOfPhotos() {
		return next;
	}
	
	
	
}

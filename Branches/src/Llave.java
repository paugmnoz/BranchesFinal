import processing.core.PApplet;
import processing.core.PImage;

public class Llave implements Runnable {

	private float x, y;
	private Mundo m;
	private PApplet app;
	private PImage llave;

	public Llave(Mundo m, float x, float y, float tam) {
		this.x = x;
		this.y = y;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub

	}

	public void cargar(PApplet app) {
		this.app = app;
		llave = app.loadImage("../data/PantallaFotos/llave.png");
	}

	/*
	 * Método que se encargará de pintar la llave
	 */
	public void pintar(PApplet app) {
		this.app = app;
		app.image(llave, x, y, 200, 357);
	}

	/*
	 * Método que se encargará de mover la llave gracias a las posiciones que da
	 * la clase Kinect y que recibirá gracias a la referencia que tiene del
	 * Mundo
	 */
	public void mover() {

	}

}

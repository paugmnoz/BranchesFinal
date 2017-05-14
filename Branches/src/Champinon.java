import processing.core.PApplet;
import processing.core.PImage;

public class Champinon implements Runnable {
//
	private float x, y;
	public boolean empezar;
	private PApplet app;
	private PImage champUno, champDos;
	private int champ;
	private float desfase;
	private Mundo m;

	public Champinon(Mundo m, float x, float y) {
		this.x = x;
		this.y = y;
		this.m = m;
		champ = (int) (1 + Math.random() * 2);
		desfase = (float) (-20 + Math.random() * 80);
		cargar();
	}

	/*
	 * Método que contendrá el hilo de la caida de los champiñones
	 */

	public void run() {

	}

	public void cargar() {
		champUno = m.getCargar().getChampUno();
		champDos = m.getCargar().getChampDos();
	}

	/*
	 * Método que nos pintara los champiñones
	 */
	public void pintar(PApplet app) {
		this.app = app;
		switch (champ) {
		case 1:
			app.image(champUno, x, y, 50, 50);
			break;
		case 2:
			app.image(champDos, x, y, 50, 50);
			break;
		}
	}

	/*
	 * Método que nos pintara los champiñones en la clase Burbuja cuando son
	 * recogidos por el usuario
	 * 
	 */
	public void pintar(PApplet app, float nuevaX, float nuevaY) {
		this.x = nuevaX;
		this.y = nuevaY;
		switch (champ) {
		case 1:
			app.image(champUno, x + desfase, y + desfase, 20, 20);
			break;
		case 2:
			app.image(champDos, x + desfase, y + desfase, 20, 20);
			break;
		}
	}

	/*
	 * Método que se encargará de animar la caida de los champiñones una vez el
	 * usuario empiece a interactuar en la pantalla
	 */
	public void caida() {

	}

	// GETTERS Y SETTERS
	public float getX() {
		return x;
	}

	public void setX(float x) {
		this.x = x;
	}

	public float getY() {
		return y;
	}

	public void setY(float y) {
		this.y = y;
	}

}

import processing.core.PApplet;
import processing.core.PImage;

public class Champinon implements Runnable {

	private float x, y;
	public boolean empezar;
	private PApplet app;
	private PImage champUno, champDos;
	private int champ;
	private float desfase;

	public Champinon(float x, float y) {
		this.x = x;
		this.y = y;
		champ = (int) (1+Math.random()*2);
		desfase = (float) (-20+Math.random()*80);
	}

	public void cargar(PApplet app) {
		this.app = app;
		switch (champ) {
		case 1:
			champUno = app.loadImage("../data/PantallaArbol/champUno.png");
			break;
		case 2:
			champDos = app.loadImage("../data/PantallaArbol/champDos.png");
			break;
		}
	}

	public void cargarChampUno(PApplet app) {

	}

	public void cargarDos(PApplet app) {
		this.app = app;

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

	public void pintarChampDos(PApplet app) {
		this.app = app;
		app.image(champDos, x, y);
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
	 * Método que contendrá el hilo de la caida de los champiñones
	 */

	public void run() {

	}

	/*
	 * Método que se encargará de animar la caida de los champiñones una vez el
	 * usuario empiece a interactuar en la pantalla
	 */
	public void caida() {

	}

	//GETTERS Y SETTERS
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


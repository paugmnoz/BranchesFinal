import processing.core.PApplet;
import processing.core.PImage;


public class Pote {

	private PApplet app;
	private PImage pote;
	private float x, y;

	public Pote() {

	}

	/*
	 * Método que nos pintara el pote
	 */

	public void cargar(PApplet app) {
		this.app = app;
		x = app.width / 2;
		y = app.height / 2;
		pote = app.loadImage("../data/PantallaArbol/pote.png");
	}

	public void pintar(PApplet app) {
		this.app = app;
		app.image(pote, x, y, 150, 150);
	}

	/*
	 * Método para mover por la pantalla el pote
	 */
	public void mover() {
		if (app.keyCode == app.RIGHT) {
			x+=5;
		}
		if (app.keyCode == app.LEFT) {
			x-=5;
		}
		if (app.keyCode == app.UP) {
			y-=5;
		}
		if (app.keyCode == app.DOWN) {
			y+=5;
		}
	}

	/*
	 * Metodo para inclinar el PImage segun la direccion del movimiento
	 */
	public void inclinar(PApplet app) {

	}
	
	//GETTERS Y SETTERS
	public PImage getPote() {
		return pote;
	}

	public void setPote(PImage pote) {
		this.pote = pote;
	}

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

	//FINAL DE LA CLASE POTE
}
